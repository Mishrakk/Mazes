package com.company.Model;

import lombok.Data;

import java.util.Iterator;

@Data
public class GridIterator implements Iterator<Cell> {
    private final Grid grid;
    private int x = 0;
    private int y = 0;
    private int count = 0;

    @Override
    public boolean hasNext() {
        return count < grid.size();
    }

    @Override
    public Cell next() {
        if (!hasNext()){
            return null;
        }
        Cell current;
        do {
            current = grid.getCellAt(x, y);
            if (x + 1 < grid.getWidth()){
                x++;
            } else {
                x = 0;
                y++;
            }
        } while (current == null);
        count++;
        return current;
    }
}
