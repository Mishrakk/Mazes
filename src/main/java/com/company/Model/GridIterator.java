package com.company.Model;

import java.util.Iterator;

public class GridIterator implements Iterator<Cell> {
    private final Grid grid;
    private int x;
    private int y;
    public Cell current;

    public GridIterator(Grid grid){
        this.grid = grid;
        x = 0;
        y = 0;
    }
    @Override
    public boolean hasNext() {
        return y * grid.getWidth() + x < grid.size();
    }

    @Override
    public Cell next() {
        current = grid.getCellAt(x, y);
        if (x + 1 < grid.getWidth()){
            x++;
        } else {
            x = 0;
            y++;
        }
        return current;
    }
}
