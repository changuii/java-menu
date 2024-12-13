package menu;

import menu.config.MenuConfig;
import menu.controller.MenuController;

public class Application {
    public static void main(String[] args) {
        MenuController controller = MenuConfig.createController();
        controller.run();
    }
}
