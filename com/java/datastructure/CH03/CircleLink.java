package com.java.datastructure.CH03;

public class CircleLink {
    public CircularNode first;
    public CircularNode last;
    
    public boolean isEmpty() {
        return first == null;
    }
    
    public void print() {
        CircularNode current = first;
        while (current != last) {
            System.out.print("[" + current.getData() + "]");
            current = current.getNext();
        }
        System.out.print("[" + current.getData() + "]");
        System.out.println();
    }
    
    public void insert(CircularNode trp) {
        CircularNode tmp;
        CircularNode newNode;
        
        if (this.isEmpty()) {
            this.first = trp;
            this.last = trp;
            this.last.setNext(trp);
        } else if (trp.getNext() == null) {
            this.last.setNext(trp);
            this.last = trp;
            this.last.setNext(this.first);
        } else {
            newNode = first;
            tmp = first;
            while (newNode.getNext() != trp.getNext()) {
                if (tmp.getNext() == first) {
                    break;
                }
                tmp = newNode;
                newNode = newNode.getNext();
            }
            tmp.setNext(trp);
            trp.setNext(newNode);
        }
    }
    
    public void delete(CircularNode delNode) {
        CircularNode newNode;
        CircularNode tmp;
        if (this.isEmpty()) {
            System.out.println("Can't delete any element, since the circular list is empty");
            return;
        }
        if (delNode.getData() == this.first.getData()) {
            this.first = this.first.getNext();
           
            if (this.first == null) {
                System.out.println("The circular list is empty now");
                return;
            }
            this.last.setNext(this.first);
        } else if (delNode.getData() == this.last.getData()) {
            newNode = this.first;
            while (newNode.getNext() != this.last) {
                newNode = newNode.getNext();
            }
            newNode.setNext(this.last.getNext());
            this.last = newNode;
            this.last.setNext(this.first);
        } else {
            newNode = this.first;
            tmp = this.first;
            while (newNode.getData() != delNode.getData()) {
                tmp = newNode;
                newNode = newNode.getNext();
            }
            tmp.setNext(newNode.getNext());
        }
    }
    
}


class CircularNode {
    private int data;
    private CircularNode next;
    
    public CircularNode(int data) {
        this.data = data;
        this.next = null;
    }

    public int getData() {
        return data;
    }

    public CircularNode getNext() {
        return next;
    }

    public void setNext(CircularNode next) {
        this.next = next;
    }
    
    
}