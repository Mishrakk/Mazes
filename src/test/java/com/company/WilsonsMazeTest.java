package com.company;

import org.junit.Assert;
import org.junit.Test;

public class WilsonsMazeTest {
    @Test
    public void testEveryCellIsAccessible(){
        Grid grid = new Grid(100,100);
        WilsonsMaze.generate(grid);
        var distances = grid.getCellAt(0,0).distances.getCellsDistances();
        Assert.assertEquals("", grid.size(), distances.size());
    }
}
