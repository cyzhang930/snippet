package com.java.datastructure.CH04;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CH04_04 {

    public static void main(String[] args) throws Exception {
        BufferedReader keyIn = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please input plate's number:");
        int plateNum = Integer.parseInt(keyIn.readLine());
        movePlate(plateNum, 1, 2, 3);
    }

    public static void movePlate(int plateNum, int p1, int p2, int p3) {
        if (plateNum == 1) {
            System.out.println("Move from " + p1 + " to " + p3);
        } else {
            movePlate(plateNum -1, p1, p3, p2);
            System.out.println("Move from " + p1 + " to " + p3);
            movePlate(plateNum -1, p2, p1, p3);
        }
    }
}
