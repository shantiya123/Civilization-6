package Utils;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Loads images from the classpath instead of an absolute filesystem path,
 * so the art still resolves after a `git clone` on another machine.
 * Paths are rooted at the classpath root — e.g. "/Images/Buildings/Farm.png"
 * resolves to src/main/resources/Images/Buildings/Farm.png once Maven's added.
 */
public final class ImageLoader {
    private static final Map<String, Image> CACHE = new ConcurrentHashMap<>();

    private ImageLoader() {
    }

    public static Image load(String classpathPath) {
        if (classpathPath == null || classpathPath.isBlank()) return null;
        return CACHE.computeIfAbsent(classpathPath, ImageLoader::loadUncached);
    }

    private static Image loadUncached(String classpathPath) {
        URL url = ImageLoader.class.getResource(classpathPath);
        if (url == null) {
            return null;
        }
        return new ImageIcon(url).getImage();
    }
}
