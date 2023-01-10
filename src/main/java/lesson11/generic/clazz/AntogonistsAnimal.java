package lesson11.generic.clazz;

/**
 * @author spasko
 */
public class AntogonistsAnimal<T extends Animal /* & Comparable<Animal> */, V extends Animal> {
    private T left;

    private V right;

    public AntogonistsAnimal(T left, V right) {
        this.left = left;
        this.right = right;
    }

    public void antogonists() {
        System.out.println(left.name() + "  very often antogonist to " + right.name());
    }

    public T getLeft() {
        return left;
    }

    public V getRight() {
        return right;
    }
}
