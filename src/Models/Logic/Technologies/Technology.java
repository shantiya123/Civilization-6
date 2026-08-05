package Models.Logic.Technologies;

import Game.World;
import Models.Elements.Resources.Resource;
import Models.Logic.Technologies.Effects.Effect;
import Models.Logic.Logic;

import java.util.Map;

public abstract class Technology extends Logic {
    protected final World world;
    protected int TownHallPrerequisite;
    protected Map<Class<? extends Resource>, Integer> BuildingCost;
    protected int TurnPrerequisite;
    protected Effect effect;
    protected int ResearchRequiredTurns;

    protected Technology(int townHallPrerequisite,
                         Map<Class<? extends Resource>, Integer> buildingCost,
                         int turnPrerequisite, Effect effect , World world , int ResearchRequiredTurns) {
        super(world);
        TownHallPrerequisite = townHallPrerequisite;
        BuildingCost = buildingCost;
        TurnPrerequisite = turnPrerequisite;
        this.effect = effect;
        this.world = world;
        this.ResearchRequiredTurns = ResearchRequiredTurns;
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

    public int getResearchRequiredTurns() {
        return ResearchRequiredTurns;
    }
}
