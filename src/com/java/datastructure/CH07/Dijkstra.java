package com.java.datastructure.CH07;

public class Dijkstra extends Adjacency {
    private int[] cost;
    private int[] selected;

    public Dijkstra(int[][] weightPath, int number) {
        super(weightPath, number);
        cost = new int[number];
        selected = new int[number];
        for (int i = 0; i < number; i++) {
            selected[i] = 0;
        }
    }

    public void shortestPath(int source) {
        int shortestDistance;
        int shortestVertice = 1;
        for (int i = 1; i < graphMatrix.length; i++) {
            cost[i] = graphMatrix[source][i];
        }
        selected[source] = 1;
        cost[source] = 0;
        for (int i = 1; i < graphMatrix.length - 1; i++) {
            shortestDistance = INFINITE;
            for (int j = 1; j < graphMatrix.length; j++) {
                if (shortestDistance > cost[j] && selected[j] == 0) {
                    shortestVertice = j;
                    shortestDistance = cost[j];
                }
            }
            selected[shortestVertice] = 1;
            for (int j = 1; j < graphMatrix.length; j++) {
                if (selected[j] == 0 && cost[shortestVertice] + graphMatrix[shortestVertice][j] < cost[j]) {
                    cost[j] = cost[shortestVertice] + graphMatrix[shortestVertice][j];
                }
            }
        }
        System.out.println("============");
        System.out.println("Vertice 1 to other vertice, shortest distance:");
        for (int j = 1; j < graphMatrix.length; j++) {
            System.out.println(String.format("1 to %d shortest distance=%d", j, cost[j]));
        }
    }

}
