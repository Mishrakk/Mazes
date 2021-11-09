package com.company;

import org.junit.Assert;
import org.junit.Test;

public class DistancesGridTest {
    @Test
    public void TestPrintingDistances(){
        var grid = new DistancesGrid(2,2);
        grid.GetCellAt(0,0).LinkCell( grid.GetCellAt(1,0) );
        grid.GetCellAt(1,0).LinkCell( grid.GetCellAt(1,1) );
        grid.GetCellAt(1,1).LinkCell( grid.GetCellAt(0,1) );
        grid.distances = grid.GetCellAt(0,0).Distances;
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

