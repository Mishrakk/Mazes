package com.company;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Distances {
    private Cell Root;
    private Map<Cell, Integer> CellsDistances;
    public Distances(Cell root){
        this.Root = root;
        CellsDistances = new HashMap<>();
    }
    public int GetDistanceTo(Cell cell){
        if (CellsDistances.size() == 0){
            Calculate();
        }
        return CellsDistances.get(cell);
    }
    private void Calculate(){
        CellsDistances.put(Root, 0);
        var queue = new PriorityQueue<Cell>(Comparator.comparingInt(this::GetDistanceTo));
        queue.add(Root);
        while (queue.size() != 0){
            Cell cell = queue.poll();
            cell.Links.entrySet().stream().filter(Map.Entry::getValue).forEach(entry -> {
                int newDistance = CellsDistances.get(cell) + 1;
                Cell neighbour = entry.getKey();
                if (!CellsDistances.containsKey(neighbour) || CellsDistances.get(neighbour) > newDistance){
                    CellsDistances.put(neighbour, newDistance);
                    queue.add(neighbour);
                }
            });
        }
    }
    public void Clear(){
        CellsDistances.clear();
    }
}
