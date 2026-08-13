package Models.Logic.TribeLogic.RelationshipState;

import Game.World;
import Models.Elements.Tribes.Tribe;
import Models.Logic.TribeLogic.Decisions.TribeDecisionType;

import java.util.List;

public class EnemyState extends RelationshipState {
    public EnemyState(World world, Tribe tribe) { super(world, tribe); }
    @Override public boolean check() { return tribe.getRelationship() <= -50; }
    @Override public void requestPeace() { behavior().callForPiece(); }
    @Override public List<TribeDecisionType> availableDecisions() {
        return List.of(TribeDecisionType.DEFEND_TERRITORY, TribeDecisionType.CONTINUE_RAID,
                TribeDecisionType.LAUNCH_RAID, TribeDecisionType.GENERATE_GUARD, TribeDecisionType.IDLE);
    }
}
