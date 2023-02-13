package com.demo.run;

import java.util.ArrayList;
import java.util.List;

 class AlignElements {
    public static void main(String[] args) {
        String[][] input = {
                {"1", "car", "1", ""},
                {"2", "car", "1", "chassis", "2", ""},
                {"3", "car", "1", "chassis", "2", "door", "3", ""},
                {"4", "car", "1", "chassis", "2", "door", "3", "window", "4", ""},
                {"5", "car", "1", "tyre", "5", ""},
                {"6", "car", "1", "engine", "6", ""},
                {"7", "car", "1", "engine", "6", "nut", "7", ""},
                {"8", "car", "1", "engine", "6", "nut", "7", "bolt", "8", ""},
        };

        String[] headers = {"Combination number", "level1", "level1 id", "level2", "level2 id", "level3", "level3 id", "level4", "level4 id"};

        List<String[]> output = new ArrayList<>();
        output.add(headers);

        for (String[] row : input) {
            String[] newRow = new String[headers.length];
            newRow[0] = row[0];
            newRow[1] = row[1];
            newRow[2] = row[2];
            int index = 3;
            for (int i = 3; i < row.length; i += 2) {
                if (!row[i].isEmpty()) {
                    newRow[index++] = row[i];
                    newRow[index++] = row[i + 1];
                }
            }
            output.add(newRow);
        }

        int[] columnWidths = new int[headers.length];
        for (int i = 0; i < headers.length; i++) {
            int maxLength = headers[i].length();
            for (String[] row : output) {
                maxLength = Math.max(maxLength, row[i].length());
            }
            columnWidths[i] = maxLength;
        }

        for (String[] row : output) {
            for (int i = 0; i < headers.length; i++) {
                System.out.printf("%-" + (columnWidths[i] + 2) + "s", row[i]);
            }
            System.out.println();
        }
    }
}
