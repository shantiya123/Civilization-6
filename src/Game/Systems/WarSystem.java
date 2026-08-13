package Game.Systems;

import Game.Systems.EventSystem.EventBus;
import Game.Systems.EventSystem.Events.NotificationRequestedEvent;
import Game.Systems.EventSystem.Events.WarEvent;
import Game.World;
import Models.Elements.Hex.Hex;
import Models.Elements.Tribes.Tribe;
import Models.Elements.Units.Unit;
import Models.Logic.War.WarManager;
import Models.Logic.War.WarResult;
import Models.Logic.War.WarValidator;

import java.util.List;

/** Controller-facing facade for player war commands. */
public final class WarSystem {
    private final World world;
    private final EventBus eventBus;
    private final WarValidator validator;

    public WarSystem(World world, EventBus eventBus) {
        this.world = world;
        this.eventBus = eventBus;
        validator = new WarValidator(world);
    }

    public void attack(Hex offensiveHex, Hex defensiveHex) {
        execute(offensiveHex, defensiveHex, false);
    }

    public void attackWall(Hex offensiveHex, Hex defensiveHex) {
        execute(offensiveHex, defensiveHex, true);
    }

    private void execute(Hex offensiveHex, Hex defensiveHex, boolean wallOnly) {
        try {
            if (wallOnly) validator.validateWallAttack(offensiveHex, defensiveHex);
            else validator.validateAttack(offensiveHex, defensiveHex);
            List<WarEvent.UnitSnapshot> before = snapshotUnits();
            Tribe defenderTribe = tribeAt(defensiveHex);
            WarResult result = wallOnly
                    ? new WarManager(world, offensiveHex, defensiveHex).attackWall()
                    : new WarManager(world, offensiveHex, defensiveHex).attack();
            List<WarEvent.UnitSnapshot> after = snapshotUnits();
            WarEvent report = WarEvent.from(offensiveHex, defensiveHex, defenderTribe, result, before, after);
            eventBus.publish(report);
            for (WarEvent.UnitSnapshot defeated : report.defeatedUnits()) {
                eventBus.publish(new Game.Systems.EventSystem.Events.UnitKilledEvent(defeated.unit(), defeated.hex()));
            }
            if (defenderTribe != null && defenderTribe.isDefeated()) {
                eventBus.publish(new Game.Systems.EventSystem.Events.TribeDefeatedEvent(
                        defenderTribe, defenderTribe.getRuntimeState().getDefeatLoot()));
            }
        } catch (Exception exception) {
            eventBus.publish(new NotificationRequestedEvent(exception.getMessage()));
        }
    }

    private List<WarEvent.UnitSnapshot> snapshotUnits() {
        return world.getUnitRecord().getAll().stream().map(WarEvent.UnitSnapshot::from).toList();
    }

    private Tribe tribeAt(Hex hex) {
        if (hex.getBuilding() instanceof Models.Elements.Buildable.Buildings.TribeCamp camp) return camp.getTribe();
        return world.getUnitRecord().getAll().stream().filter(unit -> unit.getHex() == hex && !unit.isPlayerOwned())
                .map(Unit::getOwningTribe).findFirst().orElse(null);
    }
}
