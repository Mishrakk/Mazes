package com.company.MazeGenerators;

import com.company.Model.Grid;
import com.company.Random;
import org.junit.Assert;
import org.junit.Test;

public class SidewinderTest {
    @Test
    public void testBias(){
        Random random = new Random();
        Grid grid = new Grid(2,2, random);
        var generator = new Sidewinder(random);
        generator.generate(grid);
        Assert.assertTrue(grid.getCellAt(0,0).isLinked(grid.getCellAt(1,0)));
    }
    @Test
    public void testEveryCellIsAccessible(){
        Random random = new Random();
        Grid grid = new Grid(100,100, random);
        var generator = new Sidewinder(random);
        generator.generate(grid);
        var distances = grid.getCellAt(0,0).getDistances().getCellsDistances();
        Assert.assertEquals("", grid.size(), distances.size());
    }
}
