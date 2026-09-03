package Models.Logic.BuildingLogic.TownHallLogic.TownHallOrders;

import Game.World;
import Models.Elements.Resources.Resource;
import Models.Logic.Technologies.Technology;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TechnologyResearchOrder extends TownHallOrder {
    private final Technology technology;

    public TechnologyResearchOrder(World world, Technology technology) {
        super(world, technology.getResearchRequiredTurns());
        this.technology = technology;
    }

    @Override
    public void check() throws Exception {
        if (world.getTownHall().getTownHallState().getState() < technology.getTownHallPrerequisite()) {
            throw new Exception("Town Hall level is too low");
        }
        if (world.getTechnologyRecord().contains(technology.getClass())) {
            throw new Exception("Technology is already researched");
        }
        for (Map.Entry<Class<? extends Resource>, Integer> entry : technology.getBuildingCost().entrySet()) {
            if (world.getResourceRecord().getAll(entry.getKey()).size() < entry.getValue()) {
                throw new Exception("Not enough " + entry.getKey().getSimpleName());
            }
        }
    }

    @Override
    public void action() {
        for (Map.Entry<Class<? extends Resource>, Integer> entry : technology.getBuildingCost().entrySet()) {
            List<Resource> resources = new ArrayList<>(world.getResourceRecord().getAll(entry.getKey()));
            for (int index = 0; index < entry.getValue(); index++) {
                world.getResourceRecord().remove(resources.get(index));
                Delete(resources.get(index));
            }
        }
        world.getTechnologyRecord().add(technology);
        technology.getEffect().useEffect();
    }

    @Override
    public void addTurnStep() {
        super.addTurnStep();
    }

    public Technology getTechnology() { return technology; }
}
