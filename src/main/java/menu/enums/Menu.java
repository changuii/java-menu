package menu.enums;

import java.util.Arrays;

public enum Menu {
    // 일식
    GYUDON(MenuCategory.JAPAN, "규동"),
    UDON(MenuCategory.JAPAN, "우동"),
    MISO_SOUP(MenuCategory.JAPAN, "미소시루"),
    SUSHI(MenuCategory.JAPAN, "스시"),
    KATSUDON(MenuCategory.JAPAN, "가츠동"),
    ONIGIRI(MenuCategory.JAPAN, "오니기리"),
    HAYASHI_RICE(MenuCategory.JAPAN, "하이라이스"),
    RAMEN(MenuCategory.JAPAN, "라멘"),
    OKONOMIYAKI(MenuCategory.JAPAN, "오코노미야끼"),

    // 한식
    GIMBAP(MenuCategory.KOREA, "김밥"),
    KIMCHI_STEW(MenuCategory.KOREA, "김치찌개"),
    SSAMBAP(MenuCategory.KOREA, "쌈밥"),
    DOENJANG_STEW(MenuCategory.KOREA, "된장찌개"),
    BIBIMBAP(MenuCategory.KOREA, "비빔밥"),
    KALGUKSU(MenuCategory.KOREA, "칼국수"),
    BULGOGI(MenuCategory.KOREA, "불고기"),
    TTEOKBOKKI(MenuCategory.KOREA, "떡볶이"),
    JEYUK_BOKKEUM(MenuCategory.KOREA, "제육볶음"),

    // 중식
    KANPUNGKI(MenuCategory.CHINA, "깐풍기"),
    FRIED_NOODLES(MenuCategory.CHINA, "볶음면"),
    DONG_PO_ROU(MenuCategory.CHINA, "동파육"),
    JJAJANGMYEON(MenuCategory.CHINA, "짜장면"),
    JJAMPPONG(MenuCategory.CHINA, "짬뽕"),
    MAPO_TOFU(MenuCategory.CHINA, "마파두부"),
    TANGSUYUK(MenuCategory.CHINA, "탕수육"),
    TOMATO_EGG_STIR(MenuCategory.CHINA, "토마토 달걀볶음"),
    GUOCHUJAPCHAE(MenuCategory.CHINA, "고추잡채"),

    // 아시안
    PAD_THAI(MenuCategory.ASIAN, "팟타이"),
    KHAO_PAD(MenuCategory.ASIAN, "카오 팟"),
    NASI_GORENG(MenuCategory.ASIAN, "나시고렝"),
    PINEAPPLE_FRIED_RICE(MenuCategory.ASIAN, "파인애플 볶음밥"),
    PHO(MenuCategory.ASIAN, "쌀국수"),
    TOM_YUM_GOONG(MenuCategory.ASIAN, "똠얌꿍"),
    BANH_MI(MenuCategory.ASIAN, "반미"),
    VIETNAMESE_SPRING_ROLLS(MenuCategory.ASIAN, "월남쌈"),
    BUN_CHA(MenuCategory.ASIAN, "분짜"),

    // 양식
    LASAGNA(MenuCategory.WESTERN, "라자냐"),
    GRATIN(MenuCategory.WESTERN, "그라탱"),
    GNOCCHI(MenuCategory.WESTERN, "뇨끼"),
    QUICHE(MenuCategory.WESTERN, "끼슈"),
    FRENCH_TOAST(MenuCategory.WESTERN, "프렌치 토스트"),
    BAGUETTE(MenuCategory.WESTERN, "바게트"),
    SPAGHETTI(MenuCategory.WESTERN, "스파게티"),
    PIZZA(MenuCategory.WESTERN, "피자"),
    PANINI(MenuCategory.WESTERN, "파니니"),
    EMPTY(MenuCategory.EMPTY, "");

    private MenuCategory category;
    private String name;

    Menu(final MenuCategory category, final String name) {
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
