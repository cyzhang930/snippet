package com.java.datastructure.CH07;

public class GraphLink {
    public Node first;
    public Node last;

    public boolean isEmpty() {
        return this.first == null;
    }
    
    public void print() {
        Node current = this.first;
        while (current != null) {
            System.out.print(current.x + "\t");
            current = current.next;
        }
    }
    
    public void insert(int x) {
        Node newNode = new Node(x);
        Node current = this.first;
        if (current == null) {
            this.first = newNode;
            this.last = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }
    }
}
