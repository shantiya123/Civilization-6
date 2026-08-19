package Game.Systems.Drawers;

import Models.Elements.Borders.Border;
import Models.Records.BorderRecorder;

import java.awt.*;

public class DrawBorders {
    private final BorderRecorder borderRecorder;

    public DrawBorders(BorderRecorder borderRecorder) {
        this.borderRecorder = borderRecorder;
    }
    public void draw(Graphics g){
        for (Border border: borderRecorder.getAll()){
//            System.out.println(border);
            border.getDraw().draw(g);
        }
    }
}
