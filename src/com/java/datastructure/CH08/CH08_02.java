package com.java.datastructure.CH08;

public class CH08_02 {

    public static void main(String[] args) {
        int data[] = new int[] {4, 6, 2, 7, 8, 9};
        
        System.out.println("Original data:");
        for (int i = 0 ; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
        bubble(data);

    }

    private static void bubble(int[] data) {
        int tmp;
        for (int i = data.length - 1; i >= 0; i--) {
            int flag = 0;
            for (int j = 0; j < i; j++) {
                if (data[j + 1 ] < data[j]) {
                    tmp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = tmp;
                    flag++;
                }
            }
            if (flag == 0) {
                break;
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
