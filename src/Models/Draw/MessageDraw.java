package Models.Draw;

import Models.Elements.Messages.Message;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class MessageDraw implements Draw {

    private final Message message;

    // Core structural dimensions
    private static final int WIDTH = 380;
    private static final int HEIGHT = 60;
    private static final int ARC_SIZE = 15;

    public MessageDraw(Message message) {
        this.message = message;
    }

    @Override
    public void draw(Graphics g) {
        if (message == null || !message.isActive()) {
            return;
        }

        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Match the dynamic alpha calculated by the animation tick
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, message.getAlpha()));

        int x = message.getX();
        int y = message.getY();

        // 1. Draw outer gold / weathered bronze rim (Matches EndTurnButton)
        RoundRectangle2D outerRim = new RoundRectangle2D.Double(x, y, WIDTH, HEIGHT, ARC_SIZE, ARC_SIZE);
        g2.setPaint(new GradientPaint(x, y, new Color(120, 96, 52), x + WIDTH, y + HEIGHT, new Color(198, 165, 96)));
        g2.fill(outerRim);

        // 2. Draw dark iron core (Matches EndTurnButton)
        int borderThickness = 3;
        RoundRectangle2D innerCore = new RoundRectangle2D.Double(
                x + borderThickness,
                y + borderThickness,
                WIDTH - (borderThickness * 2),
                HEIGHT - (borderThickness * 2),
                ARC_SIZE - 2,
                ARC_SIZE - 2
        );
        g2.setPaint(new RadialGradientPaint(
                new Point(x + WIDTH / 2, y + HEIGHT / 2),
                WIDTH / 1.5f,
                new float[]{0f, 1f},
                new Color[]{new Color(35, 15, 15), new Color(10, 8, 8)}
        ));
        g2.fill(innerCore);

        // 3. Draw thin inner gold hairline
        g2.setStroke(new BasicStroke(1.2f));
        g2.setColor(new Color(198, 165, 96, 140));
        RoundRectangle2D hairline = new RoundRectangle2D.Double(
                x + borderThickness + 2,
                y + borderThickness + 2,
                WIDTH - (borderThickness * 2) - 4,
                HEIGHT - (borderThickness * 2) - 4,
                ARC_SIZE - 4,
                ARC_SIZE - 4
        );
        g2.draw(hairline);

        // 4. Render the message text (Matches EndTurnButton's text style)
        g2.setFont(new Font("Serif", Font.BOLD, 15));
        g2.setColor(new Color(230, 214, 170));
        FontMetrics fm = g2.getFontMetrics();
        int textX = x + (WIDTH - fm.stringWidth(message.getContent())) / 2;
        int textY = y + ((HEIGHT - fm.getHeight()) / 2) + fm.getAscent();

        g2.drawString(message.getContent(), textX, textY);
        g2.dispose();
    }
}