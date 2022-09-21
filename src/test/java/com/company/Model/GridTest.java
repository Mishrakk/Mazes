package com.company.Model;

import com.company.Random;
import org.junit.Assert;
import org.junit.Test;

public class GridTest {
    @Test
    public void testConstructor(){
        Random random = new Random();
        Grid grid = new Grid(10, 11, random);
        Assert.assertEquals("Width is not properly set",10, grid.getWidth());
        Assert.assertEquals("Height is not properly set", 11, grid.getHeight());
        Assert.assertEquals("CellsGrid width is not properly set", 10, grid.getCellsGrid().length);
        Assert.assertEquals("CellsGrid height is not properly set", 11, grid.getCellsGrid()[0].length);
        Assert.assertNotNull("Cell is null", grid.getCellsGrid()[0][0]);
        Assert.assertNotNull("North neighbor is null", grid.getCellsGrid()[1][1].getNorth());
        Assert.assertNotNull("South neighbor is null", grid.getCellsGrid()[1][1].getSouth());
        Assert.assertNotNull("East neighbor is null", grid.getCellsGrid()[1][1].getEast());
        Assert.assertNotNull("West neighbor is null", grid.getCellsGrid()[1][1].getWest());
    }
    @Test
    public void testGetCellAt(){
        Random random = new Random();
        Grid grid = new Grid(10, 10, random);
        Assert.assertEquals("Different cell is returned",grid.getCellAt(1,1), grid.getCellsGrid()[1][1]);
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
        grid.getCellsGrid()[0][0].linkCell(grid.getCellsGrid()[1][0]);
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

