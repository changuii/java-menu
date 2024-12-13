package menu.enums;

public enum OutputMessage {
    INTRODUCE_SERVICE("점심 메뉴 추천을 시작합니다.");

    private final String message;

    OutputMessage(final String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}

