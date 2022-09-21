package com.company.MazeGenerators;

import com.company.Model.Grid;
import com.company.Random;
import org.junit.Assert;
import org.junit.Test;

public class AldousBroderTest {
    @Test
    public void testEveryCellIsAccessible(){
        Random random = new Random();
        Grid grid = new Grid(100,100, random);
        var generator = new AldousBroder(random);
        generator.generate(grid);
        var distances = grid.getCellAt(0,0).getDistances().getCellsDistances();
        Assert.assertEquals("", grid.size(), distances.size());
    }
}
