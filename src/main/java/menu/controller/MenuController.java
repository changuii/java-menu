package menu.controller;

import java.util.List;
import java.util.stream.Collectors;
import menu.component.DtoConverter;
import menu.domain.Coach;
import menu.domain.RecommendMenuMachine;
import menu.enums.Menu;
import menu.enums.MenuCategory;
import menu.handler.RetryHandler;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuController {
    private final InputView inputView;
    private final OutputView outputView;
    private final DtoConverter dtoConverter;
    private final RetryHandler retryHandler;
    private final RecommendMenuMachine recommendMenuMachine;

    public MenuController(final InputView inputView, final OutputView outputView, final DtoConverter dtoConverter,
                          final RetryHandler retryHandler, final RecommendMenuMachine recommendMenuMachine) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.dtoConverter = dtoConverter;
        this.retryHandler = retryHandler;
        this.recommendMenuMachine = recommendMenuMachine;
    }

    public void run() {
        outputView.printIntroduceService();
        List<Coach> coaches = retryHandler.retryUntilNotException(this::inputCoaches, outputView::printErrorMessage);
        List<MenuCategory> categories = recommendMenus(coaches);
        outputRecommendResult(coaches, categories);
    }

    private List<Coach> inputCoaches() {
        outputView.printIntroduceCoachNamesInput();
        List<String> coachNames = inputView.readCoachNames();
        List<List<Menu>> coachesCantEatMenus = inputCoachesCantEatMenus(coachNames);
        return dtoConverter.convertCoaches(coachNames, coachesCantEatMenus);
    }

    private List<List<Menu>> inputCoachesCantEatMenus(final List<String> coachNames) {
        return coachNames.stream()
                .map(this::inputCoachCantEatMenus)
                .collect(Collectors.toList());
    }

    private List<Menu> inputCoachCantEatMenus(final String coachName) {
        outputView.printIntroduceCoachCantEatMenusInput(coachName);
        return inputView.readCoachCantEatMenu();
    }

    private List<MenuCategory> recommendMenus(final List<Coach> coaches) {
        return recommendMenuMachine.recommendLaunch(coaches);
    }

    private void outputRecommendResult(final List<Coach> coaches, final List<MenuCategory> menuCategories) {
        outputView.printMenuRecommendHeader();
        outputView.printMenuCategories(menuCategories);
        outputView.printCoaches(dtoConverter.convertCoachDtos(coaches));
        outputView.printMenuRecommendComplete();
    }
}
