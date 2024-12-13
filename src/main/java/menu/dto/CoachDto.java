package menu.dto;

import java.util.List;
import menu.enums.Menu;

public class CoachDto {
    private final String name;
    private final List<Menu> recommendMenus;

    private CoachDto(final String name, final List<Menu> recommendMenus) {
        this.name = name;
        this.recommendMenus = recommendMenus;
    }

    public static CoachDto of(final String name, final List<Menu> recommendMenus) {
        return new CoachDto(name, recommendMenus);
    }

    public String getName() {
        return name;
    }

    public List<Menu> getRecommendMenus() {
        return recommendMenus;
    }
}
