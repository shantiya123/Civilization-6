package Game.Views.Listeners;

import Game.Controller.BoardController;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

public class BoardMouseListener extends MouseAdapter {
    private final BoardController boardController;

    public BoardMouseListener(BoardController boardController) {
        this.boardController = boardController;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        boardController.mouseClicked(e.getX() , e.getY());
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        boardController.mouseWheelChanged(e.getWheelRotation());
        super.mouseWheelMoved(e);
    }


    @Override
    public void mouseMoved(MouseEvent e) {
        boardController.mouseMoved(e.getX() , e.getY());
    }
}
