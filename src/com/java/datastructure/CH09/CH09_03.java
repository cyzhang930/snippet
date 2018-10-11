package com.java.datastructure.CH09;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CH09_03 {

    public static void main(String[] args) throws Exception {
        BufferedReader keyIn = new BufferedReader(new InputStreamReader(System.in));
        int[] data = new int[50];
        int val = 1;
        for (int i = 0; i < 50; i++) {
            data[i] = val;
            val += (int) (Math.random() * 100) % 5 + 1;
        }
        while (val != -1) {
            int find = 0;
            System.out.println("Please input the key to search, -1 to leave:");
            val = Integer.parseInt(keyIn.readLine());
            if (val == -1) {
                break;
            }
            find = interpolation(data, val);
            if (find == -1) {
                System.out.println("Cannot find value " + val);
            } else {
                System.out.println("Find value " + val + ", index " + (find + 1));
            }
        }
        System.out.println("Data content:");
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print((i * 5 + j + 1) + "[" + data[i * 5 + j] + "]");
            }
            System.out.println();
        }
    }

    private static int interpolation(int[] data, int target) {
        int find = 0;
        int start = 0;
        int end = data.length - 1;
        int targetIndex = 0;
        int tmp = 0;
        while (start <= end && find == 0 && target != -1) {
            tmp = (int) ((float)(target - data[start]) / (data[end] - data[start]) * (end - start));
            int medium = start + tmp;
            if (medium > 50 || medium < -1) {
                return -1;
            }
            if (target < data[start] || target > data[end]) {
                return -1;
            } else if (target > data[start] && target > data[end]){
                return -1;
            }
            if (target < data[medium]) {
                System.out.println("left of " + medium);
                end = medium - 1;
            } else if (target > data[medium]) {
                System.out.println("right of " + medium);
                start = medium + 1;
            } else {
                targetIndex = medium;
                find = 1;
            }
        }
        if (find == 1) {
            return targetIndex;
        } else {
            return -1;
        }
    }

}
