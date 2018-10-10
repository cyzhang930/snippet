package com.java.datastructure.CH04;

public class TraceRecord {
    public MazeNode first;
    public MazeNode last;
    
    public boolean isEmpty() {
        return this.first == null;
    }
    
    public void insert(int x, int y) {
        MazeNode newNode = new MazeNode(x, y);
        if (this.isEmpty()) {
            this.first = newNode;
            this.last = newNode;
        } else {
            this.last.setNext(newNode);
            this.last = newNode;
        }
    }
    
    public void delete() {
        if (this.isEmpty()) {
            System.out.println("List is empty");
            return;
        }
        MazeNode newNode = first;
        while (newNode.getNext() != last) {
            newNode = newNode.getNext();
        }
        newNode.setNext(null);
        last = newNode;
    }
}

class MazeNode {
    private int x;
    private int y;
    private MazeNode next;

    public MazeNode(int x, int y) {
        super();
        this.x = x;
        this.y = y;
        this.next = null;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public MazeNode getNext() {
        return next;
    }

    public void setNext(MazeNode next) {
        this.next = next;
    }

}