package com.company;

import java.util.List;

public class Random extends java.util.Random {
    static public <E> int getRandomIndex(List<E> list){
        return (int) (Math.random() * list.size());
    }
    static public <E> E getRandomElement(List<E> list){
        return list.get(getRandomIndex(list));
    }
    static public int getRandomInt(int max){
        return (int) (Math.random() * (max+1));
    }
}
