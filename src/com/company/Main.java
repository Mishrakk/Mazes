package com.company;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.print("Hello World!\n");
        var grid = new DistancesGrid(100, 100);
        SidewinderMaze.generate(grid);
        grid.distances = grid.getCellAt(0,0).distances;
        System.out.print(grid);
        var mazePrinter = new MazePrinter(grid);
        var file = new File("maze.png");
        ImageIO.write(mazePrinter.getColoredImage(), "png", file);
    }
}
