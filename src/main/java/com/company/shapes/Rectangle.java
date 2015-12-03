package com.company.shapes;


public class Rectangle extends Shapes {
    private float a;
    private float b;

    public Rectangle(float a, float b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public double calculateArea() {
        double s = a*b;
        return Math.rint(100.0 * s) / 100.0;
    }
}
