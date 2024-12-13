package menu.config;

import menu.controller.MenuController;
import menu.view.InputParser;
import menu.view.InputValidator;
import menu.view.InputView;
import menu.view.OutputView;

public abstract class MenuConfig {
    public static MenuController createController() {
        return new MenuController(createInputView(), new OutputView());
    }

    private static InputView createInputView() {
        return new InputView(new InputValidator(), new InputParser());
    }
}
