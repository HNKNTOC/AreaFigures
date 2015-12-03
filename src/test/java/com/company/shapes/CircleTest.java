package com.company.shapes;

import org.junit.Test;

import static org.junit.Assert.*;


public class CircleTest {

    @Test
    public void testCalculateArea() throws Exception {
        Circle circle = new Circle(3.14f);
        double area = circle.calculateArea();
        assertTrue(area == 7.74);
    }
}