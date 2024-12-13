package menu.enums;

import java.util.Arrays;

public enum Menu {
    // 일식
    GYUDON("일식", "규동"),
    UDON("일식", "우동"),
    MISO_SOUP("일식", "미소시루"),
    SUSHI("일식", "스시"),
    KATSUDON("일식", "가츠동"),
    ONIGIRI("일식", "오니기리"),
    HAYASHI_RICE("일식", "하이라이스"),
    RAMEN("일식", "라멘"),
    OKONOMIYAKI("일식", "오코노미야끼"),

    // 한식
    GIMBAP("한식", "김밥"),
    KIMCHI_STEW("한식", "김치찌개"),
    SSAMBAP("한식", "쌈밥"),
    DOENJANG_STEW("한식", "된장찌개"),
    BIBIMBAP("한식", "비빔밥"),
    KALGUKSU("한식", "칼국수"),
    BULGOGI("한식", "불고기"),
    TTEOKBOKKI("한식", "떡볶이"),
    JEYUK_BOKKEUM("한식", "제육볶음"),

    // 중식
    KANPUNGKI("중식", "깐풍기"),
    FRIED_NOODLES("중식", "볶음면"),
    DONG_PO_ROU("중식", "동파육"),
    JJAJANGMYEON("중식", "짜장면"),
    JJAMPPONG("중식", "짬뽕"),
    MAPO_TOFU("중식", "마파두부"),
    TANGSUYUK("중식", "탕수육"),
    TOMATO_EGG_STIR("중식", "토마토 달걀볶음"),
    GUOCHUJAPCHAE("중식", "고추잡채"),

    // 아시안
    PAD_THAI("아시안", "팟타이"),
    KHAO_PAD("아시안", "카오 팟"),
    NASI_GORENG("아시안", "나시고렝"),
    PINEAPPLE_FRIED_RICE("아시안", "파인애플 볶음밥"),
    PHO("아시안", "쌀국수"),
    TOM_YUM_GOONG("아시안", "똠얌꿍"),
    BANH_MI("아시안", "반미"),
    VIETNAMESE_SPRING_ROLLS("아시안", "월남쌈"),
    BUN_CHA("아시안", "분짜"),

    // 양식
    LASAGNA("양식", "라자냐"),
    GRATIN("양식", "그라탱"),
    GNOCCHI("양식", "뇨끼"),
    QUICHE("양식", "끼슈"),
    FRENCH_TOAST("양식", "프렌치 토스트"),
    BAGUETTE("양식", "바게트"),
    SPAGHETTI("양식", "스파게티"),
    PIZZA("양식", "피자"),
    PANINI("양식", "파니니"),
    EMPTY("", "");

    private String category;
    private String name;

    Menu(final String category, final String name) {
        this.category = category;
        this.name = name;
    }

    public static Menu parseMenu(final String menuText) {
        return Arrays.stream(values())
                .filter(menu -> menu.name.equals(menuText))
                .findAny()
                .orElseThrow(
                        () -> new IllegalArgumentException(ErrorMessage.COACH_CANT_EAT_MENUS_INVALID.getMessage()));
    }

}
