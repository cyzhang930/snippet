package com.java.datastructure.CH06;

import java.io.*;

public class CH06_05 {

    public static void main(String[] args) throws Exception {
        BinaryTree tree = new BinaryTree();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please input data, enter -1 if you want to end the input");
        while (true) {
            int value = Integer.parseInt(reader.readLine());
            if (value == -1) {
                break;
            } else {
                tree.addNodeToTree(value);
            }
        }
        System.out.println("Data in order:");
        tree.inOrder(tree.rootNode);
        System.out.println();
    }

}
