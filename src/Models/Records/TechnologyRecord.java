package Models.Records;

import Models.Logic.Technologies.Technology;

import java.util.ArrayList;
import java.util.List;

public class TechnologyRecord {

    private final List<Technology> researchedTechnologies = new ArrayList<>();

    public void add(Technology technology) {
        researchedTechnologies.add(technology);
    }

    public boolean contains(Class<? extends Technology> technologyClass) {
        return researchedTechnologies.stream()
                .anyMatch(technology -> technology.getClass().equals(technologyClass));
    }

    public List<Technology> getAll() {
        return List.copyOf(researchedTechnologies);
    }
}
