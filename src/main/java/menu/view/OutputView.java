package menu.view;

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

    private void print(final Object message, final Object... values) {
        System.out.println(formatMessage(message.toString(), values));
    }

    private String formatMessage(final Object formatMessage, final Object... values) {
        return String.format(formatMessage.toString(), values);
    }
}
