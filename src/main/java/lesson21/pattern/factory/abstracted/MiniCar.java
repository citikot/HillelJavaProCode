package lesson21.pattern.factory.abstracted;

class MiniCar extends Car {
    MiniCar(Location location) {
        super(CarType.MINI, location);
        System.out.println("Connecting to Mini car");
    }
}