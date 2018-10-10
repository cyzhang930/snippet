package com.java.datastructure.CH02;

public class CH02_08 {

    public static void main(String[] args) {
        int[] polyA = { 4, 3, 7, 0, 6, 2 };
        int[] polyB = { 4, 1, 5, 2, 0, 9 };

        System.out.println("Print polyA:");
        for (int i = 0; i < polyA.length; i++) {
            System.out.print(polyA[i] + "\t");
        }
        System.out.println();
        System.out.println("Print polyB:");
        for (int i = 0; i < polyB.length; i++) {
            System.out.print(polyB[i] + "\t");
        }
        System.out.println();
        sum(polyA, polyB);
    }

    private static void sum(int[] polyA, int[] polyB) {
        int ratioA = polyA[0];
        int ratioB = polyB[0];

        if (ratioA >= ratioB) {
            int[] polyC = new int[ratioA + 2];
            polyC[0] = ratioA + 1;
            int j = ratioB + 1;
            for (int i = ratioA + 1; i >= 0; i--) {
                System.out.println("temp:" + i + "," + j);
                if (j > 0) {
                    polyC[i] = polyA[i] + polyB[j--];
                } else {
                    polyC[i] = polyA[i];
                }
            }
            for (int i = 0; i < polyC.length; i++) {
                System.out.print(polyC[i] + "\t");
            }
        }

    }

}
