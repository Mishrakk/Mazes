package com.company.MazePrinters;

import com.company.Model.Grid;
import com.company.Random;
import org.junit.Assert;
import org.junit.Test;

import java.awt.*;

public class ColoredPrinterTest {
    @Test
    public void testDrawingColoredCellsBackground(){
        Random random = new Random();
        Grid grid = new Grid (2,2, random);
        grid.getCellAt(0,0).linkCell(grid.getCellAt(1,0));
        grid.getCellAt(1,0).linkCell(grid.getCellAt(1,1));
        grid.getCellAt(1,1).linkCell(grid.getCellAt(0,1));
        ColoredPrinter mazePrinter = new ColoredPrinter(grid, 10);
        var image = mazePrinter.getImage();
        Assert.assertEquals("Background of first cell is white", Color.white.getRGB(), image.getRGB(1,1));
        Assert.assertNotEquals("First cell background is different than last cell background", image.getRGB(1,11), image.getRGB(1,1));
    }
}
