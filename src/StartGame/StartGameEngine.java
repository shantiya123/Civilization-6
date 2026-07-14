package StartGame;

import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class StartGameEngine {

    private static final int MARGIN = 30;
    private static final int STACK_GAP = 16;

    private final StartGameFrame frame;
    private final StartGamePanel panel;

    public StartGameEngine(StartGameState state) {
        this.frame = new StartGameFrame();

        state.setFrameToClose(this.frame);

        this.panel = new StartGamePanel(state);

        frame.setContentPane(panel);
        layoutButtons();

        frame.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                layoutButtons();
            }
        });
    }

    private void layoutButtons() {
        int w = panel.getWidth() > 0 ? panel.getWidth() : frame.getWidth();
        int h = panel.getHeight() > 0 ? panel.getHeight() : frame.getHeight();

        Dimension startSize = panel.getStartButton().getPreferredSize();

        panel.getStartButton().setBounds(
                w - startSize.width - MARGIN,
                h - startSize.height - MARGIN,
                startSize.width,
                startSize.height
        );

        panel.getMusicToggleButton().setBounds(
                w - MARGIN - startSize.width / 2 - MusicToggleButton.DIAMETER / 2,
                h - startSize.height - MARGIN - STACK_GAP - MusicToggleButton.DIAMETER,
                MusicToggleButton.DIAMETER,
                MusicToggleButton.DIAMETER
        );
    }

    public void show() {
        frame.setVisible(true);
        layoutButtons();
    }
}