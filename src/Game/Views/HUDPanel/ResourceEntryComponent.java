package Game.Views.HUDPanel;

import Models.Elements.Resources.Resource;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

class ResourceEntryComponent extends JComponent {

    private static final int DIAMETER = 34;

    private final Class<? extends Resource> resourceClass;
    private final HUDState state;
    private final Image icon;

    ResourceEntryComponent(Class<? extends Resource> resourceClass, HUDState state) {
        this.resourceClass = resourceClass;
        this.state = state;
        this.icon = HUDAssets.loadIcon(resourceClass, "resources");
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

        if (icon != null) {
            g2.setClip(new Ellipse2D.Double(cx - DIAMETER / 2.0 + 2, cy - DIAMETER / 2.0 + 2, DIAMETER - 4, DIAMETER - 4));
            g2.drawImage(icon, cx - DIAMETER / 2 + 2, cy - DIAMETER / 2 + 2, DIAMETER - 4, DIAMETER - 4, this);
            g2.setClip(null);
        } else {
            g2.setColor(new Color(198, 165, 96));
            g2.setFont(new Font("Serif", Font.BOLD, 14));
            String letter = resourceClass.getSimpleName().substring(0, 1);
            FontMetrics fm = g2.getFontMetrics();
            g2.drawString(letter, cx - fm.stringWidth(letter) / 2, cy + fm.getAscent() / 2 - 2);
        }

        g2.setFont(new Font("Serif", Font.BOLD, 14));
        g2.setColor(new Color(230, 214, 170));
        String text = state.getResourceCount(resourceClass) + "/" + state.getResourceCapacity(resourceClass);
        FontMetrics fm = g2.getFontMetrics();
        g2.drawString(text, cx + DIAMETER / 2 + 8, cy + fm.getAscent() / 2 - 2);

        g2.dispose();
    }
}