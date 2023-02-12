package com.example;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class BuildCombination {
    static Map<String, List<String>> map = new HashMap<>();
    static List<String[]> result = new ArrayList<>();

    public static void main(String[] args) {
        String[][] input = {
                {"1", "car", "chassis", "mfg"},
                {"1", "car", "tyre", "mfg"},
                {"2", "chassis", "door", "mfg"},
                {"2", "chasis", "trunk", "proc"},
                {"2", "chasis", "bonut", "proc"},
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

        List<String> path = new ArrayList<>();
        dfs("car", path);
    }

    private static void dfs(String node, List<String> path) {
        path.add(node);
        System.out.println(path);
        if (!map.containsKey(node)) {
            result.add(path.toArray(new String[0]));
            return;
        }
        for (String next : map.get(node)) {
            List<String> newPath = new ArrayList<>(path);
            dfs(next, newPath);
        }
    }
}


