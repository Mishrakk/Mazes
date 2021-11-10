package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BinaryTreeMaze {
    public static void generate(Grid grid) {
        Random rand = new Random();
        for (Cell cell : grid) {
            List<Cell> neighbours = getNeighbours(cell);

            if (neighbours.size() > 0) {
                Cell neighbour = neighbours.get(rand.nextInt(neighbours.size()));
                cell.linkCell(neighbour);
            }
        }
    }
    private static List<Cell> getNeighbours(Cell cell) {
        List<Cell> neighbours = new ArrayList<>();
        if (cell.north != null) {
            neighbours.add(cell.north);
        }
        if (cell.east != null) {
            neighbours.add(cell.east);
        }
        return neighbours;
    }
}
