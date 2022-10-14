package com.company.Model;

import com.company.Random;
import org.junit.Assert;
import org.junit.Test;

public class MaskTest {
    @Test
    public void testSimpleUsage(){
        Random random = new Random();
        Mask mask = new Mask(3, 3, random);
        Assert.assertEquals("By default every cell in mask is enabled",9 ,mask.getEnabledCells());
        mask.setCellAt(1,1, false);
        Assert.assertFalse("Cell is turned off", mask.isCellEnabled(1, 1));
        Assert.assertEquals("Turning one cell off changes total number of enabled cells",8 ,mask.getEnabledCells());
    }
    @Test
    public void testGetRandomCell(){
        Random random = new Random();
        Mask mask = new Mask(100, 100, random);
        for(int x = 0; x < 100; x++){
            for(int y = 0; y < 100; y++){
                mask.setCellAt(x, y, false);
            }
        }
        mask.setCellAt(1,1, true);
        Mask.Point maskPoint = mask.getRandomLocation();
        Assert.assertTrue("Random location will always return enabled cell", mask.isCellEnabled(maskPoint.x(), maskPoint.y()));
    }
}
