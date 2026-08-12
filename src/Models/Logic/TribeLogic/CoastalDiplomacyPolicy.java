package Models.Logic.TribeLogic;
import Models.Elements.Resources.*;
import java.util.Map;
public final class CoastalDiplomacyPolicy extends ConfiguredTribeDiplomacyPolicy {
    public CoastalDiplomacyPolicy() { super(-3, Map.of(Food.class, 8, Wood.class, 10, Stone.class, 3, Iron.class, 2), 4, 16, -10, 0); }
}
