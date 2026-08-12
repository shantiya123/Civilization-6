package Models.Logic.TribeLogic;

import Models.Elements.Tribes.Tribe;

/** Single application point for relationship deltas calculated by a tribe policy. */
public final class RelationshipChangeService {
    private RelationshipChangeService() {
    }

    public static void apply(Tribe tribe, RelationshipChange change) {
        if (tribe == null || change == null) {
            throw new IllegalArgumentException("Tribe and relationship change are required");
        }
        tribe.changeRelationship(change.amount());
    }
}
