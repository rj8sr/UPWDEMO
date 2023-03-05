package com.example;


import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import static java.lang.System.out;

class BuildCombination {
    static LinkedHashMap<String, List<String>> map = new LinkedHashMap<>();
    static List<String[]> result = new ArrayList<>();
    public static final List<List<String>> addEx = new ArrayList<>();
    public static final List<List<String>> addElementsOnLevel = new ArrayList<>();

    public static void main(String[] args) {
        String[][] input = {{"1", "car", "chassis", "mfg"}, {"1", "car", "tyre", "mfg"}, {"1", "car", "seat", "mfg"}, {"2", "chassis", "door", "mfg"}, {"2", "chassis", "trunk", "proc"}, {"2", "chassis", "bonut", "proc"}, {"3", "door", "window", "mfg"}, {"3", "door", "handle", "proc"}, {"4", "window", "glass", "proc"}, {"5", "tyre", "rubber", "proc"}, {"6", "seat", "chair", "proc"},

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
        mappingTheParentNode(map.entrySet().stream().iterator().next().getKey(), path, input);
        createHeaders();
        out.println();
        printLevels();
        extractedGrouping(addEx.size());
    }

    private static void createHeaders() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Combination number" + "\t  ");
        int maxValue = 0;
        for (List<String> array : addEx) {
            int value = array.size();
            if (value > maxValue) {
                maxValue = value;
            }
        }
        maxValue = maxValue / 2;
        for (int i = 1; i <= maxValue; i++) {
            stringBuilder.append("level").append(i).append("  ").append("level").append(i).append(" id").append("  ");
        }
        out.print(stringBuilder);
    }

    private static void mappingTheParentNode(String node, List<String> path, String[][] input) {
        path.add(node);
        path.add(getId(input, node));
        makeItFormat(path);
//        out.println(path);
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
        int count = 1;
        for (List<String> arr : addEx) {
            out.print("\t\t" + count + "\t\t\t");
            count++;
            for (String s : arr) {
                out.print("  " + s + "\t  ");
            }

            out.println();
        }
    }

    private static void extractedGrouping(int count) {
        for (List<String> ex : addEx) {
            if (ex.size() > 2 && ex.size() < 5) {
                addElementsOnLevel.add(ex);
            }
        }

        for (List<String> s : addElementsOnLevel) {
            out.print("\t\t" + ++count + "\t\t\t");
            for (String value : s) {
                out.print("  " + value + "\t  ");
            }
            out.println();
            for (List<String> ex : addEx) {
                if (ex.size() > 2) {
                    out.print("\t\t" + count + "\t\t\t");
                    for (String moreValues : ex) {
                        out.print("  " + moreValues + "\t  ");
                    }
                    count++;
                    out.println();
                }
            }

        }
    }
}


