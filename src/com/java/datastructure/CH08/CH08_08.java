package com.java.datastructure.CH08;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class CH08_08 {

    public static void main(String[] args) throws Exception {
        int size;
        int[] data = new int[100];
        System.out.println("please input the size of array[<=100]:");
        try (InputStreamReader isr = new InputStreamReader(System.in); BufferedReader br = new BufferedReader(isr);) {
            size = Integer.parseInt(br.readLine());
        }
        inputArr(data, size);
        System.out.println("Original array is:");
        showData(data, size);
        radix(data, size);
    }

    private static void inputArr(int[] data, int size) throws Exception {
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            data[i] = (Math.abs(random.nextInt(999))) + 1;
        }
    }

    private static void showData(int[] data, int size) {
        for (int i = 0; i < size; i++) {
            System.out.print("[" + data[i] + "]");
        }
        System.out.println();
    }

    private static void radix(int[] data, int size) {
        for (int n = 1; n <= 100; n = n * 10) {
            int[][] tmp = new int[10][100];
            for (int i = 0; i < size; i++) {
                int m = (data[i] / n) % 10;
                tmp[m][i] = data[i];
            }
            int k = 0;
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < size; j++) {
                    if (tmp[i][j] != 0) {
                        data[k] = tmp[i][j];
                        k++;
                    }
                }
            }
            System.out.println("After " + n + " time order:");
            showData(data, size);
        }
    }

}
