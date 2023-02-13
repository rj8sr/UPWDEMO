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
                {"5", "tyre", "rubber", "proc"},
                {"1", "car", "engine", "mfg"},
                {"6", "engine", "nut", "mfg"},
                {"7", "nut", "bolt", "mfg"},
                {"8", "bolt", "bolts", "proc"}
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
        createHeaders(map);
        System.out.println();
        printLevels();
    }

    private static void createHeaders(Map<String, List<String>> map) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Combination number");
        int maxValue = 0;
        for (List<String> array : map.values()) {
            int value = array.size();
            if (value > maxValue) {
                maxValue = value;
            }
        }
        maxValue=maxValue+1;
        for (int i = 1; i <= maxValue; i++) {
            stringBuilder.append("level").append(i).append(" ").append("level").append(i).append(" id").append("  ");
        }
        System.out.print(stringBuilder);
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

    private static void printLevels() {
        Map<Integer, Integer> maxLengths = new HashMap<>();
        for (List<String> arr : addEx) {
            for (int i = 0; i < arr.size(); i += 2) {
                int index = i / 2 + 1;
                maxLengths.put(index, Math.max(maxLengths.getOrDefault(index, 0), arr.get(i).length()));
            }
        }
        int count = 1;
        for (List<String> arr : addEx) {
            System.out.print(count + "\t");
            count++;
            for (int i = 0; i < arr.size(); i += 2) {
                int index = i / 2 + 1;
                System.out.print(arr.get(i));
                for (int j = 0; j < maxLengths.get(index) - arr.get(i).length(); j++) {
                    System.out.print(" ");
                }
                System.out.print("\t");
                System.out.print(arr.get(i + 1));
                System.out.print("\t");
            }
            System.out.println();
        }
    }
}


