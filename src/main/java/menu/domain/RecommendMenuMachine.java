package menu.domain;


import java.util.ArrayList;
import java.util.List;
import menu.component.NumberGenerator;
import menu.component.ShuffleFunction;
import menu.enums.Menu;
import menu.enums.MenuCategory;

public class RecommendMenuMachine {
    private static final int RECOMMEND_COUNT = 7;
    private static final int RECOMMEND_CATEGORY_DUPLICATION_COUNT_MAX = 2;
    private final NumberGenerator numberGenerator;
    private final ShuffleFunction shuffleFunction;

    public RecommendMenuMachine(final NumberGenerator numberGenerator, final ShuffleFunction shuffleFunction) {
        this.numberGenerator = numberGenerator;
        this.shuffleFunction = shuffleFunction;
    }

    public List<MenuCategory> recommendCategories() {
        List<MenuCategory> recommendCategories = new ArrayList<>();
        while (recommendCategories.size() < RECOMMEND_COUNT) {
            recommendValidMenuCategory(recommendCategories);
        }
        return recommendCategories;
    }

    private MenuCategory recommendCategory() {
        return MenuCategory.parseNumberToMenuCategory(numberGenerator.generate());
    }

    private void recommendValidMenuCategory(final List<MenuCategory> menuCategories) {
        MenuCategory menuCategory = recommendCategory();
        while (calculateDuplicationCount(menuCategories, menuCategory) > RECOMMEND_CATEGORY_DUPLICATION_COUNT_MAX) {
            menuCategory = recommendCategory();
        }
        menuCategories.add(menuCategory);
    }

    private int calculateDuplicationCount(final List<MenuCategory> menuCategories, final MenuCategory target) {
        return (int) menuCategories.stream()
                .filter(menuCategory -> menuCategory == target)
                .count();
    }

    public void recommendMenus(final Coach coach, final List<MenuCategory> menuCategories) {
        while (!coach.isRecommendMenuComplete()) {
            recommendValidMenu(coach, menuCategories);
        }
    }

    private void recommendValidMenu(final Coach coach, final List<MenuCategory> menuCategory) {
        MenuCategory todayCategory = coach.getTodayCategory(menuCategory);
        Menu menu = recommendMenu(todayCategory);
        if (coach.isValidMenu(menu)) {
            coach.recommendMenu(menu);
        }
    }

    private String recommendRandomMenu(final MenuCategory menuCategory) {
        return shuffleFunction.shuffle(Menu.getMenusByCategories(menuCategory)).get(0);
    }

    private Menu recommendMenu(final MenuCategory menuCategory) {
        return Menu.parseMenu(recommendRandomMenu(menuCategory));
    }
}
