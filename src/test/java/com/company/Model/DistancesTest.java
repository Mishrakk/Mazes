package com.company.Model;

import com.company.Random;
import org.junit.Assert;
import org.junit.Test;

public class DistancesTest {
    @Test
    public void testDistances() {
        Random random = new Random();
        Grid grid = new Grid(2,1, random);
        var cell = grid.getCellAt(0,0);
        cell.linkCell(cell.east);
        var distances = new Distances(cell);
        Assert.assertEquals("Distance to root is zero", 0, distances.getDistanceTo(cell));
        Assert.assertEquals("Distance to neighbour is one", 1, distances.getDistanceTo(cell.east));
    }
    @Test
    public void testMaxDistance(){
        Random random = new Random();
        Grid grid = new Grid(2,1, random);
        var cell = grid.getCellAt(0,0);
        cell.linkCell(cell.east);
        var distances = new Distances(cell);
        Assert.assertEquals("Max distance is one", 1, distances.getMaxDistance());
    }
}
