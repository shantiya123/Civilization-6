# Java Project

## Project Structure

- src/Animation/BaseAnimation.java
- src/Animation/MessageAnimation.java
- src/Animation/PanAnimation.java
- src/Animation/TimerEquations.java
- src/Animation/UnitMoveAnimation.java
- src/Animation/ZoomAnimation.java
- src/Game/Controller/BoardController.java
- src/Game/Controller/Finder.java
- src/Game/Controller/HUDController.java
- src/Game/Controller/UnitPanelController.java
- src/Game/Game.java
- src/Game/Generate.java
- src/Game/Managers/AnimationManager.java
- src/Game/Managers/ControllerManager.java
- src/Game/Managers/SystemManager.java
- src/Game/Managers/TurnManager.java
- src/Game/Managers/ViewManager.java
- src/Game/MusicPlayer.java
- src/Game/Presentation/DrawingState.java
- src/Game/Presentation/UnitPanelRegistry.java
- src/Game/Presentation/ViewState.java
- src/Game/Starter.java
- src/Game/Systems/BoardSystem.java
- src/Game/Systems/Drawers/BorderDrawer.java
- src/Game/Systems/Drawers/DrawBuildings.java
- src/Game/Systems/Drawers/DrawHexes.java
- src/Game/Systems/Drawers/DrawMessages.java
- src/Game/Systems/Drawers/DrawUnits.java
- src/Game/Systems/Drawers/PathDrawer.java
- src/Game/Systems/Drawers/SelectDrawer.java
- src/Game/Systems/DrawingSystem.java
- src/Game/Systems/ElementSystem/BuildSystem.java
- src/Game/Systems/ElementSystem/ExplorationSystem.java
- src/Game/Systems/ElementSystem/MovementSystem.java
- src/Game/Systems/ElementSystem/StarvationSystem.java
- src/Game/Systems/ElementSystem/WorkSystem.java
- src/Game/Systems/EventSystem/EventBus.java
- src/Game/Systems/EventSystem/Events/ActionPointsRestoredEvent.java
- src/Game/Systems/EventSystem/Events/BoardPannedEvent.java
- src/Game/Systems/EventSystem/Events/BoardZoomChangedEvent.java
- src/Game/Systems/EventSystem/Events/BorderExpandedEvent.java
- src/Game/Systems/EventSystem/Events/BuildingConstructedEvent.java
- src/Game/Systems/EventSystem/Events/BuildingDecayedEvent.java
- src/Game/Systems/EventSystem/Events/BuildingUpkeepFailedEvent.java
- src/Game/Systems/EventSystem/Events/EndTurnRequestedEvent.java
- src/Game/Systems/EventSystem/Events/Event.java
- src/Game/Systems/EventSystem/Events/FoodDepletedEvent.java
- src/Game/Systems/EventSystem/Events/HexExploredEvent.java
- src/Game/Systems/EventSystem/Events/HexSelectionChangedEvent.java
- src/Game/Systems/EventSystem/Events/MoveEvent.java
- src/Game/Systems/EventSystem/Events/MovementPreviewChangedEvent.java
- src/Game/Systems/EventSystem/Events/NotificationRequestedEvent.java
- src/Game/Systems/EventSystem/Events/ProductionProgressedEvent.java
- src/Game/Systems/EventSystem/Events/ResourcesProducedEvent.java
- src/Game/Systems/EventSystem/Events/SafeguardProducedEvent.java
- src/Game/Systems/EventSystem/Events/SettlementConstructedEvent.java
- src/Game/Systems/EventSystem/Events/StarvationStateChangedEvent.java
- src/Game/Systems/EventSystem/Events/TerritoryDisplayChangedEvent.java
- src/Game/Systems/EventSystem/Events/TurnAdvancedEvent.java
- src/Game/Systems/EventSystem/Events/UnitProducedEvent.java
- src/Game/Systems/EventSystem/Events/UnitProductionQueuedEvent.java
- src/Game/Systems/EventSystem/Events/UnitRefreshRequestedEvent.java
- src/Game/Systems/EventSystem/Events/UnitSelectionChangedEvent.java
- src/Game/Systems/EventSystem/Events/WorkerActionFailedEvent.java
- src/Game/Systems/EventSystem/Events/WorkerStationedEvent.java
- src/Game/Systems/EventSystem/Events/WorkerUnstationedEvent.java
- src/Game/Systems/EventSystem/EventSubscriberRegistry.java
- src/Game/Systems/Listeners/BoardExpandListener.java
- src/Game/Systems/Listeners/BoardListener.java
- src/Game/Systems/Listeners/BuildingListener.java
- src/Game/Systems/Listeners/ExplorListener.java
- src/Game/Systems/Listeners/Listener.java
- src/Game/Systems/Listeners/ListenerSystem.java
- src/Game/Systems/Listeners/SelectListener.java
- src/Game/Systems/Listeners/TurnListener.java
- src/Game/Systems/Listeners/UnitListener.java
- src/Game/Systems/Listeners/WorkListener.java
- src/Game/Systems/NotificationSystem.java
- src/Game/Systems/Restarters/BuildingRestarter.java
- src/Game/Systems/Restarters/TownHallRestarter.java
- src/Game/Systems/Restarters/UnitRestarter.java
- src/Game/Systems/RestarterSystem.java
- src/Game/Systems/SelectSystem.java
- src/Game/Systems/TownHallSystem.java
- src/Game/Views/BoardPanel/BoardPanel.java
- src/Game/Views/BoardPanel/EndTurnButton.java
- src/Game/Views/GameEngine.java
- src/Game/Views/GameFrame.java
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
- src/Models/Draw/MessageDraw.java
- src/Models/Draw/UnitDraw.java
- src/Models/Draw/UnitPositionCalculator.java
- src/Models/Elements/Buildings/Building.java
- src/Models/Elements/Buildings/Dock.java
- src/Models/Elements/Buildings/Farm.java
- src/Models/Elements/Buildings/IronMine.java
- src/Models/Elements/Buildings/LumberMill.java
- src/Models/Elements/Buildings/MilitaryStable.java
- src/Models/Elements/Buildings/Road.java
- src/Models/Elements/Buildings/Settlement.java
- src/Models/Elements/Buildings/Stable.java
- src/Models/Elements/Buildings/StoneMine.java
- src/Models/Elements/Buildings/TownHall.java
- src/Models/Elements/Element.java
- src/Models/Elements/Hex/BeachHex.java
- src/Models/Elements/Hex/BergHex.java
- src/Models/Elements/Hex/ForestHex.java
- src/Models/Elements/Hex/GrassHex.java
- src/Models/Elements/Hex/Hex.java
- src/Models/Elements/Hex/LandHex.java
- src/Models/Elements/Hex/MountainHex.java
- src/Models/Elements/Hex/SeaHex.java
- src/Models/Elements/Message.java
- src/Models/Elements/Resources/Food.java
- src/Models/Elements/Resources/Iron.java
- src/Models/Elements/Resources/Resource.java
- src/Models/Elements/Resources/Stone.java
- src/Models/Elements/Resources/Wood.java
- src/Models/Elements/Showable.java
- src/Models/Elements/Units/BorderExpander.java
- src/Models/Elements/Units/Builder.java
- src/Models/Elements/Units/CombatUnits/Archer.java
- src/Models/Elements/Units/CombatUnits/AttackType.java
- src/Models/Elements/Units/CombatUnits/Cavalry.java
- src/Models/Elements/Units/CombatUnits/CombatUnit.java
- src/Models/Elements/Units/CombatUnits/Prerequisites/ArcherPrerequisite.java
- src/Models/Elements/Units/CombatUnits/Prerequisites/CavalryPrerequisite.java
- src/Models/Elements/Units/CombatUnits/Prerequisites/Prerequisite.java
- src/Models/Elements/Units/CombatUnits/Prerequisites/SwordsmanPrerequisite.java
- src/Models/Elements/Units/CombatUnits/Swordsman.java
- src/Models/Elements/Units/Explorer.java
- src/Models/Elements/Units/Unit.java
- src/Models/Elements/Units/Worker.java
- src/Models/Elements/Vulnerable.java
- src/Models/Generator.java
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
- src/StartGame/MusicSettings.java
- src/StartGame/MusicToggleButton.java
- src/StartGame/StartButton.java
- src/StartGame/StartGameEngine.java
- src/StartGame/StartGameFrame.java
- src/StartGame/StartGamePanel.java
- src/StartGame/StartGameState.java
- src/StartGame/VolumeSlider.java
- src/Utils/ImageLoader.java

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

# File: src/Animation/MessageAnimation.java

```java
package Animation;

import Game.Managers.AnimationManager;
import Models.Elements.Messages.Message;
import javax.swing.FocusManager;
import java.awt.Window;

public class MessageAnimation extends BaseAnimation {

    private final Message message;
    private final AnimationManager animationManager;
    private boolean isRunning;

    private static final int WIDTH = 380;
    private static final int HEIGHT = 60;

    public MessageAnimation(int totalSteps, Message message, AnimationManager animationManager) {
        super(totalSteps);
        this.message = message;
        this.animationManager = animationManager;
        this.isRunning = true;


        this.message.setActive(true);
    }

    @Override
    protected void onTick(double progress) {
        double phase1End = 0.15;
        double phase2End = 0.85;

        double localProgress;
        double eased;

        Window activeWindow = FocusManager.getCurrentManager().getActiveWindow();
        if (activeWindow == null) return;

        int screenWidth = activeWindow.getWidth();
        int screenHeight = activeWindow.getHeight();

        int startX = (screenWidth - WIDTH) / 2;
        int hiddenY = screenHeight + 20;
        int visibleY = screenHeight - HEIGHT - 80;

        message.setX(startX);

        if (progress < phase1End) {
            localProgress = progress / phase1End;
            eased = 1.0 - Math.pow(1.0 - localProgress, 3);
            message.setY((int) (hiddenY + (visibleY - hiddenY) * eased));
            message.setAlpha((float) localProgress);
        } else if (progress < phase2End) {
            message.setY(visibleY);
            message.setAlpha(1.0f);
        } else {
            localProgress = (progress - phase2End) / (1.0 - phase2End);
            eased = localProgress * localProgress * localProgress;
            message.setY((int) (visibleY + (hiddenY - visibleY) * eased));
            message.setAlpha((float) (1.0f - localProgress));
        }

        animationManager.refresh();
    }

    @Override
    protected void onComplete() {
        this.isRunning = false;
        this.message.setActive(false);
        animationManager.refresh();
    }

    public boolean isRunning() {
        return isRunning;
    }

    public Message getMessage() {
        return message;
    }
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
        super(40);
        this.hexManager = hexManager;

        // Target calculation logic
        this.totalDx = -(targetHex.getCenterX() - CENTER_X);
        this.totalDy = -(targetHex.getCenterY() - CENTER_Y);
    }

    @Override
    protected void onTick(double progress) {

        double smoothProgress = TimerEquations.easeOut(progress);
        double deltaProgress = smoothProgress - lastProgress;
        lastProgress = smoothProgress;


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


    public static double linear(double t) {
        return t;
    }


    public static double easeOut(double t) {
        return 1 - Math.pow(1 - t, 3);
    }


    public static double easeIn(double t) {
        return t * t * t;
    }


    public static double easeInOut(double t) {
        return t < 0.5 ? 4 * t * t * t : 1 - Math.pow(-2 * t + 2, 3) / 2;
    }


    public static double smoothStep(double t) {
        return t * t * (3 - 2 * t);
    }


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
    private final List<Hex> path;
    private final AnimationManager animationManager;
    private boolean isRunning;

    private final int totalSegments;

    public UnitMoveAnimation(Unit unit, Hex sourceHex, Hex targetHex, int totalSteps, AnimationManager animationManager) {

        super(totalSteps);
        this.unit = unit;
        this.animationManager = animationManager;


        this.path = unit.getLogic().getBestPath(targetHex);


        if (this.path == null || this.path.size() < 2) {
            this.totalSegments = 1;
        } else {
            this.totalSegments = this.path.size() - 1;
        }

        this.isRunning = true;
    }

    @Override
    protected void onTick(double overallProgress) {

        double exactSegment = overallProgress * totalSegments;
        int currentSegmentIndex = (int) Math.floor(exactSegment);

        if (currentSegmentIndex >= totalSegments) {
            currentSegmentIndex = totalSegments - 1;
        }


        double localProgress = exactSegment - currentSegmentIndex;
        double eased = localProgress * localProgress * (3 - 2 * localProgress);


        Hex sourceHex;
        Hex targetHex;

        if (path != null && path.size() >= 2) {
            sourceHex = path.get(currentSegmentIndex);
            targetHex = path.get(currentSegmentIndex + 1);
        } else {

            sourceHex = this.unit.getHex();
            targetHex = path != null && !path.isEmpty() ? path.get(path.size() - 1) : this.unit.getHex();
        }

        if (sourceHex == null || targetHex == null) return;


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

            Hex finalTarget = (path != null && path.size() >= 2) ? path.get(path.size() - 1) : this.unit.getHex();
            Hex originalStart = (path != null && !path.isEmpty()) ? path.get(0) : this.unit.getHex();

            if (finalTarget != null) {

                unit.getLogic().moveToHex(finalTarget);

                UnitPositionCalculator.refreshHex(originalStart, unit);
                UnitPositionCalculator.refreshHex(finalTarget, unit);
            }
        } catch (Exception e) {
//            e.printStackTrace();
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

        this.startZoom = hexManager.getSize();
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

# File: src/Game/Controller/BoardController.java

```java
package Game.Controller;

import Game.Systems.BoardSystem;
import Game.Systems.ElementSystem.MovementSystem;
import Game.Systems.EventSystem.EventBus;
import Game.Systems.EventSystem.Events.EndTurnRequestedEvent;
import Game.Systems.SelectSystem;
import Game.World;
import Models.Elements.Hex.Hex;
import Models.Elements.Units.Unit;

public class BoardController {
    private Finder finder;
    private World world;
    private MovementSystem movementSystem;
    private BoardSystem boardSystem;
    private SelectSystem selectSystem;
    private final EventBus eventBus;

    public BoardController(World world, MovementSystem movementSystem, BoardSystem boardSystem,
                           SelectSystem selectSystem, EventBus eventBus) {
        this.world = world;
        this.movementSystem = movementSystem;
        this.boardSystem = boardSystem;
        this.selectSystem = selectSystem;
        this.finder = new Finder(world);
        this.eventBus = eventBus;
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
        eventBus.publish(new EndTurnRequestedEvent());
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


            List<Unit> sharedHexUnits = new ArrayList<>();
            for (Unit u : world.getUnitRecord().getAll()) {
                if (u != null && hex.equals(u.getHex())) {
                    sharedHexUnits.add(u);
                }
            }

            int totalUnits = sharedHexUnits.size();
            int myIndex = -1;
            for (int i = 0; i < sharedHexUnits.size(); i++) {
                if (sharedHexUnits.get(i) == unit) {
                    myIndex = i;
                    break;
                }
            }
            if (myIndex == -1) myIndex = 0;


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


            int dx = x - targetX;
            int dy = y - targetY;
            int hitRadius = unitSize / 2;

            if (Math.sqrt(dx * dx + dy * dy) <= hitRadius) {
                return unit;
            }
        }

        return null;
    }

    public Building findBuilding(int x, int y) {
        return null;
    }


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

            Unit unit = unitClass.getDeclaredConstructor().newInstance();


            systemManager.getTownHallSystem().addToTownHall(unit);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void ShowBorders(){
        systemManager.getBoardSystem().showTerritory();
    }

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


    public void stationWorker() {
        systemManager.getWorkSystem().stationWorker();
    }

    public void unstationWorker() {
        systemManager.getWorkSystem().unstationWorker();
    }


    public void build() {
//        System.out.println("Build inside controller called ");
        systemManager.getBuildSystem().buildStructure(Farm.class);
    }

    public void build(Class<? extends Building> buildingClass) {
        systemManager.getBuildSystem().buildStructure(buildingClass);
    }


    public void exploreSurroundings() {
        systemManager.getExplorationSystem().exploreSurroundings();
    }


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
import StartGame.MusicSettings;

public class Game {
    private World world;
    private TurnManager turnManager;
    private SystemManager systemManager;
    private AnimationManager animationManager;
    private ControllerManager controllerManager;
    private ViewManager viewManager;
    private Starter starter;
    private final MusicSettings musicSettings = new MusicSettings();

    MusicPlayer musicPlayer = new MusicPlayer();

    public Game() {
        animationManager = new AnimationManager();
        world = new World();
        turnManager = new TurnManager();
        systemManager = new SystemManager(world , animationManager , turnManager);
        controllerManager = new ControllerManager(systemManager , world);
        viewManager = new ViewManager(systemManager.getDrawingSystem(), controllerManager, world, turnManager,
                systemManager.getViewState(), systemManager.getUnitPanelRegistry());
        animationManager.setGameEngine(viewManager.getGameEngine());
        starter = new Starter(world);
    }

    public void start(){
        world.Start();
        viewManager.StartGame();
    }

    public void play(){
        musicPlayer.setVolume(musicSettings.getVolume());
        musicPlayer.playLoop("/Song/06-Ramin-Djawadi-Love-In-The-Eyes.wav");
    }

    public MusicPlayer getMusicPlayer() {
        return musicPlayer;
    }

    public MusicSettings getMusicSettings() {
        return musicSettings;
    }

    public TurnManager getTurnManager() { return turnManager; }
    public SystemManager getSystemManager() { return systemManager; }
    public AnimationManager getAnimationManager() { return animationManager; }
    public ControllerManager getControllerManager() { return controllerManager; }
    public ViewManager getViewManager() { return viewManager; }
    public Starter getStarter() { return starter; }
    public World getWorld() { return world; }
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


        if (gameEngine != null) {
            gameEngine.refresh();
        }

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
        boardController = new BoardController(world, systemManager.getMovementSystem(),
                systemManager.getBoardSystem(), systemManager.getSelectSystem(), systemManager.getEventBus());

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
import Game.Systems.EventSystem.EventBus;
import Game.Systems.EventSystem.EventSubscriberRegistry;
import Game.Systems.Listeners.ListenerSystem;
import Game.Presentation.DrawingState;
import Game.Presentation.UnitPanelRegistry;
import Game.Presentation.ViewState;
import Game.World;

public class SystemManager {
    private final ListenerSystem listenerSystem;
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
    private NotificationSystem notificationSystem;
    private final EventBus eventBus;
    private final EventSubscriberRegistry registry;
    private final DrawingState drawingState;
    private final ViewState viewState;
    private final UnitPanelRegistry unitPanelRegistry;
    public SystemManager(World world, AnimationManager animationManager, TurnManager turnManager) {
        eventBus = new EventBus();
        drawingState = new DrawingState();
        viewState = new ViewState();
        unitPanelRegistry = new UnitPanelRegistry();

        this.world = world;
        this.animationManager = animationManager;
        this.turnManager = turnManager;
        this.starvationSystem = new StarvationSystem(world, eventBus);
        this.restarterSystem = new RestarterSystem(starvationSystem , world);
        this.listenerSystem = new ListenerSystem(world, animationManager, turnManager, restarterSystem,
                eventBus, drawingState, viewState);
        this.selectSystem = new SelectSystem(eventBus);
        this.boardSystem = new BoardSystem(eventBus, world.getHexManager(), drawingState);


        this.drawingSystem = new DrawingSystem(world, selectSystem, drawingState);
        this.notificationSystem = new NotificationSystem(drawingSystem , animationManager);

        this.listenerSystem.setExtraDrawer(this.drawingSystem.getExtraDrawer());
        this.listenerSystem.getSelectListener().setExtraDrawer(this.drawingSystem.getExtraDrawer());
        this.listenerSystem.setNotificationSystem(notificationSystem);
        this.townHallSystem = new TownHallSystem(world, eventBus);
        this.movementSystem = new MovementSystem(this.selectSystem,eventBus);
        this.buildSystem = new BuildSystem(this.selectSystem, eventBus);
        this.workSystem = new WorkSystem(this.selectSystem, eventBus);
        this.explorationSystem = new ExplorationSystem(this.selectSystem, eventBus);

        registry = new EventSubscriberRegistry(eventBus, listenerSystem, townHallSystem, viewState);
        registry.registerAll();
    }



    public ListenerSystem getEventSystem() {
        return listenerSystem;
    }

    public EventBus getEventBus() {
        return eventBus;
    }

    public DrawingState getDrawingState() {
        return drawingState;
    }

    public ViewState getViewState() {
        return viewState;
    }

    public UnitPanelRegistry getUnitPanelRegistry() {
        return unitPanelRegistry;
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
import Game.Presentation.UnitPanelRegistry;
import Game.Presentation.ViewState;
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

    public ViewManager(DrawingSystem drawingSystem, ControllerManager controllerManager, World world,
                       TurnManager turnManager, ViewState viewState, UnitPanelRegistry unitPanelRegistry) {
        this.drawingSystem = drawingSystem;
        this.world = world;
        this.controllerManager = controllerManager;
        boardMouseListener = new BoardMouseListener(controllerManager.getBoardController());
        this.turnManager = turnManager;
        gameEngine = new GameEngine(drawingSystem, boardMouseListener, viewState, unitPanelRegistry,
                controllerManager, turnManager, world);

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

# File: src/Game/MusicPlayer.java

```java
package Game;

import javax.sound.sampled.*;
import java.io.BufferedInputStream;
import java.io.InputStream;

public class MusicPlayer {

    private Clip clip;
    private FloatControl gainControl;
    private FloatControl volumeControl;
    private float pendingVolume = 0.7f;

    public void playLoop(String classpathPath) {
        try (InputStream raw = MusicPlayer.class.getResourceAsStream(classpathPath)) {
            if (raw == null) {
                System.err.println("MusicPlayer: resource not found on classpath: " + classpathPath);
                return;
            }
            AudioInputStream audioStream =
                    AudioSystem.getAudioInputStream(new BufferedInputStream(raw));

            clip = AudioSystem.getClip();
            clip.open(audioStream);

            gainControl = null;
            volumeControl = null;
            if (clip.isControlSupported(FloatControl.Type.MASTER_GAIN)) {
                gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            } else if (clip.isControlSupported(FloatControl.Type.VOLUME)) {
                volumeControl = (FloatControl) clip.getControl(FloatControl.Type.VOLUME);
            }
            applyVolume(pendingVolume);

            clip.loop(Clip.LOOP_CONTINUOUSLY);
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void stop() {
        if (clip != null) {
            clip.stop();
            clip.close();
        }
    }

    public void setVolume(float linear) {
        pendingVolume = Math.max(0f, Math.min(1f, linear));
        applyVolume(pendingVolume);
    }

    private void applyVolume(float linear) {
        float clamped = Math.max(0.0001f, Math.min(1f, linear));
        if (gainControl != null) {
            float dB = (float) (Math.log10(clamped) * 20.0);
            dB = Math.max(gainControl.getMinimum(), Math.min(gainControl.getMaximum(), dB));
            gainControl.setValue(dB);
        } else if (volumeControl != null) {
            float value = volumeControl.getMinimum() + clamped * (volumeControl.getMaximum() - volumeControl.getMinimum());
            volumeControl.setValue(value);
        }
    }
}
```

---

# File: src/Game/Presentation/DrawingState.java

```java
package Game.Presentation;

import Models.Elements.Hex.Hex;

import java.util.List;

public class DrawingState {
    private List<Hex> path;
    private Hex goalHex;
    private boolean showBorder;

    public List<Hex> getPath() {
        return path;
    }

    public void setPath(List<Hex> path) {
        this.path = path;
    }

    public Hex getGoalHex() {
        return goalHex;
    }

    public void setGoalHex(Hex goalHex) {
        this.goalHex = goalHex;
    }

    public boolean isShowBorder() {
        return showBorder;
    }

    public void setShowBorder(boolean showBorder) {
        this.showBorder = showBorder;
    }
}

```

---

# File: src/Game/Presentation/UnitPanelRegistry.java

```java
package Game.Presentation;

import Game.Views.UnitPanel.BorderExpanderUnitPanel;
import Game.Views.UnitPanel.BuilderUnitPanel;
import Game.Views.UnitPanel.ExplorerUnitPanel;
import Game.Views.UnitPanel.WorkerUnitPanel;
import Models.Elements.Units.BorderExpander;
import Models.Elements.Units.Builder;
import Models.Elements.Units.Explorer;
import Models.Elements.Units.Unit;
import Models.Elements.Units.Worker;

import javax.swing.JPanel;
import java.util.HashMap;
import java.util.Map;

public class UnitPanelRegistry {
    private final Map<Class<? extends Unit>, Class<? extends JPanel>> panelByUnitClass = new HashMap<>();

    public UnitPanelRegistry() {
        panelByUnitClass.put(Worker.class, WorkerUnitPanel.class);
        panelByUnitClass.put(Explorer.class, ExplorerUnitPanel.class);
        panelByUnitClass.put(BorderExpander.class, BorderExpanderUnitPanel.class);
        panelByUnitClass.put(Builder.class, BuilderUnitPanel.class);
    }

    public Class<? extends JPanel> getPanelClass(Class<? extends Unit> unitClass) {
        return panelByUnitClass.get(unitClass);
    }

    public void register(Class<? extends Unit> unitClass, Class<? extends JPanel> panelClass) {
        panelByUnitClass.put(unitClass, panelClass);
    }
}

```

---

# File: src/Game/Presentation/ViewState.java

```java
package Game.Presentation;

import Models.Elements.Buildings.TownHall;
import Models.Elements.Hex.Hex;
import Models.Elements.Units.Unit;

public class ViewState {
    private Unit selectedUnit;
    private Hex selectedHex;
    private boolean starvation;
    private TownHall townHall;
    private String message;

    public Unit getSelectedUnit() {
        return selectedUnit;
    }

    public void setSelectedUnit(Unit selectedUnit) {
        this.selectedUnit = selectedUnit;
    }

    public Hex getSelectedHex() {
        return selectedHex;
    }

    public void setSelectedHex(Hex selectedHex) {
        this.selectedHex = selectedHex;
    }

    public boolean isStarvation() {
        return starvation;
    }

    public void setStarvation(boolean starvation) {
        this.starvation = starvation;
    }

    public TownHall getTownHall() {
        return townHall;
    }

    public void setTownHall(TownHall townHall) {
        this.townHall = townHall;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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
import Models.Elements.Hex.ForestHex;
import Models.Elements.Hex.GrassHex;
import Models.Elements.Hex.Hex;
import Models.Elements.Hex.LandHex;
import Models.Elements.Units.*;
import Models.Logic.BuildingLogic.TownHallLogic;
import Models.Logic.HexLogic.HexLogic;
import Models.Records.HexRecord;
import Models.Records.UnitRecord;

import java.util.ArrayList;

public class Starter {
    private final World world;

    public Starter(World world) {
        this.world = world;
    }
    public void start(){
        Hex hex = HexLogic.findByQR(0 , 0);

        HexLogic.discover(hex);

        ArrayList<Hex> neighbors = HexLogic.getNeighbors(hex);
        hex.setBorder(true);
        for (Hex hex1:neighbors)
            hex1.setBorder(true);

        Worker worker = new Worker();
        worker.setHex(hex);
        Worker worker1 = new Worker();
        worker1.setHex(hex);
        world.getUnitRecord().add(worker);
        world.getUnitRecord().add(worker1);
        Explorer explorer = new Explorer();
        explorer.setHex(hex);
        world.getUnitRecord().add(explorer);
        Builder builder1 = new Builder();
        builder1.setHex(hex);
        world.getUnitRecord().add(builder1);
        Builder builder = new Builder();
        builder.setHex(hex);
        world.getUnitRecord().add(builder);

        UnitPositionCalculator.refreshHex(hex, worker);
    }
}
```

---

# File: src/Game/Systems/BoardSystem.java

```java
package Game.Systems;

import Game.Systems.EventSystem.EventBus;
import Game.Systems.EventSystem.Events.BoardPannedEvent;
import Game.Systems.EventSystem.Events.BoardZoomChangedEvent;
import Game.Systems.EventSystem.Events.TerritoryDisplayChangedEvent;
import Game.Presentation.DrawingState;
import Models.Manager.HexManager;

public class BoardSystem {
    private final EventBus eventBus;

    private final HexManager hexManager;

    private final DrawingState drawingState;

    public BoardSystem(EventBus eventBus, HexManager hexManager, DrawingState drawingState) {
        this.eventBus = eventBus;
        this.hexManager = hexManager;
        this.drawingState = drawingState;
    }


    public void zoom(int rotate) {
        eventBus.publish(new BoardZoomChangedEvent(rotate));
    }

    public void moveBoard(int x , int y) {
        hexManager.pan(x , y);
        eventBus.publish(new BoardPannedEvent(x, y));
    }
    public void showTerritory(){
        drawingState.setShowBorder(!drawingState.isShowBorder());
        eventBus.publish(new TerritoryDisplayChangedEvent(drawingState.isShowBorder()));
    }

}

```

---

# File: src/Game/Systems/Drawers/BorderDrawer.java

```java
package Game.Systems.Drawers;

import Game.World;
import Game.Presentation.DrawingState;
import Models.Elements.Hex.Hex;

import java.awt.*;

public class BorderDrawer {
    private final World world;
    private final DrawingState drawingState;

    public BorderDrawer(World world, DrawingState drawingState) {
        this.world = world;
        this.drawingState = drawingState;
    }
    public void draw(Graphics g){
        if (!drawingState.isShowBorder())
            return;
        for (Hex hex : world.getHexRecord().getAll())
            if (hex.isBorder())
                drawBorder(hex , g);

    }
    public void drawBorder(Hex hex  , Graphics g){
        int drawX = hex.getDrawX();
        int drawY = hex.getDrawY();
        g.setColor(new Color(246, 212, 97));
        Graphics2D g2 = (Graphics2D)g ;
        g2.setStroke(new BasicStroke(0.3f));
        g2.drawOval((int) (drawX + hex.getSize() * 1.1), (int) (drawY  + hex.getSize() * 0.1), (int) (hex.getSize() *1.6), (int) (hex.getSize() * 1.6));
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

# File: src/Game/Systems/Drawers/DrawMessages.java

```java
package Game.Systems.Drawers;

import Models.Elements.Messages.Message;
import java.awt.Graphics;

public class DrawMessages {
    private Message activeMessage;

    public void setActiveMessage(Message message) {
        this.activeMessage = message;
    }

    public void draw(Graphics g) {
        if (activeMessage != null && activeMessage.isActive()) {
            activeMessage.getDraw().draw(g);
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

import Game.Presentation.DrawingState;
import Models.Elements.Hex.Hex;

import java.awt.*;
import java.util.List;

public class PathDrawer {
    private final DrawingState drawingState;

    public PathDrawer(DrawingState drawingState) {
        this.drawingState = drawingState;
    }

    public void draw(Graphics g) {
        List<Hex> path = drawingState.getPath();


        if (path == null || path.size() < 2) {
            return;
        }

        Graphics2D g2d = (Graphics2D) g;


        Color originalColor = g2d.getColor();
        Stroke originalStroke = g2d.getStroke();


        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setStroke(new BasicStroke(4.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));


        g2d.setColor(new Color(255, 235, 120, 200));


        for (int i = 0; i < path.size() - 1; i++) {
            Hex current = path.get(i);
            Hex next = path.get(i + 1);



            int x1 = current.getCenterX();
            int y1 = current.getCenterY();
            int x2 = next.getCenterX();
            int y2 = next.getCenterY();

            g2d.drawLine(x1, y1, x2, y2);
        }


        Hex goal = drawingState.getGoalHex();
        if (goal != null) {
            int radius = 8;
            g2d.fillOval(goal.getCenterX() - radius, goal.getCenterY() - radius, radius * 2, radius * 2);
        }


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
    private Unit selectedUnit;

    public SelectDrawer(SelectSystem selectSystem, World world) {
        this.selectSystem = selectSystem;
        this.world = world;
    }

    public void draw(Graphics g) {

        if (selectedHex != null && selectedHex.isVisible()) {
            drawSelectedHex(g);
        }


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


        int selectionRadius = (int) (unitSize * 1.3);
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
import Game.Presentation.DrawingState;
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
    private final BorderDrawer borderDrawer;
    private DrawMessages drawMessages = new DrawMessages();
    public DrawingSystem(World world, SelectSystem selectSystem, DrawingState drawingState) {
        this.world = world;
        drawBuildings = new DrawBuildings(world.getBuildingRecord());
        drawHexes = new DrawHexes(world.getHexRecord());
        drawUnits = new DrawUnits(world.getUnitRecord());
        this.selectSystem = selectSystem;
        extraDrawer = new SelectDrawer(selectSystem , world);
        pathDrawer = new PathDrawer(drawingState);
        borderDrawer = new BorderDrawer(world, drawingState);
    }

    public void draw(Graphics g) {
        drawHexes.draw(g);
        drawBuildings.draw(g);
        drawUnits.draw(g);
        extraDrawer.draw(g);
        pathDrawer.draw(g);
        borderDrawer.draw(g);
        drawMessages.draw(g);
    }

    public SelectDrawer getExtraDrawer() {
        return extraDrawer;
    }

    public DrawMessages getDrawMessages() {

        return drawMessages;
    }
}

```

---

# File: src/Game/Systems/ElementSystem/BuildSystem.java

```java
package Game.Systems.ElementSystem;

import Game.Systems.EventSystem.EventBus;
import Game.Systems.EventSystem.Events.BuildingConstructedEvent;
import Game.Systems.EventSystem.Events.NotificationRequestedEvent;
import Game.Systems.EventSystem.Events.SettlementConstructedEvent;
import Game.Systems.SelectSystem;
import Game.Systems.TownHallSystem;
import Models.Elements.Buildings.Building;
import Models.Elements.Buildings.Settlement;
import Models.Elements.Units.Builder;
import Models.Logic.BuildingLogic.BuildingLogic;

public class BuildSystem {
    private final SelectSystem selectSystem;
    private final EventBus eventBus;

    public BuildSystem(SelectSystem selectSystem, EventBus eventBus) {
        this.selectSystem = selectSystem;
        this.eventBus = eventBus;
    }


    public void buildStructure(Class<? extends Building> buildingClass) {
        if (!(selectSystem.getSelectedUnit() instanceof Builder)) {
            eventBus.publish(new NotificationRequestedEvent("No active Builder selected."));
            return;
        }

        Builder builder = (Builder) selectSystem.getSelectedUnit();
        try {
            Building newBuilding = BuildingLogic.Build(builder, buildingClass);
            if (buildingClass.equals(Settlement.class)) {
                eventBus.publish(new SettlementConstructedEvent((Settlement) newBuilding, builder.getHex()));
            } else {
                eventBus.publish(new BuildingConstructedEvent(newBuilding, builder.getHex()));
            }
        } catch (Exception e) {
//            e.printStackTrace();
           eventBus.publish(new NotificationRequestedEvent(e.getMessage()));
        }
    }
}

```

---

# File: src/Game/Systems/ElementSystem/ExplorationSystem.java

```java
package Game.Systems.ElementSystem;

import Game.Systems.EventSystem.EventBus;
import Game.Systems.EventSystem.Events.BorderExpandedEvent;
import Game.Systems.EventSystem.Events.HexExploredEvent;
import Game.Systems.EventSystem.Events.NotificationRequestedEvent;
import Game.Systems.SelectSystem;
import Models.Elements.Units.Explorer;
import Models.Elements.Units.BorderExpander;
import Models.Logic.UnitLogic.ExplorerLogic;
import Models.Logic.UnitLogic.BorderExpanderLogic;

public class ExplorationSystem {
    private final SelectSystem selectSystem;
    private final EventBus eventBus;

    public ExplorationSystem(SelectSystem selectSystem, EventBus eventBus) {
        this.selectSystem = selectSystem;
        this.eventBus = eventBus;
    }


    public void exploreSurroundings() {

        if (!(selectSystem.getSelectedUnit() instanceof Explorer)) {

            eventBus.publish(new NotificationRequestedEvent("No active Explorer selected."));
            return;
        }

        Explorer explorer = (Explorer) selectSystem.getSelectedUnit();
        ExplorerLogic logic = (ExplorerLogic) explorer.getLogic();

        try {
            logic.Explore();
            eventBus.publish(new HexExploredEvent(explorer, explorer.getHex()));
        } catch (Exception e) {
            eventBus.publish(new NotificationRequestedEvent(e.getMessage()));
        }
    }
    public void expandBorder() {
        if (!(selectSystem.getSelectedUnit() instanceof BorderExpander)) {
            eventBus.publish(new NotificationRequestedEvent("No active BorderExpander selected."));
            return;
        }

        BorderExpander expander = (BorderExpander) selectSystem.getSelectedUnit();
        BorderExpanderLogic logic = (BorderExpanderLogic) expander.getLogic();

        try {
            logic.addToBorder();
            eventBus.publish(new BorderExpandedEvent(expander, expander.getHex()));
        } catch (Exception e) {
            eventBus.publish(new NotificationRequestedEvent(e.getMessage()));
        }
    }
}

```

---

# File: src/Game/Systems/ElementSystem/MovementSystem.java

```java
package Game.Systems.ElementSystem;

import Game.Systems.EventSystem.EventBus;
import Game.Systems.EventSystem.Events.MoveEvent;
import Game.Systems.SelectSystem;
import Models.Elements.Hex.Hex;
import Models.Elements.Units.Unit;
import Models.Elements.Units.Worker;
import Models.Logic.UnitLogic.FindBestPath;

public class MovementSystem {
    private final SelectSystem selectSystem;
    private final EventBus eventBus;
    public MovementSystem(SelectSystem selectSystem,EventBus eventBus) {
        this.selectSystem = selectSystem;
        this.eventBus = eventBus;
    }

    public void UnitMove() {
        Unit currentUnit = selectSystem.getSelectedUnit();
        Hex targetHex = selectSystem.getSelectedHex();
        if (!selectSystem.isReadyToMove())
            return;
        if (currentUnit == null) {
            return;
        }

        if (currentUnit instanceof Worker worker && worker.isWorking()) {
            return;
        }

        if (targetHex == null) {
            return;
        }

        Hex unitCurrentHex = currentUnit.getHex();


        if (targetHex.equals(unitCurrentHex)) {
            return;
        }

        eventBus.publish(new MoveEvent(currentUnit , unitCurrentHex , targetHex));
        FindBestPath bestPath = new FindBestPath(unitCurrentHex , targetHex);
        try {
            currentUnit.getLogic().cost(bestPath.CalculateTotalCost());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        selectSystem.selectUnit(null);
        selectSystem.setReadyToMove(false);

    }
}

```

---

# File: src/Game/Systems/ElementSystem/StarvationSystem.java

```java
package Game.Systems.ElementSystem;

import Game.World;
import Game.Systems.EventSystem.EventBus;
import Game.Systems.EventSystem.Events.StarvationStateChangedEvent;
import Models.Elements.Buildings.Building;
import Models.Elements.Resources.Food;
import Models.Elements.Resources.Resource;
import Models.Elements.Units.Unit;
import Models.Logic.UnitLogic.UnitLogic;

import java.util.Map;

public final class StarvationSystem {
    private World world;
    private final EventBus eventBus;

    public StarvationSystem(World world, EventBus eventBus) {
        this.world = world;
        this.eventBus = eventBus;
    }


    public  void StarvationCheck() {
        int totalNeed = 0;
        for (Unit unit : world.getUnitRecord().getAll()) {
            totalNeed += unit.getFoodNeed();
        }

        if (world.getResourceRecord().getAll(Food.class).size() < totalNeed) {
            setStarvationEffects();
            eventBus.publish(new StarvationStateChangedEvent(true));
        }else{
            eventBus.publish(new StarvationStateChangedEvent(false));
        }
    }


    public  void setStarvationEffects() {
        System.out.println("Set Starvation Effect called ");
        for (Unit unit : world.getUnitRecord().getAll()) {
            try {
                new UnitLogic(unit).cost(1);
                System.out.println(unit.getAP());
            } catch (Exception ignored) {
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

import Game.Systems.EventSystem.EventBus;
import Game.Systems.EventSystem.Events.NotificationRequestedEvent;
import Game.Systems.EventSystem.Events.WorkerActionFailedEvent;
import Game.Systems.EventSystem.Events.WorkerStationedEvent;
import Game.Systems.EventSystem.Events.WorkerUnstationedEvent;
import Game.Systems.SelectSystem;
import Models.Elements.Buildings.Building;
import Models.Elements.Units.Worker;
import Models.Logic.UnitLogic.WorkerLogic;

public class WorkSystem {
    private final SelectSystem selectSystem;
    private final EventBus eventBus;

    public WorkSystem(SelectSystem selectSystem, EventBus eventBus) {
        this.selectSystem = selectSystem;
        this.eventBus = eventBus;
    }


    public void stationWorker() {
        if (!(selectSystem.getSelectedUnit() instanceof Worker)) {
            eventBus.publish(new NotificationRequestedEvent("No active Worker selected"));
            return;
        }
        if (selectSystem.getSelectedHex() == null || selectSystem.getSelectedHex().getBuilding() == null) {
            eventBus.publish(new NotificationRequestedEvent("Target Hex does not contain a building"));
            return;
        }

        Worker worker = (Worker) selectSystem.getSelectedUnit();
        Building building = selectSystem.getSelectedHex().getBuilding();
        WorkerLogic logic = (WorkerLogic) worker.getLogic();

        try {
            logic.GetInBuilding(building);
            eventBus.publish(new WorkerStationedEvent(worker, building));
        } catch (Exception e) {
            eventBus.publish(new NotificationRequestedEvent(e.getMessage()));
        }
    }


    public void unstationWorker() {
        if (!(selectSystem.getSelectedUnit() instanceof Worker)) {
            eventBus.publish(new WorkerActionFailedEvent("No active Worker selected."));
            return;
        }

        Worker worker = (Worker) selectSystem.getSelectedUnit();
        WorkerLogic logic = (WorkerLogic) worker.getLogic();

        try {
            logic.GetOffBuilding();
            eventBus.publish(new WorkerUnstationedEvent(worker));
        } catch (Exception e) {
            eventBus.publish(new NotificationRequestedEvent(e.getMessage()));
        }
    }
}

```

---

# File: src/Game/Systems/EventSystem/EventBus.java

```java
package Game.Systems.EventSystem;

import Game.Systems.EventSystem.Events.Event;

import java.util.*;
import java.util.function.Consumer;

/**
 * Central communication hub between game systems.
 *
 * Systems publish events when something has already happened.
 * Other systems subscribe to event types they are interested in.
 *
 * The bus is synchronous: listeners are called immediately
 * in the order they were registered.
 */
public class EventBus {

    private final Map<Class<? extends Event>, List<Consumer<? extends Event>>> listeners;

    public EventBus() {
        this.listeners = new HashMap<>();
    }

    /**
     * Register a listener for a specific event type.
     */
    public <T extends Event> void subscribe(
            Class<T> eventType,
            Consumer<T> listener
    ) {
        listeners
                .computeIfAbsent(eventType, k -> new ArrayList<>())
                .add(listener);
    }

    /**
     * Remove a previously registered listener.
     */
    public <T extends Event> void unsubscribe(
            Class<T> eventType,
            Consumer<T> listener
    ) {
        List<Consumer<? extends Event>> eventListeners = listeners.get(eventType);
        if (eventListeners != null) {
            eventListeners.remove(listener);
        }
    }

    /**
     * Broadcast an event to all subscribers of that event type.
     */
    @SuppressWarnings("unchecked")
    public <T extends Event> void publish(T event) {
        List<Consumer<? extends Event>> eventListeners = listeners.get(event.getClass());

        if (eventListeners == null) {
            System.out.println("null");
            return;
        }

        for (Consumer<? extends Event> listener : eventListeners) {
            ((Consumer<T>) listener).accept(event);
        }
    }

    /**
     * Remove all registered listeners.
     * Useful when resetting or loading a game.
     */
    public void clear() {
        listeners.clear();
    }
}
```

---

# File: src/Game/Systems/EventSystem/Events/ActionPointsRestoredEvent.java

```java
package Game.Systems.EventSystem.Events;

import Models.Elements.Units.Unit;
import java.util.List;

/** Published by UnitRestarter after action points are restored. */
public class ActionPointsRestoredEvent implements Event {
    private List<Unit> units;

    public ActionPointsRestoredEvent(List<Unit> units) { this.units = units; }
    public List<Unit> getUnits() { return units; }
    public void setUnits(List<Unit> units) { this.units = units; }
}

```

---

# File: src/Game/Systems/EventSystem/Events/BoardPannedEvent.java

```java
package Game.Systems.EventSystem.Events;

/** Presentation event published by BoardSystem after panning. */
public class BoardPannedEvent implements Event {
    private int deltaX;
    private int deltaY;

    public BoardPannedEvent(int deltaX, int deltaY) { this.deltaX = deltaX; this.deltaY = deltaY; }
    public int getDeltaX() { return deltaX; }
    public void setDeltaX(int deltaX) { this.deltaX = deltaX; }
    public int getDeltaY() { return deltaY; }
    public void setDeltaY(int deltaY) { this.deltaY = deltaY; }
}

```

---

# File: src/Game/Systems/EventSystem/Events/BoardZoomChangedEvent.java

```java
package Game.Systems.EventSystem.Events;

/** Presentation event published by BoardSystem after a zoom request. */
public class BoardZoomChangedEvent implements Event {
    private int zoomDelta;

    public BoardZoomChangedEvent(int zoomDelta) { this.zoomDelta = zoomDelta; }
    public int getZoomDelta() { return zoomDelta; }
    public void setZoomDelta(int zoomDelta) { this.zoomDelta = zoomDelta; }
}

```

---

# File: src/Game/Systems/EventSystem/Events/BorderExpandedEvent.java

```java
package Game.Systems.EventSystem.Events;

import Models.Elements.Hex.Hex;
import Models.Elements.Units.BorderExpander;

/** Published by ExplorationSystem after territory is claimed. */
public class BorderExpandedEvent implements Event {
    private BorderExpander expander;
    private Hex claimedHex;

    public BorderExpandedEvent(BorderExpander expander, Hex claimedHex) { this.expander = expander; this.claimedHex = claimedHex; }
    public BorderExpander getExpander() { return expander; }
    public void setExpander(BorderExpander expander) { this.expander = expander; }
    public Hex getClaimedHex() { return claimedHex; }
    public void setClaimedHex(Hex claimedHex) { this.claimedHex = claimedHex; }
}

```

---

# File: src/Game/Systems/EventSystem/Events/BuildingConstructedEvent.java

```java
package Game.Systems.EventSystem.Events;

import Models.Elements.Buildings.Building;
import Models.Elements.Hex.Hex;

/** Published by BuildSystem after a building is placed. */
public class BuildingConstructedEvent implements Event {
    private Building building;
    private Hex hex;

    public BuildingConstructedEvent(Building building, Hex hex) { this.building = building; this.hex = hex; }
    public Building getBuilding() { return building; }
    public void setBuilding(Building building) { this.building = building; }
    public Hex getHex() { return hex; }
    public void setHex(Hex hex) { this.hex = hex; }
}

```

---

# File: src/Game/Systems/EventSystem/Events/BuildingDecayedEvent.java

```java
package Game.Systems.EventSystem.Events;

import Models.Elements.Buildings.Building;
import Models.Elements.Hex.Hex;

/** Published by BuildingRestarter after an unpaid building decays. */
public class BuildingDecayedEvent implements Event {
    private Building building;
    private Hex hex;

    public BuildingDecayedEvent(Building building, Hex hex) { this.building = building; this.hex = hex; }
    public Building getBuilding() { return building; }
    public void setBuilding(Building building) { this.building = building; }
    public Hex getHex() { return hex; }
    public void setHex(Hex hex) { this.hex = hex; }
}

```

---

# File: src/Game/Systems/EventSystem/Events/BuildingUpkeepFailedEvent.java

```java
package Game.Systems.EventSystem.Events;

import Models.Elements.Buildings.Building;

/** Published by BuildingRestarter when a building cannot pay upkeep. */
public class BuildingUpkeepFailedEvent implements Event {
    private Building building;
    private int decayCountdown;

    public BuildingUpkeepFailedEvent(Building building, int decayCountdown) { this.building = building; this.decayCountdown = decayCountdown; }
    public Building getBuilding() { return building; }
    public void setBuilding(Building building) { this.building = building; }
    public int getDecayCountdown() { return decayCountdown; }
    public void setDecayCountdown(int decayCountdown) { this.decayCountdown = decayCountdown; }
}

```

---

# File: src/Game/Systems/EventSystem/Events/EndTurnRequestedEvent.java

```java
package Game.Systems.EventSystem.Events;

/** Published by BoardController when the player ends the current turn. */
public class EndTurnRequestedEvent implements Event {
    public EndTurnRequestedEvent() {
    }
}

```

---

# File: src/Game/Systems/EventSystem/Events/Event.java

```java
package Game.Systems.EventSystem.Events;

public interface Event {
}
```

---

# File: src/Game/Systems/EventSystem/Events/FoodDepletedEvent.java

```java
package Game.Systems.EventSystem.Events;

/** Published by UnitRestarter when food cannot meet all unit needs. */
public class FoodDepletedEvent implements Event {
    public FoodDepletedEvent() {
    }
}

```

---

# File: src/Game/Systems/EventSystem/Events/HexExploredEvent.java

```java
package Game.Systems.EventSystem.Events;

import Models.Elements.Hex.Hex;
import Models.Elements.Units.Explorer;

/** Published by ExplorationSystem after territory is revealed. */
public class HexExploredEvent implements Event {
    private Explorer explorer;
    private Hex originHex;

    public HexExploredEvent(Explorer explorer, Hex originHex) { this.explorer = explorer; this.originHex = originHex; }
    public Explorer getExplorer() { return explorer; }
    public void setExplorer(Explorer explorer) { this.explorer = explorer; }
    public Hex getOriginHex() { return originHex; }
    public void setOriginHex(Hex originHex) { this.originHex = originHex; }
}

```

---

# File: src/Game/Systems/EventSystem/Events/HexSelectionChangedEvent.java

```java
package Game.Systems.EventSystem.Events;

import Models.Elements.Hex.Hex;

/** Published by SelectSystem when the selected hex changes. */
public class HexSelectionChangedEvent implements Event {
    private Hex selectedHex;

    public HexSelectionChangedEvent(Hex selectedHex) { this.selectedHex = selectedHex; }
    public Hex getSelectedHex() { return selectedHex; }
    public void setSelectedHex(Hex selectedHex) { this.selectedHex = selectedHex; }
}

```

---

# File: src/Game/Systems/EventSystem/Events/MoveEvent.java

```java
package Game.Systems.EventSystem.Events;

import Models.Elements.Hex.Hex;
import Models.Elements.Units.Unit;

/** Published by MovementSystem after a move is accepted. */
public class MoveEvent implements Event {
    private Unit unit;
    private Hex currentHex;
    private Hex targetHex;


    public MoveEvent(Unit unit, Hex currentHex, Hex targetHex) {
        this.unit = unit;
        this.currentHex = currentHex;
        this.targetHex = targetHex;
//        this.movementCost = movementCost;
    }

    public Unit getUnit() { return unit; }
    public void setUnit(Unit unit) { this.unit = unit; }
    public Hex getCurrentHex() { return currentHex; }
    public void setCurrentHex(Hex currentHex) { this.currentHex = currentHex; }
    public Hex getTargetHex() { return targetHex; }
    public void setTargetHex(Hex targetHex) { this.targetHex = targetHex; }
//    public int getMovementCost() { return movementCost; }
//    public void setMovementCost(int movementCost) { this.movementCost = movementCost; }
}

```

---

# File: src/Game/Systems/EventSystem/Events/MovementPreviewChangedEvent.java

```java
package Game.Systems.EventSystem.Events;

import Models.Elements.Hex.Hex;
import java.util.List;

/** Published by SelectSystem while hovering a reachable hex. */
public class MovementPreviewChangedEvent implements Event {
    private List<Hex> path;
    private Hex goalHex;

    public MovementPreviewChangedEvent(List<Hex> path, Hex goalHex) { this.path = path; this.goalHex = goalHex; }
    public List<Hex> getPath() { return path; }
    public void setPath(List<Hex> path) { this.path = path; }
    public Hex getGoalHex() { return goalHex; }
    public void setGoalHex(Hex goalHex) { this.goalHex = goalHex; }
}

```

---

# File: src/Game/Systems/EventSystem/Events/NotificationRequestedEvent.java

```java
package Game.Systems.EventSystem.Events;

/** Published when the presentation layer should display a player-facing message. */
public class NotificationRequestedEvent implements Event {
    private String message;

    public NotificationRequestedEvent(String message) { this.message = message; }
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
}

```

---

# File: src/Game/Systems/EventSystem/Events/ProductionProgressedEvent.java

```java
package Game.Systems.EventSystem.Events;

import Models.Elements.Buildings.TownHall;
import Models.Elements.Units.Unit;

/** Published during turn processing when production advances. */
public class ProductionProgressedEvent implements Event {
    private TownHall townHall;
    private Unit unit;
    private int completedSteps;
    private int totalSteps;

    public ProductionProgressedEvent(TownHall townHall, Unit unit, int completedSteps, int totalSteps) { this.townHall = townHall; this.unit = unit; this.completedSteps = completedSteps; this.totalSteps = totalSteps; }
    public TownHall getTownHall() { return townHall; }
    public void setTownHall(TownHall townHall) { this.townHall = townHall; }
    public Unit getUnit() { return unit; }
    public void setUnit(Unit unit) { this.unit = unit; }
    public int getCompletedSteps() { return completedSteps; }
    public void setCompletedSteps(int completedSteps) { this.completedSteps = completedSteps; }
    public int getTotalSteps() { return totalSteps; }
    public void setTotalSteps(int totalSteps) { this.totalSteps = totalSteps; }
}

```

---

# File: src/Game/Systems/EventSystem/Events/ResourcesProducedEvent.java

```java
package Game.Systems.EventSystem.Events;

import Models.Elements.Resources.Resource;
import java.util.Map;

/** Published by BuildingRestarter after buildings add resources. */
public class ResourcesProducedEvent implements Event {
    private Map<Class<? extends Resource>, Integer> amounts;

    public ResourcesProducedEvent(Map<Class<? extends Resource>, Integer> amounts) { this.amounts = amounts; }
    public Map<Class<? extends Resource>, Integer> getAmounts() { return amounts; }
    public void setAmounts(Map<Class<? extends Resource>, Integer> amounts) { this.amounts = amounts; }
}

```

---

# File: src/Game/Systems/EventSystem/Events/SafeguardProducedEvent.java

```java
package Game.Systems.EventSystem.Events;

import Models.Elements.Resources.Resource;
import java.util.Map;

/** Published by TownHallRestarter after safeguard resources are added. */
public class SafeguardProducedEvent implements Event {
    private Map<Class<? extends Resource>, Integer> amounts;

    public SafeguardProducedEvent(Map<Class<? extends Resource>, Integer> amounts) { this.amounts = amounts; }
    public Map<Class<? extends Resource>, Integer> getAmounts() { return amounts; }
    public void setAmounts(Map<Class<? extends Resource>, Integer> amounts) { this.amounts = amounts; }
}

```

---

# File: src/Game/Systems/EventSystem/Events/SettlementConstructedEvent.java

```java
package Game.Systems.EventSystem.Events;

import Models.Elements.Buildings.Settlement;
import Models.Elements.Hex.Hex;

/** Published by BuildSystem after a Settlement is built. */
public class SettlementConstructedEvent implements Event {
    private Settlement settlement;
    private Hex hex;

    public SettlementConstructedEvent(Settlement settlement, Hex hex) { this.settlement = settlement; this.hex = hex; }
    public Settlement getSettlement() { return settlement; }
    public void setSettlement(Settlement settlement) { this.settlement = settlement; }
    public Hex getHex() { return hex; }
    public void setHex(Hex hex) { this.hex = hex; }
}

```

---

# File: src/Game/Systems/EventSystem/Events/StarvationStateChangedEvent.java

```java
package Game.Systems.EventSystem.Events;

/** Published by StarvationSystem whenever starvation changes. */
public class StarvationStateChangedEvent implements Event {
    private boolean starving;

    public StarvationStateChangedEvent(boolean starving) { this.starving = starving; }
    public boolean isStarving() { return starving; }
    public void setStarving(boolean starving) { this.starving = starving; }
}

```

---

# File: src/Game/Systems/EventSystem/Events/TerritoryDisplayChangedEvent.java

```java
package Game.Systems.EventSystem.Events;

/** Presentation event published by BoardSystem after territory visibility changes. */
public class TerritoryDisplayChangedEvent implements Event {
    private boolean visible;

    public TerritoryDisplayChangedEvent(boolean visible) { this.visible = visible; }
    public boolean isVisible() { return visible; }
    public void setVisible(boolean visible) { this.visible = visible; }
}

```

---

# File: src/Game/Systems/EventSystem/Events/TurnAdvancedEvent.java

```java
package Game.Systems.EventSystem.Events;

/** Published after end-of-turn processing completes. */
public class TurnAdvancedEvent implements Event {
    private int turnNumber;

    public TurnAdvancedEvent(int turnNumber) { this.turnNumber = turnNumber; }
    public int getTurnNumber() { return turnNumber; }
    public void setTurnNumber(int turnNumber) { this.turnNumber = turnNumber; }
}

```

---

# File: src/Game/Systems/EventSystem/Events/UnitProducedEvent.java

```java
package Game.Systems.EventSystem.Events;

import Models.Elements.Buildings.TownHall;
import Models.Elements.Units.Unit;

/** Published when Town Hall production creates a unit. */
public class UnitProducedEvent implements Event {
    private TownHall townHall;
    private Unit unit;

    public UnitProducedEvent(TownHall townHall, Unit unit) { this.townHall = townHall; this.unit = unit; }
    public TownHall getTownHall() { return townHall; }
    public void setTownHall(TownHall townHall) { this.townHall = townHall; }
    public Unit getUnit() { return unit; }
    public void setUnit(Unit unit) { this.unit = unit; }
}

```

---

# File: src/Game/Systems/EventSystem/Events/UnitProductionQueuedEvent.java

```java
package Game.Systems.EventSystem.Events;

import Models.Elements.Buildings.TownHall;
import Models.Elements.Units.Unit;

/** Published by TownHallSystem after a unit is added to the production queue. */
public class UnitProductionQueuedEvent implements Event {
    private TownHall townHall;
    private Unit unit;
    private int totalSteps;

    public UnitProductionQueuedEvent(TownHall townHall, Unit unit, int totalSteps) { this.townHall = townHall; this.unit = unit; this.totalSteps = totalSteps; }
    public TownHall getTownHall() { return townHall; }
    public void setTownHall(TownHall townHall) { this.townHall = townHall; }
    public Unit getUnit() { return unit; }
    public void setUnit(Unit unit) { this.unit = unit; }
    public int getTotalSteps() { return totalSteps; }
    public void setTotalSteps(int totalSteps) { this.totalSteps = totalSteps; }
}

```

---

# File: src/Game/Systems/EventSystem/Events/UnitRefreshRequestedEvent.java

```java
package Game.Systems.EventSystem.Events;

/** Published when the unit-related UI needs the existing refresh behavior. */
public class UnitRefreshRequestedEvent implements Event {
    public UnitRefreshRequestedEvent() {
    }
}

```

---

# File: src/Game/Systems/EventSystem/Events/UnitSelectionChangedEvent.java

```java
package Game.Systems.EventSystem.Events;

import Models.Elements.Units.Unit;

/** Published by SelectSystem when the selected unit changes. */
public class UnitSelectionChangedEvent implements Event {
    private Unit selectedUnit;

    public UnitSelectionChangedEvent(Unit selectedUnit) { this.selectedUnit = selectedUnit; }
    public Unit getSelectedUnit() { return selectedUnit; }
    public void setSelectedUnit(Unit selectedUnit) { this.selectedUnit = selectedUnit; }
}

```

---

# File: src/Game/Systems/EventSystem/Events/WorkerActionFailedEvent.java

```java
package Game.Systems.EventSystem.Events;

/** Published by WorkSystem when a worker action cannot be performed. */
public class WorkerActionFailedEvent implements Event {
    private String reason;

    public WorkerActionFailedEvent(String reason) {
        this.reason = reason;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}

```

---

# File: src/Game/Systems/EventSystem/Events/WorkerStationedEvent.java

```java
package Game.Systems.EventSystem.Events;

import Models.Elements.Buildings.Building;
import Models.Elements.Units.Worker;

/** Published by WorkSystem after a worker is assigned. */
public class WorkerStationedEvent implements Event {
    private Worker worker;
    private Building building;

    public WorkerStationedEvent(Worker worker, Building building) { this.worker = worker; this.building = building; }
    public Worker getWorker() { return worker; }
    public void setWorker(Worker worker) { this.worker = worker; }
    public Building getBuilding() { return building; }
    public void setBuilding(Building building) { this.building = building; }
}

```

---

# File: src/Game/Systems/EventSystem/Events/WorkerUnstationedEvent.java

```java
package Game.Systems.EventSystem.Events;

import Models.Elements.Units.Worker;

/** Published by WorkSystem after a worker leaves a building. */
public class WorkerUnstationedEvent implements Event {
    private Worker worker;

    public WorkerUnstationedEvent(Worker worker) { this.worker = worker; }
    public Worker getWorker() { return worker; }
    public void setWorker(Worker worker) { this.worker = worker; }
}

```

---

# File: src/Game/Systems/EventSystem/EventSubscriberRegistry.java

```java
package Game.Systems.EventSystem;

import Game.Systems.EventSystem.Events.ActionPointsRestoredEvent;
import Game.Systems.EventSystem.Events.BoardPannedEvent;
import Game.Systems.EventSystem.Events.BoardZoomChangedEvent;
import Game.Systems.EventSystem.Events.BorderExpandedEvent;
import Game.Systems.EventSystem.Events.BuildingConstructedEvent;
import Game.Systems.EventSystem.Events.BuildingDecayedEvent;
import Game.Systems.EventSystem.Events.BuildingUpkeepFailedEvent;
import Game.Systems.EventSystem.Events.EndTurnRequestedEvent;
import Game.Systems.EventSystem.Events.FoodDepletedEvent;
import Game.Systems.EventSystem.Events.HexExploredEvent;
import Game.Systems.EventSystem.Events.HexSelectionChangedEvent;
import Game.Systems.EventSystem.Events.MoveEvent;
import Game.Systems.EventSystem.Events.MovementPreviewChangedEvent;
import Game.Systems.EventSystem.Events.NotificationRequestedEvent;
import Game.Systems.EventSystem.Events.ProductionProgressedEvent;
import Game.Systems.EventSystem.Events.ResourcesProducedEvent;
import Game.Systems.EventSystem.Events.SafeguardProducedEvent;
import Game.Systems.EventSystem.Events.SettlementConstructedEvent;
import Game.Systems.EventSystem.Events.StarvationStateChangedEvent;
import Game.Systems.EventSystem.Events.TerritoryDisplayChangedEvent;
import Game.Systems.EventSystem.Events.TurnAdvancedEvent;
import Game.Systems.EventSystem.Events.UnitProducedEvent;
import Game.Systems.EventSystem.Events.UnitProductionQueuedEvent;
import Game.Systems.EventSystem.Events.UnitSelectionChangedEvent;
import Game.Systems.EventSystem.Events.UnitRefreshRequestedEvent;
import Game.Systems.EventSystem.Events.WorkerStationedEvent;
import Game.Systems.EventSystem.Events.WorkerActionFailedEvent;
import Game.Systems.EventSystem.Events.WorkerUnstationedEvent;
import Game.Systems.Listeners.ListenerSystem;
import Game.Systems.TownHallSystem;
import Game.Presentation.ViewState;

import java.util.Objects;

public final class EventSubscriberRegistry {
    private final EventBus eventBus;
    private final ListenerSystem listenerSystem;
    private final TownHallSystem townHallSystem;
    private final ViewState viewState;

    public EventSubscriberRegistry(EventBus eventBus, ListenerSystem listenerSystem,
                                   TownHallSystem townHallSystem, ViewState viewState) {
        this.eventBus = Objects.requireNonNull(eventBus);
        this.listenerSystem = Objects.requireNonNull(listenerSystem);
        this.townHallSystem = Objects.requireNonNull(townHallSystem);
        this.viewState = Objects.requireNonNull(viewState);
    }

    public void registerAll() {
        eventBus.subscribe(EndTurnRequestedEvent.class, event ->
                listenerSystem.getTurnListener().EndTurn());

        eventBus.subscribe(MoveEvent.class, event ->
                listenerSystem.getUnitListener().UnitMoved(
                        event.getCurrentHex(), event.getTargetHex(), event.getUnit()));

        eventBus.subscribe(UnitSelectionChangedEvent.class, event ->
                listenerSystem.getSelectListener().UnitSelected(event.getSelectedUnit()));

        eventBus.subscribe(HexSelectionChangedEvent.class, event ->
                listenerSystem.getSelectListener().HexSelected(event.getSelectedHex()));

        eventBus.subscribe(MovementPreviewChangedEvent.class, event ->
                listenerSystem.getSelectListener().likelyPath(event.getPath(), event.getGoalHex()));

        eventBus.subscribe(BuildingConstructedEvent.class, event ->
                listenerSystem.getBuildingEvent().BuildingConstructed(event.getBuilding(), event.getHex()));

        eventBus.subscribe(SettlementConstructedEvent.class, event -> {
            townHallSystem.addedASettlement();
            listenerSystem.getBuildingEvent().BuildingConstructed(event.getSettlement(), event.getHex());
        });

        eventBus.subscribe(WorkerStationedEvent.class, event ->
                listenerSystem.getWorkListener().WorkerStationed(event.getWorker(), event.getBuilding()));

        eventBus.subscribe(WorkerUnstationedEvent.class, event ->
                listenerSystem.getWorkListener().WorkerUnstationed(event.getWorker()));

        eventBus.subscribe(WorkerActionFailedEvent.class, event ->
                listenerSystem.getWorkListener().WorkerActionFailed(event.getReason()));

        eventBus.subscribe(HexExploredEvent.class, event ->
                listenerSystem.getExplorEvent().HexExplored(event.getOriginHex()));

        eventBus.subscribe(BorderExpandedEvent.class, event ->
                listenerSystem.getBoardExpandListener().BorderExpanded(event.getClaimedHex()));

        eventBus.subscribe(UnitProductionQueuedEvent.class, event ->
                listenerSystem.getTurnListener().Refresh());

        eventBus.subscribe(UnitRefreshRequestedEvent.class, event ->
                listenerSystem.getUnitListener().Refresh());

        eventBus.subscribe(ProductionProgressedEvent.class, event ->
                listenerSystem.getUnitListener().Refresh());

        eventBus.subscribe(UnitProducedEvent.class, event ->
                listenerSystem.getUnitListener().Refresh());

        eventBus.subscribe(TurnAdvancedEvent.class, event -> {
            listenerSystem.Notif("Turn Ended");
        });

        eventBus.subscribe(ResourcesProducedEvent.class, event ->
                listenerSystem.getUnitListener().Refresh());

        eventBus.subscribe(SafeguardProducedEvent.class, event ->
                listenerSystem.getUnitListener().Refresh());

        eventBus.subscribe(ActionPointsRestoredEvent.class, event ->
                listenerSystem.getUnitListener().Refresh());

        eventBus.subscribe(FoodDepletedEvent.class, event ->
                listenerSystem.Notif("Food has been depleted."));

        eventBus.subscribe(StarvationStateChangedEvent.class, event -> {
            viewState.setStarvation(event.isStarving());
        });

        eventBus.subscribe(BuildingUpkeepFailedEvent.class, event ->
                listenerSystem.getBuildingEvent().BuildingFailed(
                        event.getBuilding().getClass().getSimpleName()
                                + " could not pay upkeep (" + event.getDecayCountdown() + "/3)."));

        eventBus.subscribe(BuildingDecayedEvent.class, event ->
                listenerSystem.getBuildingEvent().BuildingFailed(
                        event.getBuilding().getClass().getSimpleName() + " decayed."));

        eventBus.subscribe(NotificationRequestedEvent.class, event ->
                listenerSystem.getNotificationSystem().showNotification(event.getMessage()));

        eventBus.subscribe(BoardZoomChangedEvent.class, event ->
                listenerSystem.getBoardEvent().Zoomed(event.getZoomDelta()));

        eventBus.subscribe(BoardPannedEvent.class, event ->
                listenerSystem.getBoardEvent().MoveInBoard());

        eventBus.subscribe(TerritoryDisplayChangedEvent.class, event -> {
            if (event.isVisible()) {
                listenerSystem.getBoardExpandListener().ShowBorder();
            } else {
                listenerSystem.getBoardExpandListener().HideBorder();
            }
        });
    }

}

```

---

# File: src/Game/Systems/Listeners/BoardExpandListener.java

```java
package Game.Systems.Listeners;

import Game.Managers.AnimationManager;
import Game.Presentation.DrawingState;
import Models.Elements.Hex.Hex;

public class BoardExpandListener extends Listener {
    private final DrawingState drawingState;

    public BoardExpandListener(AnimationManager animationManager, DrawingState drawingState) {
        super(animationManager);
        this.drawingState = drawingState;
    }

    public void BorderExpanded(Hex hex) {
        animationManager.refresh();
    }
    public void ShowBorder(){
        drawingState.setShowBorder(true);
        animationManager.refresh();
    }
    public void HideBorder(){
        drawingState.setShowBorder(false);
        animationManager.refresh();
    }
    public void BorderExpansionFailed(String reason) {}
}

```

---

# File: src/Game/Systems/Listeners/BoardListener.java

```java
package Game.Systems.Listeners;

import Animation.ZoomAnimation;
import Game.Managers.AnimationManager;
import Models.Manager.HexManager;

public class BoardListener extends Listener {
    private final HexManager hexManager;
    private ZoomAnimation currentZoomAnimation;

    public BoardListener(AnimationManager animationManager, HexManager hexManager) {
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

# File: src/Game/Systems/Listeners/BuildingListener.java

```java
package Game.Systems.Listeners;

import Game.Managers.AnimationManager;
import Models.Elements.Buildings.Building;
import Models.Elements.Hex.Hex;

public class BuildingListener extends Listener {
    public BuildingListener(AnimationManager animationManager) {
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

# File: src/Game/Systems/Listeners/ExplorListener.java

```java
package Game.Systems.Listeners;

import Game.Managers.AnimationManager;
import Models.Elements.Hex.Hex;

public class ExplorListener extends Listener {
    public ExplorListener(AnimationManager animationManager) {
        super(animationManager);
    }

    public void HexExplored(Hex hex) {
        animationManager.refresh();
    }
    public void ExplorationFailed(String reason) {}
}

```

---

# File: src/Game/Systems/Listeners/Listener.java

```java
package Game.Systems.Listeners;

import Game.Managers.AnimationManager;

public abstract class Listener {
    protected AnimationManager animationManager;

    public Listener(AnimationManager animationManager) {
        this.animationManager = animationManager;
    }

    public void Refresh(){
        animationManager.refresh();
    }
}

```

---

# File: src/Game/Systems/Listeners/ListenerSystem.java

```java
package Game.Systems.Listeners;

import Game.Managers.AnimationManager;
import Game.Managers.TurnManager;
import Game.Presentation.DrawingState;
import Game.Presentation.ViewState;
import Game.Systems.Drawers.SelectDrawer;
import Game.Systems.EventSystem.EventBus;
import Game.Systems.NotificationSystem;
import Game.Systems.RestarterSystem;
import Game.World;

public class ListenerSystem {
    private final World world;
    private final BoardListener boardListener;
    private final BuildingListener buildingListener;
    private final ExplorListener explorListener;
    private final SelectListener selectListener;
    private final UnitListener unitListener;
    private final WorkListener workListener;
    private final TurnListener turnListener;
    private final BoardExpandListener boardExpandListener;
    private final AnimationManager animationManager;
    private final TurnManager turnManager;
    private final RestarterSystem restarterSystem;
    private  NotificationSystem notificationSystem;

    private SelectDrawer extraDrawer;
    public ListenerSystem(World world, AnimationManager animationManager, TurnManager turnManager,
                          RestarterSystem restarterSystem, EventBus eventBus,
                          DrawingState drawingState, ViewState viewState) {
        this.world = world;
//        extraDrawer = Generate.getGame().getSystemManager().getDrawingSystem().getExtraDrawer();
        this.animationManager = animationManager;
        this.turnManager = turnManager;
        this.restarterSystem = restarterSystem;
        this.notificationSystem = notificationSystem;

        boardListener = new BoardListener(animationManager , world.getHexManager());
        buildingListener = new BuildingListener(animationManager);
        explorListener = new ExplorListener(animationManager);
        selectListener = new SelectListener(animationManager, extraDrawer, drawingState, viewState, world);
        unitListener = new UnitListener(animationManager);
        boardExpandListener = new BoardExpandListener(animationManager, drawingState);
        workListener = new WorkListener(animationManager);

        // FIXED: We pass 'this' (EventSystem) instead of the null notificationSystem reference
        turnListener = new TurnListener(animationManager, turnManager, restarterSystem, eventBus);
    }

    public void setExtraDrawer(SelectDrawer extraDrawer) {
        this.extraDrawer = extraDrawer;
    }

    public BoardListener getBoardEvent() {
        return boardListener;
    }

    public BuildingListener getBuildingEvent() {
        return buildingListener;
    }

    public ExplorListener getExplorEvent() {
        return explorListener;
    }

    public SelectListener getSelectListener() {
        return selectListener;
    }

    public UnitListener getUnitListener() {
        return unitListener;
    }

    public WorkListener getWorkListener() {
        return workListener;
    }

    public TurnListener getTurnListener() {
        return turnListener;
    }

    public BoardExpandListener getBoardExpandListener() {
        return boardExpandListener;
    }

    public NotificationSystem getNotificationSystem() {
        return notificationSystem;
    }

    public void setNotificationSystem(NotificationSystem notificationSystem) {
        this.notificationSystem = notificationSystem;
    }

    public void Notif(String message){
        if (notificationSystem != null) {
            notificationSystem.showNotification(message);
        }
    }
}

```

---

# File: src/Game/Systems/Listeners/SelectListener.java

```java
package Game.Systems.Listeners;

import Game.Managers.AnimationManager;
import Game.Presentation.DrawingState;
import Game.Presentation.ViewState;
import Game.Systems.Drawers.SelectDrawer;
import Game.World;
import Models.Elements.Hex.Hex;
import Models.Elements.Units.Unit;
import Models.Logic.HexLogic.HexLogic;
import java.util.ArrayList;

public class SelectListener extends Listener {
    private SelectDrawer extraDrawer;
    private final DrawingState drawingState;
    private final ViewState viewState;
    private final World world;
    public SelectListener(AnimationManager animationManager, SelectDrawer extraDrawer,
                          DrawingState drawingState, ViewState viewState, World world) {
        super(animationManager);
        this.extraDrawer = extraDrawer;
        this.drawingState = drawingState;
        this.viewState = viewState;
        this.world = world;
    }

    public void setExtraDrawer(SelectDrawer extraDrawer) {
        this.extraDrawer = extraDrawer;
    }

    public void UnitSelected(Unit unit) {
        if (unit == null) {
            extraDrawer.setSelectedUnit(null);
            drawingState.setPath(null);
            drawingState.setGoalHex(null);
        } else {
            extraDrawer.setSelectedUnit(unit);
            viewState.setSelectedUnit(unit);

        }

        animationManager.refresh();
    }

    public void HexSelected(Hex hex) {
        for (Hex boardHex : world.getHexRecord().getAll()) {
            boardHex.setDarker();
        }

        if (hex == null) {
            extraDrawer.setSelectedHex(null);
        } else {
            extraDrawer.setSelectedHex(hex);

            hex.setLighter();
            ArrayList<Hex> neighbors = HexLogic.getNeighbors(hex);
            for (Hex neighbor : neighbors) {
                neighbor.setLighter();
            }
        }

        animationManager.refresh();
    }

    public void likelyPath(java.util.List<Hex> path, Hex hoveredHex) {
        drawingState.setPath(path);
        drawingState.setGoalHex(hoveredHex);
        animationManager.refresh();
    }
}

```

---

# File: src/Game/Systems/Listeners/TurnListener.java

```java
package Game.Systems.Listeners;

import Game.Managers.AnimationManager;
import Game.Managers.TurnManager;
import Game.Systems.EventSystem.EventBus;
import Game.Systems.EventSystem.Events.TurnAdvancedEvent;
import Game.Systems.RestarterSystem;

public class TurnListener extends Listener {
    private final TurnManager turnManager;
    private final RestarterSystem restarterSystem;
    private final EventBus eventBus;

    public TurnListener(AnimationManager animationManager, TurnManager turnManager,
                        RestarterSystem restarterSystem, EventBus eventBus) {
        super(animationManager);
        this.turnManager = turnManager;
        this.restarterSystem = restarterSystem;
        this.eventBus = eventBus;
    }

    public void EndTurn() {
        turnManager.nexTurn();
        restarterSystem.restart();
        animationManager.refresh();

        eventBus.publish(new TurnAdvancedEvent(turnManager.getTurns()));
    }
}

```

---

# File: src/Game/Systems/Listeners/UnitListener.java

```java
package Game.Systems.Listeners;

import Animation.UnitMoveAnimation;
import Game.Managers.AnimationManager;
import Models.Elements.Hex.Hex;
import Models.Elements.Units.Unit;

public class UnitListener extends Listener {
    public UnitListener(AnimationManager animationManager) {
        super(animationManager);
    }

    public void UnitMoved(Hex oldHex, Hex newHex, Unit unit) {
        if (oldHex == null || newHex == null || oldHex.equals(newHex)) return;

        animationManager.play(new UnitMoveAnimation(unit, oldHex, newHex, 40, animationManager));
    }

    public void UnitCannotMove(Hex hex) {}
}
```

---

# File: src/Game/Systems/Listeners/WorkListener.java

```java
package Game.Systems.Listeners;

import Game.Managers.AnimationManager;
import Models.Elements.Buildings.Building;
import Models.Elements.Units.Unit;

public class WorkListener extends Listener {
    public WorkListener(AnimationManager animationManager) {
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

# File: src/Game/Systems/NotificationSystem.java

```java
package Game.Systems;

import Animation.MessageAnimation;
import Game.Managers.AnimationManager;
import Models.Elements.Messages.Message;

public class NotificationSystem {

    private final DrawingSystem drawingSystem;
    private final AnimationManager animationManager;

    public NotificationSystem(DrawingSystem drawingSystem, AnimationManager animationManager) {
        this.drawingSystem = drawingSystem;
        this.animationManager = animationManager;
    }

    public void showNotification(String text) {
        if (text == null || text.trim().isEmpty()) {
            return;
        }

        Message message = new Message(text);

        if (drawingSystem.getDrawMessages() != null) {
            drawingSystem.getDrawMessages().setActiveMessage(message);
        }

        MessageAnimation animation = new MessageAnimation(80, message, animationManager);

        animationManager.play(animation);
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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class BuildingRestarter {
    private BuildingRecord buildingRecord;
    private ResourceRecord resourceRecord;

    public BuildingRestarter(BuildingRecord buildingRecord, ResourceRecord resourceRecord) {
        this.buildingRecord = buildingRecord;
        this.resourceRecord = resourceRecord;
    }

    public void ProduceResources() {
        for (Building building : buildingRecord.getAll()) {
            new BuildingLogic(building).Supply();
        }
    }


    public void CostUpkeep() {
        List<Building> activeBuildings = new ArrayList<>(buildingRecord.getAll());

        for (Building building : activeBuildings) {
            boolean hasEnoughUpkeep = true;


            for (Map.Entry<Class<? extends Resource>, Integer> entry : building.getUPKEEP().entrySet()) {
                List<Resource> stock = resourceRecord.getAll(entry.getKey());
                if (stock.size() < entry.getValue()) {
                    hasEnoughUpkeep = false;
                    break;
                }
            }

            if (hasEnoughUpkeep) {
                for (Map.Entry<Class<? extends Resource>, Integer> entry : building.getUPKEEP().entrySet()) {
                    List<Resource> stock = resourceRecord.getAll(entry.getKey());
                    for (int i = 0; i < entry.getValue(); i++) {
                        resourceRecord.remove(stock.get(i));
                    }
                }
                building.setDecayCountdown(0);
            } else {
                int newCountdown = building.getDecayCountdown() + 1;
                building.setDecayCountdown(newCountdown);

                if (newCountdown >= 3) {
                    new BuildingLogic(building).decay();
                    if (building.getHex() != null) {
                        building.getHex().setBuilding(null);
                    }
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

    public  void APRestart() {
        for (Unit unit : unitRecord.getAll()) {
            new UnitLogic(unit).resetAp();
        }
    }

    public void FeedAll() throws Exception {
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
import Models.Elements.Resources.Resource;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


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

        unitRestarter.APRestart();
        try {
            unitRestarter.FeedAll();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        if (!world.getTownHall().getGenerateUnit().isFinished()) {
            try {
                world.getTownHall().getGenerateUnit().newTurn();
            } catch (Exception e) {

            }
        }
        buildingRestarter.CostUpkeep();
        starvationSystem.StarvationCheck();
        enforceTownHallStorageCapacity();


    }

    private void enforceTownHallStorageCapacity() {
        for (Map.Entry<Class<? extends Resource>, Integer> entry
                : world.getTownHall().getStorageCapacity().entrySet()) {
            Integer capacity = entry.getValue();
            if (capacity == null) {
                continue;
            }

            List<Resource> resources = new ArrayList<>(world.getResourceRecord().getAll(entry.getKey()));
            for (int index = capacity; index < resources.size(); index++) {
                world.getResourceRecord().remove(resources.get(index));
            }
        }
    }
}

```

---

# File: src/Game/Systems/SelectSystem.java

```java
package Game.Systems;

import Game.Systems.EventSystem.EventBus;
import Game.Systems.EventSystem.Events.HexSelectionChangedEvent;
import Game.Systems.EventSystem.Events.MovementPreviewChangedEvent;
import Game.Systems.EventSystem.Events.UnitSelectionChangedEvent;
import Models.Elements.Buildings.Building;
import Models.Elements.Hex.Hex;
import Models.Elements.Units.Unit;

public class SelectSystem {
    private Unit selectedUnit;
    private Hex selectedHex;
    private Building selectedBuilding;
    private final EventBus eventBus;
    private boolean readyToMove;
    public SelectSystem(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    public void selectUnit(Unit unit) {
        if (this.selectedUnit == unit) {
            this.selectedUnit = null;
            eventBus.publish(new UnitSelectionChangedEvent(null));
        } else {
            this.selectedUnit = unit;
            this.selectedBuilding = null;
            eventBus.publish(new UnitSelectionChangedEvent(unit));
        }
    }

    public void selectHex(Hex hex) {
        if (this.selectedHex == hex) {
            this.selectedHex = null;
            eventBus.publish(new HexSelectionChangedEvent(null));
        } else {
            this.selectedHex = hex;
            if (selectedUnit != null)
                readyToMove = true;
            else
                readyToMove = false;
            eventBus.publish(new HexSelectionChangedEvent(hex));
        }
    }


    public void hoverHex(Hex hex) {
        if (this.selectedUnit != null) {
            var unitLogic = this.selectedUnit.getLogic();
            if (unitLogic != null && unitLogic.canReach(hex)) {
                java.util.List<Hex> path = unitLogic.getBestPath(hex);
                eventBus.publish(new MovementPreviewChangedEvent(path, hex));
            }
        }
    }

    public Unit getSelectedUnit() {
        return selectedUnit;
    }

    public Hex getSelectedHex() {
        return selectedHex;
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

import Game.Systems.EventSystem.EventBus;
import Game.Systems.EventSystem.Events.NotificationRequestedEvent;
import Game.Systems.EventSystem.Events.UnitProductionQueuedEvent;
import Game.Systems.EventSystem.Events.UnitRefreshRequestedEvent;
import Game.World;
import Models.Elements.Units.Unit;
import Models.Logic.BuildingLogic.TownHallLogic;

public class TownHallSystem {
    private final World world;
    private final EventBus eventBus;
    public TownHallSystem(World world, EventBus eventBus) {
        this.world = world;
        this.eventBus = eventBus;
    }
    public void addToTownHall(Unit unit){
        if (!new TownHallLogic(world.getTownHall()).canProduceUnit(unit.getClass())){
            String message = "Cannot produce " + unit.getClass().getSimpleName();

            eventBus.publish(new NotificationRequestedEvent(message));
            return;
        }

        try {
            world.getTownHall().getGenerateUnit().startGeneration(unit);
            eventBus.publish(new UnitProductionQueuedEvent(world.getTownHall(), unit, unit.getCreationSteps()));
        } catch (Exception e) {
            eventBus.publish(new NotificationRequestedEvent(e.getMessage()));
        }finally {
            eventBus.publish(new UnitRefreshRequestedEvent());
        }

    }
    public void addedASettlement(){
        try {
            new TownHallLogic(world.getTownHall()).increaseCapPerCity();
        } catch (Exception e) {
            eventBus.publish(new NotificationRequestedEvent("Error "));
        }finally {
            eventBus.publish(new UnitRefreshRequestedEvent());
        }
    }
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

        addActionListener(e -> {
            boardController.TurnEnded();
        });
    }

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

        if (hovering) {
            g2.setColor(new Color(198, 165, 96, 90));
            g2.fillOval(0, 0, w, h);
        }

        Ellipse2D ring = new Ellipse2D.Double(pad, pad, w - pad * 2.0, h - pad * 2.0);
        g2.setPaint(new GradientPaint(0, 0, new Color(120, 96, 52), w, h, new Color(198, 165, 96)));
        g2.fill(ring);


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


        g2.setStroke(new BasicStroke(1.5f));
        g2.setColor(new Color(198, 165, 96, 180));
        g2.draw(new Ellipse2D.Double(corePad + 3, corePad + 3, w - (corePad + 3) * 2.0, h - (corePad + 3) * 2.0));

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
import Game.Presentation.UnitPanelRegistry;
import Game.Presentation.ViewState;
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
    private final ViewState viewState;
    private final UnitPanelRegistry unitPanelRegistry;
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

    public GameEngine(DrawingSystem drawingSystem, BoardMouseListener listener, ViewState viewState,
                      UnitPanelRegistry unitPanelRegistry, ControllerManager controllerManager,
                      TurnManager turnManager, World world) {
        this.drawingSystem = drawingSystem;
        this.listener = listener;
        this.viewState = viewState;
        this.unitPanelRegistry = unitPanelRegistry;
        this.controllerManager = controllerManager;
        this.endTurnButton = new EndTurnButton(controllerManager.getBoardController());
        this.turnManager = turnManager;
        this.world = world;
        this.townHallState = new TownHallState(world.getTownHall());
        this.townHallPanel = new TownHallPanel(townHallState);

        HUDState hudState = new HUDState(controllerManager.getWorld(), turnManager,
                controllerManager.getHudController(), viewState);
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

        Unit currentUnit = viewState.getSelectedUnit();

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
            activeUnitPanel.refresh();
        }

        boardPanel.repaint();
    }

    private UnitPanel createUnitPanel(Unit unit) {
        Class<? extends JPanel> panelClass = unitPanelRegistry.getPanelClass(unit.getClass());
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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GameFrame extends JFrame {

    public GameFrame() {

        setTitle("Advanced Strategy Game");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(false);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                confirmQuit();
            }
        });

        setVisible(true);
    }

    private void confirmQuit() {
        int choice = JOptionPane.showConfirmDialog(
                this,
                "Are you sure you wanna quit the game?",
                "Quit Game",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );

        if (choice == JOptionPane.YES_OPTION) {
            dispose();
            System.exit(0);
        }

    }
}
```

---

# File: src/Game/Views/HUDPanel/HUDAssets.java

```java
package Game.Views.HUDPanel;

import Utils.ImageLoader;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;


final class HUDAssets {

    private static final Map<String, Image> CACHE = new HashMap<>();

    private HUDAssets() {
    }

    static Image loadIcon(Class<?> elementClass, String folder) {
        String key = folder + "/" + elementClass.getSimpleName();
        return CACHE.computeIfAbsent(key, k -> {
            String url = "/assets/" + folder + "/" + elementClass.getSimpleName() + ".png";
            return url != null ? ImageLoader.load(url) : null;
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

    public static final int HEIGHT = 130;

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
import Game.Presentation.ViewState;
import Game.World;
import Models.Elements.Buildings.TownHall;
import Models.Elements.Resources.Resource;
import Models.Elements.Units.Unit;

public class HUDState {
    private final World world;
    private final TurnManager turnManager;
    private final HUDController controller;
    private final ViewState viewState;

    public HUDState(World world, TurnManager turnManager, HUDController controller, ViewState viewState) {
        this.world = world;
        this.turnManager = turnManager;
        this.controller = controller;
        this.viewState = viewState;
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

    public void onUnitIconClicked(Class<? extends Unit> unitClass) {
        controller.addToTownHall(unitClass);
    }


    public void showTerritory() {
        controller.ShowBorders();
    }

    public boolean isStarvation() {
        return viewState.isStarvation();
    }

    public int getResourceCapacity(Class<? extends Resource> resourceClass) {
        Integer capacity = world.getTownHall().getStorageCapacity().get(resourceClass);
        return capacity != null ? capacity : 0;
    }

    public int getUnitCap(Class<? extends Unit> unitClass) {
        Integer cap = world.getTownHall().getUnitCap().get(unitClass);
        return cap != null ? cap : 0;
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
        setPreferredSize(new Dimension(92, DIAMETER + 4));
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

        g2.setFont(new Font("Serif", Font.BOLD, 14));
        g2.setColor(new Color(230, 214, 170));
        String text = state.getResourceCount(resourceClass) + "/" + state.getResourceCapacity(resourceClass);
        FontMetrics fm = g2.getFontMetrics();
        g2.drawString(text, cx + DIAMETER / 2 + 8, cy + fm.getAscent() / 2 - 2);

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
    private final JLabel starvationLabel;

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

        JButton showTerritoryButton = createThemedButton("Show Territory");
        showTerritoryButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        showTerritoryButton.addActionListener(e -> state.showTerritory());

        starvationLabel = new JLabel("\u26A0 STARVATION");
        starvationLabel.setFont(new Font("Serif", Font.BOLD, 12));
        starvationLabel.setForeground(new Color(200, 40, 40));
        starvationLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        starvationLabel.setVisible(false);

        add(caption);
        add(turnLabel);
        add(Box.createVerticalStrut(6));
        add(showTerritoryButton);
        add(Box.createVerticalStrut(4));
        add(starvationLabel);

        refresh();
    }

    void refresh() {
        turnLabel.setText(String.valueOf(state.getTurn()));

        boolean starving = state.isStarvation();
        if (starvationLabel.isVisible() != starving) {
            starvationLabel.setVisible(starving);
            revalidate();
            repaint();
        }
    }

    private JButton createThemedButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Serif", Font.BOLD, 11));
        button.setForeground(new Color(20, 18, 15));
        button.setBackground(new Color(198, 165, 96));
        button.setFocusPainted(false);
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        button.setMaximumSize(new Dimension(140, 26));
        return button;
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
        label.setText(name + " : " + state.getUnitCount(unitClass) + "/" + state.getUnitCap(unitClass));
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
import Utils.ImageLoader;

import javax.swing.*;
import java.awt.*;

public class TownHallPanel extends JPanel {

    public static final int PANEL_WIDTH = 160;
    public static final int PANEL_HEIGHT = 230;

    private static final int IMAGE_HEIGHT = 170;

    private final TownHallState state;
    private final JLabel nameLabel;
    private Image currentImage;
    private double progressFraction = 0;

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

    public void refresh() {
        boolean finished = state.isFinished();
        Unit unit = finished ? null : state.getCurrentUnit();

        setVisible(!finished && unit != null);
        if (!isVisible()) {
            return;
        }

        String path = state.getPicturePath(unit.getClass());
        currentImage = (path != null) ? ImageLoader.load(path) : null;

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

            g2.drawImage(currentImage, 0, 0, imgW, imgH, this);


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
        relatedPicture.put(Worker.class, "/Images/UnitBackground/ChatGPT Image Jul 13, 2026, 05_33_53 PM.png");
        relatedPicture.put(BorderExpander.class, "/Images/UnitBackground/5956229881702059521.jpg");
        relatedPicture.put(Explorer.class, "/Images/UnitBackground/ChatGPT Image Jul 13, 2026, 05_42_04 PM.png");
        relatedPicture.put(Builder.class, "/Images/UnitBackground/ChatGPT Image Jul 13, 2026, 05_50_12 PM.png");
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
import Utils.ImageLoader;

import javax.swing.*;

public class BorderExpanderUnitPanel extends UnitPanel {

    private final BorderExpander borderExpander;

    public BorderExpanderUnitPanel(BorderExpander borderExpander, UnitPanelState state) {
        super("Border Expander", state);
        this.borderExpander = borderExpander;
        backgroundImage = ImageLoader.load("/Images/UnitBackground/5956229881702059521.jpg");
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
import Utils.ImageLoader;

import javax.swing.*;
import java.util.List;

public class BuilderUnitPanel extends UnitPanel {

    private final Builder builder;
    private final JLabel chargesLabel;
    private final JPanel buildButtonsPanel;

    public BuilderUnitPanel(Builder builder, UnitPanelState state) {
        super("Builder", state);
        this.builder = builder;
        backgroundImage = ImageLoader.load("/Images/UnitBackground/ChatGPT Image Jul 13, 2026, 05_50_12 PM.png");
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

        buildButtonsPanel.revalidate();
        buildButtonsPanel.repaint();
    }

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
import Utils.ImageLoader;

import javax.swing.*;

public class ExplorerUnitPanel extends UnitPanel {

    private final Explorer explorer;

    public ExplorerUnitPanel(Explorer explorer, UnitPanelState state) {
        super("Explorer", state);
        this.explorer = explorer;
        backgroundImage = ImageLoader.load("/Images/UnitBackground/ChatGPT Image Jul 13, 2026, 05_42_04 PM.png");
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

import Utils.ImageLoader;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public abstract class UnitPanel extends JPanel {

    public static final int PANEL_WIDTH = 200;
    public static final int PANEL_HEIGHT = 380;

    protected static Image backgroundImage;

    static {
         String url ="/assets/unit_panel_background.png";
        if (url != null) {
            backgroundImage = ImageLoader.load(url);
        }
    }

    protected final UnitPanelState state;
    protected final JPanel actionPanel;

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

    public abstract void refresh();

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

    public void getInBuilding() {
//        System.out.println("UI Interaction: Station Worker triggered.");
        controller.stationWorker();
    }

    public void getOffBuilding() {
//        System.out.println("UI Interaction: Unstation Worker triggered.");
        controller.unstationWorker();
    }

    public void build(Class<? extends Building> buildingClass) {
        controller.build(buildingClass);
    }


    public void explore() {
//        System.out.println("UI Interaction: Explore triggered.");
        controller.exploreSurroundings();
    }

    public void addToBorder() {
//        System.out.println("UI Interaction: Add to Border triggered.");
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
import Utils.ImageLoader;

import javax.swing.*;

public class WorkerUnitPanel extends UnitPanel {

    private final Worker worker;

    public WorkerUnitPanel(Worker worker, UnitPanelState state) {
        super("Worker", state);
        this.worker = worker;
        backgroundImage = ImageLoader.load("/Images/UnitBackground/ChatGPT Image Jul 13, 2026, 05_33_53 PM.png");
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

import Models.Draw.UnitPositionCalculator;
import Models.Elements.Buildings.TownHall;
import Models.Elements.Hex.ForestHex;
import Models.Elements.Hex.GrassHex;
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
    private final BuildingRecord buildingRecord;
    private final HexRecord hexRecord;
    private final ResourceRecord resourceRecord;
    private final UnitRecord unitRecord;
    private final HexManager hexManager;
    private final Hexutils hexutils;
    private TownHall townHall;
    private Hex centerHex;

    public World() {
        buildingRecord  = new BuildingRecord();
        resourceRecord  = new ResourceRecord();
        unitRecord      = new UnitRecord();
        hexutils        = new Hexutils();
        hexRecord  = new HexRecord();
        hexManager = new HexManager(300, 220 , hexRecord , hexutils);
        hexManager.setOnPositionsChanged(() -> UnitPositionCalculator.refreshAll(unitRecord));
        hexRecord.setHexManager(hexManager);

        Generate.publishWorld(this);
        centerHex = new LandHex(0 , 0 , false);
        Hex hex2 = new GrassHex(0 , 1 , false);
        Hex hex3 = new ForestHex( -1 , 1 , false);
        this.townHall = new TownHall();
        townHall.setHex(centerHex);
        centerHex.setBuilding(this.townHall);
        hexRecord.add(centerHex);
        hexRecord.add(hex2);
        hexRecord.add(hex3);
        buildingRecord.add(townHall);
        new TownHallLogic(townHall).AddInitialResources();
    }

    public BuildingRecord getBuildingRecord()  { return buildingRecord; }
    public HexRecord      getHexRecord()       { return hexRecord; }
    public ResourceRecord getResourceRecord()  { return resourceRecord; }
    public UnitRecord     getUnitRecord()      { return unitRecord; }
    public HexManager     getHexManager()      { return hexManager; }
    public Hexutils       getHexutils()        { return hexutils; }

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
import StartGame.StartGameEngine;
import StartGame.StartGameState;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            StartGameState state = new StartGameState();
            new StartGameEngine(state).show();
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
    private boolean showBorder = false;


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

    public boolean isShowBorder() {
        return showBorder;
    }

    public void setShowBorder(boolean showBorder) {
        this.showBorder = showBorder;
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
    private String message;

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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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


    }
}

```

---

# File: src/Models/Draw/MessageDraw.java

```java
package Models.Draw;

import Models.Elements.Messages.Message;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class MessageDraw implements Draw {

    private final Message message;

    private static final int WIDTH = 380;
    private static final int HEIGHT = 60;
    private static final int ARC_SIZE = 15;

    public MessageDraw(Message message) {
        this.message = message;
    }

    @Override
    public void draw(Graphics g) {
        if (message == null || !message.isActive()) {
            return;
        }

        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, message.getAlpha()));

        int x = message.getX();
        int y = message.getY();

        RoundRectangle2D outerRim = new RoundRectangle2D.Double(x, y, WIDTH, HEIGHT, ARC_SIZE, ARC_SIZE);
        g2.setPaint(new GradientPaint(x, y, new Color(120, 96, 52), x + WIDTH, y + HEIGHT, new Color(198, 165, 96)));
        g2.fill(outerRim);


        int borderThickness = 3;
        RoundRectangle2D innerCore = new RoundRectangle2D.Double(
                x + borderThickness,
                y + borderThickness,
                WIDTH - (borderThickness * 2),
                HEIGHT - (borderThickness * 2),
                ARC_SIZE - 2,
                ARC_SIZE - 2
        );
        g2.setPaint(new RadialGradientPaint(
                new Point(x + WIDTH / 2, y + HEIGHT / 2),
                WIDTH / 1.5f,
                new float[]{0f, 1f},
                new Color[]{new Color(35, 15, 15), new Color(10, 8, 8)}
        ));
        g2.fill(innerCore);

        g2.setStroke(new BasicStroke(1.2f));
        g2.setColor(new Color(198, 165, 96, 140));
        RoundRectangle2D hairline = new RoundRectangle2D.Double(
                x + borderThickness + 2,
                y + borderThickness + 2,
                WIDTH - (borderThickness * 2) - 4,
                HEIGHT - (borderThickness * 2) - 4,
                ARC_SIZE - 4,
                ARC_SIZE - 4
        );
        g2.draw(hairline);

        g2.setFont(new Font("Serif", Font.BOLD, 15));
        g2.setColor(new Color(230, 214, 170));
        FontMetrics fm = g2.getFontMetrics();
        int textX = x + (WIDTH - fm.stringWidth(message.getContent())) / 2;
        int textY = y + ((HEIGHT - fm.getHeight()) / 2) + fm.getAscent();

        g2.drawString(message.getContent(), textX, textY);
        g2.dispose();
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
            return;
        }
        if (unit.getHex() == null || !unit.getHex().isVisible()){
            return;
        }

        int size = unit.getSize();
        int drawX = unit.getX() - size / 2;
        int drawY = unit.getY() - size / 2;


        g.setColor(unit.getColor());
        g.fillOval(drawX, drawY, size, size);

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

    public static Point computeRestPosition(Unit unit) {
        Hex hex = unit.getHex();
        if (hex == null) return new Point(0, 0);
        return computeRestPosition(unit, hex);
    }


    public static Point computeRestPosition(Unit unit, Hex hex) {
        List<Unit> sharedHexUnits = new ArrayList<>();
        for (Unit u : unit.getLogic().getUnitRecord().getAll()) {
            if (u != null && hex.equals(u.getHex())) {
                sharedHexUnits.add(u);
            }
        }
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
import Models.Elements.Vulnerable;
import Models.Logic.BuildingLogic.BuildingLogic;
import Utils.ImageLoader;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public abstract class Building implements Showable , Vulnerable {
    private Hex hex;
    protected int HP;
    protected Map<Class<? extends Resource>, Integer> providesPerWorker;
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

    protected Building() {
        HEX_TYPE = new HashSet<>();
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
```

---

# File: src/Models/Elements/Buildings/Dock.java

```java
package Models.Elements.Buildings;

public class Dock extends Building{

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
        HEX_TYPE.add(GrassHex.class);
        UPKEEP = Map.of(Food.class, 1);
        providesPerWorker.put(Food.class , 4);
        BuildingCost.put(Wood.class , 10);
        BuilderAp = 1;
        workerCapacity = 2;
        LightImagePath = "/Images/Buildings/Farm.png";
        DarkerImagePath = "/Images/Buildings/Darker/Farm.png";
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
        HEX_TYPE.add(MountainHex.class);
        UPKEEP = Map.of(Iron.class, 1);
        providesPerWorker.put(Iron.class , 2);
        workerCapacity = 2;
        BuildingCost.put(Wood.class , 10);
        BuilderAp = 2;
        LightImagePath = "/Images/Buildings/IronMine.png";
        DarkerImagePath = "/Images/Buildings/Darker/IronMine.png";
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
        HEX_TYPE.add(ForestHex.class);
        UPKEEP = Map.of(Wood.class, 1);
        providesPerWorker.put(Wood.class , 3);
        workerCapacity = 2;
        BuildingCost.put(Wood.class , 8);
        BuilderAp = 1;
        LightImagePath = "/Images/Buildings/LubmerMil.png";
        DarkerImagePath = "/Images/Buildings/Darker/LubmerMil.png";
        initializeImages();
    }

}
```

---

# File: src/Models/Elements/Buildings/MilitaryStable.java

```java
package Models.Elements.Buildings;

import Models.Elements.Hex.LandHex;

public class MilitaryStable extends Building{
    public MilitaryStable() {
        super();
        HEX_TYPE.add(LandHex.class);
        UPKEEP
    }
}

```

---

# File: src/Models/Elements/Buildings/Road.java

```java
package Models.Elements.Buildings;

import Models.Elements.Hex.ForestHex;
import Models.Elements.Hex.GrassHex;
import Models.Elements.Hex.LandHex;

import java.util.Collections;

public class Road extends Building{
    public Road() {
        super();
        Collections.addAll(HEX_TYPE, ForestHex.class , LandHex.class , GrassHex.class);

    }
}

```

---

# File: src/Models/Elements/Buildings/Settlement.java

```java
package Models.Elements.Buildings;

import Models.Elements.Hex.GrassHex;
import Models.Elements.Hex.Hex;
import Models.Elements.Hex.LandHex;
import Models.Elements.Resources.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Settlement extends Building {
    private static Integer UnitCapIncrease;



    public Settlement() {
        super();
        Collections.addAll(HEX_TYPE , LandHex.class , GrassHex.class);
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
        LightImagePath = "/Images/Buildings/Sattelment.png";
        DarkerImagePath = "/Images/Buildings/Darker/Sattelment.png";
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
        HEX_TYPE.add(LandHex.class);
        UPKEEP = Map.of(Food.class, 1);
        providesPerWorker.put(Food.class , 3);
        workerCapacity = 2;
        BuilderAp = 1;
        BuildingCost.put(Wood.class , 15);
        BuildingCost.put(Stone.class , 5);
        LightImagePath = "/Images/Buildings/Stable.png";
        DarkerImagePath = "/Images/Buildings/Darker/Stable.png";
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
        HEX_TYPE.add(MountainHex.class);
        UPKEEP = Map.of(Stone.class, 1);
        providesPerWorker.put(Stone.class , 3);
        workerCapacity = 2;
        BuilderAp = 2;
        BuildingCost.put(Wood.class , 15);
        BuildingCost.put(Stone.class , 5);
        LightImagePath = "/Images/Buildings/StoneMine.png";
        DarkerImagePath = "/Images/Buildings/Darker/StoneMine.png";
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
import Models.Elements.Units.*;
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
    protected Map<Class<? extends Unit> , Integer> unitCap;
    public static final Map<Class<? extends Resource>, Integer> WOULD_PROVIDE = Map.of(
            Wood.class, 1,
            Food.class, 1
    );

    public TownHall() {
        super();
        HEX_TYPE.add(Hex.class);
        UPKEEP = Map.of();
        storageCapacity = new HashMap<>();
        safeGuard = new HashMap<>();
        initialResources = new HashMap<>();
        unitCap = new HashMap<>();

        storageCapacity.put(Food.class , 100);
        storageCapacity.put(Wood.class , 100);
        storageCapacity.put(Stone.class , 100);
        storageCapacity.put(Iron.class , 50);
        safeGuard.put(Food.class , 1);
        safeGuard.put(Wood.class , 1);
        initialResources.put(Food.class , 30);
        initialResources.put(Wood.class , 20);
        initialResources.put(Stone.class, 15);

        unitCap.put(BorderExpander.class , 2);
        unitCap.put(Worker.class , 10);
        unitCap.put(Explorer.class ,3 );
        unitCap.put(Builder.class , 6);

        setLogic(new TownHallLogic(this));
        workerCapacity = 2;
        LightImagePath = "/Images/Buildings/TownHall.png";
        DarkerImagePath = "/Images/Buildings/Darker/TownHall.png";
        initializeImages();

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

    public Map<Class<? extends Resource>, Integer> getStorageCapacity() {
        return storageCapacity;
    }

    public Map<Class<? extends Unit>, Integer> getUnitCap() {
        return unitCap;
    }

    public void setStorageCapacity(Map<Class<? extends Resource>, Integer> storageCapacity) {
        this.storageCapacity = storageCapacity;
    }

    public void setSafeGuard(Map<Class<? extends Resource>, Integer> safeGuard) {
        this.safeGuard = safeGuard;
    }

    public void setInitialResources(Map<Class<? extends Resource>, Integer> initialResources) {
        this.initialResources = initialResources;
    }

    public void setUnitCap(Map<Class<? extends Unit>, Integer> unitCap) {
        this.unitCap = unitCap;
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

# File: src/Models/Elements/Hex/BeachHex.java

```java
package Models.Elements.Hex;

import Models.Elements.Buildings.Dock;
import Models.Elements.Resources.Resource;

public class BeachHex extends Hex{
    public BeachHex(int q, int r, boolean additionalResource) {
        super(q , r , null , null);
        this.movementCost = 2;
        BuildableBuildings.add(Dock.class);
    }
}

```

---

# File: src/Models/Elements/Hex/BergHex.java

```java
package Models.Elements.Hex;

import Models.Elements.Resources.Resource;

public class BergHex extends Hex{
    public BergHex(int q, int r, boolean additionalResource) {
        super(q, r, null , null);
        this.movementCost = 50;
    }
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
        setImage("/Images/JungleImage.png");
        setDarkerImage("/Images/Darker/JungleImage.png");

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
        setImage("/Images/GrassImage.png");
        setDarkerImage("/Images/Darker/GrassImage.png");
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
import Utils.ImageLoader;

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
        setBorder(false);

    }

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
            image = ImageLoader.load(DarkImagePath);
        }
        draw = new HexDraw(this);

        if (building != null) {
            building.setDarker();
        }
    }

    public void setLighter(){
        if (LightImagePath != null) {
            image = ImageLoader.load(LightImagePath);
        }
        draw = new HexDraw(this);

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

import Models.Elements.Buildings.*;
import Models.Elements.Resources.Food;
import Models.Elements.Resources.Resource;

public class LandHex extends Hex{
    public LandHex(int q, int r , boolean additionalResources) {
        super(q , r , null , Food.class);
        setAdditionalResources(additionalResources);
        BuildableBuildings.add(Settlement.class);
        BuildableBuildings.add(Road.class);
        movementCost = 1;
        if (additionalResources){
            BuildableBuildings.add(Stable.class);
            BuildableBuildings.add(MilitaryStable.class);
            setImage("/Images/ExrtraResources/LandWithAnimal.png");
            setDarkerImage("/Images/ExrtraResources/Darker/LandWithAnimal.png");
        }else {
            setImage("/Images/LandImage.png");
            setDarkerImage("/Images/Darker/LandImage.png");
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
            setImage("/Images/ExrtraResources/MountainWithIron.png");
            setDarkerImage("/Images/ExrtraResources/Darker/MountainWithIron.png");
        }

        setImage("/Images/MountainImage.png");
        setDarkerImage("/Images/Darker/MountainImage.png");
        initializeImages();
    }
}
```

---

# File: src/Models/Elements/Hex/SeaHex.java

```java
package Models.Elements.Hex;

import Models.Elements.Resources.Food;
import Models.Elements.Resources.Resource;

public class SeaHex extends Hex{
    public SeaHex(int q, int r , boolean additionalResources) {
         super(q , r , null , Food.class);
         this.movementCost = 1;
    }
}

```

---

# File: src/Models/Elements/Message.java

```java
package Models.Elements.Messages;

import Models.Draw.MessageDraw;
import Models.Elements.Showable;

public class Message implements Showable {

    private final String content;
    private final MessageDraw draw;


    private int x;
    private int y;
    private int size;
    private float alpha = 0.0f;
    private boolean active = false;

    public Message(String content) {
        this.content = content;
        this.draw = new MessageDraw(this);
    }

    public String getContent() {
        return content;
    }

    public MessageDraw getDraw() {
        return draw;
    }

    public float getAlpha() {
        return alpha;
    }

    public void setAlpha(float alpha) {
        this.alpha = alpha;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

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
        super(2, 3 , 3);
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

# File: src/Models/Elements/Units/CombatUnits/Archer.java

```java
package Models.Elements.Units.CombatUnits;

import Models.Elements.Resources.Food;
import Models.Elements.Resources.Wood;
import Models.Elements.Units.CombatUnits.Prerequisites.ArcherPrerequisite;

import java.util.Map;

public class Archer extends CombatUnit {

    public Archer() {
        super(1, 2, 3, 1, 6, 2, AttackType.RANGED,
                new ArcherPrerequisite(), Map.of(Food.class, 25, Wood.class, 15));
    }
}

```

---

# File: src/Models/Elements/Units/CombatUnits/AttackType.java

```java
package Models.Elements.Units.CombatUnits;

public enum AttackType {
    MELEE,
    RANGED
}

```

---

# File: src/Models/Elements/Units/CombatUnits/Cavalry.java

```java
package Models.Elements.Units.CombatUnits;

import Models.Elements.Resources.Food;
import Models.Elements.Resources.Iron;
import Models.Elements.Units.CombatUnits.Prerequisites.CavalryPrerequisite;

import java.util.Map;

public class Cavalry extends CombatUnit {

    public Cavalry() {
        super(2, 4, 6, 2, 8, 1, AttackType.MELEE,
                new CavalryPrerequisite(), Map.of(Food.class, 40, Iron.class, 20));
    }
}

```

---

# File: src/Models/Elements/Units/CombatUnits/CombatUnit.java

```java
package Models.Elements.Units.CombatUnits;

import Models.Elements.Resources.Resource;
import Models.Elements.Units.CombatUnits.Prerequisites.Prerequisite;
import Models.Elements.Units.Unit;

import java.util.Map;

public abstract class CombatUnit extends Unit {

    protected int combatPower;
    protected int attackRange;
    protected AttackType attackType;
    protected Prerequisite prerequisite;
    protected Map<Class<? extends Resource>, Integer> makingCost;

    protected CombatUnit(int foodNeed, int initialAP, int creationSteps, int HP,
                         int combatPower, int attackRange, AttackType attackType,
                         Prerequisite prerequisite,
                         Map<Class<? extends Resource>, Integer> makingCost) {
        super(foodNeed, initialAP, creationSteps);
        setHP(HP);
        this.combatPower = combatPower;
        this.attackRange = attackRange;
        this.attackType = attackType;
        this.prerequisite = prerequisite;
        this.makingCost = makingCost;
    }

    public int getCombatPower() {
        return combatPower;
    }

    public void setCombatPower(int combatPower) {
        this.combatPower = combatPower;
    }

    public int getAttackRange() {
        return attackRange;
    }

    public void setAttackRange(int attackRange) {
        this.attackRange = attackRange;
    }

    public AttackType getAttackType() {
        return attackType;
    }

    public void setAttackType(AttackType attackType) {
        this.attackType = attackType;
    }

    public Prerequisite getPrerequisite() {
        return prerequisite;
    }

    public void setPrerequisite(Prerequisite prerequisite) {
        this.prerequisite = prerequisite;
    }

    public Map<Class<? extends Resource>, Integer> getMakingCost() {
        return makingCost;
    }

    public void setMakingCost(Map<Class<? extends Resource>, Integer> makingCost) {
        this.makingCost = makingCost;
    }
}

```

---

# File: src/Models/Elements/Units/CombatUnits/Prerequisites/ArcherPrerequisite.java

```java
package Models.Elements.Units.CombatUnits.Prerequisites;

public class ArcherPrerequisite extends Prerequisite {

    @Override
    public boolean check() {
        return false;
    }
}

```

---

# File: src/Models/Elements/Units/CombatUnits/Prerequisites/CavalryPrerequisite.java

```java
package Models.Elements.Units.CombatUnits.Prerequisites;

public class CavalryPrerequisite extends Prerequisite {

    @Override
    public boolean check() {
        return false;
    }
}

```

---

# File: src/Models/Elements/Units/CombatUnits/Prerequisites/Prerequisite.java

```java
package Models.Elements.Units.CombatUnits.Prerequisites;

public abstract class Prerequisite {

    public abstract boolean check();
}

```

---

# File: src/Models/Elements/Units/CombatUnits/Prerequisites/SwordsmanPrerequisite.java

```java
package Models.Elements.Units.CombatUnits.Prerequisites;

public class SwordsmanPrerequisite extends Prerequisite {

    @Override
    public boolean check() {
        return false;
    }
}

```

---

# File: src/Models/Elements/Units/CombatUnits/Swordsman.java

```java
package Models.Elements.Units.CombatUnits;

import Models.Elements.Resources.Food;
import Models.Elements.Resources.Wood;
import Models.Elements.Units.CombatUnits.Prerequisites.SwordsmanPrerequisite;

import java.util.Map;

public class Swordsman extends CombatUnit {

    public Swordsman() {
        super(2, 2, 4, 1, 10, 1, AttackType.MELEE,
                new SwordsmanPrerequisite(), Map.of(Food.class, 20, Wood.class, 10));
    }
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
import Models.Elements.Vulnerable;
import Models.Logic.UnitLogic.UnitLogic;
import Utils.ImageLoader;

import javax.swing.*;
import java.awt.*;

public abstract class Unit implements Showable , Vulnerable {


    private final int foodNeed;
    private final int initialAP;
    private final int CreationSteps;
    private static Integer InitialUnitCap;
    protected Image image;

    private int AP;
    protected int HP;
    private Hex hex;
    private Color color;

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
        image = ImageLoader.load(imagePath);
        draw = new UnitDraw(this);
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
        this.draw = new UnitDraw(this);
    }

    @Override
    public int getHP() {
        return HP;
    }

    @Override
    public void setHP(int HP) {
        this.HP = HP;
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

# File: src/Models/Elements/Vulnerable.java

```java
package Models.Elements;

public interface Vulnerable {
     int getHP();
     void setHP(int HP);
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
    }

    public static GameEngine getEngine() {
        return engine;
    }
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
import Models.Logic.UnitLogic.BuilderLogic;
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
        Hex hex = builder.getHex();
        if (!hex.isBorder())
            throw new Exception("The hex is not in our territory");
        Building newBuilding = buildingClass.getDeclaredConstructor().newInstance();
        ResourceRecord resourceRecord1 = Generate.getGame().getWorld().getResourceRecord();
        BuildingRecord buildingRecord1 = Generate.getGame().getWorld().getBuildingRecord();

        for (Map.Entry<Class<? extends Resource>, Integer> entry : newBuilding.getBuildingCost().entrySet()) {
            if (resourceRecord1.getAll(entry.getKey()).size() < entry.getValue()) {
                throw new Exception("Not enough " + entry.getKey().getSimpleName() + " to build " + buildingClass.getSimpleName());
            }
        }

        if (builder.getAP() < newBuilding.getBuilderAp()) {
            throw new Exception("Builder does not have enough AP to build " + buildingClass.getSimpleName());
        }


        if (hex == null || !newBuilding.getHEX_TYPE().contains(hex.getClass())) {
            throw new Exception("Builder is not standing on a valid hex for " + buildingClass.getSimpleName());
        }

        for (Map.Entry<Class<? extends Resource>, Integer> entry : newBuilding.getBuildingCost().entrySet()) {
            List<Resource> stock = resourceRecord1.getAll(entry.getKey());
            for (int i = 0; i < entry.getValue(); i++) {
                resourceRecord1.remove(stock.get(i));
            }
        }
        builder.setAP(builder.getAP() - newBuilding.getBuilderAp());
        new BuilderLogic(builder).SpendCharge();

        newBuilding.setHex(hex);
        hex.setBuilding(newBuilding);
        buildingRecord1.add(newBuilding);
        newBuilding.setLighter();
        return newBuilding;
    }

    public void Supply() {
        int workers = building.getWorkerNumbers();
        for (Map.Entry<Class<? extends Resource>, Integer> entry : building.getProvidesPerWorker().entrySet()) {
            int amount = entry.getValue() * workers;
            for (int i = 0; i < amount; i++) {
                try {
                    resourceRecord.add(entry.getKey().getDeclaredConstructor().newInstance());
                } catch (Exception ignored) {
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
        Finished = false;
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

import Models.Draw.UnitPositionCalculator;
import Models.Elements.Buildings.TownHall;
import Models.Elements.Resources.Resource;
import Models.Elements.Units.*;
import Models.Records.ResourceRecord;
import Models.Records.UnitRecord;

import java.util.Map;

public class TownHallLogic extends BuildingLogic {

    private TownHall townHall;
    private static final Map<Class<? extends Unit>, Integer> CAP_GROWTH = Map.of(
            Worker.class, 2,
            Builder.class, 1,
            Explorer.class, 0,
            BorderExpander.class, 0
    );
    public TownHallLogic(TownHall townHall) {
        super(townHall);
        this.townHall = townHall;
    }

    public void produceSafeguard() {
        for (Map.Entry<Class<? extends Resource>, Integer> entry : townHall.getSafeGuard().entrySet()) {
            for (int i = 0; i < entry.getValue(); i++) {
                try {
                    resourceRecord.add(entry.getKey().getDeclaredConstructor().newInstance());
                } catch (Exception ignored) {
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
            }
    }

    public Unit produceUnit(Class<? extends Unit> unitClass) throws Exception {

        if (!canProduceUnit(unitClass)) {
            throw new Exception(
                    "Cannot produce " + unitClass.getSimpleName()
                            + ". Unit cap (" + townHall.getUnitCap().get(unitClass)
                            + ") has been reached."
            );
        }

        Unit unit = unitClass.getDeclaredConstructor().newInstance();
        unitRecord.add(unit);
        unit.setHex(townHall.getHex());
        UnitPositionCalculator.refreshHex(unit.getHex(), unit);

        return unit;
    }
    public void increaseCapPerCity() {

        Map<Class<? extends Unit>, Integer> cap = townHall.getUnitCap();

        for (Map.Entry<Class<? extends Unit>, Integer> entry : CAP_GROWTH.entrySet()) {
            cap.computeIfPresent(
                    entry.getKey(),
                    (k, v) -> v + entry.getValue()
            );
        }
    }
    public boolean canProduceUnit(Class<? extends Unit> unitClass) {

        Integer cap = townHall.getUnitCap().get(unitClass);

        // No cap means unlimited production.
        if (cap == null) {
            return true;
        }

        int currentCount = 0;
        if (unitRecord.getAll(unitClass) != null) {
            currentCount = unitRecord.getAll(unitClass).size();
        }

        return currentCount < cap;
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

        Hex temp = new Hex(q, r, null, null) {};

        ArrayList<Hex> neighbors = HexLogic.getNeighbors(temp);

        ArrayList<Class<? extends Hex>> pool = new ArrayList<>();

        for (Hex neighbor : neighbors) {

            if (neighbor instanceof ForestHex) {
                pool.add(ForestHex.class);
                pool.add(ForestHex.class);
                pool.add(GrassHex.class);
//                pool.add(MountainHex.class);
            }

            else if (neighbor instanceof GrassHex) {
                pool.add(GrassHex.class);
                pool.add(GrassHex.class);
                pool.add(ForestHex.class);
                pool.add(LandHex.class);
                pool.add(MountainHex.class);
            }

            else if (neighbor instanceof LandHex) {
                pool.add(LandHex.class);
                pool.add(LandHex.class);
                pool.add(LandHex.class);
                pool.add(GrassHex.class);
                pool.add(ForestHex.class);
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
    private static int[][] offsets = {
            {0, -1},
            {1, -1},
            {-1, 0},
            {1, 0},
            {-1, 1},
            {0, 1}
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

import Models.Draw.UnitPositionCalculator;
import Models.Elements.Hex.Hex;
import Models.Elements.Units.BorderExpander;
import Models.Logic.HexLogic.HexLogic;
import Models.Records.UnitRecord;

import java.util.ArrayList;

public class BorderExpanderLogic extends UnitLogic {

    private BorderExpander borderExpander;

    public BorderExpanderLogic(BorderExpander borderExpander) {
        super(borderExpander);
        this.borderExpander = borderExpander;
    }

    public void addToBorder() {
        Hex hex = borderExpander.getHex();
        ArrayList<Hex> neighbors = HexLogic.getNeighbors(hex);
        hex.setBorder(true);
        for (Hex hex1:neighbors)
            hex1.setBorder(true);
        unitRecord.remove(borderExpander);
        UnitPositionCalculator.refreshHex(unit.getHex() , unit);
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

    private Builder builder;

    public BuilderLogic(Builder builder) {
        super(builder);
        this.builder = builder;
    }

    public void build(Building building) throws Exception {
        if (!CheckBuildingHex(building))
            throw new Exception("Invalid building on this hex");
        try {
            BuildingLogic.Build(builder, building.getClass());
            new BuilderLogic(builder).SpendCharge();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void SpendCharge() {
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
            return;
        }
        unit.setAP(unit.getAP() - AP);
    }

    public void resetAp() {
        unit.setAP(unit.getInitialAP());
    }

    public void feed() throws Exception {
        resourceRecord.consumeFood(1);
    }

    public void moveToHex(Hex targetHex) {
        unit.setHex(targetHex);
    }


    public boolean canReach(Hex targetHex) {
        if (unit.getHex() == null || targetHex == null) return false;
        FindBestPath pathfinder = new FindBestPath(unit.getHex(), targetHex);
        return pathfinder.canReach(unit.getAP());
    }


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
        worker.setWorking(true);
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


    public void setOnPositionsChanged(Runnable onPositionsChanged) {
        this.onPositionsChanged = onPositionsChanged;
    }

    private void notifyPositionsChanged() {
        if (onPositionsChanged != null) {
            onPositionsChanged.run();
        }
    }


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

    public int[] axialToPixel(int q, int r, int centerX, int centerY, int size) {
        int parity = r & 1; // 0 or 1 — correct even for negative r in Java (unlike r % 2)
        double col = q + (r - parity) / 2.0;
        int x = (int) (centerX + (col + 0.5 * parity) * size * 0.8);
        int y = (int) (centerY + r * size * 2.0 / 3.0);
        return new int[]{x, y};
    }

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
    private HexManager hexManager;

    public HexRecord() {
        elements = new HashMap<>();
        elements.put(ForestHex.class,   new ArrayList<>());
        elements.put(LandHex.class,     new ArrayList<>());
        elements.put(MountainHex.class, new ArrayList<>());
        elements.put(GrassHex.class,    new ArrayList<>());
    }


    public void setHexManager(HexManager hexManager) {
        this.hexManager = hexManager;
    }

    public void add(Hex hex) {

        if (hex == null) return;
        List<Hex> list = elements.computeIfAbsent(hex.getClass(), k -> new ArrayList<>());
        list.add(hex);
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


    public List<Hex> getNeighbors(Hex hex) {

        int[][] directions = {
                {1, 0}, {-1, 0},
                {0, 1}, {0, -1},
                {1, -1}, {1, 1}
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
    public void consumeFood(int amount) throws Exception {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount to consume cannot be negative.");
        }

        List<Resource> foodList = elements.get(Food.class);
        int currentFoodCount = (foodList != null) ? foodList.size() : 0;

        if (currentFoodCount < amount) {
            throw new Exception("Not enough food! Requested: " + amount + ", Available: " + currentFoodCount);
        }

        // Remove the specified amount of food from the list
        for (int i = 0; i < amount; i++) {
            // Always remove from the end of the ArrayList for O(1) performance
            foodList.remove(foodList.size() - 1);
        }
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

# File: src/StartGame/MusicSettings.java

```java
package StartGame;

/**
 * Shared music on/off + volume state. Create exactly one instance
 * (in Generate/Main, wherever your app wiring starts) and hand the
 * SAME instance to both StartGameState and HUDState — there's only
 * one MusicPlayer/Clip actually playing, so there should only be
 * one source of truth for what it's set to.
 */
public class MusicSettings {

    private boolean musicOn = true;
    private float volume = 0.7f; // 0.0 (silent) .. 1.0 (full)

    public boolean isMusicOn() {
        return musicOn;
    }

    public void toggleMusic() {
        musicOn = !musicOn;
    }

    public float getVolume() {
        return volume;
    }

    public void setVolume(float volume) {
        this.volume = Math.max(0f, Math.min(1f, volume));
    }
}
```

---

# File: src/StartGame/MusicToggleButton.java

```java
package StartGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;

public class MusicToggleButton extends JComponent {

    public static final int DIAMETER = 64;

    private final StartGameState state;
    private boolean hovering = false;

    public MusicToggleButton(StartGameState state) {
        this.state = state;
        setPreferredSize(new Dimension(DIAMETER, DIAMETER));
        setOpaque(false);
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        setToolTipText("Toggle Music");

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

            @Override
            public void mouseClicked(MouseEvent e) {
                state.toggleMusic();
                repaint();
            }
        });
    }

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
        int pad = 3;

        if (hovering) {
            g2.setColor(new Color(198, 165, 96, 90));
            g2.fillOval(0, 0, w, h);
        }

        Ellipse2D ring = new Ellipse2D.Double(pad, pad, w - pad * 2.0, h - pad * 2.0);
        g2.setPaint(new GradientPaint(0, 0, new Color(120, 96, 52), w, h, new Color(198, 165, 96)));
        g2.fill(ring);

        int corePad = pad + 5;
        Ellipse2D core = new Ellipse2D.Double(corePad, corePad, w - corePad * 2.0, h - corePad * 2.0);
        g2.setColor(new Color(20, 17, 14));
        g2.fill(core);

        g2.setColor(new Color(230, 214, 170));
        g2.setFont(new Font("Serif", Font.PLAIN, 16));
        String note = "\u266A";
        FontMetrics fmNote = g2.getFontMetrics();
        g2.drawString(note, (w - fmNote.stringWidth(note)) / 2, h / 2 - 6);

        g2.setColor(state.isMusic() ? new Color(120, 200, 120) : new Color(200, 90, 90));
        g2.setFont(new Font("Serif", Font.BOLD, 11));
        String label = state.isMusic() ? "ON" : "OFF";
        FontMetrics fm = g2.getFontMetrics();
        g2.drawString(label, (w - fm.stringWidth(label)) / 2, h / 2 + fm.getAscent() + 2);

        g2.dispose();
    }
}
```

---

# File: src/StartGame/StartButton.java

```java
package StartGame;

import javax.swing.*;
import java.awt.*;

public class StartButton extends JButton {

    public StartButton(StartGameState state) {
        super("Start Game");
        setFont(new Font("Serif", Font.BOLD, 18));
        setForeground(new Color(20, 18, 15));
        setBackground(new Color(198, 165, 96));
        setFocusPainted(false);
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        setBorder(BorderFactory.createLineBorder(new Color(120, 96, 52), 2));
        setPreferredSize(new Dimension(180, 54));

        addActionListener(e -> state.startGame());
    }
}
```

---

# File: src/StartGame/StartGameEngine.java

```java
package StartGame;

import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class StartGameEngine {

    private static final int MARGIN = 30;
    private static final int STACK_GAP = 16;

    private final StartGameFrame frame;
    private final StartGamePanel panel;

    public StartGameEngine(StartGameState state) {
        this.frame = new StartGameFrame();

        state.setFrameToClose(this.frame);

        this.panel = new StartGamePanel(state);

        frame.setContentPane(panel);
        layoutButtons();

        frame.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                layoutButtons();
            }
        });
    }

    private void layoutButtons() {
        int w = panel.getWidth() > 0 ? panel.getWidth() : frame.getWidth();
        int h = panel.getHeight() > 0 ? panel.getHeight() : frame.getHeight();

        Dimension startSize = panel.getStartButton().getPreferredSize();

        panel.getStartButton().setBounds(
                w - startSize.width - MARGIN,
                h - startSize.height - MARGIN,
                startSize.width,
                startSize.height
        );

        panel.getMusicToggleButton().setBounds(
                w - MARGIN - startSize.width / 2 - MusicToggleButton.DIAMETER / 2,
                h - startSize.height - MARGIN - STACK_GAP - MusicToggleButton.DIAMETER,
                MusicToggleButton.DIAMETER,
                MusicToggleButton.DIAMETER
        );
        panel.getVolumeSlider().setBounds(
                w - MARGIN - startSize.width / 2 - VolumeSlider.WIDTH / 2,
                h - startSize.height - MARGIN - STACK_GAP - MusicToggleButton.DIAMETER - STACK_GAP - VolumeSlider.HEIGHT,
                VolumeSlider.WIDTH,
                VolumeSlider.HEIGHT
        );
    }

    public void show() {
        frame.setVisible(true);
        layoutButtons();
    }
}
```

---

# File: src/StartGame/StartGameFrame.java

```java
package StartGame;

import javax.swing.*;

public class StartGameFrame extends JFrame {

    public StartGameFrame() {
        setTitle("Civilization VI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(false);
        setVisible(true);
    }
}
```

---

# File: src/StartGame/StartGamePanel.java

```java
package StartGame;

import Game.Generate;
import Utils.ImageLoader;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class StartGamePanel extends JPanel {

    private static Image backgroundImage;

    static {
        backgroundImage = ImageLoader.load("/Images/ChatGPT Image Jul 14, 2026, 10_23_30 PM.png");
    }
    private final VolumeSlider volumeSlider;
    private final MusicToggleButton musicToggleButton;
    private final StartButton startButton;

    public StartGamePanel(StartGameState state) {
        setLayout(null);
        setOpaque(false);

        musicToggleButton = new MusicToggleButton(state);
        startButton = new StartButton(state);

        add(musicToggleButton);
        add(startButton);
        volumeSlider = new VolumeSlider(state.getMusicSettings(), v -> Generate.getGame().getMusicPlayer().setVolume(v));
        add(volumeSlider);
    }

    public MusicToggleButton getMusicToggleButton() {
        return musicToggleButton;
    }

    public StartButton getStartButton() {
        return startButton;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        if (backgroundImage != null) {
            g2.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        } else {
            g2.setPaint(new GradientPaint(0, 0, new Color(15, 13, 10), 0, getHeight(), new Color(35, 30, 24)));
            g2.fillRect(0, 0, getWidth(), getHeight());
        }
        g2.dispose();
    }
    public VolumeSlider getVolumeSlider() {
        return volumeSlider;
    }
}
```

---

# File: src/StartGame/StartGameState.java

```java
package StartGame;

import Game.Generate;

import javax.swing.*;

public class StartGameState {
    private JFrame frameToClose;
    private final MusicSettings musicSettings;

    public StartGameState() {
        this.musicSettings = Generate.getGame().getMusicSettings();
    }

    public boolean isMusic() {
        return musicSettings.isMusicOn();
    }

    public void toggleMusic() {
        musicSettings.toggleMusic();
    }

    public void setFrameToClose(JFrame frame) {
        this.frameToClose = frame;
    }

    public void startGame() {
        if (frameToClose != null) {
            frameToClose.dispose();
        }

        SwingUtilities.invokeLater(() -> Generate.getGame().start());
        if (musicSettings.isMusicOn())
            Generate.getGame().play();
    }

    public MusicSettings getMusicSettings() {
        return musicSettings;
    }
}
```

---

# File: src/StartGame/VolumeSlider.java

```java
package StartGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.function.Consumer;

/**
 * Thin horizontal volume bar. Click or drag anywhere on the track to set
 * the level. Doesn't touch audio APIs itself — just reports the new value
 * via onChange so it stays decoupled from however playback is wired.
 */
public class VolumeSlider extends JComponent {

    public static final int WIDTH = 140;
    public static final int HEIGHT = 18;

    private final MusicSettings musicSettings;
    private final Consumer<Float> onChange;

    public VolumeSlider(MusicSettings musicSettings, Consumer<Float> onChange) {
        this.musicSettings = musicSettings;
        this.onChange = onChange;
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setOpaque(false);
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        MouseAdapter dragHandler = new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                applyFromMouse(e.getX());
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                applyFromMouse(e.getX());
            }
        };
        addMouseListener(dragHandler);
        addMouseMotionListener(dragHandler);
    }

    private void applyFromMouse(int mouseX) {
        float fraction = Math.max(0f, Math.min(1f, mouseX / (float) getWidth()));
        musicSettings.setVolume(fraction);
        onChange.accept(fraction);
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int w = getWidth();
        int h = getHeight();
        int trackH = 6;
        int trackY = (h - trackH) / 2;

        g2.setColor(new Color(30, 24, 16));
        g2.fillRoundRect(0, trackY, w, trackH, trackH, trackH);
        g2.setColor(new Color(198, 165, 96, 120));
        g2.drawRoundRect(0, trackY, w - 1, trackH, trackH, trackH);

        float volume = musicSettings.getVolume();
        int filledW = Math.round(w * volume);
        if (filledW > 0) {
            g2.setPaint(new GradientPaint(0, 0, new Color(120, 96, 52), filledW, 0, new Color(198, 165, 96)));
            g2.fillRoundRect(0, trackY, filledW, trackH, trackH, trackH);
        }

        int knobD = h;
        int knobX = Math.max(0, Math.min(w - knobD, filledW - knobD / 2));
        g2.setColor(new Color(230, 214, 170));
        g2.fillOval(knobX, 0, knobD, knobD);
        g2.setColor(new Color(120, 96, 52));
        g2.drawOval(knobX, 0, knobD - 1, knobD - 1);

        g2.dispose();
    }
}
```

---

# File: src/Utils/ImageLoader.java

```java
package Utils;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

/**
 * Loads images from the classpath instead of an absolute filesystem path,
 * so the art still resolves after a `git clone` on another machine.
 * Paths are rooted at the classpath root — e.g. "/Images/Buildings/Farm.png"
 * resolves to src/main/resources/Images/Buildings/Farm.png once Maven's added.
 */
public final class ImageLoader {

    private ImageLoader() {
    }

    public static Image load(String classpathPath) {
        URL url = ImageLoader.class.getResource(classpathPath);
        if (url == null) {
            return null;
        }
        return new ImageIcon(url).getImage();
    }
}
```

---

