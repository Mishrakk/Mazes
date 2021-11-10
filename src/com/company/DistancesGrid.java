package com.company;

public class DistancesGrid extends Grid {
    public Distances distances;

    public DistancesGrid(int width, int height) {
        super(width, height);
    }

    @Override
    public String contentsOf(Cell cell){
        if (distances != null && distances.containsKey(cell)){
            return Integer.toString(distances.getDistanceTo(cell), Character.MAX_RADIX);
        } else {
            return super.contentsOf(cell);
        }
    }
}
