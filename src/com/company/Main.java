package com.company;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.print("Hello World!\n");
        var grid = new DistancesGrid(10, 10);
        SidewinderMaze.Generate(grid);
        grid.distances = grid.GetCellAt(0,0).Distances;
        System.out.print(grid);
        MazePrinter mazePrinter = new MazePrinter(grid);
        File file = new File("maze.png");
        ImageIO.write(mazePrinter.GetImage(), "png", file);
    }
}
