package Game.Presentation;

import Models.Elements.Borders.Border;
import Models.Elements.Hex.Hex;

import java.util.List;

public class DrawingState {
    private List<Hex> path;
    private Hex goalHex;
    private boolean showBorder;
    private Border selectedBorder;


    public List<Hex> getPath() {
        return path;
    }

    public void setPath(List<Hex> path) {
        this.path = path;
    }

    public Hex getGoalHex() {
        return goalHex;
    }

    public void setGoalHex(Hex goalHex) {
        this.goalHex = goalHex;
    }

    public boolean isShowBorder() {
        return showBorder;
    }

    public void setShowBorder(boolean showBorder) {
        this.showBorder = showBorder;
    }


    public Border getSelectedBorder() {
        return selectedBorder;
    }

    public void setSelectedBorder(Border selectedBorder) {
        this.selectedBorder = selectedBorder;
    }
}
