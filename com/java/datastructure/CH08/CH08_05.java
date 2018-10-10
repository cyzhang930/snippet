package com.java.datastructure.CH08;

public class CH08_05 {

    public static void main(String[] args) {
        int[] data = {6, 9, 2, 3, 4, 7, 5, 1};
        System.out.println("Original data:");
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
        
        int jump = data.length / 2;
        int temp;
        int index = 1;
        while (jump != 0) {
            for (int i = jump; i < data.length; i++) {
                temp = data[i];
                int j = i - jump;
                while (j >= 0 && temp < data[j]) {
                    data[i] = data[j];
                    j = j - jump;
                }
                data[jump + j] = temp;
            }
            System.out.println("The " + index++ + "th scan:");
            for (int k = 0; k < data.length; k++) {
                System.out.print(data[k] + " ");
            }
            System.out.println();
            jump = jump / 2;
        }
        
    }

}
