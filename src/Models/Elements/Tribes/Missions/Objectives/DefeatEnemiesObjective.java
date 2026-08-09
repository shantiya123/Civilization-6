package Models.Elements.Tribes.Missions.Objectives;

public class DefeatEnemiesObjective implements MissionObjective {

    private final int requiredDefeats;
    private final int radius;
    private int defeatedEnemies;

    public DefeatEnemiesObjective(int requiredDefeats, int radius) {
        this.requiredDefeats = requiredDefeats;
        this.radius = radius;
    }

    public int getRequiredDefeats() { return requiredDefeats; }
    public int getRadius() { return radius; }
    public int getDefeatedEnemies() { return defeatedEnemies; }
    public void recordDefeat() { defeatedEnemies++; }
    public boolean isComplete() { return defeatedEnemies >= requiredDefeats; }
}
