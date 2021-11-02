package com.company;

import org.junit.Assert;
import org.junit.Test;

public class GridIteratorTest {
    @Test
    public void TestEmptyCollection(){
        Grid grid = new Grid(0,0);
        GridIterator gridIterator = new GridIterator(grid);

        Assert.assertFalse("Empty collection has no next", gridIterator.hasNext());
        Assert.assertNull("Next in empty collection is null", gridIterator.next());
    }

    @Test
    public void Test1dCollection(){
        Grid grid = new Grid(2,1);
        GridIterator gridIterator = new GridIterator(grid);

        Assert.assertTrue("There is next element in initialized collection", gridIterator.hasNext());
        Assert.assertEquals("First element is equal to grid[0][0]", grid.GetCellAt(0,0), gridIterator.next());
        Assert.assertEquals("Second element is equal to grid[0][1]", grid.GetCellAt(1,0), gridIterator.next());
        Assert.assertFalse("There are only two elements in collection", gridIterator.hasNext());
        Assert.assertNull("After last element should return null", gridIterator.next());
    }
    @Test
    public void Test2dCollection(){
        Grid grid = new Grid(2,2);
        GridIterator gridIterator = new GridIterator(grid);

        gridIterator.next();
        gridIterator.next();

        Assert.assertTrue("There is next cell in new row", gridIterator.hasNext());
        Assert.assertEquals("First cell in second row is at (0,1)", grid.GetCellAt(0,1), gridIterator.next());
        Assert.assertTrue("There is fourth cell", gridIterator.hasNext());
        Assert.assertEquals("Last cell is at (1,1)", grid.GetCellAt(1,1), gridIterator.next());
        Assert.assertFalse("There are only four cells in this 2d grid", gridIterator.hasNext());
    }
}
