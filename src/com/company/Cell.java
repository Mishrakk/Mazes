package com.company;

import java.util.HashMap;

public class Cell {
    public final int X;
    public final int Y;
    public Cell North;
    public Cell South;
    public Cell East;
    public Cell West;
    public HashMap<Cell, Boolean> Links;

    public Cell(int x, int y){
        X = x;
        Y = y;
        Links = new HashMap<Cell, Boolean>();
    }
}
