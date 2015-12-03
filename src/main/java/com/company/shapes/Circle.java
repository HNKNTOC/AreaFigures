package com.company.shapes;

public class Circle extends Shapes {
        private float diameter;

        public Circle(float diameter) {
                this.diameter = diameter;
        }

        @Override
        public double calculateArea() {
                double s = Math.pow(diameter,2)/4;
                 s = Math.PI * s;
                return Math.rint(100.0 * s) / 100.0;
        }
}
