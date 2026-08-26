package Game.Systems;

import Game.Systems.ElementSystem.StarvationSystem;
import Game.Systems.Restarters.BuildingRestarter;
import Game.Systems.Restarters.TownHallRestarter;
import Game.Systems.Restarters.UnitRestarter;
import Game.World;
import Models.Elements.Borders.Border;
import Models.Elements.Borders.River;
import Models.Elements.Hex.Hex;
import Models.Elements.Hex.SeaHex;
import Models.Elements.Resources.Resource;
import Models.Elements.Buildable.Buildings.Bazaar;
import Models.Elements.Buildable.Buildings.TradingPost;
import Models.Elements.Tribes.Tribe;
import Models.Logic.Happiness.HappinessLogic;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class RestarterSystem {
    private StarvationSystem starvationSystem;
    private World world;
    private TownHallRestarter townHallRestarter;
    private BuildingRestarter buildingRestarter;
    private UnitRestarter unitRestarter;
    /** Tribe actions are turn-resolution work, just like resource production and upkeep. */
    private TribeSystem tribeSystem;


    public RestarterSystem(StarvationSystem starvationSystem, World world) {
        this.starvationSystem = starvationSystem;
        this.world = world;
        townHallRestarter = new TownHallRestarter(world);
        buildingRestarter = new BuildingRestarter(world);
        unitRestarter = new UnitRestarter(world);
    }

    public void restart()  {
        resetTradeTurns();
        townHallRestarter.produceSafeguard();
        buildingRestarter.ProduceResources();
        for (Hex hex: world.getHexRecord().getAll())
            hex.setVisible(true);
        unitRestarter.APRestart();
//        try {
//            unitRestarter.FeedAll();
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//        buildingRestarter.CostUpkeep();
        for (Border b: world.getBorderRecorder().getAll())
            if (! (b instanceof River))
                System.out.println(b);
        for (Hex hex: world.getHexRecord().getAll())
            if (hex instanceof SeaHex)
                hex.setMovementCost(world.getState().getSeaMovingCost());
        starvationSystem.StarvationCheck();
        new HappinessLogic(world).applyEndOfTurn();
        enforceTownHallStorageCapacity();
//        System.out.println(world.getSeason().getClass().toString());

    }

    /**
     * Runs tribe AI only while the end-turn resolution is active.  It is kept
     * separate from {@link #restart()} so the existing resource/reset phase
     * remains ordered before season, disaster, and Town Hall turn events.
     */
    public void processTribeTurn(int turnNumber) {
        if (tribeSystem == null) {
            throw new IllegalStateException("TribeSystem must be configured before turn resolution");
        }
        tribeSystem.processTurn(turnNumber);
    }

    public void setTribeSystem(TribeSystem tribeSystem) {
        this.tribeSystem = java.util.Objects.requireNonNull(tribeSystem);
    }

    private void resetTradeTurns() {
        for (Models.Elements.Buildable.Buildings.Building building : world.getBuildingRecord().getAll()) {
            if (building instanceof Bazaar bazaar) bazaar.resetTradeTurn();
            if (building instanceof TradingPost tradingPost) tradingPost.resetTradeTurn();
        }
        for (Tribe tribe : world.getTribeRecord().getAll()) tribe.resetTradeTurn();
        for (Tribe tribe : world.getTribeRecord().getAll()) Models.Logic.TribeLogic.MissionLogic.advanceTurn(tribe);
    }

    private void enforceTownHallStorageCapacity() {
        for (Map.Entry<Class<? extends Resource>, Integer> entry
                : world.getTownHall().getStorageCapacity().entrySet()) {
            Integer capacity = entry.getValue();
            if (capacity == null) {
                continue;
            }

            List<Resource> resources = new ArrayList<>(world.getResourceRecord().getAll(entry.getKey()));
            for (int index = capacity; index < resources.size(); index++) {
                world.getResourceRecord().remove(resources.get(index));
            }
        }
    }
}
