package com.company.shapes;

import org.junit.*;

import static org.junit.Assert.assertTrue;


public class TriangleTest {

    @Test
    public void testCalculateArea() throws Exception {
        Triangle triangle = new Triangle(35,35,35);
        assertTrue(triangle.calculateArea() == 530.44);

    }
}