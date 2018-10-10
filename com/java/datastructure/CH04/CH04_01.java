package com.java.datastructure.CH04;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CH04_01 {

    public static void main(String[] args) throws Exception {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StackByArray stack = new StackByArray(10);
        System.out.println("Please type 10 input numbers:");
        for (int i = 0; i < 11; i++) {
            int valule = Integer.parseInt(buf.readLine());
            stack.push(valule);
        }
        System.out.println("Start to pop numbers:");
        while (!stack.isEmpty()) {
            System.out.println("Pop:" + stack.pop());
        }

    }

}

class StackByArray {
    private int[] stack;

    private int top;

    public StackByArray(int stackSize) {
        this.stack = new int[stackSize];
        this.top = -1;
    }

    public boolean isEmpty() {
        return top < 0;
    }

    public boolean isFull() {
        return top + 1 >= stack.length;
    }

    public boolean push(int data) {
        if (!isFull()) {
            stack[++top] = data;
            return true;
        }
        return false;

    }

    public int pop() {
        if (!isEmpty()) {
            return stack[top--];
        }
        return -1;
    }
}
