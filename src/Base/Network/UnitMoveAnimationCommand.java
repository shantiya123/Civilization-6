package Base.Network;
/** TCP broadcast command; models are identified, never sent by reference. */
public record UnitMoveAnimationCommand(String recipientToken, int unitId, int fromHexId, int toHexId) implements ClientCommand { }
