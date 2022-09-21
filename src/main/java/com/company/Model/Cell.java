package com.company.Model;

import com.company.Random;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Getter @Setter
public class Cell {
    private final int X;
    private final int Y;
    private Cell north;
    private Cell south;
    private Cell east;
    private Cell west;
    private final HashMap<Cell, Boolean> links = new HashMap<>();
    private final Distances distances;
    private final Random random;
    private int something;

    public Cell(int x, int y, Random rand){
        X = x;
        Y = y;
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
        List<Cell> neighbours = new ArrayList<>();
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
