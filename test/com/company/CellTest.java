package com.company;

import org.junit.Assert;
import org.junit.Test;

public class CellTest {

    @Test
    public void testConstructor() {
        Cell cell = new Cell(1,2);
        Assert.assertEquals("X coordinate is not properly set",1, cell.X);
        Assert.assertEquals("Y coordinate is not properly set", 2, cell.Y);
        Assert.assertEquals("Cell should not be initially linked",0, cell.Links.size());
    }
    @Test
    public void testAreCellsLinked(){
        Cell cellA = new Cell(1,2);
        Cell cellB = new Cell(3,4);
        cellA.Links.put(cellB, true);
        Assert.assertTrue("Linked function reports false", cellA.Linked(cellB));
    }
}

