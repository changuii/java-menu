package menu.controller;

import java.util.List;
import menu.component.DtoConverter;
import menu.domain.Coach;
import menu.handler.RetryHandler;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuController {
    private final InputView inputView;
    private final OutputView outputView;
    private final DtoConverter dtoConverter;
    private final RetryHandler retryHandler;

    public MenuController(final InputView inputView, final OutputView outputView, final DtoConverter dtoConverter,
                          final RetryHandler retryHandler) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.dtoConverter = dtoConverter;
        this.retryHandler = retryHandler;
    }

    public void run() {
        outputView.printIntroduceService();
        List<Coach> coaches = retryHandler.retryUntilNotException(this::inputCoaches, outputView::printErrorMessage);
    }

    private List<Coach> inputCoaches() {
        outputView.printIntroduceCoachNamesInput();
        List<String> coachNames = inputView.readCoachNames();
        return dtoConverter.namesToCoaches(coachNames);
    }
}
