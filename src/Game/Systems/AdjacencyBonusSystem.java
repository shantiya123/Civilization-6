package Game.Systems;

import Game.World;
import Models.Logic.BuildingLogic.AdjacencyBonus.AdjacencyBonusDetect;

/** Rebuilds derived building adjacency production once per completed turn. */
public final class AdjacencyBonusSystem {
    private final AdjacencyBonusDetect bonusDetector;

    public AdjacencyBonusSystem(World world) {
        bonusDetector = new AdjacencyBonusDetect(world);
    }

    public void recalculateBonuses() {
        bonusDetector.recalculateAll();
    }
}
