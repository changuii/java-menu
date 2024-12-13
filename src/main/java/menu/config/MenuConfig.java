package menu.config;

import menu.controller.MenuController;
import menu.view.InputParser;
import menu.view.InputValidator;
import menu.view.InputView;

public abstract class MenuConfig {
    public static MenuController createController() {
        return new MenuController(createInputView());
    }

    private static InputView createInputView() {
        return new InputView(new InputValidator(), new InputParser());
    }
}
