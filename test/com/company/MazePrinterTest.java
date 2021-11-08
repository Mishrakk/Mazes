package com.company;

import org.junit.Assert;
import org.junit.Test;

import java.awt.*;

public class MazePrinterTest {
    @Test
    public void testImageSize() {
        Grid grid = new Grid(2,3);
        MazePrinter mazePrinter = new MazePrinter(grid, 10);
        var image = mazePrinter.GetImage();
        Assert.assertEquals("Image width should be equal to cell size times grid width", 21, image.getWidth());
        Assert.assertEquals("Image height should be equal to cell size times grid height", 31, image.getHeight());
    }
    @Test
    public void testDefaultCellSize() {
        Grid grid = new Grid(2,3);
        MazePrinter mazePrinter = new MazePrinter(grid);
        var image = mazePrinter.GetImage();
        Assert.assertEquals("Image width is based on default cell size", 21, image.getWidth());
        Assert.assertEquals("Image height is based on default cell size", 31, image.getHeight());
    }
    @Test
    public void testDrawingBackground(){
        Grid grid = new Grid (2,2);
        MazePrinter mazePrinter = new MazePrinter(grid);
        var image = mazePrinter.GetImage();
        Assert.assertEquals("Background is white", Color.white.getRGB(), image.getRGB(1,1));
        Assert.assertEquals("Border is black", Color.black.getRGB(), image.getRGB(0,0));
    }
    @Test
    public void testDrawCellWithNoLinks(){
        Grid grid = new Grid (3,3);
        MazePrinter mazePrinter = new MazePrinter(grid, 10);
        var image = mazePrinter.GetImage();
        Assert.assertEquals("Northern border is black", Color.black.getRGB(), image.getRGB(15, 10));
        Assert.assertEquals("Southern border is black", Color.black.getRGB(), image.getRGB(15, 20));
        Assert.assertEquals("Western border is black", Color.black.getRGB(), image.getRGB(10, 15));
        Assert.assertEquals("Eastern border is black", Color.black.getRGB(), image.getRGB(20, 15));
    }
    @Test
    public void testDrawCellWithAllLinks(){
        Grid grid = new Grid (3,3);
        MazePrinter mazePrinter = new MazePrinter(grid, 10);
        var cell = grid.GetCellAt(1,1);
        cell.LinkCell(grid.GetCellAt(1, 0));
        cell.LinkCell(grid.GetCellAt(1, 2));
        cell.LinkCell(grid.GetCellAt(0, 1));
        cell.LinkCell(grid.GetCellAt(2, 1));
        var image = mazePrinter.GetImage();
        Assert.assertEquals("Northern border is white", Color.white.getRGB(), image.getRGB(15, 10));
        Assert.assertEquals("Southern border is white", Color.white.getRGB(), image.getRGB(15, 20));
        Assert.assertEquals("Western border is white", Color.white.getRGB(), image.getRGB(10, 15));
        Assert.assertEquals("Eastern border is white", Color.white.getRGB(), image.getRGB(20, 15));
    }
}
