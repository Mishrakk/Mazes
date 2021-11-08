package com.company;

import org.junit.Assert;
import org.junit.Test;

public class DistancesTest {
    @Test
    public void testDistances() {
        Grid grid = new Grid(2,1);
        var cell = grid.GetCellAt(0,0);
        cell.LinkCell(cell.East);
        var distances = new Distances(cell);
        Assert.assertEquals("Distance to root is zero", 0, distances.GetDistanceTo(cell));
        Assert.assertEquals("Distance to neighbour is one", 1, distances.GetDistanceTo(cell.East));
    }
}
