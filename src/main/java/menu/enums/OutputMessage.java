package menu.enums;

public enum OutputMessage {
    INTRODUCE_SERVICE("점심 메뉴 추천을 시작합니다."),
    INTRODUCE_COACH_NAMES_INPUT("코치의 이름을 입력해 주세요. (, 로 구분)"),
    INTRODUCE_COACH_CANT_EAT_MENUS_INPUT("%s(이)가 못 먹는 메뉴를 입력해 주세요."),
    MENU_RECOMMEND_HEADER(
            "메뉴 추천 결과입니다.\n"
                    + "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]"
    );

    private final String message;

    OutputMessage(final String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}

