package Game.Managers;

import Animation.BaseAnimation;
import Game.Views.GameEngine;
import Game.Systems.TurnResolutionCoordinator;
import Game.Systems.EventSystem.EventBus;
import Game.Systems.EventSystem.Events.ResolutionAnimationCompletedEvent;
import java.util.UUID;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Timer;

public class AnimationManager {
    private final List<BaseAnimation> activeAnimations = new ArrayList<>();
    private final Timer loopTimer;
    private GameEngine gameEngine;

    public AnimationManager() {

        this.loopTimer = new Timer(16, e -> stepAnimations());
    }

    public void setGameEngine(GameEngine gameEngine) {
        this.gameEngine = gameEngine;
    }

    public void play(BaseAnimation animation) {
        if (!activeAnimations.contains(animation)) {
            activeAnimations.add(animation);
        }
        if (!loopTimer.isRunning()) {
            loopTimer.start();
        }
    }

    /** Registers only finite turn-resolution animations; ambient animations continue using play(). */
    public void playResolutionAnimation(BaseAnimation animation, TurnResolutionCoordinator coordinator, EventBus eventBus) {
        UUID id = coordinator.registerOneShotAnimation();
        animation.setCompletionCallback(() -> eventBus.publish(new ResolutionAnimationCompletedEvent(id)));
        play(animation);
    }

    private void stepAnimations() {
        // Process backwards so safe removal is possible upon completion
        for (int i = activeAnimations.size() - 1; i >= 0; i--) {
            BaseAnimation anim = activeAnimations.get(i);
            boolean isRunning = anim.step();

            if (!isRunning) {
                activeAnimations.remove(i);
            }
        }


        if (gameEngine != null) {
            gameEngine.refresh();
        }

        if (activeAnimations.isEmpty()) {
            loopTimer.stop();
        }
    }
    public void refresh(){
        gameEngine.refresh();
    }
}
