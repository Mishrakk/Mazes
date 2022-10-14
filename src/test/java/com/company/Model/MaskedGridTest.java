package com.company.Model;

import com.company.Random;
import org.junit.Assert;
import org.junit.Test;

public class MaskedGridTest {
    @Test
    public void testConstructor(){
        Random random = new Random();
        Mask mask = new Mask(10, 10, random);
        mask.setCellAt(1,1, false);
        mask.setCellAt(1,2, false);
        mask.setCellAt(2,1, false);
        mask.setCellAt(2,2, false);
        MaskedGrid grid = new MaskedGrid(mask, random);
        Assert.assertEquals("Width is not properly set",10, grid.getWidth());
        Assert.assertEquals("Height is not properly set", 10, grid.getHeight());
        Assert.assertEquals("CellsGrid width is not properly set", 10, grid.getCellsGrid().length);
        Assert.assertEquals("CellsGrid height is not properly set", 10, grid.getCellsGrid()[0].length);
        Assert.assertNull("Cell is null", grid.getCellsGrid()[1][1]);
        Assert.assertNull("South neighbor is null", grid.getCellsGrid()[1][0].getSouth());
    }
    @Test
    public void testGetRandomCell(){
        Random random = new Random();
        Mask mask = new Mask(10, 10, random);
        mask.setCellAt(1,1, false);
        mask.setCellAt(1,2, false);
        mask.setCellAt(2,1, false);
        mask.setCellAt(2,2, false);
        MaskedGrid grid = new MaskedGrid(mask, random);
        Assert.assertNotNull("Random cell returns not null", grid.getRandomCell());
    }
}
