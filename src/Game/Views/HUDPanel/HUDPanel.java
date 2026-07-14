package Game.Views.HUDPanel;

import javax.swing.*;
import java.awt.*;

public class HUDPanel extends JPanel {

    public static final int HEIGHT = 74;

    private final ResourcePanel resourcePanel;
    private final TurnPanel turnPanel;
    private final UnitRosterPanel unitRosterPanel;

    public HUDPanel(HUDState state) {
        setLayout(new BorderLayout());
        setOpaque(false);
        setPreferredSize(new Dimension(0, HEIGHT));
        setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(198, 165, 96)));

        resourcePanel = new ResourcePanel(state);
        turnPanel = new TurnPanel(state);
        unitRosterPanel = new UnitRosterPanel(state);

        add(wrap(resourcePanel, 20), BorderLayout.WEST);
        add(turnPanel, BorderLayout.CENTER);
        add(wrap(unitRosterPanel, 20), BorderLayout.EAST);
    }

    private JPanel wrap(JComponent content, int horizontalPad) {
        JPanel wrapper = new JPanel(new GridBagLayout());
        wrapper.setOpaque(false);
        wrapper.setBorder(BorderFactory.createEmptyBorder(0, horizontalPad, 0, horizontalPad));
        wrapper.add(content);
        return wrapper;
    }

    public void refresh() {
        resourcePanel.refresh();
        turnPanel.refresh();
        unitRosterPanel.refresh();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setPaint(new GradientPaint(0, 0, new Color(20, 17, 14), 0, getHeight(), new Color(35, 30, 24)));
        g2.fillRect(0, 0, getWidth(), getHeight());
        g2.dispose();
    }
}