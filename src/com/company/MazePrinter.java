package com.company;

import java.awt.*;
import java.awt.image.BufferedImage;

public class MazePrinter {
    private Grid Grid;
    private int CellSize;
    public MazePrinter(Grid grid, int cellSize){
        Grid = grid;
        CellSize = cellSize;
    }
    public BufferedImage GetGraphics(){
        BufferedImage bufferedImage = new BufferedImage(CellSize * Grid.Width, CellSize * Grid.Height, BufferedImage.TYPE_INT_RGB);
        return bufferedImage;
    }
}
