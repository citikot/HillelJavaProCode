package lesson21.pattern.factory.abstracted;

import java.util.Random;

class CarFactory {
    private static final Location[] LOCATIONS = Location.values();
    private static final Random RANDOM = new Random();

    private CarFactory() {
    }

    public static Car buildCar(CarType type) {
        // We can add any GPS Function here which
        // read location property somewhere from configuration
        // and use location specific car factory
        Location location = LOCATIONS[RANDOM.nextInt(LOCATIONS.length)];

        return switch (location) {
            case USA -> UsaCarFactory.buildCar(type);
            case UKRAINE -> UkraineCarFactory.buildCar(type);
            default -> throw new IllegalArgumentException("Unknown location " + location);
        };
    }
}