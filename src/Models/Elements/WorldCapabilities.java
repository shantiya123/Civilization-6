package Models.Elements;

public class WorldCapabilities {

    private boolean unitsCanEnterSea = false;

    private boolean floatUnit = false;
    private int coastalMovementCostReduction = 0;
    private int dockConstructionDiscountPercent = 0;
    private int tradeRateBonusPercent = 0;

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

    public int getCoastalMovementCostReduction() { return coastalMovementCostReduction; }
    public void setCoastalMovementCostReduction(int value) { coastalMovementCostReduction = Math.max(0, value); }
    public int getDockConstructionDiscountPercent() { return dockConstructionDiscountPercent; }
    public void setDockConstructionDiscountPercent(int value) { dockConstructionDiscountPercent = Math.max(0, value); }
    public int getTradeRateBonusPercent() { return tradeRateBonusPercent; }
    public void setTradeRateBonusPercent(int value) { tradeRateBonusPercent = Math.max(0, value); }
    public void changeTradeRateBonusPercent(int amount) { setTradeRateBonusPercent(tradeRateBonusPercent + amount); }
    public void changeDockConstructionDiscountPercent(int amount) { setDockConstructionDiscountPercent(dockConstructionDiscountPercent + amount); }
    public void changeCoastalMovementCostReduction(int amount) { setCoastalMovementCostReduction(coastalMovementCostReduction + amount); }
}
