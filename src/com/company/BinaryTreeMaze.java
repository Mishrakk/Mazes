package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BinaryTreeMaze {
    public static void Generate(Grid grid) {
        Random rand = new Random();
        for (Cell cell : grid) {
            List<Cell> neighbours = getNeighbours(cell);

            if (neighbours.size() > 0) {
                Cell neighbour = neighbours.get(rand.nextInt(neighbours.size()));
                cell.LinkCell(neighbour);
            }
        }
    }
    private static List<Cell> getNeighbours(Cell cell) {
        List<Cell> neighbours = new ArrayList<>();
        if (cell.North != null) {
            neighbours.add(cell.North);
        }
        if (cell.East != null) {
            neighbours.add(cell.East);
        }
        return neighbours;
    }
}
