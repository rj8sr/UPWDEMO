package com.demo.run;

public class ArrayInTwoD {
    public static void main(String[] args) {
        String input = "Combination numberlevel1 level1 id  level2 level2 id  level3 level3 id  level4 level4 id  \n" +
                "1\tcar\t1\t\n" +
                "2\tcar\t1\tchassis\t2\t\n" +
                "3\tcar\t1\tchassis\t2\tdoor\t3\t\n" +
                "4\tcar\t1\tchassis\t2\tdoor\t3\twindow\t4\t\n" +
                "5\tcar\t1\ttyre\t\t5\t\n" +
                "6\tcar\t1\tengine\t6\t\n" +
                "7\tcar\t1\tengine\t6\tnut\t7\t\n" +
                "8\tcar\t1\tengine\t6\tnut\t7\tbolt\t8";

        String[] rows = input.split("\n");
        String[] headers = rows[0].split("\t");

        String[][] output = new String[rows.length - 1][headers.length];
        for (int i = 1; i < rows.length; i++) {
            String[] elements = rows[i].split("\t");
            for (int j = 0; j < elements.length; j++) {
                output[i - 1][j] = elements[j];
            }
        }
    }
}
