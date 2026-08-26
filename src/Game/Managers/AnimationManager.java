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

    // While only ambient animations (e.g. background weather) are active, the
    // whole board doesn't need a full repaint on every 16ms tick to look
    // smooth. Repainting only every Nth tick here cuts steady-state CPU/redraw
    // cost dramatically without affecting real gameplay animations, which
    // always repaint every tick as before.
    private static final int AMBIENT_ONLY_REFRESH_EVERY_N_TICKS = 4; // ~15 fps for ambient-only frames
    private int ambientSkipCounter = 0;

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
        boolean anyNonAmbientActive = false;

        // Process backwards so safe removal is possible upon completion
        for (int i = activeAnimations.size() - 1; i >= 0; i--) {
            BaseAnimation anim = activeAnimations.get(i);
            boolean isRunning = anim.step();

            if (!isRunning) {
                activeAnimations.remove(i);
            } else if (!anim.isAmbient()) {
                anyNonAmbientActive = true;
            }
        }

        boolean shouldRefresh = anyNonAmbientActive;
        if (!shouldRefresh) {
            // Only ambient animations left running: repaint at a reduced rate.
            ambientSkipCounter++;
            if (ambientSkipCounter >= AMBIENT_ONLY_REFRESH_EVERY_N_TICKS) {
                ambientSkipCounter = 0;
                shouldRefresh = true;
            }
        } else {
            ambientSkipCounter = 0;
        }

        if (gameEngine != null && shouldRefresh) {
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
