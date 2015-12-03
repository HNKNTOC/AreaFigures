package com.company.shapes;

import org.junit.Test;

import static org.junit.Assert.assertTrue;


public class SquareTest {

    @Test
    public void testCalculateArea() throws Exception {
        Square square = new Square(82);
        assertTrue(square.calculateArea() == 6724);
    }
}