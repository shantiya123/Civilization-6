package Game.Views.HUDPanel;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * Loads and caches icon images for anything shown in the HUD.
 * Images aren't added yet — callers fall back to a lettered placeholder
 * circle when the resource is missing, so the HUD still renders correctly.
 * Expected paths: /assets/resources/<SimpleName>.png, /assets/units/<SimpleName>.png
 */
final class HUDAssets {

    private static final Map<String, Image> CACHE = new HashMap<>();

    private HUDAssets() {
    }

    static Image loadIcon(Class<?> elementClass, String folder) {
        String key = folder + "/" + elementClass.getSimpleName();
        return CACHE.computeIfAbsent(key, k -> {
            URL url = HUDAssets.class.getResource("/assets/" + folder + "/" + elementClass.getSimpleName() + ".png");
            return url != null ? new ImageIcon(url).getImage() : null;
        });
    }
}