package Persistence;

import Game.World;

/** Everything SaveManager.load reconstructs from a save file. */
public record LoadResult(World world, int turn) {
}