package com.company;

import java.util.List;
import java.util.Random;

public class AldousBroderMaze {
    public static void generate(Grid grid) {
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
