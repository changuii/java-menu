package menu.enums;

import java.util.Arrays;

public enum MenuCategory {
    JAPAN("일식", 1),
    KOREA("한식", 2),
    CHINA("중식", 3),
    ASIAN("아시안", 4),
    WESTERN("양식", 5),
    EMPTY("", 0);

    private String name;
    private int index;

    MenuCategory(final String name, final int index) {
        this.name = name;
        this.index = index;
    }

    public static MenuCategory parseNumberToMenuCategory(final int number) {
        return Arrays.stream(values())
                .filter(menuCategory -> menuCategory.index == number)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.CATEGORY_NOT_FOUND.getMessage()));
    }

    public String getName() {
        return name;
    }
}
