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
        Assert.assertNotNull("North neighbor is null", grid.CellsGrid[1][1].North);
        Assert.assertNotNull("South neighbor is null", grid.CellsGrid[1][1].South);
        Assert.assertNotNull("East neighbor is null", grid.CellsGrid[1][1].East);
        Assert.assertNotNull("West neighbor is null", grid.CellsGrid[1][1].West);
    }
    @Test
    public void TestGetCellAt(){
        Grid grid = new Grid(10, 10);
        Assert.assertEquals("Different cell is returned",grid.GetCellAt(1,1), grid.CellsGrid[1][1]);
        Assert.assertNull("Outside of bounds we should get null", grid.GetCellAt(-1, -1));
    }
    @Test
    public void TestPrintGrid(){
        Grid grid = new Grid(2,2);
        grid.CellsGrid[0][0].LinkCell(grid.CellsGrid[1][0]);
        String expectedOutput = """
                +---+---+
                |       |
                +---+---+
                |   |   |
                +---+---+
                """;
        Assert.assertEquals(expectedOutput, grid.toString());
    }
}

