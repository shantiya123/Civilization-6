package Game.Server.Systems.Listeners;

import Animation.EarthquakeAnimation;
import Animation.FloodAnimation;
import Animation.TornadoAnimation;
import Animation.TsunamiAnimation;
import Animation.VolcanoAnimation;
import Game.Client.Managers.AnimationManager;
import Game.Client.Drawers.EarthquakeEffectDrawer;
import Game.Client.Drawers.FloodEffectDrawer;
import Game.Client.Drawers.TornadoEffectDrawer;
import Game.Client.Drawers.TsunamiEffectDrawer;
import Game.Client.Drawers.VolcanoEffectDrawer;
import Models.Elements.Hex.Hex;
import Models.Elements.NatrualDisasters.EarthQuake;
import Models.Elements.NatrualDisasters.Flood;
import Models.Elements.NatrualDisasters.NaturalDisaster;
import Models.Elements.NatrualDisasters.Tornado;
import Models.Elements.NatrualDisasters.Tsunami;
import Models.Elements.NatrualDisasters.Volcano;
import Models.Manager.HexManager;

public class NaturalDisasterListener extends Listener {
    private final HexManager hexManager;
    private EarthquakeEffectDrawer earthquakeEffectDrawer;
    private FloodEffectDrawer floodEffectDrawer;
    private TsunamiEffectDrawer tsunamiEffectDrawer;
    private TornadoEffectDrawer tornadoEffectDrawer;
    private VolcanoEffectDrawer volcanoEffectDrawer;

    public NaturalDisasterListener(AnimationManager animationManager, HexManager hexManager) {
        super(animationManager);
        this.hexManager = hexManager;
    }

    public void setEarthquakeEffectDrawer(EarthquakeEffectDrawer earthquakeEffectDrawer) {
        this.earthquakeEffectDrawer = earthquakeEffectDrawer;
    }

    public void setFloodEffectDrawer(FloodEffectDrawer floodEffectDrawer) {
        this.floodEffectDrawer = floodEffectDrawer;
    }

    public void setTsunamiEffectDrawer(TsunamiEffectDrawer tsunamiEffectDrawer) {
        this.tsunamiEffectDrawer = tsunamiEffectDrawer;
    }

    public void setTornadoEffectDrawer(TornadoEffectDrawer tornadoEffectDrawer) {
        this.tornadoEffectDrawer = tornadoEffectDrawer;
    }

    public void setVolcanoEffectDrawer(VolcanoEffectDrawer volcanoEffectDrawer) {
        this.volcanoEffectDrawer = volcanoEffectDrawer;
    }

    public void naturalDisasterOccurred(NaturalDisaster naturalDisaster) {
        if (!isInPlayerView(naturalDisaster)) {
            animationManager.refresh();
            return;
        }

        if (naturalDisaster instanceof EarthQuake earthQuake && earthquakeEffectDrawer != null) {
            animationManager.play(new EarthquakeAnimation(earthQuake, hexManager, earthquakeEffectDrawer));
            return;
        }
        if (naturalDisaster instanceof Flood flood && floodEffectDrawer != null) {
            animationManager.play(new FloodAnimation(flood, floodEffectDrawer));
            return;
        }
        if (naturalDisaster instanceof Tsunami tsunami && tsunamiEffectDrawer != null) {
            animationManager.play(new TsunamiAnimation(tsunami, tsunamiEffectDrawer));
            return;
        }
        if (naturalDisaster instanceof Tornado tornado && tornadoEffectDrawer != null) {
            animationManager.play(new TornadoAnimation(tornado, tornadoEffectDrawer));
            return;
        }
        if (naturalDisaster instanceof Volcano volcano && volcanoEffectDrawer != null) {
            animationManager.play(new VolcanoAnimation(volcano, volcanoEffectDrawer));
            return;
        }

        animationManager.refresh();
    }

    /** Phase 2 spec: disasters outside the player's discovered/visible area only produce a HUD alert. */
    private boolean isInPlayerView(NaturalDisaster naturalDisaster) {
        if (naturalDisaster.getHex().isVisible()) return true;
        for (Hex hex : naturalDisaster.getEffectRadius()) {
            if (hex.isVisible()) return true;
        }
        return false;
    }
}