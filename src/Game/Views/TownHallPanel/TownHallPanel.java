package Game.Views.TownHallPanel;

import Models.Elements.Units.Unit;

import javax.swing.*;
import java.awt.*;

public class TownHallPanel extends JPanel {

    public static final int PANEL_WIDTH = 160;
    public static final int PANEL_HEIGHT = 230;

    private static final int IMAGE_HEIGHT = 170;

    private final TownHallState state;
    private final JLabel nameLabel;
    private Image currentImage;
    private double progressFraction = 0;

    public TownHallPanel(TownHallState state) {
        this.state = state;

        setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        setOpaque(false);
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createLineBorder(new Color(198, 165, 96), 2));

        nameLabel = new JLabel("", SwingConstants.CENTER);
        nameLabel.setFont(new Font("Serif", Font.BOLD, 14));
        nameLabel.setForeground(new Color(230, 214, 170));
        nameLabel.setBorder(BorderFactory.createEmptyBorder(6, 4, 8, 4));

        add(nameLabel, BorderLayout.SOUTH);

        refresh();
    }

    public void refresh() {
        boolean finished = state.isFinished();
        Unit unit = finished ? null : state.getCurrentUnit();

        setVisible(!finished && unit != null);
        if (!isVisible()) {
            return;
        }

        String path = state.getPicturePath(unit.getClass());
        currentImage = (path != null) ? new ImageIcon(path).getImage() : null;

        int totalStep = state.getTotalStep();
        int step = state.getStep();
        progressFraction = totalStep > 0 ? Math.min(1.0, Math.max(0.0, step / (double) totalStep)) : 0;

        nameLabel.setText(unit.getClass().getSimpleName().replaceAll("(?<!^)(?=[A-Z])", " "));

        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setColor(new Color(20, 17, 14));
        g2.fillRect(0, 0, getWidth(), getHeight());

        if (currentImage != null) {
            int imgW = getWidth();
            int imgH = IMAGE_HEIGHT;

            g2.drawImage(currentImage, 0, 0, imgW, imgH, this);


            int darkHeight = (int) Math.round(imgH * (1.0 - progressFraction));
            if (darkHeight > 0) {
                g2.setColor(new Color(0, 0, 0, 170));
                g2.fillRect(0, 0, imgW, darkHeight);
            }
        }

        g2.dispose();
    }
}