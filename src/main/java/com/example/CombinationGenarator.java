package com.example;

import java.util.ArrayList;
import java.util.List;

 class CombinationGenerator {
    public static void main(String[] args) {
        String[][] input = {
                {"car", "1"},
                {"car", "1", "chassis", "2"},
                {"car", "1", "chassis", "2", "door", "3"},
                {"car", "1", "chassis", "2", "door", "3", "window", "4"},
                {"car", "1", "tyre", "5"},
                {"car", "1", "seat", "6"}
        };

        List<String[]> combinations = new ArrayList<>();
        for (int i = 0; i < input.length; i++) {
            String[] current = input[i];
            combinations.add(current);

            for (int j = i + 1; j < input.length; j++) {
                String[] next = input[j];
                if (next.length <= current.length) {
                    continue;
                }
                boolean match = true;
                for (int k = 0; k < current.length; k++) {
                    if (!current[k].equals(next[k])) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    combinations.add(next);
                }
            }
        }

        System.out.printf("%-20s%-10s%-20s%-10s%-20s%-10s%-20s%-10s\n",
                "Combination number", "level1", "level1 id", "level2", "level2 id", "level3", "level3 id", "level4", "level4 id");
        for (int i = 0; i < combinations.size(); i++) {
            String[] combination = combinations.get(i);
            System.out.printf("%-20d", i+1);
            for (int j = 0; j < 4; j++) {
                if (j * 2 >= combination.length) {
                    System.out.printf("%-20s%-10s", "", "");
                } else {
                    System.out.printf("%-20s%-10s", combination[j * 2], combination[j * 2 + 1]);
                }
            }
            System.out.println();
        }
    }
}






