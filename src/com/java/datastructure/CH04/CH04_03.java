package com.java.datastructure.CH04;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CH04_03 {

    public static void main(String[] args) throws Exception {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StackByLink stackByLink = new StackByLink();
        int choice = 0;
        while (true) {
            System.out.println("(0) end (1) push (2) pop :");
            choice = Integer.parseInt(buf.readLine());
            if (choice == 2) {
                stackByLink.pop();
            } else if (choice == 1) {
                System.out.println("Please input data to push:");
                int data = Integer.parseInt(buf.readLine());
                stackByLink.push(data);
                stackByLink.printStack();
            } else if (choice == 0) {
                break;
            } else {
                System.out.println("Wrong input!");
            }
        }

    }

}

class StackByLink {
    Node first;
    Node last;

    public boolean isEmpty() {
        return first == null;
    }

    public void printStack() {
        Node current = first;
        while (current != null) {
            System.out.println("[" + current.getData() + "]");
            current = current.getNext();
        }
    }

    public void push(int data) {
        Node newNode = new Node(data);
        System.out.println("Push:" + data);
        if (isEmpty()) {
            first = newNode;
            last = newNode;
        } else {
            last.setNext(newNode);
            last = newNode;
        }
    }

    public void pop() {
        if (isEmpty()) {
            System.out.println("The stack is empty.");
        } else {
            Node tmp = first;
            Node lTmp = null;
            while (tmp.getNext() != null) {
                lTmp = tmp;
                tmp = tmp.getNext();
            }
            last = lTmp;
            System.out.println("Pop:" + tmp.getData());
            if (last == null) {
                first = null;
                System.out.println("Pop all data");
            }
        }
    }
}

class Node {
    private int data;
    private Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }

    public int getData() {
        return data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

}
