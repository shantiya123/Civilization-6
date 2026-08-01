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
