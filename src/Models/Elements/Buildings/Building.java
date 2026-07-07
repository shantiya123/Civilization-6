package Models.Elements.Buildings;

import Models.Elements.Hex.Hex;
import Models.Elements.Resources.Resource;
import Models.Elements.Showable;

import java.util.HashMap;
import java.util.Map;

public abstract class Building implements Showable {

    // ----- changeable instance fields -----
    private Hex hex; // hex this building is constructed on
    protected Map<Class<? extends Resource>, Integer> providesPerWorker; // current actual output (depends on stationed workers)
    protected Map<Class<? extends Resource>, Integer> BuildingCost; // current actual output (depends on stationed workers)
    protected static Map<Class<? extends Resource>, Integer> UPKEEP;
    protected Integer workerCapacity;
    // ----- Showable fields -----
    private double x;
    private double y;
    private double size;
    protected int BuilderAp;
    protected Class<? extends Hex> HEX_TYPE;
    protected int workerNumbers;
    protected Building() {
        providesPerWorker = new HashMap<>();
        BuildingCost = new HashMap<>();
    }

    public Hex getHex() { return hex; }
    public void setHex(Hex hex) { this.hex = hex; }

    public Map<Class<? extends Resource>, Integer> getProvidesPerWorker() { return providesPerWorker; }
    public void setProvidesPerWorker(Map<Class<? extends Resource>, Integer> providesPerWorker) { this.providesPerWorker = providesPerWorker; }

    @Override
    public int getX() {
        return 0;
    }

    @Override
    public void setX(int x) {

    }

    @Override
    public int getY() {
        return 0;
    }

    @Override
    public void setY(int y) {

    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public void setSize(int size) {

    }

    public void setSize(double size) { this.size = size; }

    public Map<Class<? extends Resource>, Integer> getBuildingCost() {
        return BuildingCost;
    }

    public static Map<Class<? extends Resource>, Integer> getUPKEEP() {
        return UPKEEP;
    }

    public Integer getWorkerCapacity() {
        return workerCapacity;
    }

    public int getBuilderAp() {
        return BuilderAp;
    }

    public Class<? extends Hex> getHexType() {
        return HEX_TYPE;
    }

    public int getWorkerNumbers() {
        return workerNumbers;
    }

    public void setWorkerNumbers(int workerNumbers) {
        this.workerNumbers = workerNumbers;
    }

    // Each concrete subtype below declares its own static config:
    // REQUIREMENTS, UPKEEP, WOULD_PROVIDE, HEX_TYPE, CAPACITY
    // (Java has no abstract-static, so this can't be enforced at compile time here.)
}