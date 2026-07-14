package Game.Views.BoardPanel;

import Game.Controller.BoardController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;

/**
 * The circular "End Turn" seal. This is the single most important button
 * in the game, so it's deliberately weighted differently from every other
 * themed control — a wax-seal / iron medallion rather than a rectangular button.
 */
public class EndTurnButton extends JButton {

    public static final int DIAMETER = 96;

    private boolean hovering = false;

    private final BoardController boardController;

    public EndTurnButton(BoardController boardController) {
        this.boardController = boardController;
        setPreferredSize(new Dimension(DIAMETER, DIAMETER));
        setContentAreaFilled(false);
        setBorderPainted(false);
        setFocusPainted(false);
        setOpaque(false);
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        setToolTipText("End Turn");

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

        // TODO (later): wire to BoardController.TurnEnded()
        addActionListener(e -> {
            boardController.TurnEnded();
        });
    }

    /** Restrict the clickable/hoverable area to the actual circle, not its square bounding box. */
    @Override
    public boolean contains(int x, int y) {
        double r = getWidth() / 2.0;
        double cx = getWidth() / 2.0;
        double cy = getHeight() / 2.0;
        return (x - cx) * (x - cx) + (y - cy) * (y - cy) <= r * r;
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int w = getWidth();
        int h = getHeight();
        int pad = 4;

        // Torchlit halo on hover
        if (hovering) {
            g2.setColor(new Color(198, 165, 96, 90));
            g2.fillOval(0, 0, w, h);
        }

        // Weathered gold/bronze rim
        Ellipse2D ring = new Ellipse2D.Double(pad, pad, w - pad * 2.0, h - pad * 2.0);
        g2.setPaint(new GradientPaint(0, 0, new Color(120, 96, 52), w, h, new Color(198, 165, 96)));
        g2.fill(ring);

        // Dark iron core
        int corePad = pad + 6;
        Ellipse2D core = new Ellipse2D.Double(corePad, corePad, w - corePad * 2.0, h - corePad * 2.0);
        g2.setPaint(new RadialGradientPaint(
                new Point2D.Double(w / 2.0, h / 2.5),
                w / 2f,
                new float[]{0f, 1f},
                new Color[]{
                        hovering ? new Color(60, 22, 22) : new Color(35, 15, 15),
                        new Color(10, 8, 8)
                }
        ));
        g2.fill(core);

        // Thin inner gold hairline
        g2.setStroke(new BasicStroke(1.5f));
        g2.setColor(new Color(198, 165, 96, 180));
        g2.draw(new Ellipse2D.Double(corePad + 3, corePad + 3, w - (corePad + 3) * 2.0, h - (corePad + 3) * 2.0));

        // "END TURN" label, two lines, centered
        g2.setFont(new Font("Serif", Font.BOLD, 13));
        FontMetrics fm = g2.getFontMetrics();
        int lineHeight = fm.getHeight();
        int startY = (h - lineHeight * 2) / 2 + fm.getAscent();

        g2.setColor(new Color(230, 214, 170));
        String line1 = "END";
        String line2 = "TURN";
        g2.drawString(line1, (w - fm.stringWidth(line1)) / 2, startY);
        g2.drawString(line2, (w - fm.stringWidth(line2)) / 2, startY + lineHeight);

        g2.dispose();
    }
}