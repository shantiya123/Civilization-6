package Models.Elements.Strategies.Technologies;

import Models.Elements.Resources.Resource;
import Models.Elements.Strategies.Technologies.Effects.Effect;

import java.util.Map;

public abstract class Technology {

    protected int TownHallPrerequisite;
    protected Map<Class<? extends Resource>, Integer> BuildingCost;
    protected int TurnPrerequisite;
    protected Effect effect;

    protected Technology(int townHallPrerequisite,
                         Map<Class<? extends Resource>, Integer> buildingCost,
                         int turnPrerequisite, Effect effect) {
        TownHallPrerequisite = townHallPrerequisite;
        BuildingCost = buildingCost;
        TurnPrerequisite = turnPrerequisite;
        this.effect = effect;
    }

    public int getTownHallPrerequisite() {
        return TownHallPrerequisite;
    }

    public void setTownHallPrerequisite(int townHallPrerequisite) {
        TownHallPrerequisite = townHallPrerequisite;
    }

    public Map<Class<? extends Resource>, Integer> getBuildingCost() {
        return BuildingCost;
    }

    public void setBuildingCost(Map<Class<? extends Resource>, Integer> buildingCost) {
        BuildingCost = buildingCost;
    }

    public int getTurnPrerequisite() {
        return TurnPrerequisite;
    }

    public void setTurnPrerequisite(int turnPrerequisite) {
        TurnPrerequisite = turnPrerequisite;
    }

    public Effect getEffect() {
        return effect;
    }

    public void setEffect(Effect effect) {
        this.effect = effect;
    }
}
