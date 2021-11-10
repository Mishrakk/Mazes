package com.company;

import java.util.HashMap;

public class Cell {
    public final int X;
    public final int Y;
    public Cell north;
    public Cell south;
    public Cell east;
    public Cell west;
    public HashMap<Cell, Boolean> links;
    public Distances distances;

    public Cell(int x, int y){
        X = x;
        Y = y;
        links = new HashMap<Cell, Boolean>();
        distances = new Distances(this);
    }

    public void linkCell(Cell linkedCell)
    {
        links.put(linkedCell, true);
        linkedCell.links.put(this, true);
        distances.clear();
    }

    public boolean isLinked(Cell linkedCell)
    {
        return links.getOrDefault(linkedCell, false);
    }
}
