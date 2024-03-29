package com.company.MazeGenerators;

import com.company.Model.Cell;
import com.company.Model.Grid;
import com.company.Random;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree implements IMazeGenerator {
    private final Random random;
    public BinaryTree(Random rand){
        random = rand;
    }
    public void generate(Grid grid) {
        for (Cell cell : grid) {
            List<Cell> neighbours = getNeighbours(cell);

            if (neighbours.size() > 0) {
                Cell neighbour = random.getRandomElement(neighbours);
                cell.linkCell(neighbour);
            }
        }
    }
    private List<Cell> getNeighbours(Cell cell) {
        List<Cell> neighbours = new ArrayList<>();
        if (cell.getNorth() != null) {
            neighbours.add(cell.getNorth());
        }
        if (cell.getEast() != null) {
            neighbours.add(cell.getEast());
        }
        return neighbours;
    }
}
