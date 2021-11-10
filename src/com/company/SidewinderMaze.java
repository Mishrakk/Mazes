package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SidewinderMaze {
    public static void generate(Grid grid) {
        Random rand = new Random();
        List<Cell> run = new ArrayList<>();
        for (Cell cell : grid){
            run.add(cell);
            if (shouldCloseRun(cell, rand)){
                Cell runMember = run.get(rand.nextInt(run.size()));
                if(runMember.north != null){
                    runMember.linkCell(runMember.north);
                }
                run.clear();
            } else {
                cell.linkCell(cell.east);
            }
        }
    }
    public static boolean shouldCloseRun(Cell cell, Random rand){
        boolean atEasternBoundary = cell.east == null;
        boolean atNorthernBoundary = cell.north == null;
        return atEasternBoundary || (!atNorthernBoundary && rand.nextBoolean());
    }
}
