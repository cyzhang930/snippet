package com.java.datastructure.CH05;

public class CH05_02 {

    public static void main(String[] args) {
        LinkedListQueue queue = new LinkedListQueue();
        queue.putInQueue(1);
        queue.putInQueue(2);
        queue.putInQueue(3);
        for (int i = 0; i < 4; i++) {
            System.out.println(queue.getFromQueue());
        }

    }

}

class LinkedListQueue {
    private QueueNode front;
    private QueueNode rear;

    public LinkedListQueue() {
        this.front = null;
        this.rear = null;
    }

    public QueueNode getFront() {
        return front;
    }

    public void setFront(QueueNode front) {
        this.front = front;
    }

    public QueueNode getRear() {
        return rear;
    }

    public void setRear(QueueNode rear) {
        this.rear = rear;
    }

    public boolean isEmpty() {
        return this.front == null;
    }
    
    public boolean putInQueue(int data) {
        QueueNode newNode = new QueueNode(data);
        if (isEmpty()) {
            setFront(newNode);
            setRear(newNode);
        } else {
            getRear().setNext(newNode);
            setRear(newNode);
        }
        return true;
    }
    
    public int getFromQueue() {
        int value;
        if (isEmpty()) {
            value  = -1;
        } else {
            value = getFront().getData();
            setFront(getFront().getNext());
        }
        return value;
    }
}

class QueueNode {
    private int data;
    private QueueNode next;

    public QueueNode(int data) {
        this.data = data;
        this.next = null;
    }

    public int getData() {
        return data;
    }

    public QueueNode getNext() {
        return next;
    }

    public void setNext(QueueNode next) {
        this.next = next;
    }

}