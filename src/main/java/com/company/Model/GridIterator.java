package com.company.Model;

import lombok.Data;

import java.util.Iterator;

@Data
public class GridIterator implements Iterator<Cell> {
    private final Grid grid;
    private int x = 0;
    private int y = 0;
    private Cell current;

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
