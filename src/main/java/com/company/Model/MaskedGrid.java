package com.company.Model;

import com.company.Random;

public class MaskedGrid extends Grid{
    private final Mask mask;
    public MaskedGrid(Mask mask, Random random){
        super();
        this.width = mask.getWidth();
        this.height = mask.getHeight();
        this.random = random;
        this.mask = mask;
        this.cellsGrid = new Cell[this.width][this.height];
        prepareGrid();
        prepareCells();
    }

    @Override
    protected void prepareGrid(){
        for (int x = 0; x< this.width; x++){
            for (int y = 0; y< this.height; y++){
                if (mask.isCellEnabled(x, y)){
                    cellsGrid[x][y] = new Cell(x, y, random);
                }
            }
        }
    }

    @Override
    public Cell getRandomCell(){
        Mask.Point maskPoint = mask.getRandomLocation();
        return getCellAt(maskPoint.x(), maskPoint.y());
    }

    @Override
    public int size(){
        return mask.getEnabledCells();
    }
}
