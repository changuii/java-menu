package menu.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import menu.enums.Menu;

public class InputView {
    private final InputValidator inputValidator;
    private final InputParser inputParser;

    public InputView(final InputValidator inputValidator, final InputParser inputParser) {
        this.inputValidator = inputValidator;
        this.inputParser = inputParser;
    }

    public List<String> readCoachNames() {
        String input = Console.readLine();
        inputValidator.validateCoachNamesText(input);
        List<String> coachNames = inputParser.parseCoachNames(input);
        inputValidator.validateCoachNames(coachNames);
        return coachNames;
    }

    public List<Menu> readCoachCantEatMenu() {
        String input = Console.readLine();
        inputValidator.validateCoachCantEatMenusText(input);
        List<Menu> coachCantEatMenus = inputParser.parseCoachCantEatMenus(input);
        inputValidator.validateCoachCantEatMenus(coachCantEatMenus);
        return coachCantEatMenus;
    }
}
