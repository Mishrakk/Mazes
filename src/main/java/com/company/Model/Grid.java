package com.company.Model;

import com.company.Random;

import java.util.Iterator;

public class Grid implements Iterable<Cell> {
    public final int width;
    public final int height;
    public Cell[][] cellsGrid;
    private final Random random;

    public Grid(int width, int height, Random rand){
        this.width = width;
        this.height = height;
        random = rand;
        cellsGrid = new Cell[this.width][this.height];
        for (int x = 0; x< this.width; x++){
            for (int y = 0; y< this.height; y++){
                cellsGrid[x][y] = new Cell(x, y, random);
            }
        }
        for (Cell cell : this){
            cell.north = getCellAt(cell.X,cell.Y-1);
            cell.south = getCellAt(cell.X, cell.Y + 1);
            cell.west = getCellAt(cell.X - 1, cell.Y);
            cell.east = getCellAt(cell.X + 1, cell.Y);
        }
    }

    public int size(){
        return width * height;
    }

    public Cell getCellAt(int x, int y){
        return x < 0 || x == width || y < 0 || y == height ? null : cellsGrid[x][y];
    }

    public Cell getRandomCell(){
        int randomX = random.nextInt(width+1);
        int randomY = random.nextInt(height+1);
        return getCellAt(randomX, randomY);
    }

    public String contentsOf(Cell cell){
        return " ";
    }

    public String toString()
    {
        StringBuilder output = new StringBuilder("+" + "---+".repeat(height) + "\n");

        for (int y = 0; y < height; y++)
        {
            StringBuilder top = new StringBuilder("|");
            StringBuilder bottom = new StringBuilder("+");
            for (int x = 0; x < width; x++)
            {
                Cell cell = cellsGrid[x][y];
                String body = " " + contentsOf(cell) + " ";
                String east_boundary = cell.isLinked(cell.east) ? " " : "|";
                top.append(body).append(east_boundary);
                String south_boundary = cell.isLinked(cell.south) ? "   " : "---";
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

