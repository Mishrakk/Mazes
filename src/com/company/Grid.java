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
        for (int x=0; x< Width; x++){
            for (int y=0; y< Height; y++){
                Cell cell = CellsGrid[x][y];
                cell.North = cell.Y - 1 < 0 ? null : CellsGrid[cell.X][cell.Y-1];
                cell.South = cell.Y + 1 >= Height ? null : CellsGrid[cell.X][cell.Y + 1];
                cell.West = cell.X - 1 < 0 ? null : CellsGrid[cell.X - 1][cell.Y];
                cell.East = cell.X + 1 >= Width ? null : CellsGrid[cell.X + 1][cell.Y];
            }
        }
    }
}

