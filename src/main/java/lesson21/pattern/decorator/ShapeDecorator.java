package lesson21.pattern.decorator;

public abstract class ShapeDecorator implements Shape {

    // Protected variable
    protected Shape decoratedShape;

    // Abstract class method
    protected ShapeDecorator(Shape decoratedShape) {
        // This keywordd refers to current object itself
        this.decoratedShape = decoratedShape;
    }

    // Method - draw()
    // Outside abstract class
    public void draw() {
        decoratedShape.draw();
    }
}
