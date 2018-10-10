package com.java.datastructure.CH06;

public class BinaryTree {
    public TreeNode rootNode;
    public static int count = 1;

    public BinaryTree() {
        this.rootNode = null;
    }

    public BinaryTree(int[] data) {
        for (int i = 0; i < data.length; i++) {
            addNodeToTree(data[i]);
        }
    }

    public void addNodeToTree(int value) {
        TreeNode newNode = new TreeNode(value);
        if (rootNode == null) {
            rootNode = newNode;
        } else {
            TreeNode currentNode = rootNode;
            while (true) {
                if (newNode.getValue() < currentNode.getValue()) {
                    if (currentNode.leftNode != null) {
                        currentNode = currentNode.leftNode;
                    } else {
                        currentNode.leftNode = newNode;
                        break;
                    }
                } else {
                    if (currentNode.rightNode != null) {
                        currentNode = currentNode.rightNode;
                    } else {
                        currentNode.rightNode = newNode;
                        break;
                    }
                }
            }
        }
    }

    public void preOrder(TreeNode node) {
        if (node != null) {
            System.out.print(node.getValue() + "\t");
            preOrder(node.leftNode);
            preOrder(node.rightNode);
        }
    }

    public void inOrder(TreeNode node) {
        if (node != null) {
            inOrder(node.leftNode);
            System.out.print(node.getValue() + "\t");
            inOrder(node.rightNode);
        }
    }

    public void postOrder(TreeNode node) {
        if (node != null) {
            postOrder(node.leftNode);
            postOrder(node.rightNode);
            System.out.print(node.getValue() + "\t");
        }
    }
    
    public boolean findTree(TreeNode node, int value) {
        boolean result = false;
        if (node != null) {
            if (node.getValue() == value) {
                System.out.println("Search " + count + " times");
                result = true;
            } else if (value < node.getValue()){
                count += 1;
                result = findTree(node.leftNode, value);
            } else {
                count += 1;
                result = findTree(node.rightNode, value);
            }
            
        }
        return result;
    }
}
