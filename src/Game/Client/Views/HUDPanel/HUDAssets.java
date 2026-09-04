package Game.Client.Views.HUDPanel;

import Utils.ImageLoader;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;


final class HUDAssets {

    private static final Map<String, Image> CACHE = new HashMap<>();

    private HUDAssets() {
    }

    static Image loadIcon(Class<?> elementClass, String folder) {
        String key = folder + "/" + elementClass.getSimpleName();
        return CACHE.computeIfAbsent(key, k -> {
            String url = "/assets/" + folder + "/" + elementClass.getSimpleName() + ".png";
            return url != null ? ImageLoader.load(url) : null;
        });
    }
}