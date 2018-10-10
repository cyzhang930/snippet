package com.java.datastructure.CH08;

public class CH08_01 {

    public static void main(String[] args) {
        int data[] = { 6, 5, 9, 7, 2, 8 };

        System.out.println("Bubble sort:");
        System.out.print("Original data:");
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();

        int tmp;
        for (int i = data.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (data[j] > data[j + 1]) {
                    tmp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = tmp;
                }
            }
            System.out.print("The " + (data.length - i) + "th sort result:");
            for (int k = 0; k < data.length; k++) {
                System.out.print(data[k] + " ");
            }
            System.out.println();
        }

        System.out.print("Ordered data:");
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

}
