package Animation;

import Game.Systems.Drawers.WeatherEffectDrawer;

/**
 * Ambient, never-ending background weather animation (snow / leaves / petals
 * / sunlight motes, depending on the current season).
 *
 * Unlike every other animation in this package, this one is started exactly
 * once — at game start, via AnimationManager.play(...) — and is never
 * stopped or replayed. Its totalSteps is effectively infinite, so it never
 * reaches onComplete() and never gets removed from AnimationManager's active
 * list; the weather simply keeps animating for as long as the game runs.
 * When the season actually changes, SeasonListener calls
 * WeatherEffectDrawer.setSeason(...) directly — this animation object itself
 * is untouched, so the continuous loop is never interrupted.
 */
public class WeatherAnimation extends BaseAnimation {

    // At ~16ms per tick this would take centuries to reach totalSteps,
    // so in practice the animation never finishes and never stops.
    private static final int EFFECTIVELY_FOREVER = Integer.MAX_VALUE;

    private final WeatherEffectDrawer effectDrawer;

    public WeatherAnimation(WeatherEffectDrawer effectDrawer) {
        super(EFFECTIVELY_FOREVER);
        this.effectDrawer = effectDrawer;
    }

    @Override
    public boolean isAmbient() {
        return true;
    }

    @Override
    protected void onTick(double progress) {
        // currentStep (not the near-zero `progress`) is what drives the
        // particles, since totalSteps is astronomically large.
        effectDrawer.tick(currentStep);
    }
}
