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
    public BufferedImage GetImage(){
        BufferedImage bufferedImage = new BufferedImage(CellSize * Grid.Width + 1, CellSize * Grid.Height + 1, BufferedImage.TYPE_INT_RGB);
        Graphics graphics = bufferedImage.createGraphics();
        SetBackground(graphics);
        DrawCells(graphics);
        graphics.dispose();
        return bufferedImage;
    }

    private void DrawCells(Graphics graphics) {
        graphics.setColor(Color.black);
        for (Cell cell : Grid){
            int x1 = cell.X * CellSize;
            int y1 = cell.Y * CellSize;
            int x2 = (cell.X + 1) * CellSize;
            int y2 = (cell.Y + 1) * CellSize;
            if (cell.North == null){
                graphics.drawLine(x1, y1, x2, y1);
            }
            if (cell.West == null){
                graphics.drawLine(x1, y1, x1, y2);
            }
            if(!cell.Linked(cell.South)){
                graphics.drawLine(x1, y2, x2, y2);
            }
            if(!cell.Linked(cell.East)){
                graphics.drawLine(x2, y1, x2, y2);
            }
        }
    }

    private void SetBackground(Graphics graphics) {
        graphics.setColor(Color.white);
        graphics.fillRect(0, 0, CellSize * Grid.Width, CellSize * Grid.Height);
    }
}
