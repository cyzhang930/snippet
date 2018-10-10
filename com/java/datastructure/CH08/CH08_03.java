package com.java.datastructure.CH08;

public class CH08_03 {

    public static void main(String[] args) {
        int[] data = {9, 7, 5, 3, 4, 6};
        
        System.out.println("Original data:");
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] +  " ");
        }
        System.out.println();
        int temp;
        for (int i = 0; i < data.length - 1; i++) {
            for (int j = i + 1; j < data.length; j++) {
                if (data[i] > data[j]) {
                    temp = data[i];
                    data[i] =  data[j];
                    data[j] = temp;
                }
            }
            System.out.print("The " + (i + 1) + "th sort result:");
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
