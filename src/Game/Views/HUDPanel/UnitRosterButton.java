package Game.Views.HUDPanel;

import Models.Elements.Units.Unit;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;

class UnitRosterButton extends JPanel {

    private static final int ICON_SIZE = 30;

    private final Class<? extends Unit> unitClass;
    private final HUDState state;
    private final Image icon;
    private final IconCircle iconCircle;
    private final JLabel label;
    private boolean hovering = false;

    UnitRosterButton(Class<? extends Unit> unitClass, HUDState state) {
        this.unitClass = unitClass;
        this.state = state;
        this.icon = HUDAssets.loadIcon(unitClass, "units");

        setOpaque(false);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        setBorder(BorderFactory.createEmptyBorder(4, 6, 4, 6));

        iconCircle = new IconCircle();
        iconCircle.setAlignmentX(Component.CENTER_ALIGNMENT);

        label = new JLabel();
        label.setFont(new Font("Serif", Font.BOLD, 10));
        label.setForeground(new Color(230, 214, 170));
        label.setAlignmentX(Component.CENTER_ALIGNMENT);

        add(iconCircle);
        add(Box.createVerticalStrut(3));
        add(label);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                hovering = true;
                iconCircle.repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                hovering = false;
                iconCircle.repaint();
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                state.onUnitIconClicked(unitClass);
            }
        });

        refresh();
    }

    void refresh() {
        String name = unitClass.getSimpleName().replaceAll("(?<!^)(?=[A-Z])", " ");
        label.setText(name + " : " + state.getUnitCount(unitClass) + "/" + state.getUnitCap(unitClass));
        iconCircle.repaint();
    }

    private class IconCircle extends JComponent {

        IconCircle() {
            setPreferredSize(new Dimension(ICON_SIZE + 6, ICON_SIZE + 6));
            setOpaque(false);
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            int d = ICON_SIZE;
            int off = 3;

            if (hovering) {
                g2.setColor(new Color(198, 165, 96, 90));
                g2.fillOval(0, 0, d + 6, d + 6);
            }

            g2.setPaint(new GradientPaint(0, off, new Color(60, 48, 30), 0, off + d, new Color(30, 24, 16)));
            g2.fillOval(off, off, d, d);
            g2.setStroke(new BasicStroke(2f));
            g2.setColor(new Color(198, 165, 96));
            g2.drawOval(off, off, d, d);

            if (icon != null) {
                g2.setClip(new Ellipse2D.Double(off + 2, off + 2, d - 4, d - 4));
                g2.drawImage(icon, off + 2, off + 2, d - 4, d - 4, this);
                g2.setClip(null);
            } else {
                g2.setColor(new Color(198, 165, 96));
                g2.setFont(new Font("Serif", Font.BOLD, 12));
                String letter = unitClass.getSimpleName().substring(0, 1);
                FontMetrics fm = g2.getFontMetrics();
                g2.drawString(letter, off + d / 2 - fm.stringWidth(letter) / 2, off + d / 2 + fm.getAscent() / 2 - 2);
            }

            g2.dispose();
        }
    }
}