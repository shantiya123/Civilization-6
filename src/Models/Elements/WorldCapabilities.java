package Models.Elements;

public class WorldCapabilities {

    private boolean unitsCanEnterSea = false;

    private boolean floatUnit = false;

    public boolean canUnitsEnterSea() {
        return unitsCanEnterSea;
    }

    public boolean isUnitsCanEnterSea() {
        return unitsCanEnterSea;
    }

    public boolean isFloatUnit() {
        return floatUnit;
    }

    public void setFloatUnit(boolean floatUnit) {
        this.floatUnit = floatUnit;
    }

    public void setUnitsCanEnterSea(boolean unitsCanEnterSea) {
        this.unitsCanEnterSea = unitsCanEnterSea;
    }
}
