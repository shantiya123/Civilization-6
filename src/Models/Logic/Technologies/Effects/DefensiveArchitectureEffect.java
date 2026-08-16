package Models.Logic.Technologies.Effects;

import Game.World;
import Models.Elements.Buildable.Constructure.Wall;
import Models.Elements.Hex.Hex;
import Models.Logic.HexLogic.HexLogic;
import Models.Logic.Logic;

public class DefensiveArchitectureEffect extends  Logic implements Effect {
    public DefensiveArchitectureEffect(World world) {
        super(world);
    }

    @Override
    public void useEffect() {
        world.getTownHall().setHP(350);
        Hex townHallHex = world.getTownHall().getHex();
        if (townHallHex == null) return;
        for (Hex neighbor : HexLogic.getNeighbors(world, townHallHex)) {
            boolean hasWall = world.getBorderRecorder().getAll(Wall.class).stream()
                    .map(Wall::getHexes)
                    .anyMatch(hexes -> hexes.contains(townHallHex) && hexes.contains(neighbor));
            if (!hasWall) {
                world.getBorderRecorder().add(new Wall(townHallHex, neighbor));
            }
        }
    }
}
