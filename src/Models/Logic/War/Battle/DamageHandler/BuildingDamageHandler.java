package Models.Logic.War.Battle.DamageHandler;

import Game.World;
import Models.Elements.Buildable.Buildings.Building;
import Models.Elements.Buildable.Buildings.TribeCamp;
import Models.Elements.Hex.Hex;
import Models.Logic.War.Battle.DamageUnit;
import Models.Logic.War.DamageBuildings;

/** Applies a hit to the building on the target hex after all combat units are gone. */
public final class BuildingDamageHandler extends DamageUnit {
    public BuildingDamageHandler(World world) { super(world); }

    @Override protected boolean damageThisType(Hex hex, int damage) {
        Building building = hex.getBuilding();
        if (building == null) return false;
        if (building instanceof TribeCamp camp) new DamageBuildings(world).damage(camp, damage);
        else building.getLogic().damage(damage);
        return true;
    }
}
