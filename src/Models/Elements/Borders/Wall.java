package Models.Elements.Borders;

import Models.Elements.Buildable;
import Models.Elements.Hex.Hex;
import Models.Elements.Resources.Resource;
import Models.Elements.Resources.Stone;
import Models.Elements.Resources.Wood;
import Models.Elements.Vulnerable;

import java.util.Map;

public class Wall extends Border implements Buildable, Vulnerable {

    protected int HP;
    protected Map<Class<? extends Resource>, Integer> BuildingCost;

    public Wall(Hex firstHex, Hex secondHex) {
        super(firstHex, secondHex);
        HP = 100;
        BuildingCost = Map.of(Wood.class, 5, Stone.class, 15);
    }

    @Override
    public int getHP() {
        return HP;
    }

    @Override
    public void setHP(int HP) {
        this.HP = HP;
    }

    @Override
    public Map<Class<? extends Resource>, Integer> getBuildingCost() {
        return BuildingCost;
    }
}
