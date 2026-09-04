package Game.Server.Systems.Listeners;

import Game.Client.Managers.AnimationManager;
import Game.Client.Drawers.WeatherEffectDrawer;
import Game.World;

public class SeasonListener extends Listener {
    private final World world;
    private WeatherEffectDrawer weatherEffectDrawer;

    public SeasonListener(AnimationManager animationManager, World world) {
        super(animationManager);
        this.world = world;
    }

    public void setWeatherEffectDrawer(WeatherEffectDrawer weatherEffectDrawer) {
        this.weatherEffectDrawer = weatherEffectDrawer;
    }

    public void SeasonChanged(){
        // The ambient weather animation itself never stops; it just switches
        // its look to match the new season (world.getSeason() is already
        // updated by SeasonSystem before this event fires).
        if (weatherEffectDrawer != null) {
            weatherEffectDrawer.setSeason(world.getSeason());
        }
    }
}
