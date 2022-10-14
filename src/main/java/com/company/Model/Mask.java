package com.company.Model;

import com.company.Random;
import lombok.Getter;

@Getter
public class Mask {
    private final int width;
    private final int height;
    private final boolean[][] mask;
    private final Random random;

    record Point(int x, int y) {
    }

    public Mask(int width, int height, Random random){
        this.width = width;
        this.height = height;
        this.random = random;
        mask = new boolean[width][height];
        for(int i = 0; i < width; i++){
            for (int j = 0; j< height; j++){
                mask[i][j] = true;
            }
        }
    }

    public void setCellAt(int x, int y, boolean value){
        if(x < 0 || x >= width || y < 0 || y >= height){
            throw new IndexOutOfBoundsException("Position is out of bounds of mask");
        }
        mask[x][y] = value;
    }

    public boolean isCellEnabled(int x, int y){
        if(x < 0 || x >= width || y < 0 || y >= height){
            throw new IndexOutOfBoundsException("Position is out of bounds of mask");
        }
        return mask[x][y];
    }

    public int getEnabledCells(){
        int enabledCells = 0;
        for(int i = 0; i < width; i++){
            for (int j = 0; j< height; j++){
                if (mask[i][j]){
                    enabledCells++;
                }
            }
        }
        return enabledCells;
    }

    public Point getRandomLocation(){
        while(true){
            int randomX = random.nextInt(width);
            int randomY = random.nextInt(height);
            if (mask[randomX][randomY]){
                return new Point(randomX, randomY);
            }
        }
    }

}
