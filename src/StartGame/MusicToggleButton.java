package StartGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;

public class MusicToggleButton extends JComponent {

    public static final int DIAMETER = 64;

    private final StartGameState state;
    private boolean hovering = false;

    public MusicToggleButton(StartGameState state) {
        this.state = state;
        setPreferredSize(new Dimension(DIAMETER, DIAMETER));
        setOpaque(false);
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        setToolTipText("Toggle Music");

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

            @Override
            public void mouseClicked(MouseEvent e) {
                state.toggleMusic();
                repaint();
            }
        });
    }

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
        int pad = 3;

        if (hovering) {
            g2.setColor(new Color(198, 165, 96, 90));
            g2.fillOval(0, 0, w, h);
        }

        Ellipse2D ring = new Ellipse2D.Double(pad, pad, w - pad * 2.0, h - pad * 2.0);
        g2.setPaint(new GradientPaint(0, 0, new Color(120, 96, 52), w, h, new Color(198, 165, 96)));
        g2.fill(ring);

        int corePad = pad + 5;
        Ellipse2D core = new Ellipse2D.Double(corePad, corePad, w - corePad * 2.0, h - corePad * 2.0);
        g2.setColor(new Color(20, 17, 14));
        g2.fill(core);

        g2.setColor(new Color(230, 214, 170));
        g2.setFont(new Font("Serif", Font.PLAIN, 16));
        String note = "\u266A";
        FontMetrics fmNote = g2.getFontMetrics();
        g2.drawString(note, (w - fmNote.stringWidth(note)) / 2, h / 2 - 6);

        g2.setColor(state.isMusic() ? new Color(120, 200, 120) : new Color(200, 90, 90));
        g2.setFont(new Font("Serif", Font.BOLD, 11));
        String label = state.isMusic() ? "ON" : "OFF";
        FontMetrics fm = g2.getFontMetrics();
        g2.drawString(label, (w - fm.stringWidth(label)) / 2, h / 2 + fm.getAscent() + 2);

        g2.dispose();
    }
}