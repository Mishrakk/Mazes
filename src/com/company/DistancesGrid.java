package com.company;

public class DistancesGrid extends Grid {
    public Distances distances;

    public DistancesGrid(int width, int height) {
        super(width, height);
    }

    @Override
    public String ContentsOf(Cell cell){
        if (distances != null && distances.containsKey(cell)){
            return Integer.toString(distances.GetDistanceTo(cell), Character.MAX_RADIX);
        } else {
            return super.ContentsOf(cell);
        }
    }
}
