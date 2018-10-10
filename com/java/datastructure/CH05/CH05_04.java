package com.java.datastructure.CH05;

public class CH05_04 {

    public static void main(String[] args) {
        LinkedListQueue2 queue = new LinkedListQueue2();
        queue.putInQueue(1);
        queue.putInQueue(3);
        queue.putInQueue(5);
        queue.putInQueue(7);
        queue.putInQueue(9);
        System.out.println(queue.getFromQueue(1));
        System.out.println(queue.getFromQueue(2));
        System.out.println(queue.getFromQueue(1));
        System.out.println(queue.getFromQueue(2));
        System.out.println(queue.getFromQueue(2));
    }

}

class LinkedListQueue2 {
    private QueueNode front;
    private QueueNode rear;

    public LinkedListQueue2() {
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

    public int getFromQueue(int action) {
        int value = -1;
        QueueNode startNode;
        if (getFront() != null && action == 1) {
            if (getFront().equals(getRear())) {
                setRear(null);
            }
            value = getFront().getData();
            setFront(getFront().getNext());
        } else if (getRear() != null && action == 2) {
            startNode = getFront();
            value = getRear().getData();
            while (startNode.getNext() != getRear() && startNode.getNext() != null) {
                startNode = startNode.getNext();
            }
            setRear(startNode);
            if ((getFront().getNext() == null) || (getRear().getNext() == null)) {
                setFront(null);
                setRear(null);
            }
        }

        return value;
    }
}
