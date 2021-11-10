package com.company;

import org.junit.Assert;
import org.junit.Test;

public class DistancesGridTest {
    @Test
    public void testPrintingDistances(){
        var grid = new DistancesGrid(2,2);
        grid.getCellAt(0,0).linkCell( grid.getCellAt(1,0) );
        grid.getCellAt(1,0).linkCell( grid.getCellAt(1,1) );
        grid.getCellAt(1,1).linkCell( grid.getCellAt(0,1) );
        grid.distances = grid.getCellAt(0,0).distances;
        String expected = """
                +---+---+
                | 0   1 |
                +---+   +
                | 3   2 |
                +---+---+
                """;
        Assert.assertEquals(expected, grid.toString());
    }
}

