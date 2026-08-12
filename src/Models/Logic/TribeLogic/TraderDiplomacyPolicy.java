package Models.Logic.TribeLogic;
import Models.Elements.Resources.*;
import java.util.Map;
public final class TraderDiplomacyPolicy extends ConfiguredTribeDiplomacyPolicy {
    public TraderDiplomacyPolicy() { super(-3, Map.of(Food.class, 6, Wood.class, 8, Stone.class, 7, Iron.class, 9), 6, 16, -10, 0); }
}
