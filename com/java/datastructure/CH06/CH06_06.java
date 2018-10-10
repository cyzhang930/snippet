package com.java.datastructure.CH06;

import java.io.*;

public class CH06_06 {

    public static void main(String[] args) throws Exception {
        int[] arr = { 7, 4, 1, 5, 13, 8, 16, 11, 12, 15, 9, 2 };
        System.out.println("Original data is:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println();
        BinaryTree tree = new BinaryTree(arr);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please input the value you needed:");
        int value = Integer.parseInt(reader.readLine());
        if (tree.findTree(tree.rootNode, value)) {
            System.out.println("Required value :" + value + " is found");
        } else {
            System.out.println("Sorry, " + value + " is not found");
        }
    }

}
