package com.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NewCombo {
    public static void main(String[] args) {
        String[][] input = {
                {"1", "car", "chasis", "mfg"},
                {"1", "car", "tyre", "mfg"},
                {"2", "chasis", "door", "mfg"},
                {"2", "chasis", "trunk", "proc"},
                {"2", "chasis", "bonut", "proc"},
                {"3", "door", "window", "mfg"},
                {"3", "door", "handle", "proc"},
                {"4", "window", "glass", "proc"},
                {"5", "tyre", "rubber", "proc"},
        };

        Map<String, List<String>> hierarchy = new HashMap<>();
        for (String[] row : input) {
            String parentId = row[1];
            String childId = row[2];
            if (!hierarchy.containsKey(parentId)) {
                hierarchy.put(parentId, new ArrayList<>());
            }
            hierarchy.get(parentId).add(childId);
        }

        int id = 1;
        Map<String, Integer> idMap = new HashMap<>();
        idMap.put("car", id++);
        List<String> queue = new ArrayList<>();
        queue.add("car");

        while (!queue.isEmpty()) {
            String parentId = queue.remove(0);
            if (hierarchy.containsKey(parentId)) {
                for (String childId : hierarchy.get(parentId)) {
                    if (getParentType(childId, input).equals("mfg")) {
                        String key = getKey(parentId, childId, idMap);
                        idMap.put(key, id++);
                        System.out.print(idMap.get(parentId) + "\t");
                        System.out.print(parentId + "\t");
                        System.out.print(idMap.get(childId) + "\t");
                        System.out.print(childId + "\t");
                        System.out.println(idMap.get(key));
                        queue.add(childId);
                    }
                }
            }
        }
    }

    private static String getParentType(String childId, String[][] input) {
        for (String[] row : input) {
            if (row[2].equals(childId)) {
                return row[3];
            }
        }
        return "";
    }

    private static String getKey(String parentId, String childId, Map<String, Integer> idMap) {
        String key = parentId + "_" + childId;
        if (idMap.containsKey(key)) {
            key += "_" + idMap.get(key);
        }
        return key;
    }
}

