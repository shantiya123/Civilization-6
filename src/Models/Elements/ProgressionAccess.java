package Models.Elements;

import Models.Elements.Buildable.Buildings.Building;
import Models.Elements.Units.Unit;

import java.util.ArrayList;
import java.util.List;

public class ProgressionAccess {

    private final List<Class<? extends Unit>> lockedUnits = new ArrayList<>();
    private final List<Class<? extends Building>> lockedBuildings = new ArrayList<>();

    public void lockUnit(Class<? extends Unit> unitClass) {
        if (!lockedUnits.contains(unitClass)) {
            lockedUnits.add(unitClass);
        }
    }

    public void unlockUnit(Class<? extends Unit> unitClass) {
        lockedUnits.remove(unitClass);
    }

    public boolean isUnitLocked(Class<? extends Unit> unitClass) {
        return lockedUnits.contains(unitClass);
    }

    public void lockBuilding(Class<? extends Building> buildingClass) {
        if (!lockedBuildings.contains(buildingClass)) {
            lockedBuildings.add(buildingClass);
        }
    }

    public void unlockBuilding(Class<? extends Building> buildingClass) {
        lockedBuildings.remove(buildingClass);
    }

    public boolean isBuildingLocked(Class<? extends Building> buildingClass) {
        return lockedBuildings.contains(buildingClass);
    }

    public List<Class<? extends Unit>> getLockedUnits() {
        return List.copyOf(lockedUnits);
    }

    public List<Class<? extends Building>> getLockedBuildings() {
        return List.copyOf(lockedBuildings);
    }


}
