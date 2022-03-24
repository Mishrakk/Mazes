package com.company.MazeGenerators;

import com.company.Cell;
import com.company.Grid;
import com.company.Random;

public class AldousBroder implements IMazeGenerator {
    public AldousBroder(Random rand){
    }
    public void generate(Grid grid) {
        Cell cell = grid.getRandomCell();
        int unvisited = grid.size() - 1;
        while (unvisited > 0){
            Cell neighbour = cell.getRandomNeighbour();
            if (neighbour.links.isEmpty()){
                cell.linkCell(neighbour);
                unvisited--;
            }
            cell = neighbour;
        }
    }
}
