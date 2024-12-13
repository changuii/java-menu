package menu.view;

import java.util.List;
import java.util.stream.Collectors;
import menu.dto.CoachDto;
import menu.enums.Menu;
import menu.enums.MenuCategory;
import menu.enums.OutputMessage;

public class OutputView {
    public void printIntroduceService() {
        print(OutputMessage.INTRODUCE_SERVICE);
    }

    public void printIntroduceCoachNamesInput() {
        print(OutputMessage.INTRODUCE_COACH_NAMES_INPUT);
    }

    public void printIntroduceCoachCantEatMenusInput(final String name) {
        print(OutputMessage.INTRODUCE_COACH_CANT_EAT_MENUS_INPUT, name);
    }

    public void printMenuRecommendHeader() {
        print(OutputMessage.MENU_RECOMMEND_HEADER);
    }

    public void printMenuCategories(final List<MenuCategory> menuCategories) {
        print(OutputMessage.MENU_RECOMMEND_BRACKET, formatMenuCategories(menuCategories));
    }

    public void printCoaches(final List<CoachDto> coachDtos) {
        coachDtos.forEach(this::printCoach);
    }

    private void printCoach(final CoachDto coachDto) {
        print(OutputMessage.MENU_RECOMMEND_BRACKET, formatCoaches(coachDto));
    }

    private String formatCoaches(final CoachDto coachDto) {
        String recommendMenus = coachDto.getRecommendMenus().stream()
                .map(Menu::getName)
                .collect(Collectors.joining(OutputMessage.MENU_RECOMMEND_DELIMITER.toString()));
        return formatRecommendRow(coachDto.getName(), recommendMenus);
    }

    public void printMenuRecommendComplete() {
        print(OutputMessage.MENU_RECOMMEND_COMPLETE);
    }

    public void printErrorMessage(final IllegalArgumentException customException) {
        print(customException.getMessage());
    }

    private String formatMenuCategories(final List<MenuCategory> menuCategories) {
        String menuCategory = menuCategories.stream()
                .map(MenuCategory::getName)
                .collect(Collectors.joining(OutputMessage.MENU_RECOMMEND_DELIMITER.toString()));
        return formatRecommendRow(OutputMessage.MENU_RECOMMEND_CATEGORY_ROW.toString(), menuCategory);
    }

    private String formatRecommendRow(final String row, final String menuCategory) {
        return String.join(OutputMessage.MENU_RECOMMEND_DELIMITER.toString(),
                row, menuCategory);
    }

    private void print(final Object message, final Object... values) {
        System.out.println(formatMessage(message.toString(), values));
    }

    private String formatMessage(final Object formatMessage, final Object... values) {
        return String.format(formatMessage.toString(), values);
    }
}
