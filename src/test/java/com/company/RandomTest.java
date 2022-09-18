package com.company;

import com.company.Model.Cell;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class RandomTest {

    @Test
    public void testGetRandomElement(){
        Random random = new Random();
        List<Cell> list= new ArrayList<Cell>();
        Cell cell = new Cell(1,2, random);
        list.add(cell);
        Assert.assertEquals(cell, random.getRandomElement(list));
    }
}
