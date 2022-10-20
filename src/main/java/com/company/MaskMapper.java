package com.company;

import com.company.Model.Mask;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.net.URI;

public class MaskMapper {
    private final Random random;
    public MaskMapper(Random random){
        this.random = random;
    }
    public Mask FromTextFile(URI fileUri) throws FileNotFoundException {
        List<List<Boolean>> maskList = new ArrayList<>();
        Scanner scanner = new Scanner(new File(fileUri));
        while(scanner.hasNextLine()){
            String line = scanner.nextLine();
            List<Boolean> maskLine = new ArrayList<>();
            for (char c: line.toCharArray()){
                maskLine.add(c != 'X');
            }
            maskList.add(maskLine);
        }
        int height = maskList.size();
        int width = maskList.get(0).size();
        Mask mask = new Mask(width, height, random);
        for(int y = 0; y < height; y++){
            for(int x = 0; x < width; x++){
                mask.setCellAt(x, y, maskList.get(y).get(x));
            }
        }
        return mask;
    }
}
