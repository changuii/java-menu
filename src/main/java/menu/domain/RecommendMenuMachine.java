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

    public List<MenuCategory> recommendLaunch(final List<Coach> coaches) {
        List<MenuCategory> categories = new ArrayList<>();
        while (!isAllCoachRecommendComplete(coaches)){
            MenuCategory menuCategory = recommendCategory(categories);
            coaches.forEach(coach -> recommendMenus(coach, menuCategory));
        }
        return categories;
    }

    private boolean isAllCoachRecommendComplete(final List<Coach> coaches) {
        return coaches.stream()
                .filter(coach -> coach.isRecommendMenuComplete())
                .count() == coaches.size();
    }

    private MenuCategory recommendCategory(List<MenuCategory> menuCategories) {
        MenuCategory menuCategory = recommendValidMenuCategory(menuCategories);
        menuCategories.add(menuCategory);
        return menuCategory;
    }

    private MenuCategory recommendRandomCategory() {
        return MenuCategory.parseNumberToMenuCategory(numberGenerator.generate());
    }

    private MenuCategory recommendValidMenuCategory(final List<MenuCategory> menuCategories) {
        MenuCategory menuCategory = recommendRandomCategory();
        while (!isValidDuplicationCount(menuCategories, menuCategory)) {
            menuCategory = recommendRandomCategory();
        }
        return menuCategory;
    }

    private boolean isValidDuplicationCount(final List<MenuCategory> menuCategories, final MenuCategory target) {
        return (int) menuCategories.stream()
                .filter(menuCategory -> menuCategory == target)
                .count() < RECOMMEND_CATEGORY_DUPLICATION_COUNT_MAX;
    }

    private void recommendMenus(final Coach coach, final MenuCategory menuCategory) {
        recommendValidMenu(coach, menuCategory);
    }

    private void recommendValidMenu(final Coach coach, final MenuCategory menuCategory) {
        Menu menu = recommendMenu(menuCategory);
        while (!coach.isValidMenu(menu)) {
            menu = recommendMenu(menuCategory);
        }
        coach.recommendMenu(menu);
    }

    private String recommendRandomMenu(final MenuCategory menuCategory) {
        return shuffleFunction.shuffle(Menu.getMenusByCategories(menuCategory)).get(0);
    }

    private Menu recommendMenu(final MenuCategory menuCategory) {
        return Menu.parseMenu(recommendRandomMenu(menuCategory));
    }
}
