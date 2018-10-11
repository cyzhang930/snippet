package com.java.datastructure.CH06;

public class BinarySearchTree {
    TreeNode rootNode;
    
    public BinarySearchTree() {
        this.rootNode = null;
    }
    
    public BinarySearchTree(int[] data) {
        for (int i = 0; i < data.length; i++) {
            addNodeToTree(data[i]);
        }
    }
    
    public void addNodeToTree(int data) {
        TreeNode newNode = new TreeNode(data);
        if (this.rootNode == null) {
            this.rootNode = newNode;
        } else {
            TreeNode currentNode = this.rootNode;
            while (true) {
                if (data < currentNode.getValue()) {
                    if (currentNode.leftNode == null) {
                        currentNode.leftNode = newNode;
                        break;
                    } else {
                        currentNode = currentNode.leftNode;
                    }
                } else {
                    if (currentNode.rightNode == null) {
                        currentNode.rightNode = newNode;
                        break;
                    } else {
                        currentNode = currentNode.rightNode;
                    }
                }
            }
            
        }
    }
    
}
