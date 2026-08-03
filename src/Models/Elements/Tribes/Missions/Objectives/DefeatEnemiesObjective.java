package Models.Elements.Tribes.Missions.Objectives;

public class DefeatEnemiesObjective implements MissionObjective {

    private final int requiredDefeats;
    private final int radius;

    public DefeatEnemiesObjective(int requiredDefeats, int radius) {
        this.requiredDefeats = requiredDefeats;
        this.radius = radius;
    }

    public int getRequiredDefeats() { return requiredDefeats; }
    public int getRadius() { return radius; }
}
