package com.demo.run;

import java.util.ArrayList;
import java.util.List;

 class AlignElement {
    public static void main(String[] args) {
        List<String[]> inputList = new ArrayList<>();
        inputList.add(new String[] {"1", "car", "1"});
        inputList.add(new String[] {"2", "car", "1", "chassis", "2"});
        inputList.add(new String[] {"3", "car", "1", "chassis", "2", "door", "3"});
        inputList.add(new String[] {"4", "car", "1", "chassis", "2", "door", "3", "window", "4"});
        inputList.add(new String[] {"5", "car", "1", "tyre", "5"});
        inputList.add(new String[] {"6", "car", "1", "engine", "6"});
        inputList.add(new String[] {"7", "car", "1", "engine", "6", "nut", "7"});
        inputList.add(new String[] {"8", "car", "1", "engine", "6", "nut", "7", "bolt", "8"});

        List<String[]> alignedList = alignElements(inputList);
        for (String[] row : alignedList) {
            for (String value : row) {
                System.out.print(value + "\t");
            }
            System.out.println();
        }
    }

    private static List<String[]> alignElements(List<String[]> inputList) {
        List<String[]> result = new ArrayList<>();

        int maxLength = 0;
        for (String[] row : inputList) {
            maxLength = Math.max(maxLength, row.length);
        }

        for (String[] row : inputList) {
            String[] newRow = new String[maxLength];
            System.arraycopy(row, 0, newRow, 0, row.length);
            for (int i = row.length; i < maxLength; i++) {
                newRow[i] = "";
            }
            result.add(newRow);
        }

        return result;
    }
}

