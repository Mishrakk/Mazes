package com.company.Model;

import com.company.Random;
import org.junit.Assert;
import org.junit.Test;

public class CellTest {
    private final Random random = new Random();
    @Test
    public void testConstructor() {
        Cell cell = new Cell(1,2, random);
        Assert.assertEquals("X coordinate is not properly set",1, cell.getX());
        Assert.assertEquals("Y coordinate is not properly set", 2, cell.getY());
        Assert.assertEquals("Cell should not be initially linked",0, cell.getLinks().size());
    }
    @Test
    public void testAreCellsLinked(){
        Cell cellA = new Cell(1,2, random);
        Cell cellB = new Cell(3,4, random);
        cellA.getLinks().put(cellB, true);
        Assert.assertTrue("Linked function reports false", cellA.isLinked(cellB));
    }
    @Test
    public void testLinkCells(){
        Cell cellA = new Cell(1,2, random);
        Cell cellB = new Cell(3,4, random);
        cellA.linkCell(cellB);
        Assert.assertTrue("Cells A is not linked to B", cellA.isLinked(cellB));
        Assert.assertTrue("Cells B is not linked to A", cellB.isLinked(cellA));
    }
}


