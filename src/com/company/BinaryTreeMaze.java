package com.company;

import java.util.LinkedList;
import java.util.Random;

public class BinaryTreeMaze {
    public static void Generate(Grid grid)
    {
        Random rand = new Random();
        for (Cell cell : grid){
            LinkedList<Cell> neighbours = new LinkedList<>();
            if (cell.North != null)
            {
                neighbours.add(cell.North);
            }
            if (cell.East != null)
            {
                neighbours.add(cell.East);
            }

            if (neighbours.size() > 0)
            {
                Cell neighbour = neighbours.get(rand.nextInt(neighbours.size()));
                cell.LinkCell(neighbour);
            }
        }
    }
}
