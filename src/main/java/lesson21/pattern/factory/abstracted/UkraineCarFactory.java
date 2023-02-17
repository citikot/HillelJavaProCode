package lesson21.pattern.factory.abstracted;

class UkraineCarFactory {
    private UkraineCarFactory() {
    }

    public static Car buildCar(CarType carType) {
        return switch (carType) {
            case MICRO -> new MicroCar(Location.UKRAINE);
            case MINI -> new MiniCar(Location.UKRAINE);
            case LUXURY -> new LuxuryCar(Location.UKRAINE);
            default -> throw new IllegalArgumentException("Unknown carType " + carType);
        };
    }
}