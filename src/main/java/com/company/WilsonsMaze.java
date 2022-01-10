package com.company;

import java.util.ArrayList;

public class WilsonsMaze {
    public static void generate(Grid grid) {
        var unvisited = new ArrayList<Cell>();
        for (var cell : grid){
            unvisited.add(cell);
        }
    }
}
