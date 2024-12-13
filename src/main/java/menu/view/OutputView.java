package menu.view;

import menu.enums.OutputMessage;

public class OutputView {
    public void printIntroduceService() {
        print(OutputMessage.INTRODUCE_SERVICE);
    }

    private void print(final Object message, final Object... values) {
        System.out.println(formatMessage(message.toString(), values));
    }

    private String formatMessage(final Object formatMessage, final Object... values) {
        return String.format(formatMessage.toString(), values);
    }
}
