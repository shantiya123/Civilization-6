package Models.Elements;

import Models.Elements.Resources.Resource;

import java.util.Map;

public interface Buildable {

    Map<Class<? extends Resource>, Integer> getBuildingCost();
}
