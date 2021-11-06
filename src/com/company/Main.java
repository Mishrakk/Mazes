package com.company;

public class Main {

    public static void main(String[] args) {
        System.out.print("Hello World!\n");
        Grid grid = new Grid(10, 10);
        SidewinderMaze.Generate(grid);
        System.out.print(grid);
    }
}
