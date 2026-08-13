package Models.Logic.TribeLogic.DiplomacyPolicy;
import Models.Elements.Resources.*;
import java.util.Map;
public final class FarmerDiplomacyPolicy extends ConfiguredTribeDiplomacyPolicy {
    public FarmerDiplomacyPolicy() { super(-2, Map.of(Food.class, 10, Wood.class, 6, Stone.class, 2, Iron.class, 1), 4, 15, -10, 0); }
}
