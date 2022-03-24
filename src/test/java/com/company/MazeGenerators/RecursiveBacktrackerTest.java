package com.company.MazeGenerators;

import com.company.Grid;
import com.company.MazeGenerators.RecursiveBacktracker;
import com.company.Random;
import org.junit.Assert;
import org.junit.Test;

public class RecursiveBacktrackerTest {
    @Test
    public void testEveryCellIsAccessible(){
        Random random = new Random();
        Grid grid = new Grid(100,100, random);
        var generator = new RecursiveBacktracker(random);
        generator.generate(grid);
        var distances = grid.getCellAt(0,0).distances.getCellsDistances();
        Assert.assertEquals("", grid.size(), distances.size());
    }
}
