package com.demo.run;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Formatting {
    public static void main(String[] args) {
        ArrayList<String[]> input = new ArrayList<>();
        input.add(new String[]{"car", "1"});
        input.add(new String[]{"car", "1", "chassis", "2"});
        input.add(new String[]{"car", "1", "chassis", "2", "door", "3"});
        input.add(new String[]{"car", "1", "chassis", "2", "door", "3", "window", "4"});
        input.add(new String[]{"car", "1", "tyre", "5"});
        input.add(new String[]{"car", "1", "engine", "6"});
        input.add(new String[]{"car", "1", "engine", "6", "nut", "7"});
        input.add(new String[]{"car", "1", "engine", "6", "nut", "7", "bolt", "8"});

        Map<Integer, Integer> maxLengths = new HashMap<>();
        for (String[] arr : input) {
            for (int i = 0; i < arr.length; i += 2) {
                int index = i / 2 + 1;
                maxLengths.put(index, Math.max(maxLengths.getOrDefault(index, 0), arr[i].length()));
            }
        }

        System.out.println("level1\tlevel1 id\tlevel2\tlevel2 id\tlevel3\tlevel3 id\tlevel4\tlevel4 id");
        for (String[] arr : input) {
            for (int i = 0; i < arr.length; i += 2) {
                int index = i / 2 + 1;
                System.out.print(arr[i]);
                for (int j = 0; j < maxLengths.get(index) - arr[i].length() + 1; j++) {
                    System.out.print(" ");
                }
                System.out.print("\t");
                System.out.print(arr[i + 1]);
                System.out.print("\t");
            }
            System.out.println();
        }
    }
}

