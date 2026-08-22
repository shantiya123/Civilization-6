package Animation;

import Game.Systems.Drawers.EarthquakeEffectDrawer;
import Models.Elements.NatrualDisasters.EarthQuake;
import Models.Manager.HexManager;

/**
 * Map-shake + ground-crack presentation for an EarthQuake disaster.
 * Damage is already applied by EarthQuakeLogic before this plays; this
 * class is purely visual and restores/clears all state it touches.
 */
public class EarthquakeAnimation extends BaseAnimation {

    private static final int SHAKE_MAX_PX = 8;

    private final HexManager hexManager;
    private final EarthquakeEffectDrawer effectDrawer;
    private final int originalCenterX;
    private final int originalCenterY;

    public EarthquakeAnimation(EarthQuake earthQuake, HexManager hexManager, EarthquakeEffectDrawer effectDrawer) {
        super(70);
        this.hexManager = hexManager;
        this.effectDrawer = effectDrawer;
        this.originalCenterX = hexManager.getCenterX();
        this.originalCenterY = hexManager.getCenterY();

        effectDrawer.start(earthQuake.getHex(), earthQuake.getEffectRadius());
    }

    @Override
    protected void onTick(double progress) {
        // Rises from 0, peaks mid-animation, fades back to 0 — start/spread/end per spec.
        double intensity = Math.sin(progress * Math.PI);

        int dx = (int) Math.round(SHAKE_MAX_PX * intensity * Math.sin(currentStep * 1.7));
        int dy = (int) Math.round(SHAKE_MAX_PX * intensity * Math.sin(currentStep * 2.3 + 1.0));
        hexManager.setCenter(originalCenterX + dx, originalCenterY + dy);

        effectDrawer.setIntensity(intensity);
    }

    @Override
    protected void onComplete() {
        hexManager.setCenter(originalCenterX, originalCenterY);
        effectDrawer.stop();
    }
}