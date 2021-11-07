package com.company;

import org.junit.Assert;
import org.junit.Test;

import java.awt.*;

public class MazePrinterTest {
    @Test
    public void testImageSize() {
        Grid grid = new Grid(2,3);
        MazePrinter mazePrinter = new MazePrinter(grid, 10);
        var  image = mazePrinter.GetGraphics();
        Assert.assertEquals("Image width should be equal to cell size times grid width", 20, image.getWidth());
        Assert.assertEquals("Image height should be equal to cell size times grid height", 30, image.getHeight());
    }
}
