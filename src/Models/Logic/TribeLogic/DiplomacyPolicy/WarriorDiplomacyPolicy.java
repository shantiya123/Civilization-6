package Models.Logic.TribeLogic.DiplomacyPolicy;
import Models.Elements.Resources.*;

import java.util.Map;
public final class WarriorDiplomacyPolicy extends ConfiguredTribeDiplomacyPolicy {
    public WarriorDiplomacyPolicy() { super(-6, Map.of(Food.class, 3, Wood.class, 4, Stone.class, 5, Iron.class, 10), 2, 18, -12, -10); }
}
