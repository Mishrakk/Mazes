package com.company;

import java.awt.*;
import java.awt.image.BufferedImage;

public class MazePrinter {
    private final Grid Grid;
    private final int CellSize;
    public MazePrinter(Grid grid, int cellSize){
        Grid = grid;
        CellSize = cellSize;
    }
    public MazePrinter(Grid grid){
        this(grid, 10);
    }
        BufferedImage bufferedImage = new BufferedImage(CellSize * Grid.Width, CellSize * Grid.Height, BufferedImage.TYPE_INT_RGB);
    public BufferedImage GetImage(){
        Graphics graphics = bufferedImage.createGraphics();
        SetBackground(graphics);
        return bufferedImage;
    }
    private void SetBackground(Graphics graphics) {
        graphics.setColor(Color.white);
        graphics.fillRect(0, 0, CellSize * Grid.Width, CellSize * Grid.Height);
    }
}
