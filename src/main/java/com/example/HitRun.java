package com.example;

import java.util.*;
import java.util.stream.Collectors;

class Main {

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

        Map<String, List<String>> map = new HashMap<>();

        for (String[] arr : input) {
            if (!map.containsKey(arr[1])) {
                map.put(arr[1], new ArrayList<>());
            }
            map.get(arr[1]).add(arr[0]);
        }

        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            System.out.println("arr[1]: " + entry.getKey());
            System.out.println("arr[0]: " + new HashSet<>(entry.getValue()));
        }
    }

}
