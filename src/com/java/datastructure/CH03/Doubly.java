package com.java.datastructure.CH03;

public class Doubly {
    public DoublyNode first;
    public DoublyNode last;
    
    public boolean isEmpty() {
        return first == null;
    }
    
    public void insert(DoublyNode newNode) {
        if (this.isEmpty()) {
            first = newNode;
            first.setrNext(last);
            last = newNode;
            last.setlNext(first);
        } else {
            if (newNode.getlNext() == null) {
                first.setlNext(newNode);
                newNode.setrNext(first);
                first = newNode;
            } else {
                if (newNode.getrNext() == null) {
                    last.setrNext(newNode);
                    newNode.setlNext(last);
                    last = newNode;
                } else {
                    DoublyNode lTmp = first;
                    DoublyNode rTmp = first;
                    while (lTmp.getrNext() != newNode.getrNext()) {
                        lTmp = lTmp.getrNext();
                    }
                    rTmp = lTmp.getrNext();
                    lTmp.setrNext(newNode);
                    newNode.setlNext(lTmp);
                    newNode.setrNext(rTmp);
                    rTmp.setlNext(newNode);
                }
            }
        }
    }
    
    public void delete(DoublyNode delNode) {
        if (delNode.getData() == first.getData()) {
            first = first.getrNext();
            first.setlNext(null);
        } else if (delNode.getData() == last.getData()) {
            last = last.getlNext();
            last.setrNext(null);
        } else {
            DoublyNode lTmp;
            DoublyNode rTmp = first;
            while (rTmp.getData() != delNode.getData()) {
                rTmp = rTmp.getrNext();
            }
            lTmp = rTmp.getlNext();
            rTmp = rTmp.getrNext();
            lTmp.setrNext(rTmp);
            rTmp.setlNext(lTmp);
        }
    }
}

class DoublyNode {
    private int data;
    private DoublyNode lNext;
    private DoublyNode rNext;
    
    public DoublyNode(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public DoublyNode getlNext() {
        return lNext;
    }

    public void setlNext(DoublyNode lNext) {
        this.lNext = lNext;
    }

    public DoublyNode getrNext() {
        return rNext;
    }

    public void setrNext(DoublyNode rNext) {
        this.rNext = rNext;
    }
    
}