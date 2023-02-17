package lesson21.pattern.factory.abstracted;

class LuxuryCar extends Car {
    LuxuryCar(Location location) {
        super(CarType.LUXURY, location);
        System.out.println("Connecting to luxury car");
    }
}