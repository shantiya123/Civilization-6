package Game.Views.TownHallPanel;

import Game.Controller.TownHallController;
import Models.Logic.Technologies.DefensiveArchitectureTechnology;
import Models.Logic.Technologies.SeafaringTechnology;
import Models.Logic.Technologies.SteelToolsTechnology;
import Models.Logic.Technologies.Technology;

import java.util.List;
import java.util.Map;

/** View model for the technology-choice popup; one panel/view-model purpose per DESIGN.md. */
public final class TechnologyOrderState {
    private final TownHallController controller;

    public TechnologyOrderState(TownHallController controller) {
        this.controller = controller;
    }

    public List<Class<? extends Technology>> getResearchableTechnologyTypes() {
        return List.of(DefensiveArchitectureTechnology.class, SeafaringTechnology.class, SteelToolsTechnology.class);
    }

    public String getTechnologyImagePath(Class<? extends Technology> technologyClass) {
        return TECHNOLOGY_IMAGES.get(technologyClass);
    }

    public void requestTechnologyOrder(Class<? extends Technology> technologyClass) {
        controller.requestTechnologyOrder(technologyClass);
    }

    private static final Map<Class<? extends Technology>, String> TECHNOLOGY_IMAGES = Map.of(
            DefensiveArchitectureTechnology.class, "/Images/Technologies/DefensiveArchitecture.png",
            SeafaringTechnology.class, "/Images/Technologies/Seafarm.jpg",
            SteelToolsTechnology.class, "/Images/Technologies/SteelTools.jpg"
    );
}