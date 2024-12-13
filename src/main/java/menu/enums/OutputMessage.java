package menu.enums;

public enum OutputMessage {
    INTRODUCE_SERVICE("점심 메뉴 추천을 시작합니다."),
    INTRODUCE_COACH_NAMES_INPUT("코치의 이름을 입력해 주세요. (, 로 구분)");

    private final String message;

    OutputMessage(final String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
    }

