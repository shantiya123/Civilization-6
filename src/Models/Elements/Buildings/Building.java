package Models.Elements.Buildings;

import Models.Draw.BuildingDraw;
import Game.World;
import Models.Elements.Buildable;
import Models.Elements.Hex.Hex;
import Models.Elements.Resources.Resource;
import Models.Elements.Showable;
import Models.Elements.Vulnerable;
import Models.Logic.BuildingLogic.BuildingLogic;
import Utils.ImageLoader;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public abstract class Building implements Showable, Vulnerable, Buildable {
    private Hex hex;
    protected int HP;
    protected Map<Class<? extends Resource>, Integer> providesPerWorker;
    /** Output added once per turn, independently from the number of workers. */
    protected Map<Class<? extends Resource>, Integer> adjacencyBonus;
    protected Map<Class<? extends Resource>, Integer> BuildingCost;
    protected Map<Class<? extends Resource>, Integer> UPKEEP;
    protected Integer workerCapacity;
    private double x;
    private double y;
    private double size;
    protected int BuilderAp;
    protected Set<Class<? extends Hex>> HEX_TYPE;
    protected int workerNumbers;
    protected BuildingLogic logic;
    protected BuildingDraw draw;
    protected String LightImagePath;
    protected String DarkerImagePath;
    protected Image image;


    private int decayCountdown = 0;

    protected Building(World world) {
        HEX_TYPE = new HashSet<>();
        providesPerWorker = new HashMap<>();
        adjacencyBonus = new HashMap<>();
        BuildingCost = new HashMap<>();
        logic = new BuildingLogic(this, world);
        draw = new BuildingDraw(this);
    }


    public Hex getHex() { return hex; }
    public void setHex(Hex hex) { this.hex = hex; }

    public Map<Class<? extends Resource>, Integer> getProvidesPerWorker() { return providesPerWorker; }
    public void setProvidesPerWorker(Map<Class<? extends Resource>, Integer> providesPerWorker) { this.providesPerWorker = providesPerWorker; }

    public Map<Class<? extends Resource>, Integer> getAdjacencyBonus() {
        return adjacencyBonus;
    }

    public void clearAdjacencyBonus() {
        adjacencyBonus.clear();
    }

    public void addAdjacencyBonus(Class<? extends Resource> resourceClass, int amount) {
        adjacencyBonus.merge(resourceClass, amount, Integer::sum);
    }

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

    @Override
    public int getHP() {
        return HP;
    }

    @Override
    public void setHP(int HP) {
        this.HP = HP;
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

    public Set<Class<? extends Hex>> getHEX_TYPE() {
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

    public void setDarker() {
        if (DarkerImagePath != null) {
            this.image = ImageLoader.load(DarkerImagePath);
        }
    }

    public void setLighter() {
        if (LightImagePath != null) {
            this.image = ImageLoader.load(LightImagePath);
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


    public int getDecayCountdown() {
        return decayCountdown;
    }

    public void setDecayCountdown(int decayCountdown) {
        this.decayCountdown = decayCountdown;
    }
}
