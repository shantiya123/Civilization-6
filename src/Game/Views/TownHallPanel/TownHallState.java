package Game.Views.TownHallPanel;

import Models.Elements.Buildable.Buildings.TownHall;
import Models.Elements.Units.*;
import Models.Logic.BuildingLogic.TownHallLogic.TownHallGenerateUnit;

import java.util.HashMap;
import java.util.Map;

public class TownHallState {
    private final TownHall townHall;
    private final TownHallGenerateUnit generateUnit;
    private final Map<Class<? extends Unit>, String> relatedPicture;

    public TownHallState(TownHall townHall) {
        this.townHall = townHall;
        this.generateUnit = townHall.getGenerateUnit();
        relatedPicture = new HashMap<>();
        relatedPicture.put(Worker.class, "/Images/UnitBackground/ChatGPT Image Jul 13, 2026, 05_33_53 PM.png");
        relatedPicture.put(BorderExpander.class, "/Images/UnitBackground/5956229881702059521.jpg");
        relatedPicture.put(Explorer.class, "/Images/UnitBackground/ChatGPT Image Jul 13, 2026, 05_42_04 PM.png");
        relatedPicture.put(Builder.class, "/Images/UnitBackground/ChatGPT Image Jul 13, 2026, 05_50_12 PM.png");
    }

    public boolean isFinished() {
        return generateUnit.isFinished();
    }

    public Unit getCurrentUnit() {
        return generateUnit.getUnit();
    }

    public int getStep() {
        return generateUnit.getStep();
    }

    public int getTotalStep() {
        return generateUnit.getTotalStep();
    }

    public String getPicturePath(Class<? extends Unit> unitClass) {
        return relatedPicture.get(unitClass);
    }

}