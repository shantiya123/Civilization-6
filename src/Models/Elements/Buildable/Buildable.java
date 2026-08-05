package Models.Elements.Buildable;

import Models.Elements.Hex.Hex;
import Models.Elements.Resources.Resource;

import java.util.HashMap;
import java.util.Map;
import java.util.HashSet;
import java.util.Set;

public abstract class Buildable {
    protected final Map<Class<? extends Resource>, Integer> BuildingCost;
    protected Map<Class<? extends Resource>, Integer> UPKEEP;
    protected final Set<Class<? extends Hex>> HEX_TYPE;
    protected int BuilderAp;

    protected Buildable() {
        BuildingCost = new HashMap<>();
        UPKEEP = new HashMap<>();
        HEX_TYPE = new HashSet<>();
    }

    public Map<Class<? extends Resource>, Integer> getBuildingCost() {
        return BuildingCost;
    }

    public Map<Class<? extends Resource>, Integer> getUPKEEP() {
        return UPKEEP;
    }

    public Set<Class<? extends Hex>> getHEX_TYPE() {
        return HEX_TYPE;
    }

    public int getBuilderAp() {
        return BuilderAp;
    }

    public void setUPKEEP(Map<Class<? extends Resource>, Integer> UPKEEP) {
        this.UPKEEP = UPKEEP;
    }

    public void setBuilderAp(int builderAp) {
        BuilderAp = builderAp;
    }

}
