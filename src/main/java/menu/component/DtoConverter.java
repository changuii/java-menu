package menu.component;

import java.util.List;
import java.util.stream.Collectors;
import menu.domain.Coach;

public class DtoConverter {
    public List<Coach> namesToCoaches(final List<String> coachNames) {
        return coachNames.stream()
                .map(Coach::from)
                .collect(Collectors.toList());
    }
}
