package com.company.MazeGenerators;

import com.company.Model.Cell;
import com.company.Model.Grid;
import com.company.Random;

import java.util.ArrayList;
import java.util.List;

public class Sidewinder implements IMazeGenerator {
    private final Random random;
    public Sidewinder(Random rand){
        random = rand;
    }
    public void generate(Grid grid) {
        List<Cell> run = new ArrayList<>();
        for (Cell cell : grid){
            run.add(cell);
            if (shouldCloseRun(cell)){
                Cell runMember = random.getRandomElement(run);
                if(runMember.getNorth() != null){
                    runMember.linkCell(runMember.getNorth());
                }
                run.clear();
            } else {
                cell.linkCell(cell.getEast());
            }
        }
    }
    private boolean shouldCloseRun(Cell cell){
        boolean atEasternBoundary = cell.getEast() == null;
        boolean atNorthernBoundary = cell.getNorth() == null;
        return atEasternBoundary || (!atNorthernBoundary && random.nextBoolean());
    }
}
