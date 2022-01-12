package com.company;

import java.util.List;

public class Random extends java.util.Random {
    public <E> E getRandomElement(List<E> list){
        return list.get(super.nextInt(list.size()));
    }
}
