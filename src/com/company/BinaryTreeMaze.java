package com.company;

import java.util.LinkedList;
import java.util.Random;

public class BinaryTreeMaze {
    public static Grid Generate(Grid grid)
    {
        Random rand = new Random();
        for (int x=0; x< grid.Width; x++){
            for (int y=0; y< grid.Height; y++){
                Cell cell = grid.GetCellAt(x,y);
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
        return grid;
    }
}
