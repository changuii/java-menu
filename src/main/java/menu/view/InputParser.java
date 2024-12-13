package menu.view;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import menu.enums.Menu;

public class InputParser {
    private static final String INPUT_DELIMITER = ",";

    public List<String> parseCoachNames(final String coachNamesText) {
        return Arrays.asList(coachNamesText.split(INPUT_DELIMITER));
    }

    public List<Menu> parseCoachCantEatMenus(final String coachCantEatMenuText) {
        return Arrays.stream(coachCantEatMenuText.split(INPUT_DELIMITER))
                .map(Menu::parseMenu)
                .collect(Collectors.toList());
    }
}
