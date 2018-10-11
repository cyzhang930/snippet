package com.java.datastructure.CH09;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CH09_01 {

    public static void main(String[] args) throws Exception {
        BufferedReader keyIn = new BufferedReader(new InputStreamReader(System.in));
        int[] data = new int[100];
        for (int i = 0; i < 80; i++) {
            data[i] = ((int) (Math.random() * 150)) % 150 + 1;
        }
        int val = 0;
        while (val != -1) {
            int find = 0;
            System.out.println("Please input the key to search, -1 to leave:");
            val = Integer.parseInt(keyIn.readLine());
            for (int i = 0; i < 80; i++) {
                if (data[i] ==  val) {
                    System.out.println("Find: index is " + (i + 1) + ", value is " + val);
                    find++;
                }
            }
            if (find == 0 && val != -1) {
                System.out.println("Cannot find value " + val);
            }
        }
        System.out.println("Data content:");
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print((i * 8 + j + 1) + "[" + data[i * 8 + j] + "]");
            }
            System.out.println();
        }
    }

}
