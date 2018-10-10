package com.java.datastructure.CH07;

public class CH07_08 {

    public static void main(String[] args) {
        int[][] weightPath = { { 1, 2, 10 }, { 2, 3, 20 }, { 2, 4, 25 }, { 3, 5, 18 }, { 4, 5, 22 }, { 4, 6, 95 },
                { 5, 6, 77 } };

        Floyd object = new Floyd(weightPath, 7);
        System.out.println("======");
        System.out.println("The matrix is ");
        object.printGraphMatrix();
        System.out.println("======");
        object.shortestPath();

    }

}
