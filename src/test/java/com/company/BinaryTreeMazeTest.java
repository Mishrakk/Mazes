package com.company;

import org.junit.Assert;
import org.junit.Test;

public class BinaryTreeMazeTest {
    @Test
    public void testBias(){
        Grid grid = new Grid(2,2);
        BinaryTreeMaze.generate(grid);
        Assert.assertTrue(grid.getCellAt(0,0).isLinked(grid.getCellAt(1,0))
                && grid.getCellAt(1,1).isLinked(grid.getCellAt(1,0))
        );
    }
    @Test
    public void testEveryCellIsAccessible(){
        Grid grid = new Grid(100,100);
        BinaryTreeMaze.generate(grid);
        var distances = grid.getCellAt(0,0).distances.getCellsDistances();
        Assert.assertEquals("", grid.size(), distances.size());
    }
}
