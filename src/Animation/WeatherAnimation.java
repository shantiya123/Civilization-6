package Animation;

import Game.Systems.Drawers.WeatherEffectDrawer;


public class WeatherAnimation extends BaseAnimation {

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
