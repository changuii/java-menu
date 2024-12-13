package menu.controller;

import menu.view.InputView;

public class MenuController {
    private final InputView inputView;

    public MenuController(final InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {
        inputView.readCoachCantEatMenu();
    }
}
