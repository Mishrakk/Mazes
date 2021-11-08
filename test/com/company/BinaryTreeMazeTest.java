package com.company;

import org.junit.Assert;
import org.junit.Test;

public class BinaryTreeMazeTest {
    @Test
    public void TestBias(){
        Grid grid = new Grid(2,2);
        BinaryTreeMaze.Generate(grid);
        Assert.assertTrue(grid.GetCellAt(0,0).Linked(grid.GetCellAt(1,0))
                && grid.GetCellAt(1,1).Linked(grid.GetCellAt(1,0))
        );
    }
    @Test
    public void TestEveryCellIsAccessible(){
        Grid grid = new Grid(10,10);
        BinaryTreeMaze.Generate(grid);
        var distances = grid.GetCellAt(0,0).Distances.GetCellsDistances();
        Assert.assertEquals("", grid.Size(), distances.size());
    }
}
