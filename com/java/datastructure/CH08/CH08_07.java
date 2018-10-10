package com.java.datastructure.CH08;

public class CH08_07 {

    public static void main(String[] args) {
        int[] data = { 0, 5, 6, 4, 8, 3, 2, 7, 1, 9 };
        int size = data.length;
        System.out.println("Original array:");

        for (int i = 1; i < size; i++) {
            System.out.print("[" + data[i] + "]");
        }
        System.out.println();

        heap(data, size);

        System.out.println("\nOrder result:");
        for (int i = 1; i < size; i++) {
            System.out.print("[" + data[i] + "]");
        }
        System.out.println();
    }

    public static void heap(int data[], int size) {
        for (int i = size / 2; i > 0; i--) {
            ad_heap(data, i, size - 1);
        }
        
        System.out.println("The content of heap tree:");
        for (int i = 1; i < size; i++) {
            System.out.print("[" + data[i] + "]");
        }
        System.out.println();

        for (int i = size - 2; i > 0; i--) {
            int tmp = data[i + 1];
            data[i + 1] = data[1];
            data[1] = tmp;
            System.out.println("\nBefore process:");
            for (int j = 1; j < size; j++) {
                System.out.print("[" + data[j] + "]");
            }
            ad_heap(data, 1, i);
            System.out.println("\nProcess:");
            for (int j = 1; j < size; j++) {
                System.out.print("[" + data[j] + "]");
            }

        }
    }

    public static void ad_heap(int data[], int i, int size) {
        int j = 2 * i;
        int tmp = data[i];
        int post = 0;
        while (j <= size && post == 0) {
            if (j < size) {
             //   if (data[j] < data[j + 1]) {
                if (data[j] > data[j + 1]) {
                    j++;
                }
            }
          //  if (tmp >= data[j]) {
            if (tmp <= data[j]) {
                post = 1;
            } else {
                data[j / 2] = data[j];
                j = 2 * j;
            }
            data[j / 2] = tmp;
        }

    }

}
