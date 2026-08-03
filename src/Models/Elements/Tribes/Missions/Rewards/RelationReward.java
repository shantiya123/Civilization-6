package Models.Elements.Tribes.Missions.Rewards;

public class RelationReward implements MissionReward {

    private final int amount;

    public RelationReward(int amount) { this.amount = amount; }

    public int getAmount() { return amount; }
}
