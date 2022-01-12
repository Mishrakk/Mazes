package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Cell {
    public final int X;
    public final int Y;
    public Cell north;
    public Cell south;
    public Cell east;
    public Cell west;
    public HashMap<Cell, Boolean> links;
    public Distances distances;
    private final Random random;

    public Cell(int x, int y, Random rand){
        X = x;
        Y = y;
        links = new HashMap<Cell, Boolean>();
        distances = new Distances(this);
        random = rand;
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

    public List<Cell> getNeighbours(){
        List<Cell> neighbours = new ArrayList<Cell>();
        if (north != null){
            neighbours.add(north);
        }
        if (east != null){
            neighbours.add(east);
        }
        if (south != null){
            neighbours.add(south);
        }
        if (west != null){
            neighbours.add(west);
        }
        return neighbours;
    }
    public Cell getRandomNeighbour(){
        List<Cell> neighbours = getNeighbours();
        return random.getRandomElement(neighbours);
    }
}
