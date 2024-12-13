package menu.config;

import menu.component.DtoConverter;
import menu.component.RandomNumberGenerator;
import menu.component.RandomShuffleFunction;
import menu.controller.MenuController;
import menu.domain.RecommendMenuMachine;
import menu.handler.RetryHandler;
import menu.view.InputParser;
import menu.view.InputValidator;
import menu.view.InputView;
import menu.view.OutputView;

public abstract class MenuConfig {
    public static MenuController createController() {
        return new MenuController(createInputView(), new OutputView(), new DtoConverter(), new RetryHandler(),
                createRecommendMenuMachine());
    }

    private static InputView createInputView() {
        return new InputView(new InputValidator(), new InputParser());
    }

    private static RecommendMenuMachine createRecommendMenuMachine() {
        return new RecommendMenuMachine(new RandomNumberGenerator(), new RandomShuffleFunction());
    }
}
