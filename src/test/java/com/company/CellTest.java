package com.company;

import org.junit.Assert;
import org.junit.Test;

public class CellTest {

    @Test
    public void testconstructor() {
        Cell cell = new Cell(1,2);
        Assert.assertEquals("X coordinate is not properly set",1, cell.X);
        Assert.assertEquals("Y coordinate is not properly set", 2, cell.Y);
        Assert.assertEquals("Cell should not be initially linked",0, cell.links.size());
    }
    @Test
    public void testAreCellsLinked(){
        Cell cellA = new Cell(1,2);
        Cell cellB = new Cell(3,4);
        cellA.links.put(cellB, true);
        Assert.assertTrue("Linked function reports false", cellA.isLinked(cellB));
    }
    @Test
    public void testLinkCells(){
        Cell cellA = new Cell(1,2);
        Cell cellB = new Cell(3,4);
        cellA.linkCell(cellB);
        Assert.assertTrue("Cells A is not linked to B", cellA.isLinked(cellB));
        Assert.assertTrue("Cells B is not linked to A", cellB.isLinked(cellA));
    }
}


