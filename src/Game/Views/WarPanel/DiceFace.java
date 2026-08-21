package Game.Views.WarPanel;

import javax.swing.*;
import java.awt.*;

/**
 * Reusable die-face component: draws a single six-sided die (1-6 pips)
 * with a colored accent border that communicates whether this die's
 * matched comparison favors the attacker, favors the defender, or has no
 * match at all. View-only; it paints whatever value/color it is given and
 * has no knowledge of game rules or state.
 */
final class DieFace extends JComponent {

    /** Visual result of comparing this die against its matched opponent die. */
    enum Result { FAVORS_ATTACKER, FAVORS_DEFENDER, UNMATCHED }

    private static final Color FACE_BACKGROUND = new Color(38, 32, 25);
    private static final Color PIP_COLOR = new Color(230, 214, 170);
    private static final Color FAVORS_ATTACKER_COLOR = new Color(120, 200, 120);
    private static final Color FAVORS_DEFENDER_COLOR = new Color(205, 92, 92);
    private static final Color UNMATCHED_COLOR = new Color(120, 110, 95);

    private final int value;
    private final Result result;

    DieFace(int value, Result result) {
        this.value = value;
        this.result = result;
        setPreferredSize(new Dimension(42, 42));
        setOpaque(false);
        setToolTipText(tooltipFor(result));
    }

    private static String tooltipFor(Result result) {
        return switch (result) {
            case FAVORS_ATTACKER -> "Wins this pair for the attacker";
            case FAVORS_DEFENDER -> "Wins this pair for the defender";
            case UNMATCHED -> "No matching die on the other side";
        };
    }

    private Color accentColor() {
        return switch (result) {
            case FAVORS_ATTACKER -> FAVORS_ATTACKER_COLOR;
            case FAVORS_DEFENDER -> FAVORS_DEFENDER_COLOR;
            case UNMATCHED -> UNMATCHED_COLOR;
        };
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        Graphics2D g2 = (Graphics2D) graphics.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int size = Math.min(getWidth(), getHeight());
        int x = (getWidth() - size) / 2;
        int y = (getHeight() - size) / 2;

        g2.setColor(FACE_BACKGROUND);
        g2.fillRoundRect(x, y, size, size, 8, 8);
        g2.setColor(accentColor());
        g2.setStroke(new BasicStroke(2.5f));
        g2.drawRoundRect(x + 1, y + 1, size - 2, size - 2, 8, 8);

        g2.setColor(PIP_COLOR);
        paintPips(g2, x, y, size);
        g2.dispose();
    }

    private void paintPips(Graphics2D g2, int x, int y, int size) {
        int pip = Math.max(4, size / 7);
        int inset = size / 4;
        int mid = size / 2;
        int near = inset;
        int far = size - inset;

        boolean[][] layout = PIP_LAYOUTS[value >= 1 && value <= 6 ? value - 1 : 0];
        int[] xs = {near, mid, far};
        int[] ys = {near, mid, far};
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (layout[row][col]) {
                    g2.fillOval(x + xs[col] - pip / 2, y + ys[row] - pip / 2, pip, pip);
                }
            }
        }
    }

    // Row-major 3x3 pip layouts for die faces 1-6.
    private static final boolean[][][] PIP_LAYOUTS = {
            {{false, false, false}, {false, true, false}, {false, false, false}}, // 1
            {{true, false, false}, {false, false, false}, {false, false, true}},  // 2
            {{true, false, false}, {false, true, false}, {false, false, true}},   // 3
            {{true, false, true}, {false, false, false}, {true, false, true}},    // 4
            {{true, false, true}, {false, true, false}, {true, false, true}},     // 5
            {{true, false, true}, {true, false, true}, {true, false, true}}       // 6
    };
}