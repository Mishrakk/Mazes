package com.company;

import com.company.MazeGenerators.IMazeGenerator;
import com.company.MazeGenerators.RecursiveBacktracker;
import com.company.Model.Grid;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.print("Hello World!\n");
        Random random = new Random();
        var grid = new Grid(100, 100, random);
        IMazeGenerator generator = new RecursiveBacktracker(random);
        generator.generate(grid);
        System.out.print(grid);
        var mazePrinter = new MazePrinter(grid);
        var file = new File("maze.png");
        ImageIO.write(mazePrinter.getColoredImage(), "png", file);
    }
}
