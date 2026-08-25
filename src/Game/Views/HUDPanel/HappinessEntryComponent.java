package Game.Views.HUDPanel;

import Utils.ImageLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

/** Displays the current global Happiness value using the same badge style as ResourceEntryComponent. */
class HappinessEntryComponent extends JComponent {

    private static final int DIAMETER = 34;

    private final HUDState state;
    private final Image icon;

    HappinessEntryComponent(HUDState state) {
        this.state = state;
        this.icon = ImageLoader.load("/assets/resources/Happiness.png");
        setOpaque(false);
        setPreferredSize(new Dimension(92, DIAMETER + 4));
    }

    void refresh() {
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int cy = getHeight() / 2;
        int cx = DIAMETER / 2 + 2;

        g2.setPaint(new GradientPaint(0, 0, new Color(60, 48, 30), 0, DIAMETER, new Color(30, 24, 16)));
        g2.fillOval(cx - DIAMETER / 2, cy - DIAMETER / 2, DIAMETER, DIAMETER);
        g2.setStroke(new BasicStroke(2f));
        g2.setColor(new Color(198, 165, 96));
        g2.drawOval(cx - DIAMETER / 2, cy - DIAMETER / 2, DIAMETER, DIAMETER);

        int happiness = state.getHappiness();

        if (icon != null) {
            g2.setClip(new Ellipse2D.Double(cx - DIAMETER / 2.0 + 2, cy - DIAMETER / 2.0 + 2, DIAMETER - 4, DIAMETER - 4));
            g2.drawImage(icon, cx - DIAMETER / 2 + 2, cy - DIAMETER / 2 + 2, DIAMETER - 4, DIAMETER - 4, this);
            g2.setClip(null);
        } else {
            g2.setColor(new Color(198, 165, 96));
            g2.setFont(new Font("Serif", Font.BOLD, 14));
            String letter = "H";
            FontMetrics fm = g2.getFontMetrics();
            g2.drawString(letter, cx - fm.stringWidth(letter) / 2, cy + fm.getAscent() / 2 - 2);
        }

        g2.setFont(new Font("Serif", Font.BOLD, 14));
        g2.setColor(happinessColor(happiness));
        String text = String.valueOf(happiness);
        FontMetrics fm = g2.getFontMetrics();
        g2.drawString(text, cx + DIAMETER / 2 + 8, cy + fm.getAscent() / 2 - 2);

        g2.dispose();
    }

    /** Green when happy, amber near neutral, red once it dips toward unrest. */
    private Color happinessColor(int happiness) {
        if (happiness > 0) return new Color(150, 214, 130);
        if (happiness < 0) return new Color(214, 100, 90);
        return new Color(230, 214, 170);
    }
}