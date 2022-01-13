package com.company;

import org.junit.Assert;
import org.junit.Test;

public class WilsonsMazeTest {
    @Test
    public void testEveryCellIsAccessible(){
        Random random = new Random();
        Grid grid = new Grid(100,100, random);
        var generator = new WilsonsMaze(random);
        generator.generate(grid);
        var distances = grid.getCellAt(0,0).distances.getCellsDistances();
        Assert.assertEquals("", grid.size(), distances.size());
    }
}
