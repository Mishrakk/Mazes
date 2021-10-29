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
}

