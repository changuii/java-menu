package menu.domain;

import java.util.ArrayList;
import java.util.List;
import menu.enums.ErrorMessage;
import menu.enums.Menu;

public class Coach {
    private static final int COACH_NAME_LENGTH_MIN = 2;
    private static final int COACH_NAME_LENGTH_MAX = 4;
    private final String name;
    private final List<Menu> cantEatMenus;
    private final List<Menu> recommendMenus;

    private Coach(final String name) {
        validateName(name);
        this.name = name;
        this.cantEatMenus = new ArrayList<>();
        this.recommendMenus = new ArrayList<>();
    }

    public static Coach from(final String name) {
        return new Coach(name);
    }

    private void validateName(final String name) {
        if (name.length() < COACH_NAME_LENGTH_MIN || COACH_NAME_LENGTH_MAX < name.length()) {
            throw new IllegalArgumentException(ErrorMessage.COACH_NAMES_INVALID.getMessage());
        }
    }

}
