package com.java.datastructure.CH06;

public class CH06_03 {

    public static void main(String[] args) throws Exception {
        int data[] = {7,4,1,5,16,8,11,12,15,9,2};
        System.out.println("Original array content:");
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + "\t");
        }
        System.out.println();
        BinaryTreeWithOrder tree = new BinaryTreeWithOrder(data);
        System.out.println("InOrder:");
        tree.inOrder(tree.rootNode);
        System.out.println();
        System.out.println("PreOrder:");
        tree.preOrder(tree.rootNode);
        System.out.println();
        System.out.println("PostOrder:");
        tree.postOrder(tree.rootNode);
        System.out.println();
        System.out.println("Done");
    }

}

class BinaryTreeWithOrder {
    public TreeNodeWithOrder rootNode;

    public BinaryTreeWithOrder(int[] data) {
        for (int i = 0; i < data.length; i++) {
            addNodeToTree(data[i]);
        }
    }

    public void addNodeToTree(int value) {
        TreeNodeWithOrder newNode = new TreeNodeWithOrder(value);
        if (rootNode == null) {
            rootNode = newNode;
        } else {
            TreeNodeWithOrder currentNode = rootNode;
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

    public void inOrder(TreeNodeWithOrder node) {
        if (node != null) {
            inOrder(node.leftNode);
            System.out.print("[" + node.getValue() + "]\t");
            inOrder(node.rightNode);
        }
    }
    
    public void preOrder(TreeNodeWithOrder node) {
        if (node != null) {
            System.out.print("[" + node.getValue() + "]\t");
            preOrder(node.leftNode);
            preOrder(node.rightNode);
        }
    }
    
    public void postOrder(TreeNodeWithOrder node) {
        if (node != null) {
            postOrder(node.leftNode);
            postOrder(node.rightNode);
            System.out.print("[" + node.getValue() + "]\t");
        }
    }
}

class TreeNodeWithOrder {
    private int value;
    TreeNodeWithOrder leftNode;
    TreeNodeWithOrder rightNode;

    public TreeNodeWithOrder(int value) {
        this.value = value;
        this.leftNode = null;
        this.rightNode = null;
    }

    public int getValue() {
        return this.value;
    }
}