package com.company;

import org.junit.Assert;
import org.junit.Test;

public class GridTest {
    @Test
    public void TestConstructor(){
        Grid grid = new Grid(10, 11);
        Assert.assertEquals("Width is not properly set",10, grid.Width);
        Assert.assertEquals("Height is not properly set", 11, grid.Height);
        Assert.assertEquals("CellsGrid width is not properly set", 10, grid.CellsGrid.length);
        Assert.assertEquals("CellsGrid height is not properly set", 11, grid.CellsGrid[0].length);
        Assert.assertNotNull("Cell is null", grid.CellsGrid[0][0]);
    }
}
