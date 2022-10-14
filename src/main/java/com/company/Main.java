package com.company;

import com.company.MazeGenerators.IMazeGenerator;
import com.company.MazeGenerators.RecursiveBacktracker;
import com.company.MazePrinters.ColoredPrinter;
import com.company.MazePrinters.MazePrinter;
import com.company.Model.Grid;
import com.company.Model.Mask;
import com.company.Model.MaskedGrid;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.print("Hello World!\n");
        Random random = new Random();
        Mask mask = new Mask(10, 10, random);
        mask.setCellAt(1,1, false);
        mask.setCellAt(1,1, false);
        mask.setCellAt(1,2, false);
        mask.setCellAt(2,1, false);
        mask.setCellAt(2,2, false);
        var grid = new MaskedGrid(mask, random);
        IMazeGenerator generator = new RecursiveBacktracker(random);
        generator.generate(grid);
        System.out.print(grid);
        MazePrinter mazePrinter = new ColoredPrinter(grid);
        var file = new File("maze.png");
        ImageIO.write(mazePrinter.getImage(), "png", file);
    }
}
