package Models.Logic.TribeLogic.Behaviors;

import Game.Server.Systems.EventSystem.EventBus;
import Game.Server.Systems.EventSystem.Events.TribeMissionOfferedEvent;
import Models.Elements.Tribes.Missions.Mission;
import Models.Elements.Tribes.Tribe;

/** Creates and exposes a tribe mission after a selector decides it should be offered. */
public final class MissionOffer {
    private final EventBus eventBus;

    public MissionOffer(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    public Mission execute(Tribe tribe) {
        if (tribe == null) throw new IllegalArgumentException("Tribe is required");
        tribe.getMission();
        Mission mission = tribe.getActiveMission();
        eventBus.publish(new TribeMissionOfferedEvent(tribe, mission));
        return mission;
    }
}
