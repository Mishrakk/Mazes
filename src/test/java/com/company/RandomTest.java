package com.company;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class RandomTest {
    @Test
    public void testGetRandomIndex(){
        List<Integer> list= new ArrayList<Integer>();
        list.add(10);
        Assert.assertEquals(0, Random.getRandomIndex(list));
    }

    @Test
    public void testGetRandomElement(){
        List<Cell> list= new ArrayList<Cell>();
        Cell cell = new Cell(1,2);
        list.add(cell);
        Assert.assertEquals(cell, Random.getRandomElement(list));
    }
}
