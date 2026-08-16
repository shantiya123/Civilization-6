package Game.Views.BoardPanel;

import Game.Systems.DrawingSystem;

import javax.swing.JPanel;
import java.awt.*;

public class BoardPanel extends JPanel {

    private final DrawingSystem drawingSystem;


    public BoardPanel( DrawingSystem drawingSystem) {
        this.drawingSystem = drawingSystem;
        setBackground(Color.DARK_GRAY);
        setDoubleBuffered(true);
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawingSystem.setViewportSize(getWidth(), getHeight());
        drawingSystem.draw(g);
    }
}
