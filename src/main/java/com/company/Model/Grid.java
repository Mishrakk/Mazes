package com.company.Model;

import com.company.Random;

import java.util.Iterator;
import lombok.*;

@Getter @Setter
public class Grid implements Iterable<Cell> {
    private final int width;
    private final int height;
    @Setter(AccessLevel.PRIVATE)
    private Cell[][] cellsGrid;
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
            cell.setNorth(getCellAt(cell.getX(),cell.getY() - 1));
            cell.setSouth(getCellAt(cell.getX(), cell.getY() + 1));
            cell.setWest(getCellAt(cell.getX() - 1, cell.getY()));
            cell.setEast(getCellAt(cell.getX() + 1, cell.getY()));
        }
    }

    public int size(){
        return width * height;
    }

    public Cell getCellAt(int x, int y){
        return x < 0 || x == width || y < 0 || y == height ? null : cellsGrid[x][y];
    }

    public Cell getRandomCell(){
        int randomX = random.nextInt(width);
        int randomY = random.nextInt(height);
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
                String east_boundary = cell.isLinked(cell.getEast()) ? " " : "|";
                top.append(body).append(east_boundary);
                String south_boundary = cell.isLinked(cell.getSouth()) ? "   " : "---";
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

