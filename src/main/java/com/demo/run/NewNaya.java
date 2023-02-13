package com.demo.run;

import java.util.*;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
                {"7", "nut", "bolt", "mfg"},
                {"8", "bolt", "boltaa", "proc"},
        };

        Map<String, List<String>> hierarchy = new HashMap<>();
        for (String[] in : input) {
            if (in[3].equals("mfg")) {
                if (!hierarchy.containsKey(in[1])) {
                    hierarchy.put(in[1], new ArrayList<>());
                }
                hierarchy.get(in[1]).add(in[2]);
            }
        }

        for (Map.Entry<String, List<String>> entry : hierarchy.entrySet()) {
            String parent = entry.getKey();
            System.out.print("[" + parent + " " + getId(input, parent));
            for (String child : entry.getValue()) {
                System.out.print(", " + child + " " + getId(input, child));
            }
            System.out.println("]");
        }
    }

    private static String getId(String[][] input, String item) {
        for (String[] in : input) {
            if (in[1].equals(item)) {
                return in[0];
            }
        }
        return null;
    }
}

