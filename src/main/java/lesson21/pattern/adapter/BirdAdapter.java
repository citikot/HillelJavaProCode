package lesson21.pattern.adapter;

public class BirdAdapter implements ToyDuck {
    // You need to implement the interface your
    // client expects to use.
    private Bird bird;

    public BirdAdapter(Bird bird) {
        // we need reference to the object we
        // are adapting
        this.bird = bird;
    }

    @Override
    public void squeak() {
        // translate the methods appropriately
        bird.makeSound();
    }
}