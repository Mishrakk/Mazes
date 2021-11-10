package com.company;

import java.awt.*;
import java.awt.image.BufferedImage;

public class MazePrinter {
    private final Grid grid;
    private final int cellSize;
    public MazePrinter(Grid grid, int cellSize){
        this.grid = grid;
        this.cellSize = cellSize;
    }
    public MazePrinter(Grid grid){
        this(grid, 10);
    }
    public BufferedImage getImage(){
        BufferedImage bufferedImage = new BufferedImage(cellSize * grid.width + 1, cellSize * grid.height + 1, BufferedImage.TYPE_INT_RGB);
        Graphics graphics = bufferedImage.createGraphics();
        SetBackground(graphics);
        drawCells(graphics);
        graphics.dispose();
        return bufferedImage;
    }

    private void drawCells(Graphics graphics) {
        graphics.setColor(Color.black);
        for (Cell cell : grid){
            int x1 = cell.X * cellSize;
            int y1 = cell.Y * cellSize;
            int x2 = (cell.X + 1) * cellSize;
            int y2 = (cell.Y + 1) * cellSize;
            if (cell.north == null){
                graphics.drawLine(x1, y1, x2, y1);
            }
            if (cell.west == null){
                graphics.drawLine(x1, y1, x1, y2);
            }
            if(!cell.isLinked(cell.south)){
                graphics.drawLine(x1, y2, x2, y2);
            }
            if(!cell.isLinked(cell.east)){
                graphics.drawLine(x2, y1, x2, y2);
            }
        }
    }

    private void SetBackground(Graphics graphics) {
        graphics.setColor(Color.white);
        graphics.fillRect(0, 0, cellSize * grid.width, cellSize * grid.height);
    }
}
