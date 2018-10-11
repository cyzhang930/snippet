package com.java.datastructure.CH08;

public class CH08_04 {

    public static void main(String[] args) {
        // int[] data = { 9, 7, 5, 3, 4, 6 };
        int[] data = { 8, 7, 4, 6, 9, 2 };
        System.out.println("Original data:");
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();

        int temp;
        int j;
        for (int i = 1; i < data.length; i++) {
            temp = data[i];
            j = i - 1;
            while (j >= 0 && temp < data[j]) {
                data[j + 1] = data[j];
                j--;
            }
            data[j + 1] = temp;
            System.out.println("The " + i + "th scan:");
            for (int k = 0; k < data.length; k++) {
                System.out.print(data[k] + " ");
            }
            System.out.println();
        }
        System.out.println("Ordered data:");
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

}
