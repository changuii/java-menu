package menu.view;

import java.util.Arrays;
import java.util.List;

public class InputParser {
    private static final String COACH_NAMES_DELIMITER = ",";

    public List<String> parseCoachNames(final String coachNamesText) {
        return Arrays.asList(coachNamesText.split(COACH_NAMES_DELIMITER));
    }
}
