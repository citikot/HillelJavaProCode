package lesson21.pattern.facade;

import java.util.List;

public class MeatRestaurant implements Restaurant {

    @Override
    public List<String> getMenus() {
        return List.of("Meat");
    }
}