package lesson21.pattern.factory.abstracted;

class MicroCar extends Car {
    MicroCar(Location location) {
        super(CarType.MICRO, location);
        System.out.println("Connecting to Micro Car ");
    }
}