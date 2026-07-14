# Java Project

## Project Structure

- src/Animation/BaseAnimation.java
- src/Animation/PanAnimation.java
- src/Animation/TimerEquations.java
- src/Animation/UnitMoveAnimation.java
- src/Animation/ZoomAnimation.java
- src/BoardGame/BoardState.java
- src/Game/Controller/BoardController.java
- src/Game/Controller/Finder.java
- src/Game/Controller/HUDController.java
- src/Game/Controller/tempBC.java
- src/Game/Controller/UnitPanelController.java
- src/Game/Game.java
- src/Game/Generate.java
- src/Game/Managers/AnimationManager.java
- src/Game/Managers/ControllerManager.java
- src/Game/Managers/SystemManager.java
- src/Game/Managers/TurnManager.java
- src/Game/Managers/ViewManager.java
- src/Game/Starter.java
- src/Game/Systems/BoardSystem.java
- src/Game/Systems/Drawers/DrawBuildings.java
- src/Game/Systems/Drawers/DrawHexes.java
- src/Game/Systems/Drawers/DrawUnits.java
- src/Game/Systems/Drawers/PathDrawer.java
- src/Game/Systems/Drawers/SelectDrawer.java
- src/Game/Systems/DrawingSystem.java
- src/Game/Systems/ElementSystem/BuildSystem.java
- src/Game/Systems/ElementSystem/ExplorationSystem.java
- src/Game/Systems/ElementSystem/MovementSystem.java
- src/Game/Systems/ElementSystem/StarvationSystem.java
- src/Game/Systems/ElementSystem/WorkSystem.java
- src/Game/Systems/EventSystem/BoardEvent.java
- src/Game/Systems/EventSystem/BoardExpandEvent.java
- src/Game/Systems/EventSystem/BuildingEvent.java
- src/Game/Systems/EventSystem/Event.java
- src/Game/Systems/EventSystem/EventSystem.java
- src/Game/Systems/EventSystem/ExplorEvent.java
- src/Game/Systems/EventSystem/SelectEvent.java
- src/Game/Systems/EventSystem/TurnEvent.java
- src/Game/Systems/EventSystem/UnitEvent.java
- src/Game/Systems/EventSystem/WorkEvent.java
- src/Game/Systems/Restarters/BuildingRestarter.java
- src/Game/Systems/Restarters/TownHallRestarter.java
- src/Game/Systems/Restarters/UnitRestarter.java
- src/Game/Systems/RestarterSystem.java
- src/Game/Systems/SelectSystem.java
- src/Game/Systems/TownHallSystem.java
- src/Game/Systems/VisibilitySystem.java
- src/Game/Turn/TurnState.java
- src/Game/Views/BoardPanel/BoardPanel.java
- src/Game/Views/BoardPanel/EndTurnButton.java
- src/Game/Views/GameEngine.java
- src/Game/Views/GameFrame.java
- src/Game/Views/HexBuildingPanel/HexBuildingState.java
- src/Game/Views/HUDPanel/HUDAssets.java
- src/Game/Views/HUDPanel/HUDPanel.java
- src/Game/Views/HUDPanel/HUDState.java
- src/Game/Views/HUDPanel/ResourceEntryComponent.java
- src/Game/Views/HUDPanel/ResourcePanel.java
- src/Game/Views/HUDPanel/TurnPanel.java
- src/Game/Views/HUDPanel/UnitRosterButton.java
- src/Game/Views/HUDPanel/UnitRosterPanel.java
- src/Game/Views/Listeners/BoardMouseListener.java
- src/Game/Views/TownHallPanel/TownHallPanel.java
- src/Game/Views/TownHallPanel/TownHallState.java
- src/Game/Views/UnitPanel/BorderExpanderUnitPanel.java
- src/Game/Views/UnitPanel/BuilderUnitPanel.java
- src/Game/Views/UnitPanel/ExplorerUnitPanel.java
- src/Game/Views/UnitPanel/UnitPanel.java
- src/Game/Views/UnitPanel/UnitPanelState.java
- src/Game/Views/UnitPanel/WorkerUnitPanel.java
- src/Game/World.java
- src/Main.java
- src/Models/ConnectDrawing.java
- src/Models/ConnectViews.java
- src/Models/Draw/BuildingDraw.java
- src/Models/Draw/Draw.java
- src/Models/Draw/HexDraw.java
- src/Models/Draw/UnitDraw.java
- src/Models/Draw/UnitPositionCalculator.java
- src/Models/Elements/Buildings/Building.java
- src/Models/Elements/Buildings/Farm.java
- src/Models/Elements/Buildings/IronMine.java
- src/Models/Elements/Buildings/LumberMill.java
- src/Models/Elements/Buildings/Settlement.java
- src/Models/Elements/Buildings/Stable.java
- src/Models/Elements/Buildings/StoneMine.java
- src/Models/Elements/Buildings/TownHall.java
- src/Models/Elements/Element.java
- src/Models/Elements/Hex/ForestHex.java
- src/Models/Elements/Hex/GrassHex.java
- src/Models/Elements/Hex/Hex.java
- src/Models/Elements/Hex/LandHex.java
- src/Models/Elements/Hex/MountainHex.java
- src/Models/Elements/Resources/Food.java
- src/Models/Elements/Resources/Iron.java
- src/Models/Elements/Resources/Resource.java
- src/Models/Elements/Resources/Stone.java
- src/Models/Elements/Resources/Wood.java
- src/Models/Elements/Showable.java
- src/Models/Elements/Units/BorderExpander.java
- src/Models/Elements/Units/Builder.java
- src/Models/Elements/Units/Explorer.java
- src/Models/Elements/Units/Unit.java
- src/Models/Elements/Units/Worker.java
- src/Models/Generator.java
- src/Models/Logic/BoardLogic.java
- src/Models/Logic/BuildingLogic/BuildingLogic.java
- src/Models/Logic/BuildingLogic/SettlementLogic.java
- src/Models/Logic/BuildingLogic/TownHallGenerateUnit.java
- src/Models/Logic/BuildingLogic/TownHallLogic.java
- src/Models/Logic/HexLogic/HexGenerator.java
- src/Models/Logic/HexLogic/HexLogic.java
- src/Models/Logic/Logic.java
- src/Models/Logic/UnitLogic/BorderExpanderLogic.java
- src/Models/Logic/UnitLogic/BuilderLogic.java
- src/Models/Logic/UnitLogic/ExplorerLogic.java
- src/Models/Logic/UnitLogic/FindBestPath.java
- src/Models/Logic/UnitLogic/PathNode.java
- src/Models/Logic/UnitLogic/UnitLogic.java
- src/Models/Logic/UnitLogic/WorkerLogic.java
- src/Models/Manager/HexManager.java
- src/Models/Manager/Hexutils.java
- src/Models/Records/BuildingRecord.java
- src/Models/Records/HexRecord.java
- src/Models/Records/ResourceRecord.java
- src/Models/Records/UnitRecord.java

---

# File: src/Animation/BaseAnimation.java

```java
package Animation;

public abstract class BaseAnimation {
    protected final int totalSteps;
    protected int currentStep = 0;
    private boolean finished = false;
    private boolean cancelled = false;

    public BaseAnimation(int totalSteps) {
        this.totalSteps = totalSteps;
    }

    /**
     * Process a single tick. Returns false when finished or cancelled.
     */
    public boolean step() {
        if (finished || cancelled) return false;

        currentStep++;
        double linearProgress = (double) currentStep / totalSteps;

        onTick(linearProgress);

        if (currentStep >= totalSteps) {
            finished = true;
            onComplete();
        }
        return !finished;
    }

    /** Stops this animation immediately without running onComplete — used when a newer animation supersedes it. */
    public void cancel() {
        this.cancelled = true;
    }

    public boolean isCancelled() {
        return cancelled;
    }

    protected abstract void onTick(double progress);
    protected void onComplete() {}
}
```

---

# File: src/Animation/PanAnimation.java

```java
package Animation;

import Models.Elements.Hex.Hex;
import Models.Manager.HexManager;

public class PanAnimation extends BaseAnimation {
    private final HexManager hexManager;
    private final int totalDx;
    private final int totalDy;
    private double lastProgress = 0.0;

    private static final int CENTER_X = 665;
    private static final int CENTER_Y = 335;

    public PanAnimation(Hex targetHex, HexManager hexManager) {
        super(40); // 40 steps total
        this.hexManager = hexManager;

        // Target calculation logic
        this.totalDx = -(targetHex.getCenterX() - CENTER_X);
        this.totalDy = -(targetHex.getCenterY() - CENTER_Y);
    }

    @Override
    protected void onTick(double progress) {
        // Your smooth curve equation
        double smoothProgress = TimerEquations.easeOut(progress);
        double deltaProgress = smoothProgress - lastProgress;
        lastProgress = smoothProgress;

        // Apply exactly your fractional translation formula
        int moveX = (int) (deltaProgress * totalDx) / 2;
        int moveY = (int) (deltaProgress * totalDy) / 2;

        hexManager.pan(moveX, moveY);
    }
}
```

---

# File: src/Animation/TimerEquations.java

```java
package Animation;

public class TimerEquations {

    /**
     * Linear — constant speed, no easing.
     * t goes from 0.0 to 1.0
     */
    public static double linear(double t) {
        return t;
    }

    /**
     * Ease out — starts fast, slows down at the end. (most natural for panning)
     */
    public static double easeOut(double t) {
        return 1 - Math.pow(1 - t, 3);
    }

    /**
     * Ease in — starts slow, speeds up at the end.
     */
    public static double easeIn(double t) {
        return t * t * t;
    }

    /**
     * Ease in-out — slow start, fast middle, slow end.
     */
    public static double easeInOut(double t) {
        return t < 0.5 ? 4 * t * t * t : 1 - Math.pow(-2 * t + 2, 3) / 2;
    }

    /**
     * Smooth step — similar to ease in-out but simpler curve.
     */
    public static double smoothStep(double t) {
        return t * t * (3 - 2 * t);
    }

    /**
     * Bounce — overshoots and snaps back.
     */
    public static double bounce(double t) {
        return 1 - Math.abs(Math.cos(t * Math.PI * 2.5)) * (1 - t);
    }
}
```

---

# File: src/Animation/UnitMoveAnimation.java

```java
package Animation;

import Models.Draw.UnitPositionCalculator;
import Models.Elements.Hex.Hex;
import Models.Elements.Units.Unit;
import Game.Managers.AnimationManager;
import java.awt.Point;
import java.util.List;

public class UnitMoveAnimation extends BaseAnimation {
    private final Unit unit;
    private final List<Hex> path; // Dynamically calculated path list
    private final AnimationManager animationManager;
    private boolean isRunning;

    private final int totalSegments;

    public UnitMoveAnimation(Unit unit, Hex sourceHex, Hex targetHex, int totalSteps, AnimationManager animationManager) {
        // 1. Calculate the actual sequential path right inside the constructor
        // This keeps your MovementSystem clean and untouched!
        super(totalSteps);
        this.unit = unit;
        this.animationManager = animationManager;

        // Use your unit's logic to fetch the full sequential path of hexes
        this.path = unit.getLogic().getBestPath(targetHex);

        // Fallback: If no path found, treat the straight line as a single segment
        if (this.path == null || this.path.size() < 2) {
            this.totalSegments = 1;
        } else {
            this.totalSegments = this.path.size() - 1;
        }

        this.isRunning = true;
    }

    @Override
    protected void onTick(double overallProgress) {
        // 1. Map the overall progress (0.0 to 1.0) to our sequential segments
        double exactSegment = overallProgress * totalSegments;
        int currentSegmentIndex = (int) Math.floor(exactSegment);

        if (currentSegmentIndex >= totalSegments) {
            currentSegmentIndex = totalSegments - 1;
        }

        // 2. Get local progress inside this specific hex-to-hex step
        double localProgress = exactSegment - currentSegmentIndex;
        double eased = localProgress * localProgress * (3 - 2 * localProgress);

        // 3. Extract the active segment hexes
        Hex sourceHex;
        Hex targetHex;

        if (path != null && path.size() >= 2) {
            sourceHex = path.get(currentSegmentIndex);
            targetHex = path.get(currentSegmentIndex + 1);
        } else {
            // Fallback safety logic
            sourceHex = this.unit.getHex();
            targetHex = path != null && !path.isEmpty() ? path.get(path.size() - 1) : this.unit.getHex();
        }

        if (sourceHex == null || targetHex == null) return;

        // 4. Calculate visual positions
        Point startPoint = UnitPositionCalculator.computeRestPosition(unit, sourceHex);
        Point endPoint = UnitPositionCalculator.computeRestPosition(unit, targetHex);

        int x = (int) (startPoint.x + (endPoint.x - startPoint.x) * eased);
        int y = (int) (startPoint.y + (endPoint.y - startPoint.y) * eased);

        int startSize = (int) (sourceHex.getSize() * 0.2);
        int endSize = (int) (targetHex.getSize() * 0.2);
        int size = (int) (startSize + (endSize - startSize) * eased);

        unit.setX(x);
        unit.setY(y);
        unit.setSize(size);

        animationManager.refresh();
    }

    @Override
    protected void onComplete() {
        this.isRunning = false;

        try {
            // Retrieve final target destination
            Hex finalTarget = (path != null && path.size() >= 2) ? path.get(path.size() - 1) : this.unit.getHex();
            Hex originalStart = (path != null && !path.isEmpty()) ? path.get(0) : this.unit.getHex();

            if (finalTarget != null) {
                // Instantly sync the logic engine's internal board state at the finish line
                unit.getLogic().moveToHex(finalTarget);

                UnitPositionCalculator.refreshHex(originalStart, unit);
                UnitPositionCalculator.refreshHex(finalTarget, unit);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        animationManager.refresh();
    }

    public boolean isRunning() { return isRunning; }
    public Unit getUnit() { return unit; }
}
```

---

# File: src/Animation/ZoomAnimation.java

```java
package Animation;

import Models.Manager.HexManager;

public class ZoomAnimation extends BaseAnimation {
    private final HexManager hexManager;
    private final int startZoom;
    private final int targetZoom;
    private final int totalDZoom;
    private final Runnable callback;

    public ZoomAnimation(int zoomDelta, HexManager hexManager, Runnable callback) {
        super(40);
        this.hexManager = hexManager;
        this.callback = callback;

        int[] zoomLevels = hexManager.getZoom();
        int currentIdx = hexManager.getZoomIndex();
        int targetIdx = Math.max(0, Math.min(zoomLevels.length - 1, currentIdx + zoomDelta));

        this.startZoom = hexManager.getSize();     // actual current visual size, not the table lookup
        this.targetZoom = zoomLevels[targetIdx];
        this.totalDZoom = targetZoom - startZoom;

        hexManager.setZoomIndex(targetIdx);
    }

    @Override
    protected void onTick(double progress) {
        if (totalDZoom == 0) return;

        double smoothProgress = TimerEquations.easeOut(progress);
        int ongoingSize = (int) (startZoom + smoothProgress * totalDZoom);
        hexManager.setSize(ongoingSize);
    }

    @Override
    protected void onComplete() {
        // Guarantee alignment snap
        hexManager.setSize(targetZoom);
        if (callback != null) {
            callback.run();
        }
    }
}
```

---

# File: src/BoardGame/BoardState.java

```java
package BoardGame;

import Models.Elements.Hex.GrassHex;
import Models.Elements.Hex.ForestHex;
import Models.Elements.Hex.LandHex;
import Models.Elements.Hex.MountainHex;
import Models.Manager.HexManager;

import java.awt.*;

public class BoardState {

    // Game state fields will go here
    // e.g. tiles, units, resources, turn number...
    private HexManager hexManager;
    public BoardState() {
        // Initialize game state here later
//        hexManager = new HexManager(400 , 200);
//        hexManager.addHex(new MountainHex(0 , 0));
//        hexManager.addHex(new GrassHex(0 , 2));
//        hexManager.addHex(new ForestHex(-1 , 0));
//        hexManager.addHex(new LandHex(0 , -1));
//        hexManager.addHex(new LandHex(1 , -1));
//        hexManager.addHex(new LandHex(1 , 1));
//        hexManager.addHex(new LandHex( 2 , 1));
//        hexManager.addHex(new GrassHex(2 , 0));
//        hexManager.addHex(new ForestHex(1 , 2));
//        hexManager.addHex(new MountainHex(0 , -2));
//        hexManager.addHex(new MountainHex(1 , -2));
//        hexManager.addHex(new MountainHex(0 , -3));
//        hexManager.addHex(new MountainHex(1 , -3));
//        hexManager.addHex(new JungleHex(0 , 2));
    }

    /**
     * Main draw method — called by BoardPanel every repaint.
     * Fill this in to render the hex map, units, HUD, etc.
     */
    public void draw(Graphics g, int width, int height) {
//        g.drawImage(new GrassHex(50 , 100).getImage(),50 , 80 , );
        hexManager.draw(g);
//        g.setColor(Color.RED);
//        g.fillOval(650, 320 , 30 , 30);
        // TODO: draw hex grid
        // TODO: draw units
        // TODO: draw HUD
        // TODO: draw fog of war
    }
}
```

---

# File: src/Game/Controller/BoardController.java

```java
package Game.Controller;

import Game.Systems.BoardSystem;
import Game.Systems.ElementSystem.MovementSystem;
import Game.Systems.EventSystem.EventSystem;
import Game.Systems.SelectSystem;
import Game.World;
import Models.Elements.Hex.Hex;
import Models.Elements.Units.Unit;
import Models.Elements.Buildings.Building;

public class BoardController {
    private Finder finder;
    private World world;
    private MovementSystem movementSystem;
    private BoardSystem boardSystem;
    private SelectSystem selectSystem;
    private final EventSystem eventSystem;

    public BoardController(World world, MovementSystem movementSystem, BoardSystem boardSystem, SelectSystem selectSystem, EventSystem eventSystem) {
        this.world = world;
        this.movementSystem = movementSystem;
        this.boardSystem = boardSystem;
        this.selectSystem = selectSystem;
        this.finder = new Finder(world);
        this.eventSystem = eventSystem;
    }

    public void mouseClicked(int x, int y) {
        Unit unit = finder.findUnit(x, y);
        if (unit != null) {
            selectSystem.selectUnit(unit);
        } else {
            Hex hex = finder.findHex(x, y);
            if (hex != null) {
                selectSystem.selectHex(hex);
            }
        }

        // THIS LINE MUST BE ACTIVE FOR THE MOVEMENT CHECK TO FIRED:
        movementSystem.UnitMove();
    }

    public void mouseWheelChanged(int rotate) {
        boardSystem.zoom(rotate * -1);
    }

    public void mouseDragged(int x , int y) {
        boardSystem.moveBoard(x , y);
    }

    public void mouseMoved(int x, int y) {
        Hex hoveredHex = finder.findHex(x, y);
        if (hoveredHex != null) {
            selectSystem.hoverHex(hoveredHex);
        }
    }

    public void TurnEnded(){
        eventSystem.getTurnEvent().EndTurn();
    }
}
```

---

# File: src/Game/Controller/Finder.java

```java
package Game.Controller;

import Game.World;
import Models.Elements.Hex.Hex;
import Models.Elements.Units.Unit;
import Models.Elements.Buildings.Building;
import java.util.ArrayList;
import java.util.List;

public class Finder {
    private World world;

    public Finder(World world) {
        this.world = world;
    }

    public Hex findHex(int x, int y) {
        Hex TheHex = null;
        for (Hex hex : world.getHexRecord().getAll()){
            int dx = x - hex.getCenterX();
            int dy = y - hex.getCenterY();
            int r = (int) (hex.getSize() * 0.8);

            if (Math.sqrt(dx  * dx + dy * dy) < r){
                TheHex = hex;
            }
        }
        return TheHex;
    }

    public Unit findUnit(int x, int y) {
        // Iterate backward (or forward) through all units to find which one was clicked
        for (Unit unit : world.getUnitRecord().getAll()) {
            if (unit == null) continue;

            Hex hex = unit.getHex();
            if (hex == null || !hex.isVisible()) continue;

            // 1. Reconstruct the shared hex collection to find this unit's index position
            List<Unit> sharedHexUnits = new ArrayList<>();
            for (Unit u : world.getUnitRecord().getAll()) {
                if (u != null && hex.equals(u.getHex())) {
                    sharedHexUnits.add(u);
                }
            }

            int totalUnits = sharedHexUnits.size();
            int myIndex = -1;
            for (int i = 0; i < sharedHexUnits.size(); i++) {
                if (sharedHexUnits.get(i) == unit) { // Strict reference comparison matching UnitDraw
                    myIndex = i;
                    break;
                }
            }
            if (myIndex == -1) myIndex = 0;

            // 2. Mirror the layout math from UnitDraw to pinpoint the unit's actual visual center
            int centerX = hex.getCenterX();
            int centerY = hex.getCenterY();
            double orbitRadius = hex.getSize() * 0.45;
            int unitSize = (int) (hex.getSize() * 0.4);

            int targetX = centerX;
            int targetY = centerY;

            if (totalUnits > 1) {
                double angle = (2.0 * Math.PI * myIndex) / totalUnits;
                targetX = centerX + (int) (orbitRadius * Math.cos(angle));
                targetY = centerY + (int) (orbitRadius * Math.sin(angle));
            }

            // 3. Collision check: Is the click coordinates (x, y) inside this unit's bounding oval/circle?
            int dx = x - targetX;
            int dy = y - targetY;
            int hitRadius = unitSize / 2;

            if (Math.sqrt(dx * dx + dy * dy) <= hitRadius) {
                return unit; // Found it!
            }
        }

        return null; // No unit was clicked at these coordinates
    }

    public Building findBuilding(int x, int y) {
        return null;
    }

    // Generic structural approach for finding elements
    public <T> T findElementAt(int x, int y, Class<T> type) {
        return null;
    }
}
```

---

# File: src/Game/Controller/HUDController.java

```java
package Game.Controller;

import Game.Managers.SystemManager;
import Game.Systems.TownHallSystem;
import Models.Elements.Units.Unit;


public class HUDController {
    private SystemManager systemManager;

    public HUDController(SystemManager systemManager) {
        this.systemManager = systemManager;
    }

    public void addToTownHall(Class<? extends Unit> unitClass){
        try {
            // 1. Create a brand new Unit using the empty constructor (no arguments)
            Unit unit = unitClass.getDeclaredConstructor().newInstance();

            // 2. Pass that newly created unit to the TownHall system
            systemManager.getTownHallSystem().addToTownHall(unit);

        } catch (Exception e) {
            e.printStackTrace(); // Handle your exception properly
        }
    }

}

```

---

# File: src/Game/Controller/tempBC.java

```java
package Game.Controller;



public class tempBC {
//    private static boolean zoomReady = true; // true = ready to accept a zoom
//
//    public static void findHex(int x, int y) {
//        Hex closest = null;
//        double minDist = Double.MAX_VALUE;
//
//        for (Hex hex : HexManager.getHexes()) {
//            int dx = x - hex.getCenterX();
//            int dy = y - hex.getCenterY();
//            double dist = Math.sqrt(dx * dx + dy * dy);
//            if (dist < minDist) {
//                minDist = dist;
//                closest = hex;
//            }
//        }
//
//        if (closest != null && minDist < closest.getSize() * 1.6) {
//            System.out.println("hex: q=" + closest.getQ() + " r=" + closest.getR());
//            BoardAnimations.SelectTheHexAnimation(closest);
//        }
//    }
//
//    public static void Zoom(int rotate) {
//        if (!zoomReady) return; // animation still running, ignore
//        zoomReady = false;      // lock — no more zooms until animation finishes
//        ZoomAnimation.StartZoomAnimation(-1 * rotate);
//    }
//
//    public static void resetZoom() {
//        zoomReady = true; // called by ZoomAnimation when it finishes
//    }
}

```

---

# File: src/Game/Controller/UnitPanelController.java

```java
package Game.Controller;

import Game.Managers.SystemManager;
import Models.Elements.Buildings.Building;
import Models.Elements.Buildings.Farm; // Sample default structure

public class UnitPanelController {
    private final SystemManager systemManager;

    public UnitPanelController(SystemManager systemManager) {
        this.systemManager = systemManager;
    }

    // Worker routes
    public void stationWorker() {
        systemManager.getWorkSystem().stationWorker();
    }

    public void unstationWorker() {
        systemManager.getWorkSystem().unstationWorker();
    }

    // Builder routes (Defaults to constructing a Farm for demonstration)
    public void build() {
        System.out.println("Build inside controller called ");
        systemManager.getBuildSystem().buildStructure(Farm.class);
    }

    public void build(Class<? extends Building> buildingClass) {
        systemManager.getBuildSystem().buildStructure(buildingClass);
    }

    // Explorer routes
    public void exploreSurroundings() {
        systemManager.getExplorationSystem().exploreSurroundings();
    }

    // BorderExpander routes
    public void expandBorder() {
        systemManager.getExplorationSystem().expandBorder();
    }
}
```

---

# File: src/Game/Game.java

```java
package Game;

import Game.Managers.*;

import Game.Systems.DrawingSystem;

public class Game {
    private World world;
    private TurnManager turnManager;
    private SystemManager systemManager;
    private AnimationManager animationManager;
    private ControllerManager controllerManager;
    private ViewManager viewManager;
    private Starter starter;


    public Game() {
        animationManager = new AnimationManager();
        world = new World();
        turnManager = new TurnManager();
        systemManager = new SystemManager(world , animationManager , turnManager);
        controllerManager = new ControllerManager(systemManager , world);
        viewManager = new ViewManager(systemManager.getDrawingSystem() , controllerManager , world , turnManager);
        animationManager.setGameEngine(viewManager.getGameEngine());
        starter = new Starter(world);

    }
    public void start(){
        world.Start();
        viewManager.StartGame();
    }

    public TurnManager getTurnManager() {
        return turnManager;
    }

    public SystemManager getSystemManager() {
        return systemManager;
    }

    public AnimationManager getAnimationManager() {
        return animationManager;
    }

    public ControllerManager getControllerManager() {
        return controllerManager;
    }

    public ViewManager getViewManager() {
        return viewManager;
    }

    public Starter getStarter() {
        return starter;
    }

    public World getWorld() {
        return world;
    }
}

```

---

# File: src/Game/Generate.java

```java
package Game;

public class Generate {
    private static Game game = new Game();
    private static World bootstrapWorld; // used only while Game/World are still being constructed

    public static Game getGame() {
        return game;
    }

    // Called once by World's constructor, before it builds any Elements,
    // so Logic classes can resolve records even while Generate's own
    // static init hasn't finished assigning `game` yet.
    public static void publishWorld(World world) {
        bootstrapWorld = world;
    }

    public static World getWorld() {
        if (game != null && game.getWorld() != null) {
            return game.getWorld();
        }
        return bootstrapWorld;
    }
}
```

---

# File: src/Game/Managers/AnimationManager.java

```java
package Game.Managers;

import Animation.BaseAnimation;
import Game.Views.GameEngine;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Timer;

public class AnimationManager {
    private final List<BaseAnimation> activeAnimations = new ArrayList<>();
    private final Timer loopTimer;
    private GameEngine gameEngine;

    public AnimationManager() {
        // High-precision UI update loop (~60 Frames Per Second)
        this.loopTimer = new Timer(16, e -> stepAnimations());
    }

    public void setGameEngine(GameEngine gameEngine) {
        this.gameEngine = gameEngine;
    }

    public void play(BaseAnimation animation) {
        if (!activeAnimations.contains(animation)) {
            activeAnimations.add(animation);
        }
        if (!loopTimer.isRunning()) {
            loopTimer.start();
        }
    }

    private void stepAnimations() {
        // Process backwards so safe removal is possible upon completion
        for (int i = activeAnimations.size() - 1; i >= 0; i--) {
            BaseAnimation anim = activeAnimations.get(i);
            boolean isRunning = anim.step();

            if (!isRunning) {
                activeAnimations.remove(i);
            }
        }

        // Trigger a unified UI refresh after updating frame data
        if (gameEngine != null) {
            gameEngine.refresh();
        }

        // Keep CPU idle when no animations are running
        if (activeAnimations.isEmpty()) {
            loopTimer.stop();
        }
    }
    public void refresh(){
        gameEngine.refresh();
    }
}
```

---

# File: src/Game/Managers/ControllerManager.java

```java
package Game.Managers;

import Game.Controller.BoardController;
import Game.Controller.HUDController;
import Game.Controller.UnitPanelController;
import Game.World;

public class ControllerManager {
    private SystemManager systemManager;
    private World world;
    private BoardController boardController;
    private final UnitPanelController unitPanelController;
    private final HUDController hudController;
    public ControllerManager(SystemManager systemManager, World world) {
        this.systemManager = systemManager;
        this.world = world;
        boardController = new BoardController(world , systemManager.getMovementSystem() , systemManager.getBoardSystem() , systemManager.getSelectSystem() , systemManager.getEventSystem());

        unitPanelController = new UnitPanelController(systemManager);
        hudController = new HUDController(systemManager);
    }

    public BoardController getBoardController() {
        return boardController;
    }

    public UnitPanelController getUnitPanelController() {
        return unitPanelController;
    }

    public SystemManager getSystemManager() {
        return systemManager;
    }

    public World getWorld() {
        return world;
    }

    public HUDController getHudController() {
        return hudController;
    }
}

```

---

# File: src/Game/Managers/SystemManager.java

```java
package Game.Managers;

import Game.Systems.*;
import Game.Systems.ElementSystem.*;
import Game.Systems.EventSystem.EventSystem;
import Game.World;

public class SystemManager {
    private final EventSystem eventSystem;
    private final DrawingSystem drawingSystem;
    private final BoardSystem boardSystem;
    private final SelectSystem selectSystem;
    private final MovementSystem movementSystem;
    private final BuildSystem buildSystem;
    private final WorkSystem workSystem;
    private final ExplorationSystem explorationSystem;
    private final World world;
    private final RestarterSystem restarterSystem;
    private final AnimationManager animationManager;
    private final TurnManager turnManager;
    private final StarvationSystem starvationSystem;
    private final TownHallSystem townHallSystem;

    public SystemManager(World world, AnimationManager animationManager, TurnManager turnManager) {
        this.world = world;
        this.animationManager = animationManager;
        this.turnManager = turnManager;
        this.starvationSystem = new StarvationSystem(world);
        this.restarterSystem = new RestarterSystem(starvationSystem , world);
        // 1. Initialize EventSystem first (but without its inner SelectEvent needing ExtraDrawer yet)
        // Alternatively, we create the components sequentially by passing references downstream.
        this.eventSystem = new EventSystem(world, animationManager , turnManager , restarterSystem );

        // 2. Initialize SelectSystem which depends on EventSystem
        this.selectSystem = new SelectSystem(this.eventSystem, animationManager , world.getConnectViews());

        // 3. Initialize BoardSystem
        this.boardSystem = new BoardSystem(this.eventSystem.getBoardEvent() , world.getHexManager());

        // 4. Initialize DrawingSystem - it has everything it needs now
        this.drawingSystem = new DrawingSystem(world, selectSystem);

        // 5. Explicitly update EventSystem's components with the fully created ExtraDrawer instance
        this.eventSystem.setExtraDrawer(this.drawingSystem.getExtraDrawer());
        this.eventSystem.getSelectEvent().setExtraDrawer(this.drawingSystem.getExtraDrawer());

        // 6. Inject dependencies down into operational gameplay systems
        this.movementSystem = new MovementSystem(this.selectSystem, this.eventSystem);
        this.buildSystem = new BuildSystem(this.selectSystem, this.eventSystem);
        this.workSystem = new WorkSystem(this.selectSystem, this.eventSystem);
        this.explorationSystem = new ExplorationSystem(this.selectSystem, this.eventSystem);

        this.townHallSystem = new TownHallSystem(world , eventSystem);
    }

    // --- Getters ---

    public EventSystem getEventSystem() {
        return eventSystem;
    }

    public SelectSystem getSelectSystem() {
        return selectSystem;
    }

    public MovementSystem getMovementSystem() {
        return movementSystem;
    }

    public BuildSystem getBuildSystem() {
        return buildSystem;
    }

    public WorkSystem getWorkSystem() {
        return workSystem;
    }

    public ExplorationSystem getExplorationSystem() {
        return explorationSystem;
    }

    public BoardSystem getBoardSystem() {
        return boardSystem;
    }

    public DrawingSystem getDrawingSystem() {
        return drawingSystem;
    }

    public TownHallSystem getTownHallSystem() {
        return townHallSystem;
    }


    public World getWorld() {
        return world;
    }
}
```

---

# File: src/Game/Managers/TurnManager.java

```java
package Game.Managers;

import Game.World;

public class TurnManager {
    private int turns;

    public TurnManager() {
        turns = 1;
    }
    public void nexTurn(){
        turns++;
    }

    public int getTurns() {
        return turns;
    }
}

```

---

# File: src/Game/Managers/ViewManager.java

```java
package Game.Managers;

import Game.Systems.DrawingSystem;
import Game.Views.GameEngine;
import Game.Views.Listeners.BoardMouseListener;
import Game.World;

public class ViewManager {
    private DrawingSystem drawingSystem;
    private GameEngine gameEngine;
    private final BoardMouseListener boardMouseListener;
    private final ControllerManager controllerManager;
    private final World world;
    private final TurnManager turnManager;

    public ViewManager(DrawingSystem drawingSystem, ControllerManager controllerManager, World world, TurnManager turnManager) {
        this.drawingSystem = drawingSystem;
        this.world = world;
        this.controllerManager = controllerManager;
        boardMouseListener = new BoardMouseListener(controllerManager.getBoardController());
        this.turnManager = turnManager;
        gameEngine = new GameEngine(drawingSystem , boardMouseListener , world.getConnectViews() , controllerManager , turnManager , world);

    }
    public void StartGame(){
        gameEngine.startGame();
    }

    public GameEngine getGameEngine() {
        return gameEngine;
    }
}

```

---

# File: src/Game/Starter.java

```java
package Game;

import Models.Draw.UnitPositionCalculator; // Import your calculator class
import Models.Elements.Buildings.IronMine;
import Models.Elements.Buildings.TownHall;
import Models.Elements.Hex.Hex;
import Models.Elements.Hex.LandHex;
import Models.Elements.Units.*;
import Models.Logic.BuildingLogic.TownHallLogic;
import Models.Logic.HexLogic.HexLogic;
import Models.Records.HexRecord;
import Models.Records.UnitRecord;

public class Starter {
    private final World world;

    public Starter(World world) {
        this.world = world;
    }
    public void start(){
        Hex hex = HexLogic.findByQR(0 , 0);
        HexLogic.discover(hex);

        Worker worker = new Worker();
        worker.setHex(hex);
        world.getUnitRecord().add(worker);

        Explorer explorer = new Explorer();
        explorer.setHex(hex);
        world.getUnitRecord().add(explorer);

        Builder builder = new Builder();
        builder.setHex(hex);
        BorderExpander borderExpander = new BorderExpander();
        borderExpander.setHex(hex);
        world.getUnitRecord().add(borderExpander);
        world.getUnitRecord().add(builder);
//        Hex hex1 = HexLogic.findByQR(1 , 0);

//        HexLogic.discover(hex1);
//        townHall.setHex(hex);
//        new TownHallLogic(townHall).AddInitialResources();
//        hex.setBuilding(townHall);
//        world.getBuildingRecord().add(townHall);
//        World.setTownHall(townHall);
//        // FIX: Recompute and apply initial coordinates and sizes for all units on this hex
        UnitPositionCalculator.refreshHex(hex, worker);
    }
}
```

---

# File: src/Game/Systems/BoardSystem.java

```java
package Game.Systems;

import Game.Systems.EventSystem.BoardEvent;
import Game.Systems.EventSystem.EventSystem;
import Models.Manager.HexManager;

public class BoardSystem {
    private final BoardEvent boardEvent;

    private final HexManager hexManager;

    public BoardSystem(BoardEvent boardEvent, HexManager hexManager) {
        this.boardEvent = boardEvent;
        this.hexManager = hexManager;
    }


    public void zoom(int rotate) {
        boardEvent.Zoomed(rotate);
    }

    public void moveBoard(int x , int y) {
        hexManager.pan(x , y);
        boardEvent.MoveInBoard();
    }
}
```

---

# File: src/Game/Systems/Drawers/DrawBuildings.java

```java
package Game.Systems.Drawers;

import Models.Elements.Buildings.Building;
import Models.Records.BuildingRecord;
import java.awt.*;

public class DrawBuildings {
    private final BuildingRecord buildingRecord;

    public DrawBuildings(BuildingRecord buildingRecord) {
        this.buildingRecord = buildingRecord;
    }

    public void draw(Graphics g) {
        for (Building building : buildingRecord.getAll())
            building.getDraw().draw(g);
    }
}
```

---

# File: src/Game/Systems/Drawers/DrawHexes.java

```java
package Game.Systems.Drawers;

import Models.Records.HexRecord;
import java.awt.*;

public class DrawHexes {
    private final HexRecord hexRecord;

    public DrawHexes(HexRecord hexRecord) {
        this.hexRecord = hexRecord;
    }

    public void draw(Graphics g) {
        for (var hex : hexRecord.getAll()) {
            hex.getDraw().draw(g);
        }
    }
}
```

---

# File: src/Game/Systems/Drawers/DrawUnits.java

```java
package Game.Systems.Drawers;

import Models.Elements.Units.Unit;
import Models.Records.UnitRecord;
import java.awt.*;

public class DrawUnits {
    private final UnitRecord unitRecord;

    public DrawUnits(UnitRecord unitRecord) {
        this.unitRecord = unitRecord;
    }

    public void draw(Graphics g) {
        for (Unit unit : unitRecord.getAll())
            unit.getDraw().draw(g);
    }
}
```

---

# File: src/Game/Systems/Drawers/PathDrawer.java

```java
package Game.Systems.Drawers;

import Models.ConnectDrawing;
import Models.Elements.Hex.Hex;

import java.awt.*;
import java.util.List;

public class PathDrawer {
    private final ConnectDrawing connectDrawing;

    public PathDrawer(ConnectDrawing connectDrawing) {
        this.connectDrawing = connectDrawing;
    }

    public void draw(Graphics g) {
        List<Hex> path = connectDrawing.getPath();

        // Only draw if we have a valid path with at least 2 hexes to connect
        if (path == null || path.size() < 2) {
            return;
        }

        Graphics2D g2d = (Graphics2D) g;

        // Save original configurations to prevent bleeding into other drawing systems
        Color originalColor = g2d.getColor();
        Stroke originalStroke = g2d.getStroke();

        // Configure smooth line edges and a thick brush for clear visibility
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setStroke(new BasicStroke(4.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));

        // Define a beautiful semi-transparent light yellow color (RGBA)
        g2d.setColor(new Color(255, 235, 120, 200));

        // Iterate through the path list and draw lines between consecutive hex centers
        for (int i = 0; i < path.size() - 1; i++) {
            Hex current = path.get(i);
            Hex next = path.get(i + 1);

            // Note: If your Hex class uses getCenterX()/getCenterY() or pixels directly,
            // swap out getX() and getY() to match your coordinate names!
            int x1 = current.getCenterX();
            int y1 = current.getCenterY();
            int x2 = next.getCenterX();
            int y2 = next.getCenterY();

            g2d.drawLine(x1, y1, x2, y2);
        }

        // Optional: Draw a distinct marker or highlight circle at the Goal Hex center
        Hex goal = connectDrawing.getGoalHex();
        if (goal != null) {
            int radius = 8;
            g2d.fillOval(goal.getCenterX() - radius, goal.getCenterY() - radius, radius * 2, radius * 2);
        }

        // Restore original engine states
        g2d.setColor(originalColor);
        g2d.setStroke(originalStroke);
    }
}
```

---

# File: src/Game/Systems/Drawers/SelectDrawer.java

```java
package Game.Systems.Drawers;

import Game.Systems.SelectSystem;

import Game.World;
import Models.Elements.Hex.Hex;
import Models.Elements.Units.Unit;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class SelectDrawer {
    private final SelectSystem selectSystem;
    private  World world;
    private Hex selectedHex;
    private Unit selectedUnit; // Added field to match pattern

    public SelectDrawer(SelectSystem selectSystem, World world) {
        this.selectSystem = selectSystem;
        this.world = world;
    }

    public void draw(Graphics g) {
        // Draw selected Hex indicator if it exists
        if (selectedHex != null && selectedHex.isVisible()) {
            drawSelectedHex(g);
        }

        // Draw selected Unit indicator if it exists
        if (selectedUnit != null) {
            Hex unitHex = selectedUnit.getHex();
            if (unitHex != null && unitHex.isVisible()) {
                drawSelectedUnit(g);
            }
        }
    }

    public void drawSelectedHex(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();

        Hex hex = selectedHex;
        g2d.setColor(Color.WHITE);
        g2d.setStroke(new BasicStroke(2f));
        int drawX = hex.getDrawX();
        int drawY = hex.getDrawY();
        g2d.drawOval((int) (drawX + hex.getSize() * 1.1), (int) (drawY + hex.getSize() * 0.15), (int) (hex.getSize() * 1.6), (int) (hex.getSize() * 1.6));

        g2d.dispose();
    }

    public void drawSelectedUnit(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        Hex hex = selectedUnit.getHex();

        // 1. Reconstruct multi-unit positioning context to find where this unit is drawn
        List<Unit> sharedHexUnits = new ArrayList<>();
        for (Unit u : world.getUnitRecord().getAll()) {
            if (u != null && hex.equals(u.getHex())) {
                sharedHexUnits.add(u);
            }
        }

        int totalUnits = sharedHexUnits.size();
        int myIndex = -1;
        for (int i = 0; i < sharedHexUnits.size(); i++) {
            if (sharedHexUnits.get(i) == selectedUnit) {
                myIndex = i;
                break;
            }
        }
        if (myIndex == -1) myIndex = 0;

        // 2. Resolve exact target layout node point matching your rendering engine
        int centerX = hex.getCenterX();
        int centerY = hex.getCenterY();
        double orbitRadius = hex.getSize() * 0.45;
        int unitSize = (int) (hex.getSize() * 0.4);

        int targetX = centerX;
        int targetY = centerY;

        if (totalUnits > 1) {
            double angle = (2.0 * Math.PI * myIndex) / totalUnits;
            targetX = centerX + (int) (orbitRadius * Math.cos(angle));
            targetY = centerY + (int) (orbitRadius * Math.sin(angle));
        }

        // 3. Draw a selection circle slightly larger than the unit size around targetX/Y
        int selectionRadius = (int) (unitSize * 1.3); // 30% larger than unit size
        int selectX = targetX - (selectionRadius / 2);
        int selectY = targetY - (selectionRadius / 2);

        g2d.setColor(Color.GREEN); // Classic strategy game selection ring color
        g2d.setStroke(new BasicStroke(2f));
        g2d.drawOval(selectX, selectY, selectionRadius, selectionRadius);

        g2d.dispose();
    }

    public void setSelectedHex(Hex selectedHex) {
        this.selectedHex = selectedHex;
    }

    public void setSelectedUnit(Unit selectedUnit) {
        this.selectedUnit = selectedUnit;
    }
}
```

---

# File: src/Game/Systems/DrawingSystem.java

```java
package Game.Systems;

import Game.Systems.Drawers.*;
import Game.World;
import java.awt.*;

public class DrawingSystem {
    private World world;
    private DrawHexes drawHexes;
    private DrawBuildings drawBuildings;
    private DrawUnits drawUnits;
    private final SelectSystem selectSystem;
    private final SelectDrawer extraDrawer;
    private final PathDrawer pathDrawer;

    public DrawingSystem(World world, SelectSystem selectSystem) {
        this.world = world;
        drawBuildings = new DrawBuildings(world.getBuildingRecord());
        drawHexes = new DrawHexes(world.getHexRecord());
        drawUnits = new DrawUnits(world.getUnitRecord());
        this.selectSystem = selectSystem;
        extraDrawer = new SelectDrawer(selectSystem , world);
        pathDrawer = new PathDrawer(world.getConnectDrawing());
    }

    public void draw(Graphics g) {
        drawHexes.draw(g);
        drawBuildings.draw(g);
        drawUnits.draw(g);
        extraDrawer.draw(g);
        pathDrawer.draw(g);

    }

    public SelectDrawer getExtraDrawer() {
        return extraDrawer;
    }
}

```

---

# File: src/Game/Systems/ElementSystem/BuildSystem.java

```java
package Game.Systems.ElementSystem;

import Game.Systems.EventSystem.EventSystem;
import Game.Systems.SelectSystem;
import Models.Elements.Buildings.Building;
import Models.Elements.Units.Builder;
import Models.Logic.BuildingLogic.BuildingLogic;

public class BuildSystem {
    private final SelectSystem selectSystem;
    private final EventSystem eventSystem;

    public BuildSystem(SelectSystem selectSystem, EventSystem eventSystem) {
        this.selectSystem = selectSystem;
        this.eventSystem = eventSystem;
    }

    /**
     * Attempts to build a building at the builder's current location.
     */
    public void buildStructure(Class<? extends Building> buildingClass) {
        System.out.println("BuildStructure called");
        if (!(selectSystem.getSelectedUnit() instanceof Builder)) {
            eventSystem.getBuildingEvent().BuildingFailed("No active Builder selected.");
            return;
        }

        Builder builder = (Builder) selectSystem.getSelectedUnit();
        try {
            Building newBuilding = BuildingLogic.Build(builder, buildingClass);
            eventSystem.getBuildingEvent().BuildingConstructed(newBuilding, builder.getHex());
        } catch (Exception e) {
            eventSystem.getBuildingEvent().BuildingFailed(e.getMessage());
        }
    }
}
```

---

# File: src/Game/Systems/ElementSystem/ExplorationSystem.java

```java
package Game.Systems.ElementSystem;

import Game.Systems.EventSystem.EventSystem;
import Game.Systems.SelectSystem;
import Models.Elements.Units.Explorer;
import Models.Elements.Units.BorderExpander;
import Models.Logic.UnitLogic.ExplorerLogic;
import Models.Logic.UnitLogic.BorderExpanderLogic;

public class ExplorationSystem {
    private final SelectSystem selectSystem;
    private final EventSystem eventSystem;

    public ExplorationSystem(SelectSystem selectSystem, EventSystem eventSystem) {
        this.selectSystem = selectSystem;
        this.eventSystem = eventSystem;
    }

    /**
     * Commands an Explorer unit to discover neighboring tiles.
     */
    public void exploreSurroundings() {
        System.out.println("Explore Surround called ");
        if (!(selectSystem.getSelectedUnit() instanceof Explorer)) {
            System.out.println("you didn't select Explorer");
            eventSystem.getExplorEvent().ExplorationFailed("No active Explorer selected.");
            return;
        }

        Explorer explorer = (Explorer) selectSystem.getSelectedUnit();
        ExplorerLogic logic = (ExplorerLogic) explorer.getLogic();

        try {
            System.out.println("We are trying to Explore by logic");
            logic.Explore();
            eventSystem.getExplorEvent().HexExplored(explorer.getHex());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            eventSystem.getExplorEvent().ExplorationFailed(e.getMessage());
        }
    }

    /**
     * Commands a BorderExpander unit to expand the empire borders.
     */
    public void expandBorder() {
        if (!(selectSystem.getSelectedUnit() instanceof BorderExpander)) {
            eventSystem.getBoardExpandEvent().BorderExpansionFailed("No active BorderExpander selected.");
            return;
        }

        BorderExpander expander = (BorderExpander) selectSystem.getSelectedUnit();
        BorderExpanderLogic logic = (BorderExpanderLogic) expander.getLogic();

        try {
            logic.addToBorder();
            eventSystem.getBoardExpandEvent().BorderExpanded(expander.getHex());
        } catch (Exception e) {
            eventSystem.getBoardExpandEvent().BorderExpansionFailed(e.getMessage());
        }
    }
}
```

---

# File: src/Game/Systems/ElementSystem/MovementSystem.java

```java
package Game.Systems.ElementSystem;

import Game.Systems.EventSystem.EventSystem;
import Game.Systems.SelectSystem;
import Models.Elements.Hex.Hex;
import Models.Elements.Units.Unit;
import Models.Logic.UnitLogic.FindBestPath;

public class MovementSystem {
    private final SelectSystem selectSystem;
    private final EventSystem eventSystem;

    public MovementSystem(SelectSystem selectSystem, EventSystem eventSystem) {
        this.selectSystem = selectSystem;
        this.eventSystem = eventSystem;
    }

    public void UnitMove() {
        Unit currentUnit = selectSystem.getSelectedUnit();
        Hex targetHex = selectSystem.getSelectedHex();
        if (!selectSystem.isReadyToMove())
            return;
        // 1. If no unit is selected, movement is impossible.
        if (currentUnit == null) {
            return;
        }

        // 2. If a unit is selected but no hex is selected, wait for the hex.
        if (targetHex == null) {
            return;
        }

        Hex unitCurrentHex = currentUnit.getHex();

        // 3. ENFORCE SELECTION ORDER:
        // If targetHex equals the unit's current hex, it means the user just clicked
        // the unit to select it. We return early so it doesn't move.
        if (targetHex.equals(unitCurrentHex)) {
            return;
        }

        // 4. If we get here, a unit was already selected, and the user just clicked
        // a NEW, different hex. Trigger the movement animation!
        eventSystem.getUnitEvent().UnitMoved(unitCurrentHex, targetHex, currentUnit);
        FindBestPath bestPath = new FindBestPath(unitCurrentHex , targetHex);
        try {
            currentUnit.getLogic().cost(bestPath.CalculateTotalCost());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        // Reset selection flags immediately so the next action starts fresh
        selectSystem.selectUnit(null);
        selectSystem.setReadyToMove(false);
        // selectSystem.selectHex(null); // Clear this too if your SelectSystem tracks it
    }
}
```

---

# File: src/Game/Systems/ElementSystem/StarvationSystem.java

```java
package Game.Systems.ElementSystem;

import Game.World;
import Models.Elements.Buildings.Building;
import Models.Elements.Resources.Food;
import Models.Elements.Resources.Resource;
import Models.Elements.Units.Unit;
import Models.Logic.UnitLogic.UnitLogic;

import java.util.Map;

public final class StarvationSystem {
    private World world;

    public StarvationSystem(World world) {
        this.world = world;
    }

    // Checks whether stored food covers every unit's need. If not, starvation kicks in.
    public  void StarvationCheck() {
        int totalNeed = 0;
        for (Unit unit : world.getUnitRecord().getAll()) {
            totalNeed += unit.getFoodNeed();
        }

        if (world.getResourceRecord().getAll(Food.class).size() < totalNeed) {
            setStarvationEffects();
        }
    }

    // Every unit loses 1 AP, and every building's per-worker output is throttled.
    public  void setStarvationEffects() {
        for (Unit unit : world.getUnitRecord().getAll()) {
            try {
                new UnitLogic(unit).cost(1);
            } catch (Exception ignored) {
                // unit already had no AP left this turn
            }
        }

        for (Building building : world.getBuildingRecord().getAll()) {
            Map<Class<? extends Resource>, Integer> provides = building.getProvidesPerWorker();
            for (Map.Entry<Class<? extends Resource>, Integer> entry : provides.entrySet()) {
                entry.setValue(Math.max(0, entry.getValue() / 2));
            }
        }
    }
}

```

---

# File: src/Game/Systems/ElementSystem/WorkSystem.java

```java
package Game.Systems.ElementSystem;

import Game.Systems.EventSystem.EventSystem;
import Game.Systems.SelectSystem;
import Models.Elements.Buildings.Building;
import Models.Elements.Units.Worker;
import Models.Logic.UnitLogic.WorkerLogic;

public class WorkSystem {
    private final SelectSystem selectSystem;
    private final EventSystem eventSystem;

    public WorkSystem(SelectSystem selectSystem, EventSystem eventSystem) {
        this.selectSystem = selectSystem;
        this.eventSystem = eventSystem;
    }

    /**
     * Commands the selected worker to occupy a building on the selected Hex.
     */
    public void stationWorker() {
        if (!(selectSystem.getSelectedUnit() instanceof Worker)) {
            eventSystem.getWorkEvent().WorkerActionFailed("No active Worker selected.");
            return;
        }
        if (selectSystem.getSelectedHex() == null || selectSystem.getSelectedHex().getBuilding() == null) {
            eventSystem.getWorkEvent().WorkerActionFailed("Target Hex does not contain a building.");
            return;
        }

        Worker worker = (Worker) selectSystem.getSelectedUnit();
        Building building = selectSystem.getSelectedHex().getBuilding();
        WorkerLogic logic = (WorkerLogic) worker.getLogic();

        try {
            logic.GetInBuilding(building);
            eventSystem.getWorkEvent().WorkerStationed(worker, building);
        } catch (Exception e) {
            eventSystem.getWorkEvent().WorkerActionFailed(e.getMessage());
        }
    }

    /**
     * Relieves the selected worker from their current stationed building.
     */
    public void unstationWorker() {
        if (!(selectSystem.getSelectedUnit() instanceof Worker)) {
            eventSystem.getWorkEvent().WorkerActionFailed("No active Worker selected.");
            return;
        }

        Worker worker = (Worker) selectSystem.getSelectedUnit();
        WorkerLogic logic = (WorkerLogic) worker.getLogic();

        try {
            logic.GetOffBuilding();
            eventSystem.getWorkEvent().WorkerUnstationed(worker);
        } catch (Exception e) {
            eventSystem.getWorkEvent().WorkerActionFailed(e.getMessage());
        }
    }
}
```

---

# File: src/Game/Systems/EventSystem/BoardEvent.java

```java
package Game.Systems.EventSystem;

import Animation.ZoomAnimation;
import Game.Managers.AnimationManager;
import Models.Manager.HexManager;

public class BoardEvent extends Event {
    private final HexManager hexManager;
    private ZoomAnimation currentZoomAnimation;

    public BoardEvent(AnimationManager animationManager, HexManager hexManager) {
        super(animationManager);
        this.hexManager = hexManager;
    }

    public void Zoomed(int rotate) {
        if (currentZoomAnimation != null) {
            currentZoomAnimation.cancel();
        }
        currentZoomAnimation = new ZoomAnimation(rotate, hexManager, null);
        animationManager.play(currentZoomAnimation);
    }

    public void MoveInBoard() {
        animationManager.refresh();
    }
}
```

---

# File: src/Game/Systems/EventSystem/BoardExpandEvent.java

```java
package Game.Systems.EventSystem;

import Game.Managers.AnimationManager;
import Models.Elements.Hex.Hex;

public class BoardExpandEvent extends Event {
    public BoardExpandEvent(AnimationManager animationManager) {
        super(animationManager);
    }

    public void BorderExpanded(Hex hex) {
        animationManager.refresh();
    }
    public void BorderExpansionFailed(String reason) {}
}

```

---

# File: src/Game/Systems/EventSystem/BuildingEvent.java

```java
package Game.Systems.EventSystem;

import Game.Managers.AnimationManager;
import Models.Elements.Buildings.Building;
import Models.Elements.Hex.Hex;

public class BuildingEvent extends Event{
    public BuildingEvent(AnimationManager animationManager) {
        super(animationManager);
    }

    public void BuildingConstructed(Building building, Hex hex) {
        animationManager.refresh();
    }
    public void BuildingFailed(String reason) {
        animationManager.refresh();
    }
}

```

---

# File: src/Game/Systems/EventSystem/Event.java

```java
package Game.Systems.EventSystem;

import Game.Managers.AnimationManager;
import Models.ConnectDrawing;

public abstract class Event {
    protected AnimationManager animationManager;

    public Event(AnimationManager animationManager) {
        this.animationManager = animationManager;
    }

    public void Refresh(){
        animationManager.refresh();
    }
}

```

---

# File: src/Game/Systems/EventSystem/EventSystem.java

```java
package Game.Systems.EventSystem;

import Game.Managers.AnimationManager;
import Game.Managers.TurnManager;
import Game.Systems.Drawers.SelectDrawer;
import Game.Systems.RestarterSystem;
import Game.World;

public class EventSystem {
    private final World world;
    private final BoardEvent boardEvent;
    private final BuildingEvent buildingEvent;
    private final ExplorEvent explorEvent;
    private final SelectEvent selectEvent;
    private final UnitEvent unitEvent;
    private final WorkEvent workEvent;
    private final TurnEvent turnEvent;
    private final BoardExpandEvent boardExpandEvent;
    private final AnimationManager animationManager;
    private final TurnManager turnManager;
    private final RestarterSystem restarterSystem;

    private SelectDrawer extraDrawer;
    public EventSystem(World world, AnimationManager animationManager, TurnManager turnManager, RestarterSystem restarterSystem) {
        this.world = world;
//        extraDrawer = Generate.getGame().getSystemManager().getDrawingSystem().getExtraDrawer();
        this.animationManager = animationManager;
        this.turnManager = turnManager;
        this.restarterSystem = restarterSystem;

        boardEvent = new BoardEvent(animationManager , world.getHexManager());
        buildingEvent = new BuildingEvent(animationManager);
        explorEvent = new ExplorEvent(animationManager);
        selectEvent = new SelectEvent(animationManager , extraDrawer , world.getConnectDrawing() , world.getConnectViews() , world);
        unitEvent = new UnitEvent(animationManager);
        boardExpandEvent = new BoardExpandEvent(animationManager);
        workEvent = new WorkEvent(animationManager);
        turnEvent = new TurnEvent(animationManager , turnManager , restarterSystem);
    }

    public void setExtraDrawer(SelectDrawer extraDrawer) {
        this.extraDrawer = extraDrawer;
    }

    public BoardEvent getBoardEvent() {
        return boardEvent;
    }

    public BuildingEvent getBuildingEvent() {
        return buildingEvent;
    }

    public ExplorEvent getExplorEvent() {
        return explorEvent;
    }

    public SelectEvent getSelectEvent() {
        return selectEvent;
    }

    public UnitEvent getUnitEvent() {
        return unitEvent;
    }

    public WorkEvent getWorkEvent() {
        return workEvent;
    }

    public TurnEvent getTurnEvent() {
        return turnEvent;
    }

    public BoardExpandEvent getBoardExpandEvent() {
        return boardExpandEvent;
    }
}
```

---

# File: src/Game/Systems/EventSystem/ExplorEvent.java

```java
package Game.Systems.EventSystem;

import Game.Managers.AnimationManager;
import Models.Elements.Hex.Hex;

public class ExplorEvent extends Event{
    public ExplorEvent(AnimationManager animationManager) {
        super(animationManager);
    }

    public void HexExplored(Hex hex) {
        animationManager.refresh();
    }
    public void ExplorationFailed(String reason) {}
}

```

---

# File: src/Game/Systems/EventSystem/SelectEvent.java

```java
package Game.Systems.EventSystem;

import Game.Managers.AnimationManager;
import Game.Systems.Drawers.SelectDrawer;
import Game.World;
import Models.ConnectDrawing;
import Models.ConnectViews;
import Models.Elements.Hex.Hex;
import Models.Elements.Units.Unit;
import Models.Elements.Units.Worker;
import Models.Logic.HexLogic.HexLogic;
import java.util.ArrayList;

public class SelectEvent extends Event {
    private SelectDrawer extraDrawer;
    private final ConnectDrawing connectDrawing;
    private final ConnectViews connectViews;
    private final World world;
    public SelectEvent(AnimationManager animationManager, SelectDrawer extraDrawer , ConnectDrawing connectDrawing1, ConnectViews connectViews, World world) {
        super(animationManager);
        this.extraDrawer = extraDrawer;
        this.connectDrawing = connectDrawing1;
        this.connectViews = connectViews;
        this.world = world;
    }

    public void setExtraDrawer(SelectDrawer extraDrawer) {
        this.extraDrawer = extraDrawer;
    }

    public void UnitSelected(Unit unit) {
        if (unit == null) {
            extraDrawer.setSelectedUnit(null);
            // Clear hover lines so they don't float around on an empty selection state
            connectDrawing.setPath(null);
            connectDrawing.setGoalHex(null);
        } else {
            extraDrawer.setSelectedUnit(unit);
            connectViews.setSelectedUnit(unit);

        }

        animationManager.refresh();
    }

    public void HexSelected(Hex hex) {
        // 1. Reset all tiles on the entire board to darker whenever a selection changes
        for (Hex boardHex : world.getHexRecord().getAll()) {
            boardHex.setDarker();
        }

        if (hex == null) {
            extraDrawer.setSelectedHex(null);
        } else {
            extraDrawer.setSelectedHex(hex);

            // 2. Light up the target hex and its immediate neighbors
            hex.setLighter();
            ArrayList<Hex> neighbors = HexLogic.getNeighbors(hex);
            for (Hex neighbor : neighbors) {
                neighbor.setLighter();
            }
        }

        // 3. Request a clean UI re-render
        animationManager.refresh();
    }
    /**
     * Receives predicted path data layout coordinates while a unit is selected.
     */
    public void likelyPath(java.util.List<Hex> path, Hex hoveredHex) {
        // Triggers UI draw updates for paths later.
        connectDrawing.setPath(path);
        connectDrawing.setGoalHex(hoveredHex);
        animationManager.refresh();
    }
}
```

---

# File: src/Game/Systems/EventSystem/TurnEvent.java

```java
package Game.Systems.EventSystem;

import Game.Managers.AnimationManager;
import Game.Managers.TurnManager;
import Game.Systems.RestarterSystem;

public class TurnEvent extends Event{
    private final TurnManager turnManager;
    private final RestarterSystem restarterSystem;
    public TurnEvent(AnimationManager animationManager, TurnManager turnManager, RestarterSystem restarterSystem) {
        super(animationManager);
        this.turnManager = turnManager;
        this.restarterSystem = restarterSystem;
    }

    public void EndTurn() {
        turnManager.nexTurn();
        restarterSystem.restart();
        animationManager.refresh();
    }
}

```

---

# File: src/Game/Systems/EventSystem/UnitEvent.java

```java
package Game.Systems.EventSystem;

import Animation.UnitMoveAnimation;
import Game.Managers.AnimationManager;
import Models.Elements.Hex.Hex;
import Models.Elements.Units.Unit;

public class UnitEvent extends Event {
    public UnitEvent(AnimationManager animationManager) {
        super(animationManager);
    }

    public void UnitMoved(Hex oldHex, Hex newHex, Unit unit) {
        // Ensure oldHex and newHex are distinctly passed variables!
        if (oldHex == null || newHex == null || oldHex.equals(newHex)) return;

        // 100 steps might be a little slow (nearly 1.5 to 2 seconds). Let's keep it smooth at 30-40 frames.
        animationManager.play(new UnitMoveAnimation(unit, oldHex, newHex, 40, animationManager));
    }

    public void UnitCannotMove(Hex hex) {}
}
```

---

# File: src/Game/Systems/EventSystem/WorkEvent.java

```java
package Game.Systems.EventSystem;

import Game.Managers.AnimationManager;
import Models.Elements.Buildings.Building;
import Models.Elements.Units.Unit;

public class WorkEvent extends Event{
    public WorkEvent(AnimationManager animationManager) {
        super(animationManager);
    }

    public void WorkerStationed(Unit worker, Building building) {
        animationManager.refresh();
    }
    public void WorkerUnstationed(Unit worker) {
        animationManager.refresh();
    }
    public void WorkerActionFailed(String reason) {
        animationManager.refresh();
    }
}

```

---

# File: src/Game/Systems/Restarters/BuildingRestarter.java

```java
package Game.Systems.Restarters;

import Models.Elements.Buildings.Building;
import Models.Elements.Resources.Resource;
import Models.Logic.BuildingLogic.BuildingLogic;
import Models.Records.BuildingRecord;
import Models.Records.ResourceRecord;

import java.util.List;
import java.util.Map;

public final class BuildingRestarter {
    private BuildingRecord buildingRecord;
    private ResourceRecord resourceRecord;

    public BuildingRestarter(BuildingRecord buildingRecord, ResourceRecord resourceRecord) {
        this.buildingRecord = buildingRecord;
        this.resourceRecord = resourceRecord;
    }

    // providesPerWorker * workerNumbers for every building, added to ResourceRecord.
    public void ProduceResources() {
        for (Building building : buildingRecord.getAll()) {
            new BuildingLogic(building).Supply();
        }
    }

    // Consumes each building's upkeep cost from ResourceRecord.
    public  void CostUpkeep() {
        for (Building building : buildingRecord.getAll()) {
            for (Map.Entry<Class<? extends Resource>, Integer> entry : building.getUPKEEP().entrySet()) {
                List<Resource> stock = resourceRecord.getAll(entry.getKey());
                int amount = Math.min(entry.getValue(), stock.size());
                for (int i = 0; i < amount; i++) {
                    resourceRecord.remove(stock.get(i));
                }
            }
        }
    }
}

```

---

# File: src/Game/Systems/Restarters/TownHallRestarter.java

```java
package Game.Systems.Restarters;

import Models.Elements.Buildings.Building;
import Models.Elements.Buildings.TownHall;
import Models.Logic.BuildingLogic.BuildingLogic;
import Models.Logic.BuildingLogic.TownHallLogic;
import Models.Records.BuildingRecord;

public final class TownHallRestarter {
    private BuildingRecord buildingRecord;

    public TownHallRestarter(BuildingRecord buildingRecord) {
        this.buildingRecord = buildingRecord;
    }

    public void produceSafeguard() {
        for (Building building : buildingRecord.getAll(TownHall.class)) {

            new TownHallLogic((TownHall) building).produceSafeguard();
        }
    }
}

```

---

# File: src/Game/Systems/Restarters/UnitRestarter.java

```java
package Game.Systems.Restarters;

import Models.Elements.Resources.Food;
import Models.Elements.Units.Unit;
import Models.Logic.UnitLogic.UnitLogic;
import Models.Records.ResourceRecord;
import Models.Records.UnitRecord;

import java.util.List;

public final class UnitRestarter {
    private UnitRecord unitRecord;
    private ResourceRecord resourceRecord;

    public UnitRestarter(UnitRecord unitRecord, ResourceRecord resourceRecord) {
        this.unitRecord = unitRecord;
        this.resourceRecord = resourceRecord;
    }

    // Refreshes AP back to each unit's initial AP.
    public  void APRestart() {
        for (Unit unit : unitRecord.getAll()) {
            new UnitLogic(unit).resetAp();
        }
    }

    // If there's enough stored food for every unit's need, feeds them all.
    // Otherwise, the empire is starving: the food stock is emptied entirely.
    public void FeedAll() {
        List<Unit> units = unitRecord.getAll();

        int totalNeed = 0;
        for (Unit unit : units) {
            totalNeed += unit.getFoodNeed();
        }

        if (resourceRecord.getAll(Food.class).size() >= totalNeed) {
            for (Unit unit : units) {
                new UnitLogic(unit).feed();
            }
        } else {
            resourceRecord.clear(Food.class);
        }
    }
}

```

---

# File: src/Game/Systems/RestarterSystem.java

```java
package Game.Systems;

import Game.Systems.ElementSystem.StarvationSystem;
import Game.Systems.Restarters.BuildingRestarter;
import Game.Systems.Restarters.TownHallRestarter;
import Game.Systems.Restarters.UnitRestarter;
import Game.World;


public class RestarterSystem {
    private StarvationSystem starvationSystem;
    private World world;
    private TownHallRestarter townHallRestarter;
    private BuildingRestarter buildingRestarter;
    private UnitRestarter unitRestarter;


    public RestarterSystem(StarvationSystem starvationSystem, World world) {
        this.starvationSystem = starvationSystem;
        this.world = world;
        townHallRestarter = new TownHallRestarter(world.getBuildingRecord());
        buildingRestarter = new BuildingRestarter(world.getBuildingRecord() , world.getResourceRecord());
        unitRestarter = new UnitRestarter(world.getUnitRecord() , world.getResourceRecord());
    }

    public void restart()  {
        townHallRestarter.produceSafeguard();
        buildingRestarter.ProduceResources();
        buildingRestarter.CostUpkeep();
        starvationSystem.StarvationCheck();
        unitRestarter.APRestart();
        unitRestarter.FeedAll();
        if (!world.getTownHall().getGenerateUnit().isFinished()) {
            try {
                world.getTownHall().getGenerateUnit().newTurn();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }




    }
}

```

---

# File: src/Game/Systems/SelectSystem.java

```java
package Game.Systems;

import Game.Managers.AnimationManager;
import Game.Systems.EventSystem.EventSystem;
import Models.ConnectViews;
import Models.Elements.Buildings.Building;
import Models.Elements.Hex.Hex;
import Models.Elements.Units.Unit;

public class SelectSystem {
    private Unit selectedUnit;
    private Hex selectedHex;
    private Building selectedBuilding;
    private final EventSystem eventSystem;
    private final AnimationManager animationManager;
    private boolean readyToMove;
    private final ConnectViews connectViews;
    public SelectSystem(EventSystem eventSystem, AnimationManager animationManager, ConnectViews connectViews) {
        this.eventSystem = eventSystem;
        this.animationManager = animationManager;
        this.connectViews = connectViews;
    }

    public void selectUnit(Unit unit) {
        if (this.selectedUnit == unit) {
            this.selectedUnit = null;
            eventSystem.getSelectEvent().UnitSelected(null);
        } else {
            this.selectedUnit = unit;
            this.selectedBuilding = null; // Unselect building when selecting a unit
            eventSystem.getSelectEvent().UnitSelected(unit);
        }
    }

    public void selectHex(Hex hex) {
        System.out.println("===========================");
        if (this.selectedHex == hex) {
            System.out.println("onSelect");
            this.selectedHex = null;
            eventSystem.getSelectEvent().HexSelected(null);
        } else {
            System.out.println("select");
            this.selectedHex = hex;
            if (selectedUnit != null)
                readyToMove = true;
            else
                readyToMove = false;
            eventSystem.getSelectEvent().HexSelected(hex);
        }
    }

    public void buildingSelect(Building building) {
        if (this.selectedBuilding == building) {
            this.selectedBuilding = null;
        } else {
            this.selectedBuilding = building;

            // Cleanly clear drawing indicators when focus drops to a building
            if (this.selectedUnit != null) {
                this.selectedUnit = null;
                eventSystem.getSelectEvent().UnitSelected(null);
            }
        }
    }
    /**
     * Handles dynamic mouse hover events over valid map tiles.
     */
    public void hoverHex(Hex hex) {
        if (this.selectedUnit != null) {
            var unitLogic = this.selectedUnit.getLogic();
            if (unitLogic != null && unitLogic.canReach(hex)) {
                java.util.List<Hex> path = unitLogic.getBestPath(hex);
                eventSystem.getSelectEvent().likelyPath(path, hex);
            }
        }
    }

    public Unit getSelectedUnit() {
        return selectedUnit;
    }

    public Hex getSelectedHex() {
        return selectedHex;
    }

    public Building getSelectedBuilding() {
        return selectedBuilding;
    }

    public void clearSelection() {
        this.selectedUnit = null;
        this.selectedHex = null;
        this.selectedBuilding = null;
        eventSystem.getSelectEvent().UnitSelected(null);
        eventSystem.getSelectEvent().HexSelected(null);
    }

    public boolean isReadyToMove() {
        return readyToMove;
    }

    public void setReadyToMove(boolean readyToMove) {
        this.readyToMove = readyToMove;
    }
}
```

---

# File: src/Game/Systems/TownHallSystem.java

```java
package Game.Systems;

import Game.Systems.EventSystem.EventSystem;
import Game.Systems.EventSystem.WorkEvent;
import Game.World;
import Models.Elements.Units.Unit;

public class TownHallSystem {
    private final World world;
    private final EventSystem eventSystem;
    public TownHallSystem(World world, EventSystem eventSystem) {
        this.world = world;
        this.eventSystem = eventSystem;
    }
    public void addToTownHall(Unit unit){
        System.out.println("Add To TownHall" + unit.getClass());
        try {
            world.getTownHall().getGenerateUnit().startGeneration(unit);
            eventSystem.getTurnEvent().Refresh();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}

```

---

# File: src/Game/Systems/VisibilitySystem.java

```java
package Game.Systems;

public class VisibilitySystem {
}

```

---

# File: src/Game/Turn/TurnState.java

```java
package Game.Turn;

public class TurnState {
}

```

---

# File: src/Game/Views/BoardPanel/BoardPanel.java

```java
package Game.Views.BoardPanel;

import Game.Systems.DrawingSystem;

import javax.swing.JPanel;
import java.awt.*;

public class BoardPanel extends JPanel {

//    private final BoardState boardState;
    private final DrawingSystem drawingSystem;


    public BoardPanel( DrawingSystem drawingSystem) {
        this.drawingSystem = drawingSystem;
        setBackground(Color.DARK_GRAY);
        setDoubleBuffered(true);
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawingSystem.draw(g);
    }
}
```

---

# File: src/Game/Views/BoardPanel/EndTurnButton.java

```java
package Game.Views.BoardPanel;

import Game.Controller.BoardController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;

/**
 * The circular "End Turn" seal. This is the single most important button
 * in the game, so it's deliberately weighted differently from every other
 * themed control — a wax-seal / iron medallion rather than a rectangular button.
 */
public class EndTurnButton extends JButton {

    public static final int DIAMETER = 96;

    private boolean hovering = false;

    private final BoardController boardController;

    public EndTurnButton(BoardController boardController) {
        this.boardController = boardController;
        setPreferredSize(new Dimension(DIAMETER, DIAMETER));
        setContentAreaFilled(false);
        setBorderPainted(false);
        setFocusPainted(false);
        setOpaque(false);
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        setToolTipText("End Turn");

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                hovering = true;
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                hovering = false;
                repaint();
            }
        });

        // TODO (later): wire to BoardController.TurnEnded()
        addActionListener(e -> {
            boardController.TurnEnded();
        });
    }

    /** Restrict the clickable/hoverable area to the actual circle, not its square bounding box. */
    @Override
    public boolean contains(int x, int y) {
        double r = getWidth() / 2.0;
        double cx = getWidth() / 2.0;
        double cy = getHeight() / 2.0;
        return (x - cx) * (x - cx) + (y - cy) * (y - cy) <= r * r;
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int w = getWidth();
        int h = getHeight();
        int pad = 4;

        // Torchlit halo on hover
        if (hovering) {
            g2.setColor(new Color(198, 165, 96, 90));
            g2.fillOval(0, 0, w, h);
        }

        // Weathered gold/bronze rim
        Ellipse2D ring = new Ellipse2D.Double(pad, pad, w - pad * 2.0, h - pad * 2.0);
        g2.setPaint(new GradientPaint(0, 0, new Color(120, 96, 52), w, h, new Color(198, 165, 96)));
        g2.fill(ring);

        // Dark iron core
        int corePad = pad + 6;
        Ellipse2D core = new Ellipse2D.Double(corePad, corePad, w - corePad * 2.0, h - corePad * 2.0);
        g2.setPaint(new RadialGradientPaint(
                new Point2D.Double(w / 2.0, h / 2.5),
                w / 2f,
                new float[]{0f, 1f},
                new Color[]{
                        hovering ? new Color(60, 22, 22) : new Color(35, 15, 15),
                        new Color(10, 8, 8)
                }
        ));
        g2.fill(core);

        // Thin inner gold hairline
        g2.setStroke(new BasicStroke(1.5f));
        g2.setColor(new Color(198, 165, 96, 180));
        g2.draw(new Ellipse2D.Double(corePad + 3, corePad + 3, w - (corePad + 3) * 2.0, h - (corePad + 3) * 2.0));

        // "END TURN" label, two lines, centered
        g2.setFont(new Font("Serif", Font.BOLD, 13));
        FontMetrics fm = g2.getFontMetrics();
        int lineHeight = fm.getHeight();
        int startY = (h - lineHeight * 2) / 2 + fm.getAscent();

        g2.setColor(new Color(230, 214, 170));
        String line1 = "END";
        String line2 = "TURN";
        g2.drawString(line1, (w - fm.stringWidth(line1)) / 2, startY);
        g2.drawString(line2, (w - fm.stringWidth(line2)) / 2, startY + lineHeight);

        g2.dispose();
    }
}
```

---

# File: src/Game/Views/GameEngine.java

```java
package Game.Views;

import Game.Managers.ControllerManager;
import Game.Managers.TurnManager;
import Game.Systems.DrawingSystem;
import Game.Views.BoardPanel.BoardPanel;
import Game.Views.BoardPanel.EndTurnButton;
import Game.Views.HUDPanel.HUDPanel;
import Game.Views.HUDPanel.HUDState;
import Game.Views.Listeners.BoardMouseListener;
import Game.Views.TownHallPanel.TownHallPanel;
import Game.Views.TownHallPanel.TownHallState;
import Game.Views.UnitPanel.UnitPanel;
import Game.Views.UnitPanel.UnitPanelState;
import Game.World;
import Models.ConnectViews;
import Models.Elements.Buildings.TownHall;
import Models.Elements.Units.Unit;
import Models.Logic.HexLogic.HexLogic;
import Models.Records.HexRecord;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Constructor;

public class GameEngine {

    private final DrawingSystem drawingSystem;
    private final GameFrame gameFrame;
    private final BoardPanel boardPanel;
    private final BoardMouseListener listener;
    private final ConnectViews connectViews;
    private final EndTurnButton endTurnButton;
    private final HUDPanel hudPanel;
    private final JLayeredPane layeredPane;
    private Unit lastSelectedUnit = null;
    private UnitPanel activeUnitPanel = null;
    private final ControllerManager controllerManager;
    private final TurnManager turnManager;
    private final TownHallPanel townHallPanel;
    private final TownHallState townHallState;
    private final World world;

    public GameEngine(DrawingSystem drawingSystem, BoardMouseListener listener, ConnectViews connectViews, ControllerManager controllerManager, TurnManager turnManager, World world) {
        this.drawingSystem = drawingSystem;
        this.listener = listener;
        this.connectViews = connectViews;
        this.controllerManager = controllerManager;
        this.endTurnButton = new EndTurnButton(controllerManager.getBoardController());
        this.turnManager = turnManager;
        this.world = world;
        this.townHallState = new TownHallState(world.getTownHall());
        this.townHallPanel = new TownHallPanel(townHallState);

        HUDState hudState = new HUDState(controllerManager.getWorld(), turnManager,controllerManager.getHudController());
        this.hudPanel = new HUDPanel(hudState);

        gameFrame = new GameFrame();
        boardPanel = new BoardPanel(drawingSystem);
        boardPanel.addMouseListener(listener);
        boardPanel.addMouseMotionListener(listener);
        boardPanel.addMouseWheelListener(listener);
        gameFrame.setLayout(new BorderLayout());

        layeredPane = new JLayeredPane();
        boardPanel.setBounds(0, 0, gameFrame.getWidth(), gameFrame.getHeight());
        layeredPane.add(boardPanel, JLayeredPane.DEFAULT_LAYER);
        layeredPane.add(endTurnButton, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(hudPanel, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(townHallPanel, JLayeredPane.PALETTE_LAYER);
        gameFrame.setContentPane(layeredPane);
    }

    public void startGame() {
        gameFrame.setVisible(true);
        boardPanel.setBounds(0, 0, gameFrame.getWidth(), gameFrame.getHeight());
        endTurnButton.setBounds(30, gameFrame.getHeight() - EndTurnButton.DIAMETER - 30,
                EndTurnButton.DIAMETER, EndTurnButton.DIAMETER);
        hudPanel.setBounds(0, 0, gameFrame.getWidth(), HUDPanel.HEIGHT);
        townHallPanel.setBounds(20, HUDPanel.HEIGHT + 20, TownHallPanel.PANEL_WIDTH, TownHallPanel.PANEL_HEIGHT);
    }

    public void refresh() {
        boardPanel.setBounds(0, 0, gameFrame.getWidth(), gameFrame.getHeight());
        endTurnButton.setBounds(30, gameFrame.getHeight() - EndTurnButton.DIAMETER - 30,
                EndTurnButton.DIAMETER, EndTurnButton.DIAMETER);
        hudPanel.setBounds(0, 0, gameFrame.getWidth(), HUDPanel.HEIGHT);
        hudPanel.refresh();
        townHallPanel.setBounds(20, HUDPanel.HEIGHT + 20, TownHallPanel.PANEL_WIDTH, TownHallPanel.PANEL_HEIGHT);
        townHallPanel.refresh();

        Unit currentUnit = connectViews.getSelectedUnit();

        if (currentUnit != lastSelectedUnit) {
            if (activeUnitPanel != null) {
                layeredPane.remove(activeUnitPanel);
                activeUnitPanel = null;
            }

            if (currentUnit != null) {
                activeUnitPanel = createUnitPanel(currentUnit);

                if (activeUnitPanel != null) {
                    activeUnitPanel.setBounds(
                            gameFrame.getWidth() - UnitPanel.PANEL_WIDTH - 20,
                            gameFrame.getHeight() - UnitPanel.PANEL_HEIGHT - 60,
                            UnitPanel.PANEL_WIDTH,
                            UnitPanel.PANEL_HEIGHT
                    );
                    layeredPane.add(activeUnitPanel, JLayeredPane.PALETTE_LAYER);
                }
            }

            lastSelectedUnit = currentUnit;
            layeredPane.revalidate();
            layeredPane.repaint();
        } else if (activeUnitPanel != null) {
            // Same unit still selected — just refresh its stats (AP, Charges, etc.)
            activeUnitPanel.refresh();
        }

        boardPanel.repaint();
    }

    /**
     * Resolves the panel type for this unit via ConnectViews' relatedPanel map,
     * then constructs it reflectively. This is the only place that needs to know
     * unit type -> panel type exists as a Map, not an if/else chain — add a new
     * unit + panel pair by registering it in ConnectViews and nothing here changes.
     */
    private UnitPanel createUnitPanel(Unit unit) {
        Class<? extends JPanel> panelClass = connectViews.getRelatedPanel().get(unit.getClass());
        if (panelClass == null) {
            System.err.println("GameEngine: no UnitPanel registered for " + unit.getClass().getSimpleName());
            return null;
        }

        try {
            Constructor<? extends JPanel> constructor =
                    panelClass.getConstructor(unit.getClass(), UnitPanelState.class);
            UnitPanelState state = new UnitPanelState(controllerManager.getUnitPanelController());
            return (UnitPanel) constructor.newInstance(unit, state);
        } catch (ReflectiveOperationException e) {
            throw new RuntimeException(
                    "GameEngine: failed to build " + panelClass.getSimpleName()
                            + " for " + unit.getClass().getSimpleName(), e);
        }
    }
}
```

---

# File: src/Game/Views/GameFrame.java

```java
package Game.Views;

import javax.swing.*;

public class GameFrame extends JFrame {

    public GameFrame() {


        setTitle("Advanced Strategy Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setBackground(Color.DARK_GRAY);   

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(false); // set true if you want borderless fullscreen
        setVisible(true);
    }

}

```

---

# File: src/Game/Views/HexBuildingPanel/HexBuildingState.java

```java
package Game.Views.HexBuildingPanel;

import Models.ConnectViews;

public class HexBuildingState {
//    private ConnectViews connectViews
}

```

---

# File: src/Game/Views/HUDPanel/HUDAssets.java

```java
package Game.Views.HUDPanel;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * Loads and caches icon images for anything shown in the HUD.
 * Images aren't added yet — callers fall back to a lettered placeholder
 * circle when the resource is missing, so the HUD still renders correctly.
 * Expected paths: /assets/resources/<SimpleName>.png, /assets/units/<SimpleName>.png
 */
final class HUDAssets {

    private static final Map<String, Image> CACHE = new HashMap<>();

    private HUDAssets() {
    }

    static Image loadIcon(Class<?> elementClass, String folder) {
        String key = folder + "/" + elementClass.getSimpleName();
        return CACHE.computeIfAbsent(key, k -> {
            URL url = HUDAssets.class.getResource("/assets/" + folder + "/" + elementClass.getSimpleName() + ".png");
            return url != null ? new ImageIcon(url).getImage() : null;
        });
    }
}
```

---

# File: src/Game/Views/HUDPanel/HUDPanel.java

```java
package Game.Views.HUDPanel;

import javax.swing.*;
import java.awt.*;

public class HUDPanel extends JPanel {

    public static final int HEIGHT = 74;

    private final ResourcePanel resourcePanel;
    private final TurnPanel turnPanel;
    private final UnitRosterPanel unitRosterPanel;

    public HUDPanel(HUDState state) {
        setLayout(new BorderLayout());
        setOpaque(false);
        setPreferredSize(new Dimension(0, HEIGHT));
        setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(198, 165, 96)));

        resourcePanel = new ResourcePanel(state);
        turnPanel = new TurnPanel(state);
        unitRosterPanel = new UnitRosterPanel(state);

        add(wrap(resourcePanel, 20), BorderLayout.WEST);
        add(turnPanel, BorderLayout.CENTER);
        add(wrap(unitRosterPanel, 20), BorderLayout.EAST);
    }

    private JPanel wrap(JComponent content, int horizontalPad) {
        JPanel wrapper = new JPanel(new GridBagLayout());
        wrapper.setOpaque(false);
        wrapper.setBorder(BorderFactory.createEmptyBorder(0, horizontalPad, 0, horizontalPad));
        wrapper.add(content);
        return wrapper;
    }

    /** Call after any resource/unit/turn change. */
    public void refresh() {
        resourcePanel.refresh();
        turnPanel.refresh();
        unitRosterPanel.refresh();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setPaint(new GradientPaint(0, 0, new Color(20, 17, 14), 0, getHeight(), new Color(35, 30, 24)));
        g2.fillRect(0, 0, getWidth(), getHeight());
        g2.dispose();
    }
}
```

---

# File: src/Game/Views/HUDPanel/HUDState.java

```java
package Game.Views.HUDPanel;

import Game.Controller.HUDController;
import Game.Managers.TurnManager;
import Game.World;
import Models.ConnectViews;
import Models.Elements.Resources.Resource;
import Models.Elements.Units.Unit;

public class HUDState {
    private final World world;
    private final TurnManager turnManager;
    private final HUDController controller;

    public HUDState(World world, TurnManager turnManager, HUDController controller) {
        this.world = world;
        this.turnManager = turnManager;

        this.controller = controller;
    }

    public int getResourceCount(Class<? extends Resource> resourceClass) {
        return world.getResourceRecord().getAll(resourceClass).size();
    }

    public int getUnitCount(Class<? extends Unit> unitClass) {
        return world.getUnitRecord().getAll(unitClass).size();
    }

    public int getTurn() {
        return turnManager.getTurns();
    }

    /** Called when a unit's icon in the roster is clicked. Empty for now. */
    public void onUnitIconClicked(Class<? extends Unit> unitClass) {
//        System.out.println(unitClass);
        controller.addToTownHall(unitClass);
    }
}
```

---

# File: src/Game/Views/HUDPanel/ResourceEntryComponent.java

```java
package Game.Views.HUDPanel;

import Models.Elements.Resources.Resource;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

class ResourceEntryComponent extends JComponent {

    private static final int DIAMETER = 34;

    private final Class<? extends Resource> resourceClass;
    private final HUDState state;
    private final Image icon;

    ResourceEntryComponent(Class<? extends Resource> resourceClass, HUDState state) {
        this.resourceClass = resourceClass;
        this.state = state;
        this.icon = HUDAssets.loadIcon(resourceClass, "resources");
        setOpaque(false);
        setPreferredSize(new Dimension(72, DIAMETER + 4));
    }

    void refresh() {
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int cy = getHeight() / 2;
        int cx = DIAMETER / 2 + 2;

        g2.setPaint(new GradientPaint(0, 0, new Color(60, 48, 30), 0, DIAMETER, new Color(30, 24, 16)));
        g2.fillOval(cx - DIAMETER / 2, cy - DIAMETER / 2, DIAMETER, DIAMETER);
        g2.setStroke(new BasicStroke(2f));
        g2.setColor(new Color(198, 165, 96));
        g2.drawOval(cx - DIAMETER / 2, cy - DIAMETER / 2, DIAMETER, DIAMETER);

        if (icon != null) {
            g2.setClip(new Ellipse2D.Double(cx - DIAMETER / 2.0 + 2, cy - DIAMETER / 2.0 + 2, DIAMETER - 4, DIAMETER - 4));
            g2.drawImage(icon, cx - DIAMETER / 2 + 2, cy - DIAMETER / 2 + 2, DIAMETER - 4, DIAMETER - 4, this);
            g2.setClip(null);
        } else {
            g2.setColor(new Color(198, 165, 96));
            g2.setFont(new Font("Serif", Font.BOLD, 14));
            String letter = resourceClass.getSimpleName().substring(0, 1);
            FontMetrics fm = g2.getFontMetrics();
            g2.drawString(letter, cx - fm.stringWidth(letter) / 2, cy + fm.getAscent() / 2 - 2);
        }

        g2.setFont(new Font("Serif", Font.BOLD, 15));
        g2.setColor(new Color(230, 214, 170));
        String count = String.valueOf(state.getResourceCount(resourceClass));
        FontMetrics fm = g2.getFontMetrics();
        g2.drawString(count, cx + DIAMETER / 2 + 8, cy + fm.getAscent() / 2 - 2);

        g2.dispose();
    }
}
```

---

# File: src/Game/Views/HUDPanel/ResourcePanel.java

```java
package Game.Views.HUDPanel;

import Models.Elements.Resources.Food;
import Models.Elements.Resources.Iron;
import Models.Elements.Resources.Resource;
import Models.Elements.Resources.Stone;
import Models.Elements.Resources.Wood;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

class ResourcePanel extends JPanel {

    private final List<ResourceEntryComponent> entries = new ArrayList<>();

    ResourcePanel(HUDState state) {
        setOpaque(false);
        setLayout(new FlowLayout(FlowLayout.LEFT, 14, 0));

        addEntry(Food.class, state);
        addEntry(Wood.class, state);
        addEntry(Stone.class, state);
        addEntry(Iron.class, state);
    }

    private void addEntry(Class<? extends Resource> resourceClass, HUDState state) {
        ResourceEntryComponent entry = new ResourceEntryComponent(resourceClass, state);
        entries.add(entry);
        add(entry);
    }

    void refresh() {
        entries.forEach(ResourceEntryComponent::refresh);
    }
}
```

---

# File: src/Game/Views/HUDPanel/TurnPanel.java

```java
package Game.Views.HUDPanel;

import javax.swing.*;
import java.awt.*;

class TurnPanel extends JPanel {

    private final HUDState state;
    private final JLabel turnLabel;

    TurnPanel(HUDState state) {
        this.state = state;
        setOpaque(false);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel caption = new JLabel("TURN");
        caption.setFont(new Font("Serif", Font.PLAIN, 11));
        caption.setForeground(new Color(198, 165, 96));
        caption.setAlignmentX(Component.CENTER_ALIGNMENT);

        turnLabel = new JLabel();
        turnLabel.setFont(new Font("Serif", Font.BOLD, 22));
        turnLabel.setForeground(new Color(230, 214, 170));
        turnLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        add(caption);
        add(turnLabel);

        refresh();
    }

    void refresh() {
        turnLabel.setText(String.valueOf(state.getTurn()));
    }
}
```

---

# File: src/Game/Views/HUDPanel/UnitRosterButton.java

```java
package Game.Views.HUDPanel;

import Models.Elements.Units.Unit;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;

class UnitRosterButton extends JPanel {

    private static final int ICON_SIZE = 30;

    private final Class<? extends Unit> unitClass;
    private final HUDState state;
    private final Image icon;
    private final IconCircle iconCircle;
    private final JLabel label;
    private boolean hovering = false;

    UnitRosterButton(Class<? extends Unit> unitClass, HUDState state) {
        this.unitClass = unitClass;
        this.state = state;
        this.icon = HUDAssets.loadIcon(unitClass, "units");

        setOpaque(false);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        setBorder(BorderFactory.createEmptyBorder(4, 6, 4, 6));

        iconCircle = new IconCircle();
        iconCircle.setAlignmentX(Component.CENTER_ALIGNMENT);

        label = new JLabel();
        label.setFont(new Font("Serif", Font.BOLD, 10));
        label.setForeground(new Color(230, 214, 170));
        label.setAlignmentX(Component.CENTER_ALIGNMENT);

        add(iconCircle);
        add(Box.createVerticalStrut(3));
        add(label);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                hovering = true;
                iconCircle.repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                hovering = false;
                iconCircle.repaint();
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                state.onUnitIconClicked(unitClass);
            }
        });

        refresh();
    }

    void refresh() {
        String name = unitClass.getSimpleName().replaceAll("(?<!^)(?=[A-Z])", " ");
        label.setText(name + " (" + state.getUnitCount(unitClass) + ")");
        iconCircle.repaint();
    }

    private class IconCircle extends JComponent {

        IconCircle() {
            setPreferredSize(new Dimension(ICON_SIZE + 6, ICON_SIZE + 6));
            setOpaque(false);
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            int d = ICON_SIZE;
            int off = 3;

            if (hovering) {
                g2.setColor(new Color(198, 165, 96, 90));
                g2.fillOval(0, 0, d + 6, d + 6);
            }

            g2.setPaint(new GradientPaint(0, off, new Color(60, 48, 30), 0, off + d, new Color(30, 24, 16)));
            g2.fillOval(off, off, d, d);
            g2.setStroke(new BasicStroke(2f));
            g2.setColor(new Color(198, 165, 96));
            g2.drawOval(off, off, d, d);

            if (icon != null) {
                g2.setClip(new Ellipse2D.Double(off + 2, off + 2, d - 4, d - 4));
                g2.drawImage(icon, off + 2, off + 2, d - 4, d - 4, this);
                g2.setClip(null);
            } else {
                g2.setColor(new Color(198, 165, 96));
                g2.setFont(new Font("Serif", Font.BOLD, 12));
                String letter = unitClass.getSimpleName().substring(0, 1);
                FontMetrics fm = g2.getFontMetrics();
                g2.drawString(letter, off + d / 2 - fm.stringWidth(letter) / 2, off + d / 2 + fm.getAscent() / 2 - 2);
            }

            g2.dispose();
        }
    }
}
```

---

# File: src/Game/Views/HUDPanel/UnitRosterPanel.java

```java
package Game.Views.HUDPanel;

import Models.Elements.Units.BorderExpander;
import Models.Elements.Units.Builder;
import Models.Elements.Units.Explorer;
import Models.Elements.Units.Unit;
import Models.Elements.Units.Worker;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

class UnitRosterPanel extends JPanel {

    private final List<UnitRosterButton> buttons = new ArrayList<>();

    UnitRosterPanel(HUDState state) {
        setOpaque(false);
        setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 0));

        addButton(Worker.class, state);
        addButton(Builder.class, state);
        addButton(Explorer.class, state);
        addButton(BorderExpander.class, state);
    }

    private void addButton(Class<? extends Unit> unitClass, HUDState state) {
        UnitRosterButton button = new UnitRosterButton(unitClass, state);
        buttons.add(button);
        add(button);
    }

    void refresh() {
        buttons.forEach(UnitRosterButton::refresh);
    }
}
```

---

# File: src/Game/Views/Listeners/BoardMouseListener.java

```java
package Game.Views.Listeners;

import Game.Controller.BoardController;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

public class BoardMouseListener extends MouseAdapter {
    private final BoardController boardController;
    private int lastX;
    private int lastY;

    public BoardMouseListener(BoardController boardController) {
        this.boardController = boardController;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // Capture the starting point of the drag
        lastX = e.getX();
        lastY = e.getY();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        boardController.mouseClicked(e.getX(), e.getY());
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        boardController.mouseWheelChanged(e.getWheelRotation());
        super.mouseWheelMoved(e);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        super.mouseDragged(e);

        int dx = e.getX() - lastX;
        int dy = e.getY() - lastY;

        boardController.mouseDragged(dx, dy);

        lastX = e.getX();
        lastY = e.getY();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        boardController.mouseMoved(e.getX(), e.getY());
    }
}
```

---

# File: src/Game/Views/TownHallPanel/TownHallPanel.java

```java
package Game.Views.TownHallPanel;

import Models.Elements.Units.Unit;

import javax.swing.*;
import java.awt.*;

public class TownHallPanel extends JPanel {

    public static final int PANEL_WIDTH = 160;
    public static final int PANEL_HEIGHT = 230;

    private static final int IMAGE_HEIGHT = 170;

    private final TownHallState state;
    private final JLabel nameLabel;
    private Image currentImage;
    private double progressFraction = 0; // step / totalStep, 0..1

    public TownHallPanel(TownHallState state) {
        this.state = state;

        setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        setOpaque(false);
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createLineBorder(new Color(198, 165, 96), 2));

        nameLabel = new JLabel("", SwingConstants.CENTER);
        nameLabel.setFont(new Font("Serif", Font.BOLD, 14));
        nameLabel.setForeground(new Color(230, 214, 170));
        nameLabel.setBorder(BorderFactory.createEmptyBorder(6, 4, 8, 4));

        add(nameLabel, BorderLayout.SOUTH);

        refresh();
    }

    /**
     * Pulls current generation progress from TownHallState, loads the
     * relevant background image, and repaints. Hides itself entirely
     * once generation is finished — that's the "show nothing" case.
     */
    public void refresh() {
        boolean finished = state.isFinished();
        Unit unit = finished ? null : state.getCurrentUnit();

        setVisible(!finished && unit != null);
        if (!isVisible()) {
            return;
        }

        String path = state.getPicturePath(unit.getClass());
        currentImage = (path != null) ? new ImageIcon(path).getImage() : null;

        int totalStep = state.getTotalStep();
        int step = state.getStep();
        progressFraction = totalStep > 0 ? Math.min(1.0, Math.max(0.0, step / (double) totalStep)) : 0;

        nameLabel.setText(unit.getClass().getSimpleName().replaceAll("(?<!^)(?=[A-Z])", " "));

        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setColor(new Color(20, 17, 14));
        g2.fillRect(0, 0, getWidth(), getHeight());

        if (currentImage != null) {
            int imgW = getWidth();
            int imgH = IMAGE_HEIGHT;

            // Full picture at normal brightness
            g2.drawImage(currentImage, 0, 0, imgW, imgH, this);

            // Dark overlay over the TOP (1 - progress) portion.
            // The bottom `progress` fraction (e.g. 2/5) stays lit.
            int darkHeight = (int) Math.round(imgH * (1.0 - progressFraction));
            if (darkHeight > 0) {
                g2.setColor(new Color(0, 0, 0, 170));
                g2.fillRect(0, 0, imgW, darkHeight);
            }
        }

        g2.dispose();
    }
}
```

---

# File: src/Game/Views/TownHallPanel/TownHallState.java

```java
package Game.Views.TownHallPanel;

import Models.Elements.Buildings.TownHall;
import Models.Elements.Units.*;
import Models.Logic.BuildingLogic.TownHallGenerateUnit;

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
        relatedPicture.put(Worker.class, "C:\\Users\\shantiya\\Desktop\\django\\java\\Civilizatino-6\\src\\Images\\UnitBackground\\ChatGPT Image Jul 13, 2026, 05_33_53 PM.png");
        relatedPicture.put(BorderExpander.class, "C:\\Users\\shantiya\\Desktop\\django\\java\\Civilizatino-6\\src\\Images\\UnitBackground\\5956229881702059521.jpg");
        relatedPicture.put(Explorer.class, "C:\\Users\\shantiya\\Desktop\\django\\java\\Civilizatino-6\\src\\Images\\UnitBackground\\ChatGPT Image Jul 13, 2026, 05_42_04 PM.png");
        relatedPicture.put(Builder.class, "C:\\Users\\shantiya\\Desktop\\django\\java\\Civilizatino-6\\src\\Images\\UnitBackground\\ChatGPT Image Jul 13, 2026, 05_50_12 PM.png");
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
```

---

# File: src/Game/Views/UnitPanel/BorderExpanderUnitPanel.java

```java
package Game.Views.UnitPanel;

import Game.Views.UnitPanel.UnitPanel;
import Game.Views.UnitPanel.UnitPanelState;
import Models.Elements.Units.BorderExpander;

import javax.swing.*;

public class BorderExpanderUnitPanel extends UnitPanel {

    private final BorderExpander borderExpander;

    public BorderExpanderUnitPanel(BorderExpander borderExpander, UnitPanelState state) {
        super("Border Expander", state);
        this.borderExpander = borderExpander;
        backgroundImage = new ImageIcon("C:\\Users\\shantiya\\Desktop\\django\\java\\Civilizatino-6\\src\\Images\\UnitBackground\\5956229881702059521.jpg").getImage();
        JButton addToBorderButton = createThemedButton("Add To Border");
        addToBorderButton.addActionListener(e -> state.addToBorder());

        actionPanel.add(addToBorderButton);

        refresh();
    }

    public void refresh() {
        updateStats(borderExpander.getAP(), borderExpander.getFoodNeed());
    }
}
```

---

# File: src/Game/Views/UnitPanel/BuilderUnitPanel.java

```java
package Game.Views.UnitPanel;

import Models.Elements.Buildings.Building;
import Models.Elements.Units.Builder;

import javax.swing.*;
import java.util.List;

public class BuilderUnitPanel extends UnitPanel {

    private final Builder builder;
    private final JLabel chargesLabel;
    private final JPanel buildButtonsPanel;

    public BuilderUnitPanel(Builder builder, UnitPanelState state) {
        super("Builder", state);
        this.builder = builder;
        backgroundImage = new ImageIcon("C:\\Users\\shantiya\\Desktop\\django\\java\\Civilizatino-6\\src\\Images\\UnitBackground\\ChatGPT Image Jul 13, 2026, 05_50_12 PM.png").getImage();
        chargesLabel = createThemedLabel("", 14f, false);

        buildButtonsPanel = new JPanel();
        buildButtonsPanel.setOpaque(false);
        buildButtonsPanel.setLayout(new BoxLayout(buildButtonsPanel, BoxLayout.Y_AXIS));

        actionPanel.add(chargesLabel);
        actionPanel.add(Box.createVerticalStrut(8));
        actionPanel.add(buildButtonsPanel);

        refresh();
    }

    @Override
    public void refresh() {
        updateStats(builder.getAP(), builder.getFoodNeed());
        chargesLabel.setText("Charges: " + builder.getCharges());
        rebuildBuildButtons();
    }

    /**
     * Rebuilds the "Build X" buttons from the builder's current hex.
     * Can't be done once in the constructor — the builder moves between
     * refresh() calls, and each hex may allow different buildings.
     */
    private void rebuildBuildButtons() {
        buildButtonsPanel.removeAll();

        var hex = builder.getHex();
        boolean hexOccupied = hex != null && hex.getBuilding() != null;
        List<Class<? extends Building>> buildable = hex != null ? hex.getBuildableBuildings() : null;

        if (!hexOccupied && buildable != null && !buildable.isEmpty()) {
            for (Class<? extends Building> buildingClass : buildable) {
                JButton buildButton = createThemedButton("Build " + displayName(buildingClass));
                buildButton.addActionListener(e -> state.build(buildingClass));
                buildButtonsPanel.add(buildButton);
                buildButtonsPanel.add(Box.createVerticalStrut(6));
            }
        }
        // hexOccupied, or buildable null/empty -> buildButtonsPanel stays empty, nothing shown

        buildButtonsPanel.revalidate();
        buildButtonsPanel.repaint();
    }

    /** "IronMine" -> "Iron Mine" */
    private String displayName(Class<? extends Building> buildingClass) {
        return buildingClass.getSimpleName().replaceAll("(?<!^)(?=[A-Z])", " ");
    }
}
```

---

# File: src/Game/Views/UnitPanel/ExplorerUnitPanel.java

```java
package Game.Views.UnitPanel;

import Game.Views.UnitPanel.UnitPanel;
import Game.Views.UnitPanel.UnitPanelState;
import Models.Elements.Units.Explorer;

import javax.swing.*;

public class ExplorerUnitPanel extends UnitPanel {

    private final Explorer explorer;

    public ExplorerUnitPanel(Explorer explorer, UnitPanelState state) {
        super("Explorer", state);
        this.explorer = explorer;
        backgroundImage = new ImageIcon("C:\\Users\\shantiya\\Desktop\\django\\java\\Civilizatino-6\\src\\Images\\UnitBackground\\ChatGPT Image Jul 13, 2026, 05_42_04 PM.png").getImage();
        JButton exploreButton = createThemedButton("Explore");
        exploreButton.addActionListener(e -> state.explore());

        actionPanel.add(exploreButton);

        refresh();
    }

    public void refresh() {
        updateStats(explorer.getAP(), explorer.getFoodNeed());
    }
}
```

---

# File: src/Game/Views/UnitPanel/UnitPanel.java

```java
package Game.Views.UnitPanel;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public abstract class UnitPanel extends JPanel {

    public static final int PANEL_WIDTH = 200;
    public static final int PANEL_HEIGHT = 380;

    protected static Image backgroundImage;

    static {
        // Place the artwork at src/main/resources/assets/unit_panel_background.png
        URL url = UnitPanel.class.getResource("/assets/unit_panel_background.png");
        if (url != null) {
            backgroundImage = new ImageIcon(url).getImage();
        }
    }

    protected final UnitPanelState state;
    protected final JPanel actionPanel; // subclasses append their buttons/fields here

    private final JLabel nameLabel;
    private final JLabel apLabel;
    private final JLabel foodNeedLabel;

    protected UnitPanel(String unitName, UnitPanelState state) {
        this.state = state;

        setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        setLayout(new BorderLayout());
        setOpaque(false);
        setBorder(BorderFactory.createLineBorder(new Color(198, 165, 96), 2));

        nameLabel = createThemedLabel(unitName, 20f, true);
        nameLabel.setHorizontalAlignment(SwingConstants.CENTER);

        apLabel = createThemedLabel("", 14f, false);
        foodNeedLabel = createThemedLabel("", 14f, false);

        JPanel statsPanel = new JPanel(new GridLayout(2, 1, 0, 4));
        statsPanel.setOpaque(false);
        statsPanel.setBorder(BorderFactory.createEmptyBorder(8, 12, 8, 12));
        statsPanel.add(apLabel);
        statsPanel.add(foodNeedLabel);

        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setOpaque(false);
        headerPanel.add(nameLabel, BorderLayout.NORTH);
        headerPanel.add(statsPanel, BorderLayout.CENTER);

        actionPanel = new JPanel();
        actionPanel.setOpaque(false);
        actionPanel.setLayout(new BoxLayout(actionPanel, BoxLayout.Y_AXIS));
        actionPanel.setBorder(BorderFactory.createEmptyBorder(8, 16, 16, 16));

        add(headerPanel, BorderLayout.NORTH);
        add(actionPanel, BorderLayout.SOUTH);
    }

    /**
     * Abstract refresh contract.
     * Subclasses will override this to query their specific Unit model
     * and call updateStats() along with any subclass-specific UI updates.
     */
    public abstract void refresh();

    /** Call after construction (or whenever the unit's stats change). */
    protected void updateStats(int ap, int foodNeed) {
        apLabel.setText("Remaining AP: " + ap);
        foodNeedLabel.setText("Food Need: " + foodNeed);
    }

    protected JLabel createThemedLabel(String text, float size, boolean bold) {
        JLabel label = new JLabel(text);
        label.setForeground(new Color(230, 214, 170));
        label.setFont(new Font("Serif", bold ? Font.BOLD : Font.PLAIN, (int) size));
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        return label;
    }

    protected JButton createThemedButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Serif", Font.BOLD, 13));
        button.setForeground(new Color(20, 18, 15));
        button.setBackground(new Color(198, 165, 96));
        button.setFocusPainted(false);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setMaximumSize(new Dimension(160, 32));
        return button;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        if (backgroundImage != null) {
            g2.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            g2.setColor(new Color(0, 0, 0, 120)); // overlay for text contrast
            g2.fillRect(0, 0, getWidth(), getHeight());
        } else {
            g2.setColor(new Color(25, 22, 18));
            g2.fillRect(0, 0, getWidth(), getHeight());
        }
        g2.dispose();
    }

}
```

---

# File: src/Game/Views/UnitPanel/UnitPanelState.java

```java
package Game.Views.UnitPanel;

import Game.Controller.UnitPanelController;
import Models.Elements.Buildings.Building;

public class UnitPanelState {
    private final UnitPanelController controller;

    public UnitPanelState(UnitPanelController controller) {
        this.controller = controller;
    }

    // Worker actions
    public void getInBuilding() {
        System.out.println("UI Interaction: Station Worker triggered.");
        controller.stationWorker();
    }

    public void getOffBuilding() {
        System.out.println("UI Interaction: Unstation Worker triggered.");
        controller.unstationWorker();
    }

    // Builder actions
    public void build(Class<? extends Building> buildingClass) {
        controller.build(buildingClass);
    }

    // Explorer actions
    public void explore() {
        System.out.println("UI Interaction: Explore triggered.");
        controller.exploreSurroundings();
    }

    // BorderExpander actions
    public void addToBorder() {
        System.out.println("UI Interaction: Add to Border triggered.");
        controller.expandBorder();
    }
}
```

---

# File: src/Game/Views/UnitPanel/WorkerUnitPanel.java

```java
package Game.Views.UnitPanel;


import Game.Views.UnitPanel.UnitPanel;
import Game.Views.UnitPanel.UnitPanelState;
import Models.Elements.Units.Worker;

import javax.swing.*;

public class WorkerUnitPanel extends UnitPanel {

    private final Worker worker;

    public WorkerUnitPanel(Worker worker, UnitPanelState state) {
        super("Worker", state);
        this.worker = worker;
        backgroundImage = new ImageIcon("C:\\Users\\shantiya\\Desktop\\django\\java\\Civilizatino-6\\src\\Images\\UnitBackground\\ChatGPT Image Jul 13, 2026, 05_33_53 PM.png").getImage();
        JButton getInBuildingButton = createThemedButton("Get In Building");
        getInBuildingButton.addActionListener(e -> state.getInBuilding());

        JButton getOffBuildingButton = createThemedButton("Get Off Building");
        getOffBuildingButton.addActionListener(e -> state.getOffBuilding());

        actionPanel.add(getInBuildingButton);
        actionPanel.add(Box.createVerticalStrut(8));
        actionPanel.add(getOffBuildingButton);

        refresh();
    }

    public void refresh() {
        updateStats(worker.getAP(), worker.getFoodNeed());
    }
}
```

---

# File: src/Game/World.java

```java
package Game;

import Models.ConnectDrawing;
import Models.ConnectViews;
import Models.Draw.UnitPositionCalculator;
import Models.Elements.Buildings.TownHall;
import Models.Elements.Hex.Hex;
import Models.Elements.Hex.LandHex;
import Models.Logic.BuildingLogic.TownHallGenerateUnit;
import Models.Logic.BuildingLogic.TownHallLogic;
import Models.Manager.HexManager;
import Models.Manager.Hexutils;
import Models.Records.BuildingRecord;
import Models.Records.HexRecord;
import Models.Records.ResourceRecord;
import Models.Records.UnitRecord;

public class World {
//    private static TownHall townHall = new TownHall();
    private final BuildingRecord buildingRecord;
    private final HexRecord hexRecord;
    private final ResourceRecord resourceRecord;
    private final UnitRecord unitRecord;
    private final HexManager hexManager;
    private final Hexutils hexutils;
    private final ConnectViews connectViews;
//    private final TownHallGenerateUnit townHallGenerateUnit;
    private ConnectDrawing connectDrawing;
    private TownHall townHall;
    private Hex centerHex;

    public World() {
        buildingRecord  = new BuildingRecord();
        resourceRecord  = new ResourceRecord();
        unitRecord      = new UnitRecord();
        hexutils        = new Hexutils();
        connectDrawing = new ConnectDrawing();
        hexRecord  = new HexRecord();
        // 665, 335 = screen center — adjust to your panel size
        hexManager = new HexManager(300, 220 , hexRecord , hexutils);
        // Wire HexRecord → HexManager so add() auto-positions hexes
        hexManager.setOnPositionsChanged(() -> UnitPositionCalculator.refreshAll(unitRecord));
        hexRecord.setHexManager(hexManager);
        connectViews = new ConnectViews();

        Generate.publishWorld(this);
//        townHallGenerateUnit = new TownHallGenerateUnit();
        centerHex = new LandHex(0 , 0 , false);
        this.townHall = new TownHall();
        townHall.setHex(centerHex);
        centerHex.setBuilding(this.townHall);
        hexRecord.add(centerHex);
        buildingRecord.add(townHall);
        new TownHallLogic(townHall).AddInitialResources();
    }

    public BuildingRecord getBuildingRecord()  { return buildingRecord; }
    public HexRecord      getHexRecord()       { return hexRecord; }
    public ResourceRecord getResourceRecord()  { return resourceRecord; }
    public UnitRecord     getUnitRecord()      { return unitRecord; }
    public HexManager     getHexManager()      { return hexManager; }
    public Hexutils       getHexutils()        { return hexutils; }

    public ConnectDrawing getConnectDrawing() {
        return connectDrawing;
    }

    public ConnectViews getConnectViews() {
        return connectViews;
    }

    public void setConnectDrawing(ConnectDrawing connectDrawing) {
        this.connectDrawing = connectDrawing;
    }

//    public TownHallGenerateUnit getTownHallGenerateUnit() {
//        return townHallGenerateUnit;
//    }
    public void Start(){
        new Starter(this).start();
    }

    public TownHall getTownHall() {
        return townHall;
    }
}
```

---

# File: src/Main.java

```java
import Game.Generate;
import Models.Generator;

import javax.swing.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(()->{
            Generate.getGame().start();
        });
    }
}
```

---

# File: src/Models/ConnectDrawing.java

```java
package Models;

import Models.Elements.Hex.Hex;

import java.util.List;

public class ConnectDrawing {
    private Hex selectedHex;

    private List<Hex> path;
    private Hex GoalHex;

    public Hex getSelectedHex() {
        return selectedHex;
    }

    public List<Hex> getPath() {
        return path;
    }

    public Hex getGoalHex() {
        return GoalHex;
    }

    public void setSelectedHex(Hex selectedHex) {
        this.selectedHex = selectedHex;
    }

    public void setPath(List<Hex> path) {
        this.path = path;
    }

    public void setGoalHex(Hex goalHex) {
        GoalHex = goalHex;
    }
}


```

---

# File: src/Models/ConnectViews.java

```java
package Models;

import Game.Views.UnitPanel.BorderExpanderUnitPanel;
import Game.Views.UnitPanel.BuilderUnitPanel;
import Game.Views.UnitPanel.ExplorerUnitPanel;
import Game.Views.UnitPanel.WorkerUnitPanel;
import Models.Elements.Buildings.TownHall;
import Models.Elements.Hex.Hex;
import Models.Elements.Units.*;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class ConnectViews {
    private Map<Class<? extends Unit> , Class<? extends JPanel>> relatedPanel;
    private Class<? extends Unit> selectedUnitClass;
    private Unit selectedUnit;
    private Hex selectedHex;
    private boolean starvation;
    private TownHall townHall;

    public ConnectViews() {
        relatedPanel = new HashMap<>();
        relatedPanel.put( Worker.class, WorkerUnitPanel.class );
        relatedPanel.put(Explorer.class , ExplorerUnitPanel.class);
        relatedPanel.put(BorderExpander.class , BorderExpanderUnitPanel.class);
        relatedPanel.put(Builder.class , BuilderUnitPanel.class);
    }

    public Map<Class<? extends Unit>, Class<? extends JPanel>> getRelatedPanel() {
        return relatedPanel;
    }

    public Class<? extends Unit> getSelectedUnitClass() {
        return selectedUnitClass;
    }

    public void setSelectedUnitClass(Class<? extends Unit> selectedUnitClass) {
        this.selectedUnitClass = selectedUnitClass;
    }

    public Unit getSelectedUnit() {
        return selectedUnit;
    }

    public void setSelectedUnit(Unit selectedUnit) {
        this.selectedUnit = selectedUnit;
    }

    public boolean isStarvation() {
        return starvation;
    }

    public void setRelatedPanel(Map<Class<? extends Unit>, Class<? extends JPanel>> relatedPanel) {
        this.relatedPanel = relatedPanel;
    }

    public void setStarvation(boolean starvation) {
        this.starvation = starvation;
    }

    public Hex getSelectedHex() {
        return selectedHex;
    }

    public void setSelectedHex(Hex selectedHex) {
        this.selectedHex = selectedHex;
    }

    public TownHall getTownHall() {
        return townHall;
    }

    public void setTownHall(TownHall townHall) {
        this.townHall = townHall;
    }
}

```

---

# File: src/Models/Draw/BuildingDraw.java

```java
package Models.Draw;

import Models.Elements.Buildings.Building;
import Models.Elements.Hex.Hex;

import javax.swing.*;
import java.awt.*;

public class BuildingDraw implements Draw {
    private final Building building;

    public BuildingDraw(Building building) {
        this.building = building;
    }

    @Override
    public void draw(Graphics g) {
        int drawX = building.getHex().getDrawX();
        int drawY = building.getHex().getDrawY();
        int drawW = building.getHex().getDrawW();
        int drawH = building.getHex().getDrawH();

        g.drawImage(building.getImage(), drawX, drawY, drawW, drawH, null);
    }
}
```

---

# File: src/Models/Draw/Draw.java

```java
package Models.Draw;

import java.awt.*;

public interface Draw {
    void draw(Graphics g);
}
```

---

# File: src/Models/Draw/HexDraw.java

```java
package Models.Draw;

import Models.Elements.Hex.Hex;

import java.awt.*;

public class HexDraw implements Draw{
    private Hex hex;

    public HexDraw(Hex hex) {
        this.hex = hex;
    }

    @Override
    public void draw(Graphics g) {
        if (hex.getImage() == null) return;
        Image image = hex.getImage();
        int x = hex.getX();
        int y = hex.getY();
        int size = hex.getSize();
        boolean visible = hex.isVisible();
        hex.SetDrawing();
        int drawX = hex.getDrawX();
        int drawY = hex.getDrawY();
        int drawW = hex.getDrawW();
        int drawH = hex.getDrawH();
        g.setColor(Color.red);

        if (visible) {
            g.drawImage(image, drawX, drawY, drawW, drawH, null);
        } else {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.drawImage(image, drawX, drawY, drawW, drawH, null);
        }
        g.setColor(Color.red);
        size *= 1.6;
        int centerX = hex.getCenterX();
        int centerY = hex.getCenterY();
//        g.fillOval((int) (centerX - hex.getSize() * 0.05), (int) (centerY- (hex.getSize() * 0.05)), (int) (hex.getSize() * 0.1), (int) (hex.getSize() * 0.1));
//        g.drawOval((int) (drawX + hex.getSize() * 1.1), (int) (drawY  + hex.getSize() * 0.1), (int) (hex.getSize() *1.6), (int) (hex.getSize() * 1.6));
    }
}

```

---

# File: src/Models/Draw/UnitDraw.java

```java
package Models.Draw;

import Models.Elements.Units.Unit;
import java.awt.*;

public class UnitDraw implements Draw {
    private final Unit unit;

    public UnitDraw(Unit unit) {
        this.unit = unit;
    }

    @Override
    public void draw(Graphics g) {
        if (unit == null){
            System.out.println("unit is null");
            return;
        }
        if (unit.getHex() == null || !unit.getHex().isVisible()){
            System.out.println("hex is empty ");
            return;
        }

        int size = unit.getSize();
        int drawX = unit.getX() - size / 2;
        int drawY = unit.getY() - size / 2;

//        System.out.println(drawX + ">" + drawY + ">" + size);
        g.setColor(unit.getColor());
        g.fillOval(drawX, drawY, size, size);

//        g.drawOval(200 , 500 , 20 , 20 );
        g.setColor(Color.black);
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(0.2f));
        g2.drawOval(drawX, drawY, size, size);
    }
}
```

---

# File: src/Models/Draw/UnitPositionCalculator.java

```java
package Models.Draw;

import Models.Elements.Hex.Hex;
import Models.Elements.Units.Unit;
import Models.Records.UnitRecord;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UnitPositionCalculator {

    /** Computes where a unit should rest on its CURRENT hex, spreading out among any sharing units. */
    public static Point computeRestPosition(Unit unit) {
        Hex hex = unit.getHex();
        if (hex == null) return new Point(0, 0);
        return computeRestPosition(unit, hex);
    }

    /** Computes where a unit should rest on a SPECIFIC hex (used for animation targets, before the unit's hex field is actually updated). */
    public static Point computeRestPosition(Unit unit, Hex hex) {
        List<Unit> sharedHexUnits = new ArrayList<>();
        for (Unit u : unit.getLogic().getUnitRecord().getAll()) {
            if (u != null && hex.equals(u.getHex())) {
                sharedHexUnits.add(u);
            }
        }
        // Make sure the unit itself is counted even if its hex field hasn't been updated yet
        if (!sharedHexUnits.contains(unit)) {
            sharedHexUnits.add(unit);
        }

        int totalUnits = sharedHexUnits.size();
        int myIndex = sharedHexUnits.indexOf(unit);
        if (myIndex == -1) myIndex = 0;

        int centerX = hex.getCenterX();
        int centerY = hex.getCenterY();
        double orbitRadius = hex.getSize() * 0.45;

        if (totalUnits <= 1) {
            return new Point(centerX, centerY);
        }

        double angle = (2.0 * Math.PI * myIndex) / totalUnits;
        int targetX = centerX + (int) (orbitRadius * Math.cos(angle));
        int targetY = centerY + (int) (orbitRadius * Math.sin(angle));
        return new Point(targetX, targetY);
    }

    /** Recomputes and applies rest positions for every unit currently on a hex — call after any unit enters/leaves it. */
    public static void refreshHex(Hex hex, Unit anyUnitForRecordAccess) {
        if (hex == null) return;
        for (Unit u : anyUnitForRecordAccess.getLogic().getUnitRecord().getAll()) {
            if (u != null && hex.equals(u.getHex())) {
                Point p = computeRestPosition(u, hex);
                u.setX(p.x);
                u.setY(p.y);
                u.setSize((int) (hex.getSize() * 0.2));
            }
        }
    }
    public static void refreshAll(UnitRecord unitRecord) {
        Map<Hex, List<Unit>> byHex = new HashMap<>();
        for (Unit u : unitRecord.getAll()) {
            if (u == null || u.getHex() == null) continue;
            byHex.computeIfAbsent(u.getHex(), h -> new ArrayList<>()).add(u);
        }

        for (Map.Entry<Hex, List<Unit>> entry : byHex.entrySet()) {
            Hex hex = entry.getKey();
            List<Unit> units = entry.getValue();
            int total = units.size();
            double orbitRadius = hex.getSize() * 0.45;
            int unitSize = (int) (hex.getSize() * 0.2);

            for (int i = 0; i < total; i++) {
                Unit u = units.get(i);
                int targetX = hex.getCenterX();
                int targetY = hex.getCenterY();

                if (total > 1) {
                    double angle = (2.0 * Math.PI * i) / total;
                    targetX += (int) (orbitRadius * Math.cos(angle));
                    targetY += (int) (orbitRadius * Math.sin(angle));
                }

                u.setX(targetX);
                u.setY(targetY);
                u.setSize(unitSize);
            }
        }
    }
}
```

---

# File: src/Models/Elements/Buildings/Building.java

```java
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
        System.out.println("Set Darker called ");
        if (DarkerImagePath != null) {
            this.image = new ImageIcon(DarkerImagePath).getImage();
        }
    }

    // ADDED: Toggle active asset to lighter path variant
    public void setLighter() {
        System.out.println("Set lighter Called");
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
```

---

# File: src/Models/Elements/Buildings/Farm.java

```java
package Models.Elements.Buildings;

import Models.Elements.Hex.GrassHex;
import Models.Elements.Hex.Hex;
import Models.Elements.Resources.Food;
import Models.Elements.Resources.Resource;
import Models.Elements.Resources.Wood;

import java.util.Map;

public class Farm extends Building {

    public static final int CAPACITY = 0;

    public Farm() {
        super();
        HEX_TYPE = GrassHex.class;
        UPKEEP = Map.of(Food.class, 1);
        providesPerWorker.put(Food.class , 4);
        BuildingCost.put(Wood.class , 10);
        BuilderAp = 1;
        workerCapacity = 2;
        LightImagePath = "C:\\Users\\shantiya\\Desktop\\django\\java\\Civilizatino-6\\src\\Images\\Buildings\\Farm.png";
        DarkerImagePath = "C:\\Users\\shantiya\\Desktop\\django\\java\\Civilizatino-6\\src\\Images\\Buildings\\Darker\\Farm.png";
        initializeImages();
    }
}
```

---

# File: src/Models/Elements/Buildings/IronMine.java

```java
package Models.Elements.Buildings;

import Models.Elements.Hex.Hex;
import Models.Elements.Hex.MountainHex;
import Models.Elements.Resources.Iron;
import Models.Elements.Resources.Resource;
import Models.Elements.Resources.Wood;

import java.util.Map;

public class IronMine extends Building {
    public static final int CAPACITY = 0;

    public IronMine() {
        super();
        HEX_TYPE = MountainHex.class;
        UPKEEP = Map.of(Iron.class, 1);
        providesPerWorker.put(Iron.class , 2);
        workerCapacity = 2;
        BuildingCost.put(Wood.class , 10);
        BuilderAp = 2;
        LightImagePath = "C:\\Users\\shantiya\\Desktop\\django\\java\\Civilizatino-6\\src\\Images\\Buildings\\IronMine.png";
        DarkerImagePath = "C:\\Users\\shantiya\\Desktop\\django\\java\\Civilizatino-6\\src\\Images\\Buildings\\Darker\\IronMine.png";
        initializeImages();
    }
}
```

---

# File: src/Models/Elements/Buildings/LumberMill.java

```java
package Models.Elements.Buildings;

import Models.Elements.Hex.ForestHex;
import Models.Elements.Hex.Hex;
import Models.Elements.Resources.Resource;
import Models.Elements.Resources.Wood;

import java.util.Map;

public class LumberMill extends Building {

    public static final int CAPACITY = 0;

    public LumberMill() {
        super();
        HEX_TYPE = ForestHex.class;
        UPKEEP = Map.of(Wood.class, 1);
        providesPerWorker.put(Wood.class , 3);
        workerCapacity = 2;
        BuildingCost.put(Wood.class , 8);
        BuilderAp = 1;
        LightImagePath = "C:\\Users\\shantiya\\Desktop\\django\\java\\Civilizatino-6\\src\\Images\\Buildings\\LubmerMil.png";
        DarkerImagePath = "C:\\Users\\shantiya\\Desktop\\django\\java\\Civilizatino-6\\src\\Images\\Buildings\\Darker\\LubmerMil.png";
        initializeImages();
    }

}
```

---

# File: src/Models/Elements/Buildings/Settlement.java

```java
package Models.Elements.Buildings;

import Models.Elements.Hex.Hex;
import Models.Elements.Resources.*;

import java.util.HashMap;
import java.util.Map;

public class Settlement extends Building {
    private static Integer UnitCapIncrease;

    public static final Map<Class<? extends Resource>, Integer> REQUIREMENTS = Map.of(
            Stone.class, 0,
            Iron.class, 0,
            Wood.class, 0
    );
    public static final int CAPACITY = 0;

    public Settlement() {
        super();
        HEX_TYPE = Hex.class;
        UPKEEP = new HashMap<>();
        workerCapacity = 0;
        UnitCapIncrease = 5;
        UPKEEP.put(Food.class , 1);
        UPKEEP.put(Wood.class , 1);
        BuilderAp = 4;
        BuildingCost.put(Food.class , 10);
        BuildingCost.put(Wood.class , 40);
        BuildingCost.put(Stone.class , 30);
        BuildingCost.put(Iron.class , 10);
        LightImagePath = "C:\\Users\\shantiya\\Desktop\\django\\java\\Civilizatino-6\\src\\Images\\Buildings\\Sattelment.png";
        DarkerImagePath = "C:\\Users\\shantiya\\Desktop\\django\\java\\Civilizatino-6\\src\\Images\\Buildings\\Darker\\Sattelment.png";
        initializeImages();
    }

    public static Integer getUnitCapIncrease() {
        return UnitCapIncrease;
    }
}
```

---

# File: src/Models/Elements/Buildings/Stable.java

```java
package Models.Elements.Buildings;

import Models.Elements.Hex.Hex;
import Models.Elements.Hex.LandHex;
import Models.Elements.Resources.Food;
import Models.Elements.Resources.Resource;
import Models.Elements.Resources.Stone;
import Models.Elements.Resources.Wood;

import java.util.Map;

public class Stable extends Building {

    public static final int CAPACITY = 0;

    public Stable() {
        super();
        HEX_TYPE = LandHex.class;
        UPKEEP = Map.of(Food.class, 1);
        providesPerWorker.put(Food.class , 3);
        workerCapacity = 2;
        BuilderAp = 1;
        BuildingCost.put(Wood.class , 15);
        BuildingCost.put(Stone.class , 5);
        LightImagePath = "C:\\Users\\shantiya\\Desktop\\django\\java\\Civilizatino-6\\src\\Images\\Buildings\\Stable.png";
        DarkerImagePath = "C:\\Users\\shantiya\\Desktop\\django\\java\\Civilizatino-6\\src\\Images\\Buildings\\Darker\\Stable.png";
        initializeImages();
    }
}
```

---

# File: src/Models/Elements/Buildings/StoneMine.java

```java
package Models.Elements.Buildings;

import Models.Elements.Hex.Hex;
import Models.Elements.Hex.MountainHex;
import Models.Elements.Resources.Resource;
import Models.Elements.Resources.Stone;
import Models.Elements.Resources.Wood;

import java.util.Map;

public class StoneMine extends Building {
    public static final int CAPACITY = 0;

    public StoneMine() {
        super();
        HEX_TYPE = MountainHex.class;
        UPKEEP = Map.of(Stone.class, 1);
        providesPerWorker.put(Stone.class , 3);
        workerCapacity = 2;
        BuilderAp = 2;
        BuildingCost.put(Wood.class , 15);
        BuildingCost.put(Stone.class , 5);
        LightImagePath = "C:\\Users\\shantiya\\Desktop\\django\\java\\Civilizatino-6\\src\\Images\\Buildings\\StoneMine.png";
        DarkerImagePath = "C:\\Users\\shantiya\\Desktop\\django\\java\\Civilizatino-6\\src\\Images\\Buildings\\Darker\\StoneMine.png";
        initializeImages();
    }
}
```

---

# File: src/Models/Elements/Buildings/TownHall.java

```java
package Models.Elements.Buildings;

import Models.Elements.Hex.Hex;
import Models.Elements.Resources.*;
import Models.Logic.BuildingLogic.TownHallGenerateUnit;
import Models.Logic.BuildingLogic.TownHallLogic;

import java.util.HashMap;
import java.util.Map;

public class TownHall extends Building {

    private final TownHallGenerateUnit generateUnit;
    public static final Map<Class<? extends Resource>, Integer> REQUIREMENTS = Map.of();
    protected Map<Class<? extends Resource> , Integer> storageCapacity;
    protected Map<Class<? extends Resource> , Integer> safeGuard;
    protected Map<Class<? extends Resource> , Integer> initialResources;
    public static final Map<Class<? extends Resource>, Integer> WOULD_PROVIDE = Map.of(
            Wood.class, 1,
            Food.class, 1
    );
    public static final int CAPACITY = 0; // doesn't hold workers

    public TownHall() {
        super();
        HEX_TYPE = Hex.class;
        UPKEEP = Map.of();
        storageCapacity = new HashMap<>();
        safeGuard = new HashMap<>();
        initialResources = new HashMap<>();
        storageCapacity.put(Food.class , 100);
        storageCapacity.put(Wood.class , 100);
        storageCapacity.put(Stone.class , 100);
        storageCapacity.put(Iron.class , 50);
        //---------------------
        safeGuard.put(Food.class , 1);
        safeGuard.put(Wood.class , 1);
        //---------------------------
        initialResources.put(Food.class , 30);
        initialResources.put(Wood.class , 20);
        initialResources.put(Stone.class, 15);
        setLogic(new TownHallLogic(this));
        workerCapacity = 2;
        LightImagePath = "C:\\Users\\shantiya\\Desktop\\django\\java\\Civilizatino-6\\src\\Images\\Buildings\\TownHall.png";
        DarkerImagePath = "C:\\Users\\shantiya\\Desktop\\django\\java\\Civilizatino-6\\src\\Images\\Buildings\\Darker\\TownHall.png";
        initializeImages();
//        generateUnit = new TownHallGenerateUnit(this);

        generateUnit = new TownHallGenerateUnit(this);
    }

    public Map<Class<? extends Resource>, Integer> getInitialResources() {
        return initialResources;
    }

    public Map<Class<? extends Resource>, Integer> getSafeGuard() {
        return safeGuard;
    }

    public TownHallGenerateUnit getGenerateUnit() {
        return generateUnit;
    }
}
```

---

# File: src/Models/Elements/Element.java

```java
package Models.Elements;

public interface Element {
}

```

---

# File: src/Models/Elements/Hex/ForestHex.java

```java
package Models.Elements.Hex;

import Models.Elements.Buildings.LumberMill;
import Models.Elements.Resources.Resource;
import Models.Elements.Resources.Wood;

public class ForestHex extends Hex {
    public ForestHex(int q, int r, boolean additionalResource) {
        super(q, r, Wood.class, null);
        this.movementCost = 2;
        BuildableBuildings.add(LumberMill.class);
        // 1. Assign local absolute resource path strings first
        setImage("C:\\Users\\shantiya\\Desktop\\django\\java\\Civilizatino-6\\src\\Images\\JungleImage.png");
        setDarkerImage("C:\\Users\\shantiya\\Desktop\\django\\java\\Civilizatino-6\\src\\Images\\Darker\\JungleImage.png");

        // 2. Safely initialize image references now that paths are present
        initializeImages();
    }
}
```

---

# File: src/Models/Elements/Hex/GrassHex.java

```java
package Models.Elements.Hex;

import Models.Elements.Buildings.Farm;
import Models.Elements.Buildings.Stable;
import Models.Elements.Resources.Food;
import Models.Elements.Resources.Resource;

public class GrassHex extends Hex{
    public GrassHex(int q, int r,boolean additionalResources) {
        super(q , r , null , Food.class);
        setAdditionalResources(additionalResources);
        movementCost = 1;
        BuildableBuildings.add(Farm.class);
        setImage("C:\\Users\\shantiya\\Desktop\\django\\java\\Civilizatino-6\\src\\Images\\GrassImage.png");
        setDarkerImage("C:\\Users\\shantiya\\Desktop\\django\\java\\Civilizatino-6\\src\\Images\\Darker\\GrassImage.png");
        initializeImages();
    }
}

```

---

# File: src/Models/Elements/Hex/Hex.java

```java
package Models.Elements.Hex;

import Models.Elements.Buildings.Building;
import Models.Elements.Resources.Resource;
import Models.Elements.Showable;
import Models.Draw.HexDraw;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public abstract class Hex implements Showable {
    protected int x;
    protected int y;
    protected int q;
    protected int r;
    protected int drawX;
    protected int drawY;
    protected int drawH;
    protected int drawW;
    protected int centerX;
    protected int centerY;
    protected Image image;
    protected Image darkerImage;
    private String LightImagePath;
    private String DarkImagePath;

    protected int size = 20;
    protected int movementCost;
    protected boolean visible = true;
    protected boolean border = true;
    protected HexDraw draw;
    protected final Class<? extends Resource> resourceType;
    protected final Class<? extends Resource> additionalResource;
    protected ArrayList<Class<? extends Building>> BuildableBuildings;
    protected boolean additionalResources;
    protected Building building;

    public Hex(int q, int r, Class<? extends Resource> resourceType, Class<? extends Resource> additionalResource) {
        this.q = q;
        this.r = r;
        this.resourceType = resourceType;
        this.additionalResource = additionalResource;
        this.BuildableBuildings = new ArrayList<>();
        // Do not call setDarker() here! The child classes haven't set their paths yet.
    }

    // Call this setup method explicitly right after instantiation or inside child class setup
    public void initializeImages() {
        setDarker();
        SetDrawing();
    }

    public int getX() { return x; }
    public int getY() { return y; }
    public Image getImage() { return image; }
    public int getSize() { return size; }
    public boolean isVisible() { return visible; }
    public void setVisible(boolean visible) { this.visible = visible; }

    public int getQ() { return q; }
    public int getR() { return r; }
    public int getDrawX() { return drawX; }
    public int getDrawY() { return drawY; }
    public int getDrawH() { return drawH; }
    public int getDrawW() { return drawW; }


    public void setX(int x) {
        this.x = x;
        SetDrawing();
    }

    public void setY(int y) {
        this.y = y;
        SetDrawing();
    }

    public void setSize(int size) {
        this.size = size;
        SetDrawing();
    }

    public HexDraw getDraw() { return draw; }

    public void SetDrawing() {
        drawX = (x - size) * 2;
        drawY = (y - size) * 2;
        drawW = (int) (size * 3.8);
        drawH = size * 2;
        centerX = drawX + drawW / 2;
        centerY = drawY + drawH / 2;
    }

    public int getCenterX() { return centerX; }
    public int getCenterY() { return centerY; }

    @Override
    public String toString() {
        return "Hex{" + "q=" + q + ", r=" + r + ", centerX=" + centerX + ", centerY=" + centerY + '}';
    }

    public int getMovementCost() { return movementCost; }
    public boolean isBorder() { return border; }
    public void setBorder(boolean border) { this.border = border; }
    public boolean isAdditionalResources() { return additionalResources; }
    public void setAdditionalResources(boolean additionalResources) { this.additionalResources = additionalResources; }
    public Building getBuilding() { return building; }
    public void setBuilding(Building building) { this.building = building; }

    public void setDarkerImage(String path) {
        DarkImagePath = path;
    }

    public void setImage(String imagePath) {
        LightImagePath = imagePath;
    }

    public void setDarker(){
        System.out.println(this + "Hex darker called ");
        if (DarkImagePath != null) {
            image = new ImageIcon(DarkImagePath).getImage();
        }
        draw = new HexDraw(this);

        // PROPAGATE: Toggle building to dark mode
        if (building != null) {
            building.setDarker();
        }
    }

    public void setLighter(){
        System.out.println(this + "Set Lighter called");
        if (LightImagePath != null) {
            image = new ImageIcon(LightImagePath).getImage();
        }
        draw = new HexDraw(this);

        // PROPAGATE: Toggle building to light mode
        if (building != null) {
            building.setLighter();
        }
    }

    public ArrayList<Class<? extends Building>> getBuildableBuildings() {
        return BuildableBuildings;
    }
}
```

---

# File: src/Models/Elements/Hex/LandHex.java

```java
package Models.Elements.Hex;

import Models.Elements.Buildings.Farm;
import Models.Elements.Buildings.Settlement;
import Models.Elements.Buildings.Stable;
import Models.Elements.Resources.Food;
import Models.Elements.Resources.Resource;

public class LandHex extends Hex{
    public LandHex(int q, int r , boolean additionalResources) {
        super(q , r , null , Food.class);
        setAdditionalResources(additionalResources);
        BuildableBuildings.add(Settlement.class);
        movementCost = 1;
        if (additionalResources){
            BuildableBuildings.add(Stable.class);
            setImage("C:\\Users\\shantiya\\Desktop\\django\\java\\Civilizatino-6\\src\\Images\\ExrtraResources\\LandWithAnimal.png");
            setDarkerImage("C:\\Users\\shantiya\\Desktop\\django\\java\\Civilizatino-6\\src\\Images\\ExrtraResources\\Darker\\LandWithAnimal.png");
        }else {
            setImage("C:\\Users\\shantiya\\Desktop\\django\\java\\Civilizatino-6\\src\\Images\\LandImage.png");
            setDarkerImage("C:\\Users\\shantiya\\Desktop\\django\\java\\Civilizatino-6\\src\\Images\\Darker\\LandImage.png");
        }




        initializeImages();
    }
}

```

---

# File: src/Models/Elements/Hex/MountainHex.java

```java
package Models.Elements.Hex;

import Models.Elements.Buildings.IronMine;
import Models.Elements.Buildings.StoneMine;
import Models.Elements.Resources.Iron;
import Models.Elements.Resources.Resource;
import Models.Elements.Resources.Stone;

public class MountainHex extends Hex{
    public MountainHex(int q, int r , boolean additionalResources) {
        super(q , r , Stone.class , Iron.class);
        setAdditionalResources(additionalResources);
        movementCost = 4;
        BuildableBuildings.add(StoneMine.class);
        if (additionalResources){
            BuildableBuildings.add(IronMine.class);
            setImage("C:\\Users\\shantiya\\Desktop\\django\\java\\Civilizatino-6\\src\\Images\\ExrtraResources\\MountainWithIron.png");
            setDarkerImage("C:\\Users\\shantiya\\Desktop\\django\\java\\Civilizatino-6\\src\\Images\\ExrtraResources\\Darker\\MountainWithIron.png");
        }

        setImage("C:\\Users\\shantiya\\Desktop\\django\\java\\Civilizatino-6\\src\\Images\\MountainImage.png");
        setDarkerImage("C:\\Users\\shantiya\\Desktop\\django\\java\\Civilizatino-6\\src\\Images\\Darker\\MountainImage.png");
        initializeImages();
    }
}

```

---

# File: src/Models/Elements/Resources/Food.java

```java
package Models.Elements.Resources;

public class Food extends Resource{
}

```

---

# File: src/Models/Elements/Resources/Iron.java

```java
package Models.Elements.Resources;

public class Iron extends Resource{
}

```

---

# File: src/Models/Elements/Resources/Resource.java

```java
package Models.Elements.Resources;

import Models.Elements.Element;

public abstract class Resource implements Element {
}

```

---

# File: src/Models/Elements/Resources/Stone.java

```java
package Models.Elements.Resources;

public class Stone extends Resource{
}

```

---

# File: src/Models/Elements/Resources/Wood.java

```java
package Models.Elements.Resources;

public class Wood extends Resource{

}

```

---

# File: src/Models/Elements/Showable.java

```java
package Models.Elements;

import Models.Elements.Element;

public interface Showable extends Element {
    int getX();
    void setX(int x);

    int getY();
    void setY(int y);

    int getSize();
    void setSize(int size);

}
```

---

# File: src/Models/Elements/Units/BorderExpander.java

```java
package Models.Elements.Units;

import Models.Logic.UnitLogic.BorderExpanderLogic;

import java.awt.*;

public class BorderExpander extends Unit {

    public BorderExpander() {
        super(2, 3 , 4);
        setLogic(new BorderExpanderLogic(this));
        setColor(new Color(218, 11, 208));
    }

}
```

---

# File: src/Models/Elements/Units/Builder.java

```java
package Models.Elements.Units;

import Models.Logic.UnitLogic.BuilderLogic;

import java.awt.*;

public class Builder extends Unit {

    private int charges;

    public Builder() {
        super(1, 4 , 3);
        this.charges = 3;
        setLogic(new BuilderLogic(this));
        setColor(new Color(179, 78, 17));
    }

    public int getCharges() { return charges; }
    public void setCharges(int charges) { this.charges = charges; }
}
```

---

# File: src/Models/Elements/Units/Explorer.java

```java
package Models.Elements.Units;

import Models.Logic.UnitLogic.ExplorerLogic;

import java.awt.*;

public class Explorer extends Unit {


    public Explorer() {
        super(1, 8 , 5);
        setLogic(new ExplorerLogic(this));
        setColor(Color.blue);
    }

}
```

---

# File: src/Models/Elements/Units/Unit.java

```java
package Models.Elements.Units;

import Models.Draw.HexDraw;
import Models.Draw.UnitDraw;
import Models.Elements.Hex.Hex;
import Models.Elements.Showable;
import Models.Logic.UnitLogic.UnitLogic;

import javax.swing.*;
import java.awt.*;

public abstract class Unit implements Showable {

    // ----- final fields -----
    private final int foodNeed;
    private final int initialAP;
    private final int CreationSteps;
    private static Integer InitialUnitCap;
    protected Image image;
    // ----- changeable fields -----
    private int AP;
    private Hex hex;
    private Color color;
    // ----- Showable fields -----
    private int x;
    private int y;
    private int size;
    protected UnitLogic logic;
    protected UnitDraw draw;
    protected Unit(int foodNeed, int initialAP, int creationSteps) {
        this.foodNeed = foodNeed;
        this.initialAP = initialAP;
        this.AP = initialAP;
        CreationSteps = creationSteps;
    }

    public int getFoodNeed() { return foodNeed; }
    public int getInitialAP() { return initialAP; }

    public int getAP() { return AP; }
    public void setAP(int AP) { this.AP = AP; }

    public Hex getHex() { return hex; }
    public void setHex(Hex hex) { this.hex = hex; }

    @Override
    public int getX() { return x; }

    @Override
    public void setX(int x) { this.x = x; }

    @Override
    public int getY() { return y; }

    @Override
    public void setY(int y) { this.y = y; }

    @Override
    public int getSize() { return size; }

    @Override
    public void setSize(int size) { this.size = size; }
    public static Integer getInitialUnitCap() {
        return InitialUnitCap;
    }

    public UnitLogic getLogic() {
        return logic;
    }

    public UnitDraw getDraw() {
        return draw;
    }

    public Image getImage() {
        return image;
    }
    public void setImage(String imagePath) {
        image = new ImageIcon(imagePath).getImage();
        draw = new UnitDraw(this);
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
        this.draw = new UnitDraw(this);
    }

    public void setLogic(UnitLogic logic) {
        this.logic = logic;
    }

    public int getCreationSteps() {
        return CreationSteps;
    }
}
```

---

# File: src/Models/Elements/Units/Worker.java

```java
package Models.Elements.Units;

import Models.Elements.Buildings.Building;
import Models.Logic.UnitLogic.WorkerLogic;

import java.awt.*;

public class Worker extends Unit {

    // changeable: the building this worker is currently stationed in, null if idle
    private Building stationedBuilding;

    private boolean Working;

    public Worker() {
        super(1, 5 , 2);
        setColor(Color.GRAY);
        setLogic(new WorkerLogic(this));

    }

    public Building getStationedBuilding() { return stationedBuilding; }
    public void setStationedBuilding(Building stationedBuilding) { this.stationedBuilding = stationedBuilding; }

    public boolean isWorking() {
        return Working;
    }

    public void setWorking(boolean working) {
        Working = working;
    }
}
```

---

# File: src/Models/Generator.java

```java
package Models;

import Game.Views.GameEngine;

public class Generator {
    private static GameEngine engine;

    public Generator() {
//        engine = new GameEngine();
    }

    public static GameEngine getEngine() {
        return engine;
    }
}

```

---

# File: src/Models/Logic/BoardLogic.java

```java
package Models.Logic;

public class BoardLogic {
}

```

---

# File: src/Models/Logic/BuildingLogic/BuildingLogic.java

```java
package Models.Logic.BuildingLogic;

import Game.Generate;
import Models.Elements.Buildings.Building;
import Models.Elements.Hex.Hex;
import Models.Elements.Resources.Resource;
import Models.Elements.Units.Builder;
import Models.Logic.Logic;
import Models.Records.BuildingRecord;
import Models.Records.ResourceRecord;

import java.util.List;
import java.util.Map;

public class BuildingLogic extends Logic {

    private Building building;

    public BuildingLogic(Building building) {
        this.building = building;
    }


    public static Building Build(Builder builder, Class<? extends Building> buildingClass) throws Exception {
        Building newBuilding = buildingClass.getDeclaredConstructor().newInstance();
        ResourceRecord resourceRecord1 = Generate.getGame().getWorld().getResourceRecord();
        BuildingRecord buildingRecord1 = Generate.getGame().getWorld().getBuildingRecord();
        // 1) enough resources stored?
        for (Map.Entry<Class<? extends Resource>, Integer> entry : newBuilding.getBuildingCost().entrySet()) {
            if (resourceRecord1.getAll(entry.getKey()).size() < entry.getValue()) {
                throw new Exception("Not enough " + entry.getKey().getSimpleName() + " to build " + buildingClass.getSimpleName());
            }
        }

        // 2) enough Builder AP?
        if (builder.getAP() < newBuilding.getBuilderAp()) {
            throw new Exception("Builder does not have enough AP to build " + buildingClass.getSimpleName());
        }

        // 3) correct hex type?
        Hex hex = builder.getHex();
        if (hex == null || !newBuilding.getHexType().isInstance(hex)) {
            throw new Exception("Builder is not standing on a valid hex for " + buildingClass.getSimpleName());
        }

        // all checks passed: pay the cost
        for (Map.Entry<Class<? extends Resource>, Integer> entry : newBuilding.getBuildingCost().entrySet()) {
            List<Resource> stock = resourceRecord1.getAll(entry.getKey());
            for (int i = 0; i < entry.getValue(); i++) {
                resourceRecord1.remove(stock.get(i));
            }
        }
        builder.setAP(builder.getAP() - newBuilding.getBuilderAp());

        // place the building
        newBuilding.setHex(hex);
        hex.setBuilding(newBuilding);
        buildingRecord1.add(newBuilding);
        newBuilding.setLighter();
        return newBuilding;
    }

    // Computes providesPerWorker * workerNumbers and adds the result to ResourceRecord.
    public void Supply() {
        int workers = building.getWorkerNumbers();
        for (Map.Entry<Class<? extends Resource>, Integer> entry : building.getProvidesPerWorker().entrySet()) {
            int amount = entry.getValue() * workers;
            for (int i = 0; i < amount; i++) {
                try {
                    resourceRecord.add(entry.getKey().getDeclaredConstructor().newInstance());
                } catch (Exception ignored) {
                    // resource classes are simple no-arg markers; this shouldn't happen
                }
            }
        }
    }

    public void addWorker() throws Exception {
        if (building.getWorkerNumbers() >= building.getWorkerCapacity()) {
            throw new Exception("Building's worker capacity is full");
        }
        building.setWorkerNumbers(building.getWorkerNumbers() + 1);
    }

    public void removeWorker() {
        building.setWorkerNumbers(building.getWorkerNumbers() - 1);
    }

    public void decay() {
        buildingRecord.remove(building);
    }
}

```

---

# File: src/Models/Logic/BuildingLogic/SettlementLogic.java

```java
package Models.Logic.BuildingLogic;

public class SettlementLogic {
}

```

---

# File: src/Models/Logic/BuildingLogic/TownHallGenerateUnit.java

```java
package Models.Logic.BuildingLogic;

import Models.Elements.Buildings.TownHall;
import Models.Elements.Units.Unit;

public class TownHallGenerateUnit {
    private final TownHall townHall;

    private Unit unit;

    private int totalStep;
    private int step;

    private boolean Finished = true;

    public TownHallGenerateUnit(TownHall townHall) {
        this.townHall = townHall;
    }

    public void startGeneration(Unit unit) throws Exception {
        if (!isFinished())
            throw new Exception("Town Hall hasn't finished it's last creation");
        this.unit = unit;
        this.totalStep = unit.getCreationSteps();
        step = 0;
    }

    public void newTurn() throws Exception {
        step++;
        Check();
    }

    private void Check() throws Exception {
        if (step >= totalStep) {
            new TownHallLogic(townHall).produceUnit(unit.getClass());
            unit = null;
            Finished = true;
            step = 0;
        }
    }

    public boolean isFinished() {
        return Finished;
    }

    public Unit getUnit() {
        return unit;
    }

    public int getStep() {
        return step;
    }

    public int getTotalStep() {
        return totalStep;
    }
}
```

---

# File: src/Models/Logic/BuildingLogic/TownHallLogic.java

```java
package Models.Logic.BuildingLogic;

import Models.Elements.Buildings.TownHall;
import Models.Elements.Resources.Resource;
import Models.Elements.Units.Unit;
import Models.Records.ResourceRecord;
import Models.Records.UnitRecord;

import java.util.Map;

public class TownHallLogic extends BuildingLogic {

    private TownHall townHall;

    public TownHallLogic(TownHall townHall) {
        super(townHall);
        this.townHall = townHall;
    }

    // Adds every safeguard resource (e.g. +1 Wood, +1 Food) listed on the TownHall to ResourceRecord.
    public void produceSafeguard() {
        for (Map.Entry<Class<? extends Resource>, Integer> entry : townHall.getSafeGuard().entrySet()) {
            for (int i = 0; i < entry.getValue(); i++) {
                try {
                    resourceRecord.add(entry.getKey().getDeclaredConstructor().newInstance());
                } catch (Exception ignored) {
                    // resource classes are simple no-arg markers; this shouldn't happen
                }
            }
        }
    }
    public void AddInitialResources(){
        for (Map.Entry<Class<? extends Resource>, Integer> entry : townHall.getInitialResources().entrySet())
            try {
                for (int i = 0 ; i < entry.getValue();i++)
                    resourceRecord.add(entry.getKey().getDeclaredConstructor().newInstance());
            } catch (Exception ignored) {
                // resource classes are simple no-arg markers; this shouldn't happen
            }
    }

    // Creates a new unit of the given type, registers it in UnitRecord, and places it on the TownHall's own hex.
    public Unit produceUnit(Class<? extends Unit> unitClass) throws Exception {
        Unit unit = unitClass.getDeclaredConstructor().newInstance();
        unitRecord.add(unit);
        unit.setHex(townHall.getHex());
        return unit;
    }
}

```

---

# File: src/Models/Logic/HexLogic/HexGenerator.java

```java
package Models.Logic.HexLogic;

import Game.Generate;
import Models.Elements.Hex.*;
import Models.Records.HexRecord;

import java.util.ArrayList;
import java.util.Random;

public class HexGenerator {
    public static void generateHex(int q, int r) {
    HexRecord hexRecord = Generate.getGame().getWorld().getHexRecord();
        if (HexLogic.findByQR(q, r) != null)
            return;

        Random random = new Random();

        // Temporary hex used only for neighbor lookup
        Hex temp = new Hex(q, r, null, null) {};

        ArrayList<Hex> neighbors = HexLogic.getNeighbors(temp);

        ArrayList<Class<? extends Hex>> pool = new ArrayList<>();

        for (Hex neighbor : neighbors) {

            if (neighbor instanceof ForestHex) {
                pool.add(ForestHex.class);
                pool.add(ForestHex.class);
                pool.add(GrassHex.class);
            }

            else if (neighbor instanceof GrassHex) {
                pool.add(GrassHex.class);
                pool.add(GrassHex.class);
                pool.add(ForestHex.class);
                pool.add(LandHex.class);
            }

            else if (neighbor instanceof LandHex) {
                pool.add(LandHex.class);
                pool.add(LandHex.class);
                pool.add(LandHex.class);
                pool.add(GrassHex.class);
                pool.add(ForestHex.class);
                pool.add(MountainHex.class);
            }

            else if (neighbor instanceof MountainHex) {
                pool.add(MountainHex.class);
                pool.add(MountainHex.class);
                pool.add(LandHex.class);
                pool.add(ForestHex.class);
            }
        }

        // First generated tile
        if (pool.isEmpty()) {
            pool.add(ForestHex.class);
            pool.add(GrassHex.class);
            pool.add(LandHex.class);
            pool.add(MountainHex.class);
        }

        Class<? extends Hex> chosen = pool.get(random.nextInt(pool.size()));

        boolean hasAdditionalResources = random.nextDouble() < 0.35;

        Hex hex;

        if (chosen == ForestHex.class)
            hex = new ForestHex(q, r, hasAdditionalResources);
        else if (chosen == GrassHex.class)
            hex = new GrassHex(q, r, hasAdditionalResources);
        else if (chosen == LandHex.class)
            hex = new LandHex(q, r, hasAdditionalResources);
        else
            hex = new MountainHex(q, r, hasAdditionalResources);

        hexRecord.add(hex);

//        for (Hex hex1 : hexRecord.getAll())
//            System.out.println(hex1);
    }
}

```

---

# File: src/Models/Logic/HexLogic/HexLogic.java

```java
package Models.Logic.HexLogic;

import Game.Generate;
import Models.Elements.Hex.Hex;
import Models.Records.HexRecord;

import java.util.ArrayList;

public class HexLogic {
    // FIXED: Adjusted axial direction offsets to match your structural layout geometry
    private static int[][] offsets = {
            {0, -1},   // Up-Left
            {1, -1},   // Up-Right
            {-1, 0},   // Left
            {1, 0},    // Right
            {-1, 1},   // Down-Left   ← fix: was {1, 1}
            {0, 1}     // Down-Right
    };

    public static Hex findByQR(int q, int r) {
        HexRecord hexRecord = Generate.getGame().getWorld().getHexRecord();
        for (Hex hex : hexRecord.getAll()) {
            if (hex.getQ() == q && hex.getR() == r) {
                return hex;
            }
        }
        return null;
    }

    public static ArrayList<Hex> getNeighbors(Hex hex) {
//        System.out.println("Get neighbor called ");
        ArrayList<Hex> neighbors = new ArrayList<>();
        if (hex == null) return neighbors;

        int q = hex.getQ();
        int r = hex.getR();

        for (int[] offset : offsets) {
            int nq = q + offset[0];
            int nr = r + offset[1];
            Hex neighbor = findByQR(nq, nr);
            if (neighbor != null) {
                neighbors.add(neighbor);
            }
        }
        return neighbors;
    }

    public static void discover(Hex hex){
        System.out.println("discover called");
        int q = hex.getQ();
        int r = hex.getR();
        for (int[] offset : offsets) {
            int nq = q + offset[0];
            int nr = r + offset[1];
            HexGenerator.generateHex(nq, nr);
        }
    }
}
```

---

# File: src/Models/Logic/Logic.java

```java
package Models.Logic;

import Game.Generate;
import Models.Records.BuildingRecord;
import Models.Records.HexRecord;
import Models.Records.ResourceRecord;
import Models.Records.UnitRecord;

public abstract class Logic {
    protected UnitRecord unitRecord = Generate.getWorld().getUnitRecord();
    protected ResourceRecord resourceRecord = Generate.getWorld().getResourceRecord();
    protected HexRecord hexRecord = Generate.getWorld().getHexRecord();
    protected BuildingRecord buildingRecord = Generate.getWorld().getBuildingRecord();

    public UnitRecord getUnitRecord() {
        return unitRecord;
    }

    public ResourceRecord getResourceRecord() {
        return resourceRecord;
    }

    public HexRecord getHexRecord() {
        return hexRecord;
    }

    public BuildingRecord getBuildingRecord() {
        return buildingRecord;
    }
}

```

---

# File: src/Models/Logic/UnitLogic/BorderExpanderLogic.java

```java
package Models.Logic.UnitLogic;

import Models.Elements.Hex.Hex;
import Models.Elements.Units.BorderExpander;
import Models.Records.UnitRecord;

public class BorderExpanderLogic extends UnitLogic {

    private BorderExpander borderExpander;

    public BorderExpanderLogic(BorderExpander borderExpander) {
        super(borderExpander);
        this.borderExpander = borderExpander;
    }

    // Marks the hex the BorderExpander stands on as part of the empire's
    // border, then consumes the unit (removes it from UnitRecord).
    public void addToBorder() {
        Hex hex = borderExpander.getHex();
        hex.setBorder(true);
        unitRecord.remove(borderExpander);
    }
}

```

---

# File: src/Models/Logic/UnitLogic/BuilderLogic.java

```java
package Models.Logic.UnitLogic;

import Models.Elements.Buildings.*;
import Models.Elements.Hex.*;
import Models.Elements.Units.Builder;
import Models.Elements.Units.Unit;
import Models.Logic.BuildingLogic.BuildingLogic;
import Models.Records.UnitRecord;

public class BuilderLogic extends UnitLogic {
    public BuilderLogic(Unit unit) {
        super(unit);
    }

    private Builder builder;

    public void build(Building building) throws Exception {
        if (!CheckBuildingHex(building))
            throw new Exception("Invalid building on this hex");
        try {
            BuildingLogic.Build(builder, building.getClass());
            SpendCharge();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void SpendCharge() {
        if (builder.getCharges() <= 0)
            unitRecord.remove(builder);
        builder.setCharges(builder.getCharges() - 1);
    }

    private boolean CheckBuildingHex(Building building) {
        Hex hex = builder.getHex();
        if (building.getClass().equals(Farm.class)) {
            return hex.getClass().equals(GrassHex.class);
        } else if (building.getClass().equals(StoneMine.class)) {
            return hex.getClass().equals(MountainHex.class);
        } else if (building.getClass().equals(LumberMill.class)) {
            return hex.getClass().equals(ForestHex.class);

        } else if (building.getClass().equals(IronMine.class)) {
            return hex.getClass().equals(MountainHex.class) && hex.isAdditionalResources();
        } else if (building.getClass().equals(Stable.class)) {
            return hex.getClass().equals(LandHex.class) && hex.isAdditionalResources();
        } else if (building.getClass().equals(Settlement.class))
            return hex.getClass().equals(LandHex.class);
        return false;
    }
}

```

---

# File: src/Models/Logic/UnitLogic/ExplorerLogic.java

```java
package Models.Logic.UnitLogic;

import Models.Elements.Units.Explorer;
import Models.Logic.HexLogic.HexLogic;

public class ExplorerLogic extends UnitLogic {

    private Explorer explorer;

    public ExplorerLogic(Explorer explorer) {
        super(explorer);
        this.explorer = explorer;
    }

    public void Explore() throws Exception {
        System.out.println("Explore inside the logic called ");
        cost(1);
        HexLogic.discover(explorer.getHex());
    }
}

```

---

# File: src/Models/Logic/UnitLogic/FindBestPath.java

```java
package Models.Logic.UnitLogic;

import Game.Generate;
import Models.Elements.Hex.Hex;
import Models.Logic.HexLogic.HexLogic;
import Models.Records.HexRecord;

import java.util.*;

public class FindBestPath {

    private final HexRecord hexRecord =
            Generate.getGame().getWorld().getHexRecord();

    private final Hex start;
    private final Hex goal;

    private int totalCost = -1;

    public FindBestPath(Hex start, Hex goal) {
        this.start = start;
        this.goal = goal;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public boolean canReach(int maxCost) {
        return !findPath(maxCost).isEmpty();
    }

    public List<Hex> findPath(int maxCost) {

        totalCost = -1;

        if (start == null || goal == null)
            return Collections.emptyList();

        List<Hex> existing = hexRecord.getAll();

        if (!existing.contains(start) || !existing.contains(goal))
            return Collections.emptyList();

        PriorityQueue<PathNode> queue =
                new PriorityQueue<>(Comparator.comparingInt(n -> n.cost));

        Map<Hex, Integer> distance = new HashMap<>();

        queue.add(new PathNode(start, 0, null));
        distance.put(start, 0);

        while (!queue.isEmpty()) {

            PathNode current = queue.poll();

            // Dijkstra optimization
            if (current.cost > maxCost)
                break;

            if (current.hex.equals(goal)) {

                totalCost = current.cost;

                ArrayList<Hex> path = new ArrayList<>();

                while (current != null) {
                    path.add(0, current.hex);
                    current = current.previous;
                }

                return path;
            }

            for (Hex neighbor : HexLogic.getNeighbors(current.hex)) {

                if (neighbor == null)
                    continue;

                int newCost =
                        current.cost + neighbor.getMovementCost();

                // AP optimization
                if (newCost > maxCost)
                    continue;

                Integer oldCost = distance.get(neighbor);

                if (oldCost == null || newCost < oldCost) {

                    distance.put(neighbor, newCost);

                    queue.add(new PathNode(
                            neighbor,
                            newCost,
                            current
                    ));
                }
            }
        }

        return Collections.emptyList();
    }
    public List<Hex> bestPath(int maxCost) {

        if (!canReach(maxCost))
            return Collections.emptyList();

        return findPath(maxCost);
    }
    public int CalculateTotalCost(){
        findPath(70);
        return totalCost;
    }
}
```

---

# File: src/Models/Logic/UnitLogic/PathNode.java

```java
package Models.Logic.UnitLogic;

import Models.Elements.Hex.Hex;

public class PathNode {

    public Hex hex;
    public int cost;
    public PathNode previous;

    public PathNode(Hex hex, int cost, PathNode previous) {
        this.hex = hex;
        this.cost = cost;
        this.previous = previous;
    }
}
```

---

# File: src/Models/Logic/UnitLogic/UnitLogic.java

```java
package Models.Logic.UnitLogic;

import Models.Elements.Hex.Hex;
import Models.Elements.Resources.Food;
import Models.Elements.Resources.Resource;
import Models.Elements.Units.Unit;
import Models.Logic.HexLogic.HexLogic;
import Models.Logic.Logic;

import java.util.ArrayList;
import java.util.List;

public class UnitLogic extends Logic {

    protected Unit unit;

    public UnitLogic(Unit unit) {
        this.unit = unit;
    }

    public void cost(int AP) throws Exception {
        if (unit.getAP() < AP) {
            throw new Exception("Not enough AP");
        }
        unit.setAP(unit.getAP() - AP);
    }

    public void resetAp() {
        unit.setAP(unit.getInitialAP());
    }

    public void feed() {
        // Implementation for feeding logic
    }

    public void moveToHex(Hex targetHex) {
        unit.setHex(targetHex);
    }

    /**
     * Checks if the unit can reach the targeted hex using its remaining current AP.
     */
    public boolean canReach(Hex targetHex) {
        if (unit.getHex() == null || targetHex == null) return false;
        FindBestPath pathfinder = new FindBestPath(unit.getHex(), targetHex);
        return pathfinder.canReach(unit.getAP());
    }

    /**
     * Gets the shortest optimal path list of hexes to the target hex.
     */
    public List<Hex> getBestPath(Hex targetHex) {
        if (unit.getHex() == null || targetHex == null) return new ArrayList<>();
        FindBestPath pathfinder = new FindBestPath(unit.getHex(), targetHex);
        return pathfinder.bestPath(unit.getAP());
    }
}
```

---

# File: src/Models/Logic/UnitLogic/WorkerLogic.java

```java
package Models.Logic.UnitLogic;

import Models.Elements.Buildings.Building;
import Models.Elements.Units.Worker;
import Models.Logic.BuildingLogic.BuildingLogic;

import java.awt.*;

public class WorkerLogic extends UnitLogic {

    private Worker worker;

    public WorkerLogic(Worker worker) {
        super(worker);
        this.worker = worker;
    }

    public void GetInBuilding(Building building) throws Exception {
        new BuildingLogic(building).addWorker();
        worker.setStationedBuilding(building);
        worker.setColor(Color.BLACK);
        cost(1);
    }

    public void GetOffBuilding() throws Exception {
        Building building = worker.getStationedBuilding();
        if (building != null) {
            new BuildingLogic(building).removeWorker();
        }
        worker.setStationedBuilding(null);
        worker.setWorking(false);
        worker.setColor(Color.GRAY);
        cost(1);
    }
}

```

---

# File: src/Models/Manager/HexManager.java

```java
package Models.Manager;

import Models.Elements.Hex.Hex;
import Models.Records.HexRecord;

import java.awt.*;

public class HexManager {

    private int[] zoom = {30, 50, 70, 100, 150};
    private int zoomIndex = 1;
    private int centerX;
    private int centerY;
    private int size;
    private HexRecord hexRecord;
    private Hexutils hexutils;
    private Runnable onPositionsChanged;

    public HexManager(int centerX, int centerY, HexRecord hexRecord , Hexutils hexutils) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.hexRecord = hexRecord;
        this.size = zoom[zoomIndex];
        this.hexutils = hexutils;
    }

    /** Register a callback to run whenever hex positions/sizes are recalculated (zoom, pan, initial add). */
    public void setOnPositionsChanged(Runnable onPositionsChanged) {
        this.onPositionsChanged = onPositionsChanged;
    }

    private void notifyPositionsChanged() {
        if (onPositionsChanged != null) {
            onPositionsChanged.run();
        }
    }

    /** Called by HexRecord.add() automatically — no need to call manually. */
    public void onHexAdded(Hex hex) {
        hexutils.updateHexPosition(hex, centerX, centerY, size);
        notifyPositionsChanged();
    }

    public void draw(Graphics g) {
        for (Hex hex : hexRecord.getAll()) {
            hex.getDraw().draw(g);
        }
    }

    public void recalculateAll() {
        for (Hex hex : hexRecord.getAll()) {
            hexutils.updateHexPosition(hex, centerX, centerY, size);
        }
        notifyPositionsChanged();
    }

    public void setSize(int newSize) {
        this.size = newSize;
        recalculateAll();
    }

    public void pan(int dx, int dy) {
        this.centerX += dx;
        this.centerY += dy;
        recalculateAll();
    }

    public void setCenter(int x, int y) {
        this.centerX = x;
        this.centerY = y;
        recalculateAll();
    }

    public int getCenterX() { return centerX; }
    public int getCenterY() { return centerY; }
    public int getSize()    { return size; }
    public int[] getZoom()  { return zoom; }
    public int getZoomIndex() { return zoomIndex; }

    public void setZoomIndex(int zoomIndex) {
        this.zoomIndex = zoomIndex;
    }
}
```

---

# File: src/Models/Manager/Hexutils.java

```java
package Models.Manager;

import Models.Elements.Hex.Hex;

public class Hexutils {

    /**
     * Converts axial hex coordinates (q, r) to pixel coordinates (x, y).
     *
     * Uses flat-top hex layout where:
     *   - q axis goes horizontally to the right  (red arrow)
     *   - r axis goes diagonally down-left        (blue arrow)
     *
     * @param q        axial column of the target hex
     * @param r        axial row of the target hex
     * @param centerX  pixel x of the center hex (0,0)
     * @param centerY  pixel y of the center hex (0,0)
     * @param size     hex size (center to corner in pixels)
     * @return int[]{x, y} pixel position of the target hex center
     */
    public int[] axialToPixel(int q, int r, int centerX, int centerY, int size) {
        int parity = r & 1; // 0 or 1 — correct even for negative r in Java (unlike r % 2)
        double col = q + (r - parity) / 2.0;
        int x = (int) (centerX + (col + 0.5 * parity) * size * 0.8);
        int y = (int) (centerY + r * size * 2.0 / 3.0);
        return new int[]{x, y};
    }

    /**
     * Applies pixel coordinates back onto the hex object itself.
     * Call this whenever zoom or pan changes.
     *
     * @param hex      the hex to update
     * @param centerX  pixel x of the center hex (0,0)
     * @param centerY  pixel y of the center hex (0,0)
     * @param size     current hex size (changes on zoom)
     */
    public void updateHexPosition(Hex hex, int centerX, int centerY, int size) {
        int[] pos = axialToPixel(hex.getQ(), hex.getR(), centerX, centerY, size);
        hex.setX(pos[0]);
        hex.setY(pos[1]);
        hex.setSize(size);
    }
}
```

---

# File: src/Models/Records/BuildingRecord.java

```java
package Models.Records;

import Models.Elements.Buildings.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Collections;

public final class BuildingRecord {

    private final Map<Class<? extends Building>, List<Building>> elements;

    public BuildingRecord() {
        elements = new HashMap<>();
        elements.put(Farm.class, new ArrayList<>());
        elements.put(IronMine.class, new ArrayList<>());
        elements.put(LumberMill.class, new ArrayList<>());
        elements.put(Settlement.class, new ArrayList<>());
        elements.put(Stable.class, new ArrayList<>());
        elements.put(StoneMine.class, new ArrayList<>());
        elements.put(TownHall.class, new ArrayList<>());
    }

    public  void add(Building building) {
        if (building == null) return;
        List<Building> list = elements.computeIfAbsent(building.getClass(), k -> new ArrayList<>());
        list.add(building);
    }

    public  void remove(Building building) {
        if (building == null) return;
        List<Building> list = elements.get(building.getClass());
        if (list != null) {
            list.remove(building);
        }
    }

    public List<Building> getAll(Class<? extends Building> clazz) {
        List<Building> list = elements.get(clazz);
        return list != null ? Collections.unmodifiableList(new ArrayList<>(list)) : Collections.emptyList();
    }

    public List<Building> getAll() {
        List<Building> all = new ArrayList<>();
        for (List<Building> list : elements.values()) {
            all.addAll(list);
        }
        return Collections.unmodifiableList(all);
    }

    public  Building create(Building building) {
        add(building);
        return building;
    }
}
```

---

# File: src/Models/Records/HexRecord.java

```java
package Models.Records;

import Models.Elements.Hex.*;
import Models.Manager.HexManager;

import java.util.*;

public final class HexRecord {

    private final Map<Class<? extends Hex>, List<Hex>> elements;
    private HexManager hexManager; // set after World constructs both

    public HexRecord() {
        elements = new HashMap<>();
        elements.put(ForestHex.class,   new ArrayList<>());
        elements.put(LandHex.class,     new ArrayList<>());
        elements.put(MountainHex.class, new ArrayList<>());
        elements.put(GrassHex.class,    new ArrayList<>());
    }

    /** World calls this after constructing HexManager to wire them together. */
    public void setHexManager(HexManager hexManager) {
        this.hexManager = hexManager;
    }

    public void add(Hex hex) {
//        System.out.println("add called ");
        if (hex == null) return;
        List<Hex> list = elements.computeIfAbsent(hex.getClass(), k -> new ArrayList<>());
        list.add(hex);
        // Automatically position the hex on the board
        if (hexManager != null) {
            hexManager.onHexAdded(hex);
        }
    }

    public void remove(Hex hex) {
        if (hex == null) return;
        List<Hex> list = elements.get(hex.getClass());
        if (list != null) list.remove(hex);
    }

    public List<Hex> getAll(Class<? extends Hex> clazz) {
        List<Hex> list = elements.get(clazz);
        return list != null ? Collections.unmodifiableList(new ArrayList<>(list)) : Collections.emptyList();
    }

    public List<Hex> getAll() {
        List<Hex> all = new ArrayList<>();
        for (List<Hex> list : elements.values()) all.addAll(list);
        return Collections.unmodifiableList(all);
    }

    public Hex create(Hex hex) {
        add(hex);
        return hex;
    }
    // Add this method to HexRecord.java

    public List<Hex> getNeighbors(Hex hex) {
        // Axial directions for flat-top hex grid
        int[][] directions = {
                {1, 0}, {-1, 0},
                {0, 1}, {0, -1},
                {1, -1}, {1, 1}   // ← {1,1} is wrong here too, should be {-1,1}
        };

        List<Hex> neighbors = new ArrayList<>();
        for (int[] dir : directions) {
            Hex neighbor = getByQR(hex.getQ() + dir[0], hex.getR() + dir[1]);
            if (neighbor != null) neighbors.add(neighbor);
        }
        return neighbors;
    }

    public Hex getByQR(int q, int r) {
        for (Hex hex : getAll()) {
            if (hex.getQ() == q && hex.getR() == r) return hex;
        }
        return null;
    }
}
```

---

# File: src/Models/Records/ResourceRecord.java

```java
package Models.Records;

import Models.Elements.Resources.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Collections;

public final class ResourceRecord {


    private final Map<Class<? extends Resource>, List<Resource>> elements;

    public ResourceRecord() {
        elements = new HashMap<>();
        elements.put(Iron.class, new ArrayList<>());
        elements.put(Food.class, new ArrayList<>());
        elements.put(Stone.class, new ArrayList<>());
        elements.put(Wood.class, new ArrayList<>());
    }

    public  void add(Resource resource) {
        if (resource == null) return;
        List<Resource> list = elements.computeIfAbsent(resource.getClass(), k -> new ArrayList<>());
        list.add(resource);
    }

    public void remove(Resource resource) {
        if (resource == null) return;
        List<Resource> list = elements.get(resource.getClass());
        if (list != null) {
            list.remove(resource);
        }
    }

    public void clear(Class<? extends Resource> clazz) {
        List<Resource> list = elements.get(clazz);
        if (list != null) {
            list.clear();
        }
    }

    public  List<Resource> getAll(Class<? extends Resource> clazz) {
        List<Resource> list = elements.get(clazz);
        return list != null ? Collections.unmodifiableList(new ArrayList<>(list)) : Collections.emptyList();
    }

    public List<Resource> getAll() {
        List<Resource> all = new ArrayList<>();
        for (List<Resource> list : elements.values()) {
            all.addAll(list);
        }
        return Collections.unmodifiableList(all);
    }

    public Resource create(Resource resource) {
        add(resource);
        return resource;
    }
}
```

---

# File: src/Models/Records/UnitRecord.java

```java
package Models.Records;

import Models.Elements.Units.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Collections;

public final class UnitRecord {


    private final Map<Class<? extends Unit>, List<Unit>> elements;

    private int UnitCap;

    public UnitRecord() {
        elements = new HashMap<>();
        elements.put(Worker.class, new ArrayList<>());
        elements.put(Builder.class, new ArrayList<>());
        elements.put(BorderExpander.class, new ArrayList<>());
        elements.put(Explorer.class, new ArrayList<>());
    }

    public void add(Unit unit) {
        if (unit == null) return;
        List<Unit> list = elements.computeIfAbsent(unit.getClass(), k -> new ArrayList<>());
        list.add(unit);
    }

    public void remove(Unit unit) {
        if (unit == null) return;
        List<Unit> list = elements.get(unit.getClass());
        if (list != null) {
            list.remove(unit);
        }
    }

    public  List<Unit> getAll(Class<? extends Unit> clazz) {
        List<Unit> list = elements.get(clazz);
        return list != null ? Collections.unmodifiableList(new ArrayList<>(list)) : Collections.emptyList();
    }

    public  List<Unit> getAll() {
        List<Unit> all = new ArrayList<>();
        for (List<Unit> list : elements.values()) {
            all.addAll(list);
        }
        return Collections.unmodifiableList(all);
    }

    public  Unit create(Unit unit) {
        add(unit);
        return unit;
    }
}
```

---

