package Models.Logic.TribeLogic.RelationSheepState;

import Game.World;
import Models.Elements.Tribes.Tribe;

public class EnemyState extends RelationshipState {
    public EnemyState(World world, Tribe tribe) { super(world, tribe); }
    @Override public boolean check() { return tribe.getRelationship() <= -50; }
    @Override public void requestPeace() { behavior().callForPiece(); }
}
