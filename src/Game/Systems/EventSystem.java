package Game.Systems;

import Models.Elements.Hex.Hex;
import Models.Elements.Units.Unit;
import Models.Elements.Buildings.Building;

public class EventSystem {

    // --- Movement Events ---
    public void UnitMoved(Hex oldHex, Hex newHex, Unit unit) {}
    public void UnitCannotMove(Hex hex) {}

    // --- Selection Events ---
    public void UnitSelected(Unit unit) {}
    public void HexSelected(Hex hex) {}

    // --- Build Events ---
    public void BuildingConstructed(Building building, Hex hex) {}
    public void BuildingFailed(String reason) {}

    // --- Work Events ---
    public void WorkerStationed(Unit worker, Building building) {}
    public void WorkerUnstationed(Unit worker) {}
    public void WorkerActionFailed(String reason) {}

    // --- Exploration Events ---
    public void HexExplored(Hex hex) {}
    public void ExplorationFailed(String reason) {}

    // --- Border Events ---
    public void BorderExpanded(Hex hex) {}
    public void BorderExpansionFailed(String reason) {}
}