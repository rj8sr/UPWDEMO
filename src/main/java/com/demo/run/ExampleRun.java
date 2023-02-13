package com.demo.run;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExampleRun {
    public static void main(String[] args) {
        List<List<String>> input = new ArrayList<>();
        input.add(Arrays.asList("1", "car"));
        input.add(Arrays.asList("1", "car", "chassis", "2"));
        input.add(Arrays.asList("1", "car", "chassis", "2", "door", "3"));
        input.add(Arrays.asList("1", "car", "chassis", "2", "door", "3", "window", "4"));
        input.add(Arrays.asList("1", "car", "tyre", "5"));

        System.out.println("level1   level1 id   level2   level2 id   level3   level3 id   level4   level4 id   level5   level5 id");
        printLevels(input, 0, 1);
    }

    private static void printLevels(List<List<String>> input, int level, int currentLevel) {
        if (level == input.get(0).size()) {
            return;
        }
        for (List<String> strings : input) {
            for (int k = 0; k < strings.size(); k++) {
                if (strings.size() > level) {
                    System.out.print(strings.get(k) + "          ");
                }
            }
            System.out.println();
        }
        printLevels(input, level + 2, currentLevel + 1);
    }
}

