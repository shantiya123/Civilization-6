package Models.Logic.NaturalDisasterLogic;

import Game.World;
import Models.Elements.Hex.Hex;
import Models.Elements.Hex.SeaHex;
import Models.Elements.NatrualDisasters.Tsunami;

import java.util.ArrayList;

public class TsunamiLogic extends NaturalDisasterLogic {
    private final Tsunami tsunami;

    public TsunamiLogic(World world, Tsunami tsunami) {
        super(world, tsunami);
        this.tsunami = tsunami;
    }

    @Override
    public void calculateEffectRadius() {
        if (!(tsunami.getHex() instanceof SeaHex)) {
            throw new IllegalStateException("Tsunami must start on a coastal sea hex");
        }

        ArrayList<Hex> affected = new ArrayList<>();
        affected.add(tsunami.getHex());
        for (Hex neighbor : getHexesWithin(tsunami.getHex(), 1)) {
            if (neighbor != tsunami.getHex() && isCoastal(neighbor)) {
                affected.add(neighbor);
                if (affected.size() == 3) {
                    break;
                }
            }
        }
        tsunami.setEffectRadius(affected);
    }

    @Override
    public void effect() {
        if (tsunami.getEffectRadius().isEmpty()) {
            calculateEffectRadius();
        }
        damageUnits(tsunami.getEffectRadius(), 30, true);
        destroyBuildings(tsunami.getEffectRadius());
    }

    private boolean isCoastal(Hex hex) {
        return hex instanceof SeaHex || getHexesWithin(hex, 1).stream()
                .anyMatch(neighbor -> neighbor instanceof SeaHex);
    }
}
