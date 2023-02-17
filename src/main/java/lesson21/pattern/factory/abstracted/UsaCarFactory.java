package lesson21.pattern.factory.abstracted;

class UsaCarFactory {
    private UsaCarFactory() {
    }

    public static Car buildCar(CarType carType) {
        return switch (carType) {
            case MICRO -> new MicroCar(Location.USA);
            case MINI -> new MiniCar(Location.USA);
            case LUXURY -> new LuxuryCar(Location.USA);
            default -> throw new IllegalArgumentException("Unknown carType " + carType);
        };
    }
}