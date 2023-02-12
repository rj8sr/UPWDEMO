package com.example;

import java.util.ArrayList;
import java.util.Arrays;
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
         };

         Map<String, String> map = new HashMap<>();
         for (String[] arr : input) {
             if (arr[3].equals("mfg")) {
                 map.put(arr[2], arr[0]);
             }
         }

         String[][] output = new String[map.size()][];
         int i = 0;
         for (Map.Entry<String, String> entry : map.entrySet()) {
             String[] row = {entry.getValue(), entry.getKey()};
             output[i++] = row;
         }

         for (String[] arr : output) {
             System.out.println(Arrays.toString(arr));
         }
     }

 }




