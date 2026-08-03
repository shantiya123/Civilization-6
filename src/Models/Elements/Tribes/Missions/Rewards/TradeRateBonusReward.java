package Models.Elements.Tribes.Missions.Rewards;

public class TradeRateBonusReward implements MissionReward {

    private final int percentage;

    public TradeRateBonusReward(int percentage) { this.percentage = percentage; }

    public int getPercentage() { return percentage; }
}
