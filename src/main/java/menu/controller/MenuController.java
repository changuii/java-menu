package menu.controller;

import menu.view.InputView;
import menu.view.OutputView;

public class MenuController {
    private final InputView inputView;
    private final OutputView outputView;

    public MenuController(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        outputView.printIntroduceService();
    }

    private void inputCoachNames() {
        outputView.printIntroduceCoachNamesInput();
        inputView.readCoachNames();
    }
}
