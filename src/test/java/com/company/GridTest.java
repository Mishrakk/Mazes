package com.company;

import org.junit.Assert;
import org.junit.Test;

public class GridTest {
    @Test
    public void testConstructor(){
        Random random = new Random();
        Grid grid = new Grid(10, 11, random);
        Assert.assertEquals("Width is not properly set",10, grid.width);
        Assert.assertEquals("Height is not properly set", 11, grid.height);
        Assert.assertEquals("CellsGrid width is not properly set", 10, grid.cellsGrid.length);
        Assert.assertEquals("CellsGrid height is not properly set", 11, grid.cellsGrid[0].length);
        Assert.assertNotNull("Cell is null", grid.cellsGrid[0][0]);
        Assert.assertNotNull("North neighbor is null", grid.cellsGrid[1][1].north);
        Assert.assertNotNull("South neighbor is null", grid.cellsGrid[1][1].south);
        Assert.assertNotNull("East neighbor is null", grid.cellsGrid[1][1].east);
        Assert.assertNotNull("West neighbor is null", grid.cellsGrid[1][1].west);
    }
    @Test
    public void testGetCellAt(){
        Random random = new Random();
        Grid grid = new Grid(10, 10, random);
        Assert.assertEquals("Different cell is returned",grid.getCellAt(1,1), grid.cellsGrid[1][1]);
        Assert.assertNull("Outside of bounds we should get null", grid.getCellAt(-1, -1));
    }
    @Test
    public void testGetRandomCell(){
        Random random = new Random();
        Grid grid = new Grid(10, 10, random);
        Assert.assertNotNull("Random cell returns not null", grid.getRandomCell());
    }
    @Test
    public void testPrintGrid(){
        Random random = new Random();
        Grid grid = new Grid(2,2, random);
        grid.cellsGrid[0][0].linkCell(grid.cellsGrid[1][0]);
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

