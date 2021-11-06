package com.company;

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
        return y * grid.Width + x < grid.Size();
    }

    @Override
    public Cell next() {
        current = grid.GetCellAt(x, y);
        if (x + 1 < grid.Width){
            x++;
        } else {
            x = 0;
            y++;
        }
        return current;
    }
}
