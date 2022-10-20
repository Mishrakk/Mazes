package com.company;

import com.company.MazeGenerators.IMazeGenerator;
import com.company.MazeGenerators.RecursiveBacktracker;
import com.company.MazePrinters.ColoredPrinter;
import com.company.MazePrinters.MazePrinter;
import com.company.Model.Mask;
import com.company.Model.MaskedGrid;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Objects;

public class Main {

    public static void main(String[] args) throws IOException, URISyntaxException {
        System.out.print("Hello World!\n");
        Random random = new Random();
        MaskMapper maskMapper = new MaskMapper(random);
        URI filePath = Objects.requireNonNull(Main.class.getClassLoader().getResource("masks/mask_with_hole.txt")).toURI();
        Mask mask = maskMapper.FromTextFile(filePath);
        var grid = new MaskedGrid(mask, random);
        IMazeGenerator generator = new RecursiveBacktracker(random);
        generator.generate(grid);
        System.out.print(grid);
        MazePrinter mazePrinter = new ColoredPrinter(grid);
        var file = new File("maze.png");
        ImageIO.write(mazePrinter.getImage(), "png", file);
    }
}
