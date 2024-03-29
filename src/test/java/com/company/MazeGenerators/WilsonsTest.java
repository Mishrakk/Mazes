package com.company.MazeGenerators;

import com.company.Model.Grid;
import com.company.Random;
import org.junit.Assert;
import org.junit.Test;

public class WilsonsTest {
    @Test
    public void testEveryCellIsAccessible(){
        Random random = new Random();
        Grid grid = new Grid(10,10, random);
        var generator = new Wilsons(random);
        generator.generate(grid);
        var distances = grid.getCellAt(0,0).getDistances().getCellsDistances();
        Assert.assertEquals("", grid.size(), distances.size());
    }
}
