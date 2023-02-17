package lesson21.pattern.factory.abstracted;

abstract class Car {
    private CarType model = null;
    private Location location = null;
    
    Car(CarType model, Location location) {
        this.model = model;
        this.location = location;
    }

    CarType getModel() {
        return model;
    }

    void setModel(CarType model) {
        this.model = model;
    }

    Location getLocation() {
        return location;
    }

    void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "CarModel - " + model + " located in " + location;
    }
}
