package com.java.datastructure.CH07;

public class CH07_03 {

    public static void main(String[] args) {
        int[][] data = { { 1, 2 }, { 2, 1 }, { 1, 5 }, { 5, 1 }, { 2, 3 }, { 3, 2 }, { 2, 4 }, { 4, 2 }, { 3, 4 },
                { 4, 3 }, { 3, 5 }, { 5, 3 }, { 4, 5 }, { 5, 4 } };
        
        GraphLink[] links = new GraphLink[6];
        for (int i = 0; i < 6; i++) {
            links[i] = new GraphLink();
            System.out.print("Point:" + i + "=>");
            for (int j = 0; j < 14; j++) {
                if (data[j][0] == i) {
                    links[i].insert(data[j][1]);
                }
            }
            links[i].print();
            System.out.println();
        }

    }

}
