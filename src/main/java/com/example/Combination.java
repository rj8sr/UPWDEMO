package com.example;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class BuildCombination {
    static Map<String, List<String>> map = new HashMap<>();
    static List<String[]> result = new ArrayList<>();
    public static final List<List<String>> addEx = new ArrayList<>();

    public static void main(String[] args) {
        String[][] input = {
                {"1", "car", "chassis", "mfg"},
                {"1", "car", "tyre", "mfg"},
                {"2", "chassis", "door", "mfg"},
                {"2", "chassis", "trunk", "proc"},
                {"2", "chassis", "bonut", "proc"},
                {"3", "door", "window", "mfg"},
                {"3", "door", "handle", "proc"},
                {"4", "window", "glass", "proc"},
                {"5", "tyre", "rubber", "proc"}

        };

        for (String[] row : input) {
            if (row[3].equals("mfg")) {
                if (!map.containsKey(row[1])) {
                    map.put(row[1], new ArrayList<>());
                }
                map.get(row[1]).add(row[2]);
            }
        }

        List<String> path = new ArrayList<>();
        mappingTheParentNode("car", path, input);
        createHeaders(input);
        System.out.println();
        printLevels(addEx, 0, 1);
    }

    private static void createHeaders(String[][] input) {
        int maxValue = 0;
        for (String[] array : input) {
            int value = Integer.parseInt(array[0]);
            if (value > maxValue) {
                maxValue = value;
            }
        }
        for (int i = 1; i <= maxValue; i++) {
            System.out.print("level" + i + " " + "level" + i + " id" + " ");
        }
    }

    private static void mappingTheParentNode(String node, List<String> path, String[][] input) {
        path.add(node);
        path.add(getId(input, node));
        makeItFormat(path);
        // out.println(path);
        if (!map.containsKey(node)) {
            result.add(path.toArray(new String[0]));
            return;
        }
        for (String next : map.get(node)) {
            List<String> newPath = new ArrayList<>(path);
            mappingTheParentNode(next, newPath, input);
        }
    }

    private static void makeItFormat(List<String> path) {
        addEx.add(path);

    }

    private static String getId(String[][] input, String item) {
        for (String[] in : input) {
            if (in[1].equals(item)) {
                return in[0];
            }
        }
        return "";
    }

    private static void printLevels(List<List<String>> input, int level, int currentLevel) {
        if (level == input.get(0).size()) {
            return;
        }
        for (List<String> strings : input) {
            for (int k = 0; k < strings.size(); k++) {
                if (strings.size() > level) {
                    System.out.print(strings.get(k) + "      ");
                }
            }
            System.out.println();
        }
        printLevels(input, level + 2, currentLevel + 1);
    }
}


