package com.company;

import org.junit.Assert;
import org.junit.Test;

import java.awt.*;

public class MazePrinterTest {
    @Test
    public void testImageSize() {
        Grid grid = new Grid(2,3);
        MazePrinter mazePrinter = new MazePrinter(grid, 10);
        Assert.assertEquals("Image width should be equal to cell size times grid width", 20, image.getWidth());
        Assert.assertEquals("Image height should be equal to cell size times grid height", 30, image.getHeight());
        var image = mazePrinter.GetImage();
    }
    @Test
    public void testDefaultCellSize() {
        Grid grid = new Grid(2,3);
        MazePrinter mazePrinter = new MazePrinter(grid);
        Assert.assertEquals("Image width is based on default cell size", 20, image.getWidth());
        Assert.assertEquals("Image height is based on default cell size", 30, image.getHeight());
        var image = mazePrinter.GetImage();
    @Test
    public void testDrawingBackground(){
        Grid grid = new Grid (2,2);
        MazePrinter mazePrinter = new MazePrinter(grid);
        var image = mazePrinter.GetImage();
        Assert.assertEquals("Background is white", Color.white.getRGB(), image.getRGB(1,1));
    }
}
