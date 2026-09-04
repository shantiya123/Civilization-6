package Game.Client.Views.WarPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Small floating button that puts the board into "pick offensive hex, then defensive hex" mode
 * (see {@code BoardController#requestWarTargeting()}). Per Phase2.md, attacks are declared by
 * choosing an offensive hex and a defensive hex, not by clicking an "attack" button on a unit.
 */
public class StartWarButton extends JButton {

    public static final int WIDTH = 130;
    public static final int HEIGHT = 40;

    private static final Color GOLD = new Color(198, 165, 96);
    private static final Color TEXT = new Color(230, 214, 170);

    private boolean hovering = false;

    public StartWarButton() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setContentAreaFilled(false);
        setBorderPainted(false);
        setFocusPainted(false);
        setOpaque(false);
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        setToolTipText("Pick an offensive hex, then a defensive hex, to start a war");

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                hovering = true;
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                hovering = false;
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int w = getWidth();
        int h = getHeight();

        g2.setPaint(new GradientPaint(0, 0, new Color(30, 30, 30), 0, h,
                hovering ? new Color(48, 40, 22) : new Color(20, 20, 20)));
        g2.fillRoundRect(0, 0, w, h, 12, 12);

        g2.setStroke(new BasicStroke(2f));
        g2.setColor(GOLD);
        g2.drawRoundRect(1, 1, w - 3, h - 3, 12, 12);

        g2.setFont(new Font("Serif", Font.BOLD, 13));
        FontMetrics fm = g2.getFontMetrics();
        String text = "Start War";
        g2.setColor(TEXT);
        g2.drawString(text, (w - fm.stringWidth(text)) / 2, (h + fm.getAscent()) / 2 - 3);

        g2.dispose();
    }
}