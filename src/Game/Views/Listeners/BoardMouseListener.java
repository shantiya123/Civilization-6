package Game.Views.Listeners;

import Game.Controller.BoardController;

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
        System.out.println("kiiiiir");
        System.out.println(e.getWheelRotation());
        BoardController.Zoom(e.getWheelRotation());
        super.mouseWheelMoved(e);
    }


    @Override
    public void mouseMoved(MouseEvent e) {
//        System.out.println("Kir2");
    }
}
