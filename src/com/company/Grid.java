package com.company;

import java.util.Iterator;

public class Grid implements Iterable<Cell> {
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
                cell.North = GetCellAt(cell.X,cell.Y-1);
                cell.South = GetCellAt(cell.X, cell.Y + 1);
                cell.West = GetCellAt(cell.X - 1, cell.Y);
                cell.East = GetCellAt(cell.X + 1, cell.Y);
            }
        }
    }

    public Cell GetCellAt(int x, int y){
        return x < 0 || x == Width || y < 0 || y == Height ? null : CellsGrid[x][y];
    }

    public String toString()
    {
        StringBuilder output = new StringBuilder("+" + "---+".repeat(Height) + "\n");

        for (int y = 0; y < Height; y++)
        {
            StringBuilder top = new StringBuilder("|");
            StringBuilder bottom = new StringBuilder("+");
            for (int x = 0; x < Width; x++)
            {
                Cell cell = CellsGrid[x][y];
                String body = "   ";
                String east_boundary = cell.Linked(cell.East) ? " " : "|";
                top.append(body).append(east_boundary);
                String south_boundary = cell.Linked(cell.South) ? "   " : "---";
                bottom.append(south_boundary).append("+");
            }
            output.append(top).append("\n");
            output.append(bottom).append("\n");
        }
        return output.toString();
    }

    @Override
    public Iterator<Cell> iterator() {
        return new GridIterator(this);
    }
}

