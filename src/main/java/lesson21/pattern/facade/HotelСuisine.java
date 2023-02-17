package lesson21.pattern.facade;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HotelСuisine implements Restaurant, Bar {
    private Restaurant meatRestaurant = new MeatRestaurant();
    private Restaurant vegetarianRestaurant = new VegetarianRestaurant();
    private Restaurant fishRestaurant = new FishRestaurant();
    private GroundFloorBar groundFloorBar = new GroundFloorBar();

    @Override
    public List<String> getMenus() {
        List<String> globalMenu = new ArrayList<>();
        globalMenu.addAll(meatRestaurant.getMenus());
        globalMenu.addAll(vegetarianRestaurant.getMenus());
        globalMenu.addAll(fishRestaurant.getMenus());
        return globalMenu;
    }

    @Override
    public Map<String, Integer> getVineCard() {
        return groundFloorBar.getVineCard();
    }

}
