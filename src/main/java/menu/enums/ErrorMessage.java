package menu.enums;

public enum ErrorMessage {
    COACH_NAMES_INVALID("코치 이름이 유효하지 않습니다.");
    private static final String ERROR_PREFIX = "[ERROR] ";
    private final String message;

    ErrorMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_PREFIX + message;
    }
}
