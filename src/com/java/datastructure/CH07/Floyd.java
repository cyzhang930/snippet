package com.java.datastructure.CH07;

public class Floyd extends Adjacency {
    private static final int INIT_VALUE = 0;
    private int[][] cost;
    private int capcity;

    public Floyd(int[][] weightPath, int number) {
        super(weightPath, number);
        cost = new int[number][];
        capcity = graphMatrix.length;
        for (int i = 0; i < capcity; i++) {
            cost[i] = new int[number];
        }
    }

    public void shortestPath() {
        for (int i = 1; i < capcity; i++) {
            for (int j = 1; j < capcity; j++) {
                if (cost[i][j] == INIT_VALUE) {
                    cost[i][j] = graphMatrix[i][j];
                    cost[j][i] = graphMatrix[i][j];
                }
            }
        }
        for (int i = 1; i < capcity; i++) {
            for (int j = 1; j < capcity; j++) {
                System.out.println(i + "," + j + ":" + cost[i][j]);
            }
        }

        for (int k = 1; k < capcity; k++) {
            for (int i = 1; i < capcity; i++) {
                for (int j = 1; j < capcity; j++) {
                    if (cost[i][k] + cost[k][j] < cost[i][j]) {
                        cost[i][j] = cost[i][k] + cost[k][j];
                    }
                }
            }
        }
        System.out.println("Vertix vex1, vex2, vex3, vex4, vex5, vex6");
        for (int i = 1; i < capcity; i++) {
            System.out.print("vex " + i + " ");
            for (int j = 1; j < capcity; j++) {
                if (cost[i][j] < 10) {
                    System.out.print(" ");
                }
                if (cost[i][j] < 100) {
                    System.out.print(" ");
                }
                System.out.print(" " + cost[i][j] + "  ");
            }
            System.out.println();
        }
    }

}
