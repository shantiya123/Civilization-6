package StartGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.function.Consumer;


public class VolumeSlider extends JComponent {

    public static final int WIDTH = 140;
    public static final int HEIGHT = 18;

    private final MusicSettings musicSettings;
    private final Consumer<Float> onChange;

    public VolumeSlider(MusicSettings musicSettings, Consumer<Float> onChange) {
        this.musicSettings = musicSettings;
        this.onChange = onChange;
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setOpaque(false);
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        MouseAdapter dragHandler = new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                applyFromMouse(e.getX());
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                applyFromMouse(e.getX());
            }
        };
        addMouseListener(dragHandler);
        addMouseMotionListener(dragHandler);
    }

    private void applyFromMouse(int mouseX) {
        float fraction = Math.max(0f, Math.min(1f, mouseX / (float) getWidth()));
        musicSettings.setVolume(fraction);
        onChange.accept(fraction);
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int w = getWidth();
        int h = getHeight();
        int trackH = 6;
        int trackY = (h - trackH) / 2;

        g2.setColor(new Color(30, 24, 16));
        g2.fillRoundRect(0, trackY, w, trackH, trackH, trackH);
        g2.setColor(new Color(198, 165, 96, 120));
        g2.drawRoundRect(0, trackY, w - 1, trackH, trackH, trackH);

        float volume = musicSettings.getVolume();
        int filledW = Math.round(w * volume);
        if (filledW > 0) {
            g2.setPaint(new GradientPaint(0, 0, new Color(120, 96, 52), filledW, 0, new Color(198, 165, 96)));
            g2.fillRoundRect(0, trackY, filledW, trackH, trackH, trackH);
        }

        int knobD = h;
        int knobX = Math.max(0, Math.min(w - knobD, filledW - knobD / 2));
        g2.setColor(new Color(230, 214, 170));
        g2.fillOval(knobX, 0, knobD, knobD);
        g2.setColor(new Color(120, 96, 52));
        g2.drawOval(knobX, 0, knobD - 1, knobD - 1);

        g2.dispose();
    }
}