package Game.Systems.Listeners;

import Game.Managers.AnimationManager;
import Game.Systems.Drawers.WeatherEffectDrawer;
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
