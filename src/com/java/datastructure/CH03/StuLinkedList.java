package com.java.datastructure.CH03;

public class StuLinkedList {
    public StuNode first;
    public StuNode last;

    public boolean isEmpty() {
        return first == null;
    }

    public void print() {
        StuNode current = first;
        while (current != null) {
            System.out.println("[" + current.getData() + " " + current.getNames() + " " + current.getNp() + "]");
            current = current.getNext();
        }
        System.out.println();
    }
    
    public void insert(int data, String names, int np) {
        StuNode newNode = new StuNode(data, names, np);
        if (this.isEmpty()) {
            first = newNode;
            last = newNode;
        } else {
            last.setNext(newNode);
            last = newNode;
        }
    }
    
    public void delete(StuNode delNode) {
        StuNode newNode;
        StuNode tmp;
        if (delNode.getData() == first.getData()) {
            first = first.getNext();
        } else if (delNode.getData() == last.getData()) {
            newNode = first;
            while (newNode.getNext() != last) {
                newNode = newNode.getNext();
            }
            newNode.setNext(last.getNext());// set null
            last = newNode;
        } else {
            newNode = first;
            tmp = first;
            while (newNode.getData() != delNode.getData()) {
                tmp = newNode;
                newNode = newNode.getNext();
            }
            tmp.setNext(delNode.getNext());
        }
        
    }
}

class StuNode {
    private int data;
    private int np;
    private String names;
    private StuNode next;

    public StuNode(int data, String names, int np) {
        this.data = data;
        this.names = names;
        this.np = np;
        this.next = null;
    }

    public int getData() {
        return this.data;
    }

    public int getNp() {
        return this.np;
    }

    public String getNames() {
        return this.names;
    }

    public StuNode getNext() {
        return this.next;
    }

    public void setNext(StuNode next) {
        this.next = next;
    }
}
