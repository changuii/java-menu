package menu.enums;

public enum MenuCategory {
    JAPAN("일식"),
    KOREA("한식"),
    CHINA("중식"),
    ASIAN("아시안"),
    WESTERN("양식"),
    EMPTY("");

    private String name;

    MenuCategory(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
