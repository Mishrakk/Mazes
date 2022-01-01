package com.company;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;

public class GridIteratorTest {
    @Test
    public void testEmptyCollection(){
        Grid grid = new Grid(0,0);
        GridIterator gridIterator = new GridIterator(grid);

        Assert.assertFalse("Empty collection has no next", gridIterator.hasNext());
        Assert.assertNull("Next in empty collection is null", gridIterator.next());

        LinkedList<Cell> list = new LinkedList<>();
        for (Cell cell : grid){
            list.add(cell);
        }
        Assert.assertEquals("There are no cells to iterate over in empty collection", 0, list.size());
    }

    @Test
    public void test1DCollection(){
        Grid grid = new Grid(2,1);
        GridIterator gridIterator = new GridIterator(grid);

        Assert.assertTrue("There is next element in initialized collection", gridIterator.hasNext());
        Assert.assertEquals("First element is equal to grid[0][0]", grid.getCellAt(0,0), gridIterator.next());
        Assert.assertEquals("Second element is equal to grid[0][1]", grid.getCellAt(1,0), gridIterator.next());
        Assert.assertFalse("There are only two elements in collection", gridIterator.hasNext());
        Assert.assertNull("After last element should return null", gridIterator.next());

        LinkedList<Cell> list = new LinkedList<>();
        for (Cell cell : grid){
            list.add(cell);
        }
        Assert.assertEquals("There are exactly two elements we iterate over", 2, list.size());
        Assert.assertTrue("Cells are in proper order", list.get(0) == grid.getCellAt(0,0) && list.get(1) == grid.getCellAt(1,0));
    }
    @Test
    public void test2DCollection(){
        Grid grid = new Grid(2,2);
        GridIterator gridIterator = new GridIterator(grid);

        gridIterator.next();
        gridIterator.next();

        Assert.assertTrue("There is next cell in new row", gridIterator.hasNext());
        Assert.assertEquals("First cell in second row is at (0,1)", grid.getCellAt(0,1), gridIterator.next());
        Assert.assertTrue("There is fourth cell", gridIterator.hasNext());
        Assert.assertEquals("Last cell is at (1,1)", grid.getCellAt(1,1), gridIterator.next());
        Assert.assertFalse("There are only four cells in this 2d grid", gridIterator.hasNext());
        LinkedList<Cell> list = new LinkedList<>();
        for (Cell cell : grid){
            list.add(cell);
        }
        Assert.assertEquals("There are exactly four elements we iterate over", 4, list.size());
        Assert.assertTrue("Cells are in proper order", list.get(2) == grid.getCellAt(0,1) && list.get(3) == grid.getCellAt(1,1));
    }
}
