package com.java.datastructure.CH06;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CH06_02 {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int data[] = new int[10];
        System.out.println("Please insert 10 numbers:");
        for (int i = 0; i < 10; i++) {
            data[i] = Integer.parseInt(reader.readLine());
        }
        new BinaryTree(data);
        System.out.println("Done");
    }

}
