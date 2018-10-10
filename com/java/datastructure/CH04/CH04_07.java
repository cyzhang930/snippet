package com.java.datastructure.CH04;

import java.io.DataInputStream;
import java.io.IOException;

public class CH04_07 {
    static int MAX = 50;
    static char[] infixQ = new char[MAX];

    public static void main(String[] args) {
        for (int i = 0; i < MAX; i++) {
            infixQ[i] = '\0';
        }
        System.out.println("\t ============================================ \t");
        System.out.println("\t This program will transform infix to postfix \t");
        System.out.println("\t Pleaase input the infix expression \t");
        System.out.println("\t For example: (9+3)*8+7*6-12/4");
        System.out.println("\t Allowed operator:^, *, +, -, /, (, ) ......");
        System.out.println("\t ============================================ \t");
        System.out.println("\t Please start to input your expression:");
        infixToPostfix();
        System.out.println();
        System.out.println("\t ============================================ \t");
    }

    public static int compare(char oStack, char oInfix) {
        char[] infixPriority = { 'q', ')', '+', '-', '*', '/', '^', ' ', '(' };
        char[] stackPriority = { 'q', '(', '+', '-', '*', '/', '^', ' ' };

        int sIndex = 0;
        int iIndex = 0;
        while (sIndex < 8 && stackPriority[sIndex] != oStack) {
            sIndex++;
        }
        while (iIndex < 9 && infixPriority[iIndex] != oInfix) {
            iIndex++;
        }
        return ((int) (sIndex / 2)) >= ((int) (iIndex / 2)) ? 1 : 0;
    }

    public static void infixToPostfix() {
        DataInputStream input = new DataInputStream(System.in);
        char[] tStack = new char[MAX];

        for (int i = 0; i < MAX; i++) {
            tStack[i] = '\0';
        }
        int rear = 0;
        while (infixQ[rear] != '\n') {
            System.out.flush();
            try {
                infixQ[++rear] = (char) System.in.read();
            } catch (IOException e) {
                System.err.println(e);
            }
        }

        infixQ[rear] = 'q';
        System.out.println("\t The postfix method: ");
        int top = 0;
        tStack[top] = 'q';

        for (int flag = 0; flag <= rear; flag++) {
            switch (infixQ[flag]) {
            case ')':
                while (tStack[top] != '(') {
                    System.out.print(tStack[top--]);
                }
                top--;
                break;
            case 'q':
                while (tStack[top] != 'q') {
                    System.out.print(tStack[top--]);
                }
                break;
            case '(':
            case '^':
            case '*':
            case '/':
            case '+':
            case '-':
                while (compare(tStack[top], infixQ[flag]) == 1) {
                    System.out.print(tStack[top--]);
                }
                tStack[++top] = infixQ[flag];
                break;
            default:
                System.out.print(infixQ[flag]);
                break;
            }
        }
    }

}
