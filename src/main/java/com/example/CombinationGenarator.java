package com.example;

class CombinationGenerator {
    public static void main(String[] args) {

        String[][] values = {
                {"car", "1"},
                {"car", "1", "chassis", "2"},
                {"car", "1", "chassis", "2", "door", "3"},
                {"car", "1", "chassis", "2", "door", "3", "window", "4"},
                {"car", "1", "tyre", "5"},
                {"car", "1", "seat", "6"}
        };

        // iterate over the array and print the desired output
        for (int i = 0; i < values.length; i++) {
            System.out.print(values[i][0] + " " + values[i][1] + " ");
            for (int j = 2; j < values[i].length; j += 2) {
                for (int k = 0; k <= i; k++) {
                    if (values[i][j].equals(values[k][j]) && values[i][j + 1].equals(values[k][j + 1])) {
                        System.out.print(values[k][j] + " " + values[k][j + 1] + " ");
                        break;
                    }
                }
            }
            System.out.println();
        }
    }
}






