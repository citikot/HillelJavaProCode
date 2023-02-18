package lesson21.pattern.adapter;

public class Sparrow implements Bird {
    // a concrete implementation of bird
    @Override
    public void fly() {
        System.out.println("Flying");
    }

    @Override
    public void makeSound() {
        System.out.println("Chirp Chirp");
    }
}