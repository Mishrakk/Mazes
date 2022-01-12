package com.company;

public class AldousBroderMaze {
    private final Random random;
    public AldousBroderMaze(Random rand){
        random = rand;
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
