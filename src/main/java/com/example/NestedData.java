package com.example;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

class NestedData {
    static LinkedHashMap<String, List<String>> map = new LinkedHashMap<>();
    static List<String[]> result = new ArrayList<>();
    public static final List<String> path = new ArrayList<>();

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
        };

        for (String[] row : input) {
            if (row[3].equals("mfg")) {
                if (!map.containsKey(row[1])) {
                    map.put(row[1], new ArrayList<>());
                }
                map.get(row[1]).add(row[2]);
            }
        }

        createHeaders();
        System.out.println();
        for (Map.Entry<String, List<String>> stringListEntry : map.entrySet()) {
            if (!stringListEntry.getKey().equals("door"))
                mappingTheParentNode(stringListEntry.getKey(), path, input);
        }
    }

    private static void createHeaders() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Combination number" + "\t  ");
        int maxValue = 0;
        for (List<String> array : map.values()) {
            int value = array.size();
            if (value > maxValue) {
                maxValue = value;
            }
        }
        maxValue = maxValue / 2;
        for (int i = 1; i <= maxValue; i++) {
            stringBuilder.append("level").append(i).append("  ").append("level").append(i).append(" id").append("  ");
        }
        System.out.print(stringBuilder);
    }

    private static void mappingTheParentNode(String node, List<String> path, String[][] input) {
        path.add(node);
        path.add(getId(input, node));

        if (!map.containsKey(node)) {
            printCombination();
            path.remove(path.size() - 1);
            path.remove(path.size() - 1);
            return;
        }
        for (String next : map.get(node)) {
            List<String> newPath = new ArrayList<>(path);
            mappingTheParentNode(next, newPath, input);
        }
        path.remove(path.size() - 1);
        path.remove(path.size() - 1);
    }

    private static void printCombination() {
        int count = result.size() + 1;
        String[] arr = path.toArray(new String[0]);
        String[] newComb = new String[arr.length + 1];
        newComb[0] = Integer.toString(count);
        for (int i = 0; i < arr.length; i++) {
            newComb[i + 1] = arr[i];
        }
        result.add(newComb);
        System.out.print("\t\t" + count + "\t\t\t");
        for (String s : newComb) {
            System.out.print("  " + s + "\t  ");
        }
        System.out.println();
    }

    private static String getId(String[][] input, String node) {
        for (String[] row : input) {
            if (row[1].equals(node)) {
                return row[0];
            }
        }
        return "";
    }


}


