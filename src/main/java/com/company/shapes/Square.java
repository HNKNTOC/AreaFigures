package com.company.shapes;


public class Square extends Shapes {
    private float a;

    public Square(float a) {
        this.a = a;
    }

    @Override
    public double calculateArea() {
        double s = Math.pow(a,2);
        return Math.rint(100.0 * s) / 100.0;
    }
}
