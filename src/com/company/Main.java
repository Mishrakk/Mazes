package com.company;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.print("Hello World!\n");
        Grid grid = new Grid(10, 10);
        SidewinderMaze.Generate(grid);
        System.out.print(grid);
        MazePrinter mazePrinter = new MazePrinter(grid);
        File file = new File("maze.png");
        ImageIO.write(mazePrinter.GetImage(), "png", file);
    }
}
