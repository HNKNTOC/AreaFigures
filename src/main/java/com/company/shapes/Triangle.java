package com.company.shapes;

public class Triangle extends Shapes {
    private float a;
    private float b;
    private float c;

    public Triangle(float a, float b, float c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }



    @Override
    public double calculateArea() {
        double p = (a+b+c)/2;
        double s = Math.sqrt(p*(p-a)*(p-b)*(p-c));
        return Math.rint(100.0 * s) / 100.0;
    }
}
