package com.demo.run;

import java.util.*;

import java.util.Map.*;

import java.util.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

 class HierarchyPrinter {
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

        Map<String, List<String>> graph = new HashMap<>();
        for (String[] edge : input) {
            if (edge[3].equals("mfg")) {
                if (!graph.containsKey(edge[1])) {
                    graph.put(edge[1], new ArrayList<>());
                }
                graph.get(edge[1]).add(edge[2]);
            }
        }

        List<String> hierarchy = new ArrayList<>();
        hierarchy.add("car");
        printHierarchy(graph, hierarchy, 1);
    }

    private static void printHierarchy(Map<String, List<String>> graph, List<String> hierarchy, int level) {
        String parent = hierarchy.get(hierarchy.size() - 1);
        if (!graph.containsKey(parent)) {
            return;
        }

        for (String child : graph.get(parent)) {
            hierarchy.add(child);
            for (String node : hierarchy) {
                System.out.print(node + "\t"+ "\t" + (level)+ "\t");
            }
            System.out.println();
            printHierarchy(graph, hierarchy, level+1);
//            hierarchy.remove(hierarchy.size() - 1);
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

