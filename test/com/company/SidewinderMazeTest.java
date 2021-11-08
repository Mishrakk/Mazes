package com.company;

import org.junit.Assert;
import org.junit.Test;

public class SidewinderMazeTest {
    @Test
    public void TestBias(){
        Grid grid = new Grid(2,2);
        SidewinderMaze.Generate(grid);
        Assert.assertTrue(grid.GetCellAt(0,0).Linked(grid.GetCellAt(1,0)));
    }
    @Test
    public void TestEveryCellIsAccessible(){
        Grid grid = new Grid(100,100);
        SidewinderMaze.Generate(grid);
        var distances = grid.GetCellAt(0,0).Distances.GetCellsDistances();
        Assert.assertEquals("", grid.Size(), distances.size());
    }
}
