package com.java.datastructure.CH03;

public class LinkedList {
    private Node first;
    private Node last;

    public boolean isEmpty() {
        return first == null;
    }

    public void print() {
        Node current = first;
        while (current != null) {
            System.out.println("[" + current.getData() + " " + current.getName() + " " + current.getNp() + "]");
            current = current.getNext();
        }
        System.out.println();
    }

    public void insert(int data, String name, int np) {
        Node newNode = new Node(data, name, np);
        if (this.isEmpty()) {
            first = newNode;
            last = newNode;
        } else {
            last.setNext(newNode);
            last = newNode;
        }
    }
    
    public String getNameInNode(Node node) {
        return node.getName();
    }

    public Node getFirst() {
        return first;
    }

    public void setFirst(Node first) {
        this.first = first;
    }

    public Node getLast() {
        return last;
    }

    public void setLast(Node last) {
        this.last = last;
    }

}

class Node {
    private int data;
    private int np;
    private String name;
    private Node next;

    public Node(int data, String name, int np) {
        this.data = data;
        this.name = name;
        this.np = np;
        this.next = null;
    }

    public int getData() {
        return this.data;
    }

    public int getNp() {
        return this.np;
    }

    public String getName() {
        return this.name;
    }

    public Node getNext() {
        return this.next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}