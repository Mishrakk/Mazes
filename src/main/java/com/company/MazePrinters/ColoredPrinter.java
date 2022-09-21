package com.company.MazePrinters;

import com.company.Model.Cell;
import com.company.Model.Distances;
import com.company.Model.Grid;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ColoredPrinter extends MazePrinter{

    public ColoredPrinter(Grid grid, int cellSize) {
        super(grid, cellSize);
    }

    public ColoredPrinter(Grid grid) {
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
        Distances distances = new Distances(grid.getCellAt(0,0));
        for (Cell cell : grid){
            graphics.setColor(Color.white);
            double intensity = ((double) (distances.getMaxDistance() - distances.getDistanceTo(cell)) )/ distances.getMaxDistance();
            int dark = (int) Math.round(255 * intensity);
            int bright = 128 + (int)Math.round((127*intensity));
            Color color = new Color(dark,bright,dark);
            graphics.setColor(color);
            int x1 = cell.X * cellSize;
            int y1 = cell.Y * cellSize;
            graphics.fillRect(x1, y1, cellSize, cellSize);
        }
    }
}
