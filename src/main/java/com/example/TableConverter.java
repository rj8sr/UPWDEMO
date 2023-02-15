package com.example;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

 class TableConverter {
    public static void main(String[] args) {
        String[][] cd = {
                {"car", "1"},
                {"car", "1", "chassis", "2"},
                {"car", "1", "chassis", "2", "door", "3"},
                {"car", "1", "chassis", "2", "door", "3", "window", "4"},
                {"car", "1", "tyre", "5"}
        };

        // Create a LinkedHashMap to store the grouped elements
        Map<String, List<Map<String, String>>> groupedElements = new LinkedHashMap<>();

        // Iterate through each row in the 2D array
        for (String[] row : cd) {
            // Initialize the keys for the grouped elements
            String car = row[0];
            String number = row[1];

            // Create a new Map for the current row's elements
            Map<String, String> currentElements = new LinkedHashMap<>();

            // Iterate through each column in the row (skipping the first two columns)
            for (int i = 2; i < row.length; i += 2) {
                // Get the current element and its corresponding number
                String element = row[i];
                String elementNumber = row[i+1];

                // Add the current element and its number to the currentElements Map
                currentElements.put(element, elementNumber);
            }

            // If the current car and number combination already exists in the groupedElements Map, add the currentElements Map to its value (List of Maps of elements)
            if (groupedElements.containsKey(car + " " + number)) {
                groupedElements.get(car + " " + number).add(currentElements);
            }
            // Otherwise, add a new entry to the groupedElements Map with the current car and number combination as the key and a new List containing the currentElements Map as the value
            else {
                List<Map<String, String>> elementsList = new ArrayList<>();
                elementsList.add(currentElements);
                groupedElements.put(car + " " + number, elementsList);
            }
        }

        // Iterate through the groupedElements Map and print each element in the required format
        for (Map.Entry<String, List<Map<String, String>>> entry : groupedElements.entrySet()) {
            // Get the current car and number combination
            String carNumber = entry.getKey();

            // Iterate through the list of elements and print each one in the required format
            for (Map<String, String> elementsMap : entry.getValue()) {
                StringBuilder output = new StringBuilder(carNumber);

                for (Map.Entry<String, String> elementEntry : elementsMap.entrySet()) {
                    output.append("\t").append(elementEntry.getKey()).append("\t").append(elementEntry.getValue());
                }

                System.out.println(output);
            }
        }
    }
}


