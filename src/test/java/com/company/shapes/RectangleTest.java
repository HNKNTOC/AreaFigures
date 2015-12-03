package com.company.shapes;

import org.junit.Test;
import static org.junit.Assert.*;

public class RectangleTest {

    @Test
    public void testCalculateArea() throws Exception {
        Rectangle rectangle = new Rectangle(20,18);
        assertTrue(rectangle.calculateArea()==360);
    }
}