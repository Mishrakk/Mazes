package com.company.MazeGenerators;

import com.company.Cell;
import com.company.Grid;
import com.company.Random;

public class HuntAndKill implements IMazeGenerator {
    private final Random random;
    public HuntAndKill(Random rand){
        random = rand;
    }

    public void generate(Grid grid) {
        Cell current = grid.getRandomCell();
        while (current != null){
            var unvisitedNeighbours = current.getNeighbours().stream().filter(n -> n.links.isEmpty()).toArray();
            if (unvisitedNeighbours.length > 0){
                Cell randomNeighbour = (Cell) unvisitedNeighbours[random.nextInt(unvisitedNeighbours.length)];
                current.linkCell(randomNeighbour);
                current = randomNeighbour;
            } else {
                current = null;
                for (var cell : grid){
                    var visitedNeighbours = cell.getNeighbours().stream().filter(n -> n.links.size() > 0).toArray();
                    if (cell.links.isEmpty() && visitedNeighbours.length > 0){
                        current = cell;
                        var neighbour = (Cell) visitedNeighbours[random.nextInt(visitedNeighbours.length)];
                        current.linkCell(neighbour);
                    }
                }
            }
        }
    }
}
