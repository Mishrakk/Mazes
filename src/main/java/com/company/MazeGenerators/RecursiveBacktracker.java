package com.company.MazeGenerators;

import com.company.Cell;
import com.company.Grid;
import com.company.Random;

import java.util.Stack;

public class RecursiveBacktracker implements IMazeGenerator {
    private final Random random;
    public RecursiveBacktracker(Random rand){
        random = rand;
    }
    public void generate(Grid grid) {
        var stack = new Stack<Cell>();
        stack.push(grid.getRandomCell());
        while(!stack.isEmpty()){
            var current = stack.peek();
            var neighbours = current.getNeighbours().stream().filter(n -> n.links.isEmpty()).toList();
            if (neighbours.isEmpty()){
                stack.pop();
            } else {
                var neighbour = random.getRandomElement(neighbours);
                current.linkCell(neighbour);
                stack.push(neighbour);
            }
        }
    }
}
