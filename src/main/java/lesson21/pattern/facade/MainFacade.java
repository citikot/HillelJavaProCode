package lesson21.pattern.facade;

public class MainFacade {
    public static void main(String[] args) {
        HotelСuisine hotelСuisine = new HotelСuisine();
        System.out.println("Menu: " + hotelСuisine.getMenus());
        System.out.println("Vines: " + hotelСuisine.getVineCard());
    }
}
