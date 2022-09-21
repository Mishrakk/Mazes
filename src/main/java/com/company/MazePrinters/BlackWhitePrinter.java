package com.company.MazePrinters;

import com.company.Model.Grid;

import java.awt.*;
import java.awt.image.BufferedImage;

public class BlackWhitePrinter extends MazePrinter {
    public BlackWhitePrinter(Grid grid, int cellSize){
        super(grid, cellSize);
    }
    public BlackWhitePrinter(Grid grid){
        super(grid);
    }

    @Override
    public BufferedImage getImage(){
        BufferedImage bufferedImage = new BufferedImage(cellSize * grid.getWidth() + 1, cellSize * grid.getHeight() + 1, BufferedImage.TYPE_INT_RGB);
        Graphics graphics = bufferedImage.createGraphics();
        SetBackground(graphics);
        drawCells(graphics);
        graphics.dispose();
        return bufferedImage;
    }

    private void SetBackground(Graphics graphics) {
        graphics.setColor(Color.white);
        graphics.fillRect(0, 0, cellSize * grid.getWidth(), cellSize * grid.getHeight());
    }
}
