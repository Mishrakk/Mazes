package com.company;

public class Grid {
    public final int Width;
    public final int Height;
    public Cell[][] CellsGrid;

    public Grid(int width, int height){
        Width = width;
        Height = height;
        CellsGrid = new Cell[Width][Height];
        for (int x=0; x< Width; x++){
            for (int y=0; y< Height; y++){
                CellsGrid[x][y] = new Cell(x, y);
            }
        }
    }
}

