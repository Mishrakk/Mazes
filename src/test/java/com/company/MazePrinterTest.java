package com.company;

import org.junit.Assert;
import org.junit.Test;

import java.awt.*;

public class MazePrinterTest {
    @Test
    public void testImageSize() {
        Random random = new Random();
        Grid grid = new Grid(2,3, random);
        MazePrinter mazePrinter = new MazePrinter(grid, 10);
        var image = mazePrinter.getImage();
        Assert.assertEquals("Image width should be equal to cell size times grid width", 21, image.getWidth());
        Assert.assertEquals("Image height should be equal to cell size times grid height", 31, image.getHeight());
    }
    @Test
    public void testDefaultCellSize() {
        Random random = new Random();
        Grid grid = new Grid(2,3, random);
        MazePrinter mazePrinter = new MazePrinter(grid);
        var image = mazePrinter.getImage();
        Assert.assertEquals("Image width is based on default cell size", 21, image.getWidth());
        Assert.assertEquals("Image height is based on default cell size", 31, image.getHeight());
    }
    @Test
    public void testDrawingBackground(){
        Random random = new Random();
        Grid grid = new Grid (2,2, random);
        MazePrinter mazePrinter = new MazePrinter(grid);
        var image = mazePrinter.getImage();
        Assert.assertEquals("Background is white", Color.white.getRGB(), image.getRGB(1,1));
        Assert.assertEquals("Border is black", Color.black.getRGB(), image.getRGB(0,0));
    }
    @Test
    public void testDrawCellWithNoLinks(){
        Random random = new Random();
        Grid grid = new Grid (3,3, random);
        MazePrinter mazePrinter = new MazePrinter(grid, 10);
        var image = mazePrinter.getImage();
        Assert.assertEquals("Northern border is black", Color.black.getRGB(), image.getRGB(15, 10));
        Assert.assertEquals("Southern border is black", Color.black.getRGB(), image.getRGB(15, 20));
        Assert.assertEquals("Western border is black", Color.black.getRGB(), image.getRGB(10, 15));
        Assert.assertEquals("Eastern border is black", Color.black.getRGB(), image.getRGB(20, 15));
    }
    @Test
    public void testDrawCellWithAllLinks(){
        Random random = new Random();
        Grid grid = new Grid (3,3, random);
        MazePrinter mazePrinter = new MazePrinter(grid, 10);
        var cell = grid.getCellAt(1,1);
        cell.linkCell(grid.getCellAt(1, 0));
        cell.linkCell(grid.getCellAt(1, 2));
        cell.linkCell(grid.getCellAt(0, 1));
        cell.linkCell(grid.getCellAt(2, 1));
        var image = mazePrinter.getImage();
        Assert.assertEquals("Northern border is white", Color.white.getRGB(), image.getRGB(15, 10));
        Assert.assertEquals("Southern border is white", Color.white.getRGB(), image.getRGB(15, 20));
        Assert.assertEquals("Western border is white", Color.white.getRGB(), image.getRGB(10, 15));
        Assert.assertEquals("Eastern border is white", Color.white.getRGB(), image.getRGB(20, 15));
    }

    @Test
    public void testDrawingColoredCellsBackground(){
        Random random = new Random();
        Grid grid = new Grid (2,2, random);
        grid.getCellAt(0,0).linkCell(grid.getCellAt(1,0));
        grid.getCellAt(1,0).linkCell(grid.getCellAt(1,1));
        grid.getCellAt(1,1).linkCell(grid.getCellAt(0,1));
        MazePrinter mazePrinter = new MazePrinter(grid, 10);
        var image = mazePrinter.getColoredImage();
        Assert.assertEquals("Background of first cell is white", Color.white.getRGB(), image.getRGB(1,1));
        Assert.assertNotEquals("First cell background is different than last cell background", image.getRGB(1,11), image.getRGB(1,1));
    }
}

