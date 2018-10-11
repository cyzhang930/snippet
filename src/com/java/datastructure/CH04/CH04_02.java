package com.java.datastructure.CH04;

public class CH04_02 {
    private static int top = -1;

    public static void main(String[] args) {
        int[] card = new int[52];
        int[] stack = new int[52];
        char ascVal = 'H';
        int style;
        for (int i = 0; i < 52; i++) {
            card[i] = i;
        }
        System.out.println("Shuffling...");

        int k = 0;
        while (k < 30) {
            for (int i = 0; i < 51; i++) {
                for (int j = i + 1; j < 52; j++) {
                    if (((int) (Math.random() * 5)) == 2) {
                        int tmp = card[i];
                        card[i] = card[j];
                        card[j] = tmp;
                    }
                }
            }
            k++;
        }
        int i = 0;
        while (i < 52) {
            push(stack, 52, card[i]);
            i++;
        }
        
        System.out.println("Sending...");
        while (top >= 0) {
            style = stack[top] / 13;
            switch (style) {
            case 0:
                ascVal = 'C';
                break;
            case 1:
                ascVal = 'D';
                break;
            case 2:
                ascVal = 'H';
                break;
            case 3:
                ascVal = 'S';
                break;
            default:
                break;
            }
            System.out.print("[" + ascVal + (pop(stack) % 13 + 1) + "]");
            System.out.print("\t");
            if ((top + 1) % 4 == 0) {
                System.out.println();
            }
        }
    }

    public static void push(int[] stack, int length, int value) {
        if (top + 1 >= length) {
            System.out.println("Stack is full");
        } else {
            stack[++top] = value;
        }
    }

    public static int pop(int[] stack) {
        if (top < 0) {
            System.out.println("Stack is empty");
        } else {
            return stack[top--];
        }
        return -1;
    }

}
