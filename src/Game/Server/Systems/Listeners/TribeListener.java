package Game.Server.Systems.Listeners;

import Game.Client.Managers.AnimationManager;
import Models.Elements.Tribes.Missions.Mission;
import Models.Elements.Tribes.Tribe;

/** Presentation hook for tribe panels and notifications. */
public final class TribeListener extends Listener {
    public TribeListener(AnimationManager animationManager) { super(animationManager); }
    public void missionOffered(Tribe tribe, Mission mission) { animationManager.refresh(); }
}
