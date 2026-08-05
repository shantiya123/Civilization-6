package Models.Logic.ConstructureLogic;

import Game.World;
import Models.Elements.Buildable.Constructure.Constructure;
import Models.Elements.Hex.Hex;
import Models.Elements.Resources.Resource;
import Models.Elements.Units.Builder;
import Models.Logic.HexLogic.HexLogic;
import Models.Logic.Logic;
import Models.Logic.UnitLogic.BuilderLogic;
import Models.Records.ResourceRecord;

import java.util.List;
import java.util.Map;

/** Handles construction and removal of edge constructures such as roads and walls. */
public class ConstructureLogic extends Logic {
    private final Constructure constructure;

    public ConstructureLogic(Constructure constructure, World world) {
        super(world);
        this.constructure = constructure;
    }

    public static Constructure Build(World world, Builder builder,
                                    Class<? extends Constructure> constructureClass,
                                    Hex secondHex) throws Exception {
        if (builder == null || builder.getHex() == null) {
            throw new Exception("Builder must stand on a hex to build a constructure");
        }
        if (secondHex == null) {
            throw new Exception("A constructure needs two hexes");
        }

        Hex firstHex = builder.getHex();
        if (!firstHex.isBorder() || !secondHex.isBorder()) {
            throw new Exception("Constructures must be built in our territory");
        }
        if (!HexLogic.getNeighbors(world, firstHex).contains(secondHex)) {
            throw new Exception("Constructure hexes must be adjacent");
        }
        if (HexLogic.getBorderBetween(world, firstHex, secondHex) != null) {
            throw new Exception("A constructure already exists between these hexes");
        }

        Constructure newConstructure = constructureClass
                .getDeclaredConstructor(Hex.class, Hex.class)
                .newInstance(firstHex, secondHex);
        if (!newConstructure.getHEX_TYPE().contains(firstHex.getClass())
                || !newConstructure.getHEX_TYPE().contains(secondHex.getClass())) {
            throw new Exception("Constructure cannot be built on these hexes");
        }
        if (builder.getAP() < newConstructure.getBuilderAp()) {
            throw new Exception("Builder does not have enough AP to build "
                    + constructureClass.getSimpleName());
        }

        ResourceRecord resources = world.getResourceRecord();
        for (Map.Entry<Class<? extends Resource>, Integer> entry : newConstructure.getBuildingCost().entrySet()) {
            if (resources.getAll(entry.getKey()).size() < entry.getValue()) {
                throw new Exception("Not enough " + entry.getKey().getSimpleName()
                        + " to build " + constructureClass.getSimpleName());
            }
        }
        for (Map.Entry<Class<? extends Resource>, Integer> entry : newConstructure.getBuildingCost().entrySet()) {
            List<Resource> stock = resources.getAll(entry.getKey());
            for (int i = 0; i < entry.getValue(); i++) {
                resources.remove(stock.get(i));
            }
        }

        builder.setAP(builder.getAP() - newConstructure.getBuilderAp());
        new BuilderLogic(builder, world).SpendCharge();
        world.getBorderRecorder().add(newConstructure);
        return newConstructure;
    }

    public static Constructure build(World world, Builder builder,
                                     Class<? extends Constructure> constructureClass,
                                     Hex secondHex) throws Exception {
        return Build(world, builder, constructureClass, secondHex);
    }

    public void decay() {
        world.getBorderRecorder().remove(constructure);
    }
}
