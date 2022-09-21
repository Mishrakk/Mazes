package com.company.MazePrinters;

import com.company.Model.Cell;
import com.company.Model.Grid;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class MazePrinter {
    protected final Grid grid;
    protected final int cellSize;
    public MazePrinter(Grid grid, int cellSize){
        this.grid = grid;
        this.cellSize = cellSize;
    }
    public MazePrinter(Grid grid){
        this(grid, 10);
    }
    protected void drawCells(Graphics graphics) {
        graphics.setColor(Color.black);
        for (Cell cell : grid){
            int x1 = cell.getX() * cellSize;
            int y1 = cell.getY() * cellSize;
            int x2 = (cell.getX() + 1) * cellSize;
            int y2 = (cell.getY() + 1) * cellSize;
            if (cell.getNorth() == null){
                graphics.drawLine(x1, y1, x2, y1);
            }
            if (cell.getWest() == null){
                graphics.drawLine(x1, y1, x1, y2);
            }
            if(!cell.isLinked(cell.getSouth())){
                graphics.drawLine(x1, y2, x2, y2);
            }
            if(!cell.isLinked(cell.getEast())){
                graphics.drawLine(x2, y1, x2, y2);
            }
        }
    }

    public abstract BufferedImage getImage();
}
