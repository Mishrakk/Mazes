package com.company;

import org.junit.Assert;
import org.junit.Test;

public class SidewinderMazeTest {
    @Test
    public void testBias(){
        Random random = new Random();
        Grid grid = new Grid(2,2, random);
        var generator = new SidewinderMaze(random);
        generator.generate(grid);
        Assert.assertTrue(grid.getCellAt(0,0).isLinked(grid.getCellAt(1,0)));
    }
    @Test
    public void testEveryCellIsAccessible(){
        Random random = new Random();
        Grid grid = new Grid(100,100, random);
        var generator = new SidewinderMaze(random);
        generator.generate(grid);
        var distances = grid.getCellAt(0,0).distances.getCellsDistances();
        Assert.assertEquals("", grid.size(), distances.size());
    }
}
