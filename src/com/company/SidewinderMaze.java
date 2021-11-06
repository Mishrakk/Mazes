package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SidewinderMaze {
    public static void Generate(Grid grid) {
        Random rand = new Random();
        List<Cell> run = new ArrayList<>();
        for (Cell cell : grid){
            run.add(cell);
            if (ShouldCloseRun(cell)){
                Cell runMember = run.get(rand.nextInt(run.size()));
                if(runMember.North != null){
                    runMember.LinkCell(runMember.North);
                    run.clear();
                }
            } else {
                cell.LinkCell(cell.East);
            }
        }
    }
    public static boolean ShouldCloseRun(Cell cell){
        Random rand = new Random();
        boolean atEasternBoundary = cell.East == null;
        boolean atNorthernBoundary = cell.North == null;
        return atEasternBoundary || (!atNorthernBoundary && rand.nextBoolean());
    }
}
