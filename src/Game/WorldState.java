package Game;

public class WorldState {
    private int ExtractionEfficiency = 1 ;

    private int SeaMovingCost = 50;


    public int getExtractionEfficiency() {
        return ExtractionEfficiency;
    }

    public void setExtractionEfficiency(int extractionEfficiency) {
        ExtractionEfficiency = extractionEfficiency;
    }

    public int getSeaMovingCost() {
        return SeaMovingCost;
    }

    public void setSeaMovingCost(int seaMovingCost) {
        SeaMovingCost = seaMovingCost;
    }
}
