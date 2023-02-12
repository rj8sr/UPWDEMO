package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.util.*;

class CombinationithId {
    static Map<String, List<String>> map = new HashMap<>();
    static Map<String, String> numberMap = new HashMap<>();
    static List<String[]> result = new ArrayList<>();

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
                {"7", "nut", "bolt", "proc"},

        };

        for (String[] row : input) {
            if (row[3].equals("mfg")) {
                if (!map.containsKey(row[1])) {
                    map.put(row[1], new ArrayList<>());
                }
                map.get(row[1]).add(row[2]);
                numberMap.put(row[2], row[0]);
            }
        }

        List<String> path = new ArrayList<>();
        dfs("car", path);

        for (String[] arr : result) {
            System.out.print("[car");
            for (int i = 1; i < arr.length; i++) {
                System.out.print(", " + arr[i] + " " + numberMap.get(arr[i]));
            }
            System.out.println("]");
        }
    }

    private static void dfs(String node, List<String> path) {
        path.add(node);
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





