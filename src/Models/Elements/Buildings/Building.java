package Models.Elements.Buildings;

import Models.Draw.BuildingDraw;
import Models.Elements.Hex.Hex;
import Models.Elements.Resources.Resource;
import Models.Elements.Showable;
import Models.Logic.BuildingLogic.BuildingLogic;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public abstract class Building implements Showable {

    // ----- changeable instance fields -----
    private Hex hex; // hex this building is constructed on
    protected Map<Class<? extends Resource>, Integer> providesPerWorker; // current actual output (depends on stationed workers)
    protected Map<Class<? extends Resource>, Integer> BuildingCost; // current actual output (depends on stationed workers)
    protected Map<Class<? extends Resource>, Integer> UPKEEP;
    protected Integer workerCapacity;
    // ----- Showable fields -----
    private double x;
    private double y;
    private double size;
    protected int BuilderAp;
    protected Class<? extends Hex> HEX_TYPE;
    protected int workerNumbers;
    protected BuildingLogic logic;
    protected BuildingDraw draw;
    protected String LightImagePath;
    protected String DarkerImagePath;
    protected Image image;

    protected Building() {
        providesPerWorker = new HashMap<>();
        BuildingCost = new HashMap<>();
        logic = new BuildingLogic(this);
        draw = new BuildingDraw(this);
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

    public Map<Class<? extends Resource>, Integer> getUPKEEP() {
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

    public BuildingDraw getDraw() {
        return draw;
    }

    public BuildingLogic getLogic() {
        return logic;
    }

    public void initializeImages() {
        setDarker(); // default state
    }

    public Image getImage() {
        return image;
    }

    // ADDED: Toggle active asset to darker path variant
    public void setDarker() {
//        System.out.println("Set Darker called ");
        if (DarkerImagePath != null) {
            this.image = new ImageIcon(DarkerImagePath).getImage();
        }
    }

    // ADDED: Toggle active asset to lighter path variant
    public void setLighter() {
//        System.out.println("Set lighter Called");
        if (LightImagePath != null) {
            this.image = new ImageIcon(LightImagePath).getImage();
        }
    }

    public void setLogic(BuildingLogic logic) {
        this.logic = logic;
    }

    public String getLightImagePath() {
        return LightImagePath;
    }

    public String getDarkerImagePath() {
        return DarkerImagePath;
    }
}