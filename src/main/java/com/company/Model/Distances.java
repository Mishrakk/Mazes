package com.company.Model;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Distances {
    private final Cell root;
    private final Map<Cell, Integer> cellsDistances;
    private int maxDistance;
    public Distances(Cell root){
        this.root = root;
        cellsDistances = new HashMap<>();
    }
    public Boolean containsKey(Cell cell){
        if (cellsDistances.size() == 0){
            calculate();
        }
        return cellsDistances.containsKey(cell);
    }
    public int getDistanceTo(Cell cell){
        if (cellsDistances.size() == 0){
            calculate();
        }
        return cellsDistances.get(cell);
    }

    public int getMaxDistance(){
        if (cellsDistances.size() == 0){
            calculate();
        }
        return maxDistance;
    }

    private void calculate(){
        cellsDistances.put(root, 0);
        var queue = new PriorityQueue<Cell>(Comparator.comparingInt(this::getDistanceTo));
        queue.add(root);
        while (queue.size() != 0){
            Cell cell = queue.poll();
            cell.getLinks().entrySet().stream().filter(Map.Entry::getValue).forEach(entry -> {
                int newDistance = cellsDistances.get(cell) + 1;
                Cell neighbour = entry.getKey();
                if (!cellsDistances.containsKey(neighbour) || cellsDistances.get(neighbour) > newDistance){
                    cellsDistances.put(neighbour, newDistance);
                    queue.add(neighbour);
                    maxDistance = Math.max(maxDistance, newDistance);
                }
            });
        }
    }
    public void clear(){
        cellsDistances.clear();
        maxDistance = 0;
    }
    public Map<Cell, Integer> getCellsDistances(){
        if (cellsDistances.size() == 0){
            calculate();
        }
        return cellsDistances;
    }
}
