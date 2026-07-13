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
- src/Game/Controller/tempBC.java
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
- src/Game/Systems/Drawers/ExtraDrawer.java
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
- src/Game/Systems/EventSystem/UnitEvent.java
- src/Game/Systems/EventSystem/WorkEvent.java
- src/Game/Systems/Restarters/BuildingRestarter.java
- src/Game/Systems/Restarters/TownHallRestarter.java
- src/Game/Systems/Restarters/UnitRestarter.java
- src/Game/Systems/RestarterSystem.java
- src/Game/Systems/SelectSystem.java
- src/Game/Systems/VisibilitySystem.java
- src/Game/Turn/TurnState.java
- src/Game/Views/BoardPanel.java
- src/Game/Views/GameEngine.java
- src/Game/Views/GameFrame.java
- src/Game/Views/HUDPanel.java
- src/Game/Views/Listeners/BoardMouseListener.java
- src/Game/World.java
- src/Main.java
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

    public BaseAnimation(int totalSteps) {
        this.totalSteps = totalSteps;
    }

    /**
     * Process a single tick. Returns false when finished.
     */
    public boolean step() {
        if (finished) return false;

        currentStep++;
        double linearProgress = (double) currentStep / totalSteps;

        // Perform calculation step
        onTick(linearProgress);

        if (currentStep >= totalSteps) {
            finished = true;
            onComplete();
        }
        return !finished;
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

public class UnitMoveAnimation extends BaseAnimation {
    private final Unit unit;
    private final Hex sourceHex;
    private final Hex targetHex;
    private final AnimationManager animationManager;
    private boolean isRunning;

    public UnitMoveAnimation(Unit unit, Hex sourceHex, Hex targetHex, int totalSteps, AnimationManager animationManager) {
        super(totalSteps);
        this.unit = unit;
        this.sourceHex = sourceHex;
        this.targetHex = targetHex;
        this.animationManager = animationManager;
        this.isRunning = true;
    }

    @Override
    protected void onTick(double progress) {
        double eased = progress * progress * (3 - 2 * progress);

        // Recompute live each tick, so a zoom/pan mid-move is reflected immediately
        // instead of tweening toward stale, pre-zoom coordinates.
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
            unit.getLogic().moveToHex(targetHex);

            UnitPositionCalculator.refreshHex(sourceHex, unit);
            UnitPositionCalculator.refreshHex(targetHex, unit);
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

    public BoardController(World world, MovementSystem movementSystem, BoardSystem boardSystem, SelectSystem selectSystem) {
        this.world = world;
        this.movementSystem = movementSystem;
        this.boardSystem = boardSystem;
        this.selectSystem = selectSystem;
        this.finder = new Finder(world);
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

    public void mouseDragged() {
        boardSystem.moveBoard();
    }

    public void mouseMoved(int x, int y) {
        // Left empty intentionally for now
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
        systemManager = new SystemManager(world , animationManager);
        controllerManager = new ControllerManager(systemManager , world);
        viewManager = new ViewManager(systemManager.getDrawingSystem() , controllerManager);
        animationManager.setGameEngine(viewManager.getGameEngine());
        starter = new Starter(world);
    }
    public void start(){
        starter.start();
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

    public static Game getGame() {
        return game;
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
import Game.World;

public class ControllerManager {
    private SystemManager systemManager;
    private World world;
    private BoardController boardController;

    public ControllerManager(SystemManager systemManager, World world) {
        this.systemManager = systemManager;
        this.world = world;
        boardController = new BoardController(world , systemManager.getMovementSystem() , systemManager.getBoardSystem() , systemManager.getSelectSystem());

    }

    public BoardController getBoardController() {
        return boardController;
    }

    public SystemManager getSystemManager() {
        return systemManager;
    }
}

```

---

# File: src/Game/Managers/SystemManager.java

```java
package Game.Managers;

import Game.Systems.BoardSystem;
import Game.Systems.DrawingSystem;
import Game.Systems.ElementSystem.BuildSystem;
import Game.Systems.ElementSystem.ExplorationSystem;
import Game.Systems.ElementSystem.MovementSystem;
import Game.Systems.ElementSystem.WorkSystem;
import Game.Systems.EventSystem.EventSystem;
import Game.Systems.SelectSystem;
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
    private final AnimationManager animationManager;

    public SystemManager(World world, AnimationManager animationManager) {
        this.world = world;
        this.animationManager = animationManager;

        // 1. Initialize EventSystem first (but without its inner SelectEvent needing ExtraDrawer yet)
        // Alternatively, we create the components sequentially by passing references downstream.
        this.eventSystem = new EventSystem(world, animationManager);

        // 2. Initialize SelectSystem which depends on EventSystem
        this.selectSystem = new SelectSystem(this.eventSystem, animationManager);

        // 3. Initialize BoardSystem
        this.boardSystem = new BoardSystem(this.eventSystem.getBoardEvent());

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

    public World getWorld() {
        return world;
    }
}
```

---

# File: src/Game/Managers/TurnManager.java

```java
package Game.Managers;

public class TurnManager {
}

```

---

# File: src/Game/Managers/ViewManager.java

```java
package Game.Managers;

import Game.Systems.DrawingSystem;
import Game.Views.GameEngine;
import Game.Views.Listeners.BoardMouseListener;

public class ViewManager {
    private DrawingSystem drawingSystem;
    private GameEngine gameEngine;
    private final BoardMouseListener boardMouseListener;
    private final ControllerManager controllerManager;


    public ViewManager(DrawingSystem drawingSystem, ControllerManager controllerManager) {
        this.drawingSystem = drawingSystem;

        this.controllerManager = controllerManager;
        boardMouseListener = new BoardMouseListener(controllerManager.getBoardController());
        gameEngine = new GameEngine(drawingSystem , boardMouseListener);
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
import Models.Elements.Hex.Hex;
import Models.Elements.Hex.LandHex;
import Models.Elements.Units.Builder;
import Models.Elements.Units.Explorer;
import Models.Elements.Units.Unit;
import Models.Elements.Units.Worker;
import Models.Logic.HexLogic.HexLogic;
import Models.Records.HexRecord;
import Models.Records.UnitRecord;

public class Starter {
    private final World world;

    public Starter(World world) {
        this.world = world;
    }
    public void start(){
        world.getHexRecord().add(new LandHex(0 , 0 , false));
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
        world.getUnitRecord().add(builder);

        // FIX: Recompute and apply initial coordinates and sizes for all units on this hex
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

public class BoardSystem {
    private final BoardEvent boardEvent;

    public BoardSystem(BoardEvent boardEvent) {
        this.boardEvent = boardEvent;
    }


    public void zoom(int rotate) {
        boardEvent.Zoomed(rotate);
    }

    public void moveBoard() {
        // Will be filled out later
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

# File: src/Game/Systems/Drawers/ExtraDrawer.java

```java
package Game.Systems.Drawers;

import Game.Systems.SelectSystem;
import Game.World;
import Models.Elements.Hex.Hex;
import Models.Elements.Units.Unit;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ExtraDrawer {
    private final SelectSystem selectSystem;
    private final World world;
    private Hex selectedHex;
    private Unit selectedUnit; // Added field to match pattern

    public ExtraDrawer(SelectSystem selectSystem, World world) {
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

import Game.Systems.Drawers.DrawBuildings;
import Game.Systems.Drawers.DrawHexes;
import Game.Systems.Drawers.DrawUnits;
import Game.Systems.Drawers.SelectDrawer;
import Game.World;

import java.awt.*;

public class DrawingSystem {
    private World world;
    private DrawHexes drawHexes;
    private DrawBuildings drawBuildings;
    private DrawUnits drawUnits;
    private final SelectSystem selectSystem;
    private final SelectDrawer extraDrawer;

    public DrawingSystem(World world, SelectSystem selectSystem) {
        this.world = world;
        drawBuildings = new DrawBuildings(world.getBuildingRecord());
        drawHexes = new DrawHexes(world.getHexRecord());
        drawUnits = new DrawUnits(world.getUnitRecord());
        this.selectSystem = selectSystem;
        extraDrawer = new SelectDrawer(selectSystem, world);
    }

    public void draw(Graphics g) {
        drawHexes.draw(g);
        drawBuildings.draw(g);
        drawUnits.draw(g);
        extraDrawer.draw(g);
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
        if (!(selectSystem.getSelectedUnit() instanceof Explorer)) {
            eventSystem.getExplorEvent().ExplorationFailed("No active Explorer selected.");
            return;
        }

        Explorer explorer = (Explorer) selectSystem.getSelectedUnit();
        ExplorerLogic logic = (ExplorerLogic) explorer.getLogic();

        try {
            logic.Explore();
            eventSystem.getExplorEvent().HexExplored(explorer.getHex());
        } catch (Exception e) {
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

public class MovementSystem {
    private final SelectSystem selectSystem;
    private final EventSystem eventSystem;
    private boolean unitWasSelectedFirst = false;

    public MovementSystem(SelectSystem selectSystem, EventSystem eventSystem) {
        this.selectSystem = selectSystem;
        this.eventSystem = eventSystem;
    }

    public void UnitMove() {
        Unit currentUnit = selectSystem.getSelectedUnit();
        Hex currentHex = selectSystem.getSelectedHex();

        if (currentUnit == null && currentHex == null) {
            unitWasSelectedFirst = false;
            return;
        }

        if (currentUnit != null && currentHex == null) {
            unitWasSelectedFirst = true;
        }

        if (currentUnit == null || currentHex == null) {
            return;
        }

        if (!unitWasSelectedFirst) {
            return;
        }

        Hex oldHex = currentUnit.getHex();

        // Safety guard: Don't move to the exact same hex
        if (currentHex.equals(oldHex)) {
            return;
        }

        // Trigger the animation event FIRST before changing the state
        eventSystem.getUnitEvent().UnitMoved(oldHex, currentHex, currentUnit);

        // Reset your selection flags immediately
        unitWasSelectedFirst = false;
        selectSystem.selectUnit(null);
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

public class BoardEvent extends Event{
    private final HexManager hexManager;
    public BoardEvent(AnimationManager animationManager , HexManager hexManager) {
        super(animationManager);
        this.hexManager = hexManager;
    }

    public void Zoomed(int rotate){
        animationManager.play(new ZoomAnimation(rotate , hexManager , null ));
    }
    public void MoveInBoard(){


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

    public void BorderExpanded(Hex hex) {}
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

    public void BuildingConstructed(Building building, Hex hex) {}
    public void BuildingFailed(String reason) {}
}

```

---

# File: src/Game/Systems/EventSystem/Event.java

```java
package Game.Systems.EventSystem;

import Game.Managers.AnimationManager;

public abstract class Event {
    protected AnimationManager animationManager;

    public Event(AnimationManager animationManager) {
        this.animationManager = animationManager;
    }
}

```

---

# File: src/Game/Systems/EventSystem/EventSystem.java

```java
package Game.Systems.EventSystem;

import Game.Managers.AnimationManager;
import Game.Systems.Drawers.SelectDrawer;
import Game.World;

public class EventSystem {
    private final World world;
    private final BoardEvent boardEvent;
    private final BuildingEvent buildingEvent;
    private final ExplorEvent explorEvent;
    private final SelectEvent selectEvent;
    private final UnitEvent unitEvent;
    private final WorkEvent workEvent;
    private final BoardExpandEvent boardExpandEvent;
    private final AnimationManager animationManager;
    private SelectDrawer extraDrawer;

    public EventSystem(World world, AnimationManager animationManager) {
        this.world = world;
//        extraDrawer = Generate.getGame().getSystemManager().getDrawingSystem().getExtraDrawer();
        this.animationManager = animationManager;
        boardEvent = new BoardEvent(animationManager, world.getHexManager());
        buildingEvent = new BuildingEvent(animationManager);
        explorEvent = new ExplorEvent(animationManager);
        selectEvent = new SelectEvent(animationManager, extraDrawer);
        unitEvent = new UnitEvent(animationManager);
        boardExpandEvent = new BoardExpandEvent(animationManager);
        workEvent = new WorkEvent(animationManager);
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

    public void HexExplored(Hex hex) {}
    public void ExplorationFailed(String reason) {}
}

```

---

# File: src/Game/Systems/EventSystem/SelectEvent.java

```java
package Game.Systems.EventSystem;

import Game.Managers.AnimationManager;
import Game.Systems.Drawers.SelectDrawer;
import Models.Elements.Hex.Hex;
import Models.Elements.Units.Unit;
import Models.Logic.HexLogic.HexLogic;

import java.util.ArrayList;

public class SelectEvent extends Event {
    private SelectDrawer extraDrawer;

    public SelectEvent(AnimationManager animationManager, SelectDrawer extraDrawer) {
        super(animationManager);
        this.extraDrawer = extraDrawer;
    }

    public void setExtraDrawer(SelectDrawer extraDrawer) {
        this.extraDrawer = extraDrawer;
    }

    public void UnitSelected(Unit unit) {
        if (unit == null) {
            extraDrawer.setSelectedUnit(null);
        } else {
            extraDrawer.setSelectedUnit(unit);
        }

        // Request a clean UI re-render when unit selection state updates
        animationManager.refresh();
    }

    public void HexSelected(Hex hex) {
        // 1. Reset all tiles on the entire board to darker whenever a selection changes
        for (Hex boardHex : Game.Generate.getGame().getWorld().getHexRecord().getAll()) {
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
import com.sun.nio.sctp.AbstractNotificationHandler;

public class WorkEvent extends Event{
    public WorkEvent(AnimationManager animationManager) {
        super(animationManager);
    }

    public void WorkerStationed(Unit worker, Building building) {}
    public void WorkerUnstationed(Unit worker) {}
    public void WorkerActionFailed(String reason) {}
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

    public void restart(){
        townHallRestarter.produceSafeguard();
        buildingRestarter.ProduceResources();
        buildingRestarter.CostUpkeep();
        starvationSystem.StarvationCheck();
        unitRestarter.APRestart();
        unitRestarter.FeedAll();
    }
}

```

---

# File: src/Game/Systems/SelectSystem.java

```java
package Game.Systems;

import Game.Managers.AnimationManager;
import Game.Systems.EventSystem.EventSystem;
import Models.Elements.Buildings.Building;
import Models.Elements.Hex.Hex;
import Models.Elements.Units.Unit;

public class SelectSystem {
    private Unit selectedUnit;
    private Hex selectedHex;
    private Building selectedBuilding;
    private final EventSystem eventSystem;
    private final AnimationManager animationManager;

    public SelectSystem(EventSystem eventSystem, AnimationManager animationManager) {
        this.eventSystem = eventSystem;
        this.animationManager = animationManager;
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

# File: src/Game/Views/BoardPanel.java

```java
package Game.Views;

import BoardGame.BoardState;
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

# File: src/Game/Views/GameEngine.java

```java
package Game.Views;

import BoardGame.BoardState;
import Game.Systems.DrawingSystem;
import Game.Views.Listeners.BoardMouseListener;


import java.awt.*;

public class GameEngine {

    private final DrawingSystem drawingSystem;
    private final GameFrame gameFrame;
    private final BoardPanel boardPanel;
    private final BoardMouseListener listener;

    public GameEngine(DrawingSystem drawingSystem, BoardMouseListener listener) {
        this.drawingSystem = drawingSystem;
        this.listener = listener;
        gameFrame = new GameFrame();
        boardPanel = new BoardPanel(drawingSystem);
        boardPanel.addMouseListener(listener);
        boardPanel.addMouseMotionListener(listener);
        boardPanel.addMouseWheelListener(listener);

        gameFrame.setLayout(new BorderLayout());
        gameFrame.add(boardPanel, BorderLayout.CENTER);

    }

    public void startGame(){
        gameFrame.setVisible(true);
    }
    /**
     * Triggers a repaint of the board.
     * Call this after any state change (end of turn, unit move, etc.)
     */
    public void refresh() {
        boardPanel.repaint();
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

# File: src/Game/Views/HUDPanel.java

```java
package Game.Views;

public class HUDPanel {
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

    public BoardMouseListener(BoardController boardController) {
        this.boardController = boardController;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        boardController.mouseClicked(e.getX() , e.getY());
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        boardController.mouseWheelChanged(e.getWheelRotation());
        super.mouseWheelMoved(e);
    }


    @Override
    public void mouseMoved(MouseEvent e) {
        boardController.mouseMoved(e.getX() , e.getY());
    }
}

```

---

# File: src/Game/World.java

```java
package Game;

import Models.Draw.UnitPositionCalculator;
import Models.Manager.HexManager;
import Models.Manager.Hexutils;
import Models.Records.BuildingRecord;
import Models.Records.HexRecord;
import Models.Records.ResourceRecord;
import Models.Records.UnitRecord;

public class World {
    private final BuildingRecord buildingRecord;
    private final HexRecord hexRecord;
    private final ResourceRecord resourceRecord;
    private final UnitRecord unitRecord;
    private final HexManager hexManager;
    private final Hexutils hexutils;

    public World() {
        buildingRecord  = new BuildingRecord();
        resourceRecord  = new ResourceRecord();
        unitRecord      = new UnitRecord();
        hexutils        = new Hexutils();

        hexRecord  = new HexRecord();
        hexManager = new HexManager(300, 220 , hexRecord , hexutils);
        hexRecord.setHexManager(hexManager);

        // Keep unit x/y/size in sync whenever hex positions change (zoom/pan/add)
        hexManager.setOnPositionsChanged(() -> UnitPositionCalculator.refreshAll(unitRecord));
    }

    public BuildingRecord getBuildingRecord()  { return buildingRecord; }
    public HexRecord      getHexRecord()       { return hexRecord; }
    public ResourceRecord getResourceRecord()  { return resourceRecord; }
    public UnitRecord     getUnitRecord()      { return unitRecord; }
    public HexManager     getHexManager()      { return hexManager; }
    public Hexutils       getHexutils()        { return hexutils; }
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

# File: src/Models/Draw/BuildingDraw.java

```java
package Models.Draw;

import Models.Elements.Buildings.Building;
import java.awt.*;

public class BuildingDraw implements Draw {
    private final Building building;

    public BuildingDraw(Building building) {
        this.building = building;
    }

    @Override
    public void draw(Graphics g) {
        // TODO: draw building
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

        System.out.println(drawX + ">" + drawY + ">" + size);
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
    }
}
```

---

# File: src/Models/Elements/Buildings/TownHall.java

```java
package Models.Elements.Buildings;

import Models.Elements.Hex.Hex;
import Models.Elements.Resources.*;

import java.util.HashMap;
import java.util.Map;

public class TownHall extends Building {

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

        workerCapacity = 2;

    }

    public Map<Class<? extends Resource>, Integer> getSafeGuard() {
        return safeGuard;
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

import Models.Elements.Resources.Resource;
import Models.Elements.Resources.Wood;

public class ForestHex extends Hex {
    public ForestHex(int q, int r, boolean additionalResource) {
        super(q, r, Wood.class, null);
        this.movementCost = 2;

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

import Models.Elements.Resources.Food;
import Models.Elements.Resources.Resource;

public class GrassHex extends Hex{
    public GrassHex(int q, int r,boolean additionalResources) {
        super(q , r , null , Food.class);
        setAdditionalResources(additionalResources);
        movementCost = 1;
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
    protected boolean additionalResources;
    protected Building building;

    public Hex(int q, int r, Class<? extends Resource> resourceType, Class<? extends Resource> additionalResource) {
        this.q = q;
        this.r = r;
        this.resourceType = resourceType;
        this.additionalResource = additionalResource;
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
        if (DarkImagePath != null) {
            image = new ImageIcon(DarkImagePath).getImage();
        }
        draw = new HexDraw(this);
    }

    public void setLighter(){
        if (LightImagePath != null) {
            // FIXED: Now accurately loads the light image asset path variant
            image = new ImageIcon(LightImagePath).getImage();
        }
        draw = new HexDraw(this);
    }
}
```

---

# File: src/Models/Elements/Hex/LandHex.java

```java
package Models.Elements.Hex;

import Models.Elements.Resources.Food;
import Models.Elements.Resources.Resource;

public class LandHex extends Hex{
    public LandHex(int q, int r , boolean additionalResources) {
        super(q , r , null , Food.class);
        setAdditionalResources(additionalResources);
        movementCost = 1;
        setImage("C:\\Users\\shantiya\\Desktop\\django\\java\\Civilizatino-6\\src\\Images\\LandImage.png");
        setDarkerImage("C:\\Users\\shantiya\\Desktop\\django\\java\\Civilizatino-6\\src\\Images\\Darker\\LandImage.png");

        initializeImages();
    }
}

```

---

# File: src/Models/Elements/Hex/MountainHex.java

```java
package Models.Elements.Hex;

import Models.Elements.Resources.Iron;
import Models.Elements.Resources.Resource;
import Models.Elements.Resources.Stone;

public class MountainHex extends Hex{
    public MountainHex(int q, int r , boolean additionalResources) {
        super(q , r , Stone.class , Iron.class);
        setAdditionalResources(additionalResources);
        movementCost = 4;
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
        super(2, 3);
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
        super(1, 4);
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
        super(1, 8);
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
    protected Unit(int foodNeed, int initialAP) {
        this.foodNeed = foodNeed;
        this.initialAP = initialAP;
        this.AP = initialAP;
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

    public Worker() {
        super(1, 5);
        setColor(Color.GRAY);
        setLogic(new WorkerLogic(this));

    }

    public Building getStationedBuilding() { return stationedBuilding; }
    public void setStationedBuilding(Building stationedBuilding) { this.stationedBuilding = stationedBuilding; }
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

    // Static: attempts to construct `buildingClass` for the given builder.
    // Checks resources (ResourceRecord), Builder AP, and hex type before
    // actually creating and registering the building.
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
//        System.out.println("discover called");
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
    protected UnitRecord unitRecord = Generate.getGame().getWorld().getUnitRecord();
    protected ResourceRecord resourceRecord = Generate.getGame().getWorld().getResourceRecord();
    protected HexRecord hexRecord = Generate.getGame().getWorld().getHexRecord();
    protected BuildingRecord buildingRecord = Generate.getGame().getWorld().getBuildingRecord();

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
        if (unit.getAP() < AP)
            throw new Exception("AP is not enough");

        unit.setAP(unit.getAP() - AP);
    }

    public void resetAp() {
        unit.setAP(unit.getInitialAP());
    }

    public void feed() {

        List<Resource> foodStock =
                resourceRecord.getAll(Food.class);

        int need = unit.getFoodNeed();

        for (int i = 0; i < need && i < foodStock.size(); i++) {
            resourceRecord.remove(foodStock.get(i));
        }
    }

    public void moveToNextHex(Hex hex) throws Exception {

        ArrayList<Hex> neighbors =
                HexLogic.getNeighbors(unit.getHex());

        if (!neighbors.contains(hex))
            throw new Exception("Hex is not adjacent");

        if (hex.getMovementCost() > unit.getAP())
            throw new Exception("Not enough AP");

        cost(hex.getMovementCost());

        unit.setHex(hex);
    }

    public int calculateMovementCost(Hex goal) {

        FindBestPath finder =
                new FindBestPath(unit.getHex(), goal);

        finder.findPath(Integer.MAX_VALUE);

        return finder.getTotalCost();
    }

    public boolean canReach(Hex goal) {

        FindBestPath finder =
                new FindBestPath(unit.getHex(), goal);

        return finder.canReach(unit.getAP());
    }

    public void moveToHex(Hex goal) throws Exception {
        if (goal.equals(unit.getHex()))
            return;

        FindBestPath finder =
                new FindBestPath(unit.getHex(), goal);

        List<Hex> path = finder.bestPath(unit.getAP());

        if (path.isEmpty())
            throw new Exception("Destination is unreachable.");

        for (int i = 1; i < path.size(); i++) {
            cost(path.get(i).getMovementCost());
        }
        unit.setHex(goal);
    }
    public List<Hex> getBestPath(Hex goal){
        FindBestPath finder =
                new FindBestPath(unit.getHex(), goal);
        return finder.bestPath(unit.getAP());
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

public class WorkerLogic extends UnitLogic {

    private Worker worker;

    public WorkerLogic(Worker worker) {
        super(worker);
        this.worker = worker;
    }

    public void GetInBuilding(Building building) throws Exception {
        new BuildingLogic(building).addWorker();
        worker.setStationedBuilding(building);
        cost(1);
    }

    public void GetOffBuilding() throws Exception {
        Building building = worker.getStationedBuilding();
        if (building != null) {
            new BuildingLogic(building).removeWorker();
        }
        worker.setStationedBuilding(null);
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

