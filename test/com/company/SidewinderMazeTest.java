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
}
