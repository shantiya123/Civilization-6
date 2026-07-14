package Models;

import Models.Elements.Hex.Hex;

import java.util.List;

public class ConnectDrawing {
    private Hex selectedHex;

    private List<Hex> path;
    private Hex GoalHex;
    private boolean showBorder = true;


    public Hex getSelectedHex() {
        return selectedHex;
    }

    public List<Hex> getPath() {
        return path;
    }

    public Hex getGoalHex() {
        return GoalHex;
    }

    public void setSelectedHex(Hex selectedHex) {
        this.selectedHex = selectedHex;
    }

    public void setPath(List<Hex> path) {
        this.path = path;
    }

    public void setGoalHex(Hex goalHex) {
        GoalHex = goalHex;
    }

    public boolean isShowBorder() {
        return showBorder;
    }

    public void setShowBorder(boolean showBorder) {
        this.showBorder = showBorder;
    }

}

