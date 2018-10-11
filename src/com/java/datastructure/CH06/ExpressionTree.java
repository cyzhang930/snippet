package com.java.datastructure.CH06;

public class ExpressionTree extends BinarySearchTree {
    public ExpressionTree(char[] information, int index) {
        this.rootNode = create(information, index);
    }

    public TreeNode create(char[] information, int index) {
        TreeNode newNode = null;
        if (index < information.length) {
            newNode = new TreeNode((int)information[index]);
            newNode.leftNode = create(information, index * 2);
            newNode.rightNode = create(information, index * 2 + 1);
        }

        return newNode;
    }

    public void preOrder(TreeNode node) {
        if (node != null) {
            System.out.print((char) node.getValue() + "\t");
            preOrder(node.leftNode);
            preOrder(node.rightNode);
        }
    }

    public void inOrder(TreeNode node) {
        if (node != null) {
            inOrder(node.leftNode);
            System.out.print((char) node.getValue() + "\t");
            inOrder(node.rightNode);
        }
    }

    public void postOrder(TreeNode node) {
        if (node != null) {
            postOrder(node.leftNode);
            postOrder(node.rightNode);
            System.out.print((char) node.getValue() + "\t");
        }
    }

    public int condition(char operator, int num1, int num2) {
        int result = -12345;
        switch (operator) {
        case '*':
            result = (num1 * num2);
            break;
        case '/':
            result = (num1 / num2);
            break;
        case '+':
            result = (num1 + num2);
            break;
        case '-':
            result = (num1 - num2);
            break;
        case '%':
            result = (num1 % num2);
            break;
        default:
            break;
        }
        return result;
    }
    
    public int answer(TreeNode node) {
        int firstNumber = 0;
        int secondNumber = 0;
        if (node.leftNode == null && node.rightNode == null) {
            return Character.getNumericValue((char) node.getValue());
        } else {
            firstNumber = answer(node.leftNode);
            secondNumber = answer(node.rightNode);
            return condition((char) node.getValue(), firstNumber, secondNumber);
        }
    }
}
