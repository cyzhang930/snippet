package com.java.datastructure.CH06;

public class CH06_07 {

    public static void main(String[] args) throws Exception {
        int[] data1 = {0,10,20,30,100,399,453,43,237,373,655};
//        ThreadedBinaryTree tree1 = new ThreadedBinaryTree();
//        ThreadNode node= tree1.createBinaryTree(data1, 0);
//        tree1.inThreadOrder(node);
//        System.out.println("Example 1:");
//        tree1.inThreadList(node);
//        System.out.println();
        
      ThreadedBinaryTree tree2 = new ThreadedBinaryTree(data1);
      tree2.inThreadOrder(tree2.rootNode);
      System.out.println("Example 1:");
      tree2.inThreadList(tree2.rootNode);
      System.out.println();
        
//        ThreadNode node= tree1.createBinaryTree(data1, 0);
//        tree1.preThreadOrder(node);
//        System.out.println("Example 1:");
//        tree1.preThreadList(node);
//        System.out.println();
        
//        ThreadedBinaryTree tree2 = new ThreadedBinaryTree(data1);
//        tree2.preThreadOrder(tree2.rootNode);
//        System.out.println("Example 1:");
//        tree2.preThreadList(tree2.rootNode);
//        System.out.println();

    }

}
