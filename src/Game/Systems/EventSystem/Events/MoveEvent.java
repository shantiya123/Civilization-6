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
