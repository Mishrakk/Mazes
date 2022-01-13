package com.company;

import java.util.ArrayList;
import java.util.List;

public class WilsonsMaze {
    private final Random random;

    public WilsonsMaze(Random random) {
        this.random = random;
    }

    public void generate(Grid grid) {
        var unvisited = new ArrayList<Cell>();
        for (var cell : grid){
            unvisited.add(cell);
        }
        unvisited.remove(random.nextInt(unvisited.size()));
        while(!unvisited.isEmpty()){
            Cell cell = random.getRandomElement(unvisited);
            List<Cell> path = new ArrayList<Cell>();
            path.add(cell);
            while(unvisited.contains(cell)){
                cell = cell.getRandomNeighbour();
                if (path.contains(cell)){
                    path = path.subList(0, path.indexOf(cell));
                } else {
                    path.add(cell);
                }
            }
            for(int i = 0; i < path.size() - 1; i++){
                path.get(i).linkCell(path.get(i+1));
                unvisited.remove(path.get(i));
            }
        }
    }
}
