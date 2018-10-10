package com.java.datastructure.CH06;

public class CH06_04 {

    public static void main(String[] args) {
        char[] information1 = { ' ', '+', '*', '%', '6', '3', '9', '5' };
        char[] information2 = { ' ', '+', '+', '+', '*', '%', '/', '*', '1', '2', '3', '2', '6', '3', '2', '2' };
        ExpressionTree exp1 = new ExpressionTree(information1, 1);
        System.out.println("== Binary expression tree example 1: ==");
        System.out.println("=======================================");
        System.out.println("== Transfer to inOrder ==");
        exp1.inOrder(exp1.rootNode);
        System.out.println();
        System.out.println("== Transfer to preOrder ==");
        exp1.preOrder(exp1.rootNode);
        System.out.println();
        System.out.println("== Transfer to postOrder ==");
        exp1.postOrder(exp1.rootNode);
        System.out.println();
        System.out.print("After calculate, result is:");
        System.out.println(exp1.answer(exp1.rootNode));
        ExpressionTree exp2 = new ExpressionTree(information2, 1);
        System.out.println("== Binary expression tree example 2: ==");
        System.out.println("=======================================");
        System.out.println("== Transfer to inOrder ==");
        exp2.inOrder(exp2.rootNode);
        System.out.println();
        System.out.println("== Transfer to preOrder ==");
        exp2.preOrder(exp2.rootNode);
        System.out.println();
        System.out.println("== Transfer to postOrder ==");
        exp2.postOrder(exp2.rootNode);
        System.out.println();
        System.out.print("After calculate, result is:");
        System.out.println(exp2.answer(exp2.rootNode));
    }

}
