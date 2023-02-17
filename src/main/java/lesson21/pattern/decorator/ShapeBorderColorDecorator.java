package lesson21.pattern.decorator;

import java.awt.Color;

public class ShapeBorderColorDecorator extends ShapeDecorator {

    private Color color;

    public ShapeBorderColorDecorator(Shape decoratedShape, Color color) {
        super(decoratedShape);
        this.color = color;
    }

    @Override
    public void draw() {
        decoratedShape.draw();
        setBorderColor();
    }

    private void setBorderColor() {
        // Display message whenever function is called
        System.out.println("Border Color: " + color);
    }
}
