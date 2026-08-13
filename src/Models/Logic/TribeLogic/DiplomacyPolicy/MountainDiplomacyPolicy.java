package Models.Logic.TribeLogic.DiplomacyPolicy;
import Models.Elements.Resources.*;

import java.util.Map;
public final class MountainDiplomacyPolicy extends ConfiguredTribeDiplomacyPolicy {
    public MountainDiplomacyPolicy() { super(-5, Map.of(Food.class, 2, Wood.class, 5, Stone.class, 10, Iron.class, 8), 3, 17, -11, -5); }
}
