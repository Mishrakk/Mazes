package com.company;

public class Grid {
    public final int Width;
    public final int Height;
    public Cell[][] CellsGrid;

    public Grid(int width, int height){
        Width = width;
        Height = height;
        CellsGrid = new Cell[Width][Height];
    }
}

