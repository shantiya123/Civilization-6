package Controller.Listeners;

import Controller.BoardController;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

public class BoardMouseListener extends MouseAdapter {

    @Override
    public void mouseClicked(MouseEvent e) {
        BoardController.findHex(e.getX() , e.getY());
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        super.mouseWheelMoved(e);
    }
}
