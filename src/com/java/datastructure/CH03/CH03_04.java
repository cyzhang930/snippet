package com.java.datastructure.CH03;

public class CH03_04 {

    public static void main(String[] args) {
        PolyLinkedList a = new PolyLinkedList();
        PolyLinkedList b = new PolyLinkedList();
        PolyLinkedList c = new PolyLinkedList();
        int[] data1 = { 8, 54, 7, 0, 1, 3, 0, 4, 2 };
        int[] data2 = { -2, 6, 0, 0, 0, 5, 6, 8, 6, 9 };
        for (int i = 0; i < data1.length; i++) {
            a.createLink(data1[i], data1.length -i - 1);
        }
        for (int i = 0; i < data2.length; i++) {
            b.createLink(data2[i], data2.length -i - 1);
        }
        a.printList();
        b.printList();
        c = a.sumList(b);
        c.printList();
    }

}

class PolyLinkedList {
    private PolyNode first;
    private PolyNode last;

    public boolean isEmpty() {
        return first == null;
    }

    public void createLink(int coef, int exp) {
        PolyNode newNode = new PolyNode(coef, exp);
        if (first == null) {
            first = newNode;
            last = newNode;
        } else {
            last.setNext(newNode);
            last = newNode;
        }
    }

    public void printList() {
        PolyNode current = first;
        while (current != null) {
            if (current.getCoef() != 0 && current.getExp() == 1) {
                System.out.print(current.getCoef() + "X + ");
            } else if (current.getCoef() != 0 && current.getExp() != 0) {
                System.out.print(current.getCoef() + "X^" + current.getExp() + " + ");
            } else if (current.getCoef() != 0) {
                System.out.print(current.getCoef());
            }
            current = current.getNext();
        }
        System.out.println();
    }

    public PolyLinkedList sumList(PolyLinkedList other) {
        int sum[] = new int[10];
        PolyLinkedList result = new PolyLinkedList();
        PolyNode startA = this.first;
        PolyNode startB = other.first;

        while (startA != null) {
            int exp = startA.getExp();
            if (startB.getExp() > exp) {
                result.createLink(startB.getCoef(), startB.getExp());
                startB = startB.getNext();
            } else {
                while (startB.getExp() < exp) {
                    startB = startB.getNext();
                }
                if (startB != null) {
                    result.createLink(startA.getCoef() + startB.getCoef(), exp);
                }
                startA = startA.getNext();
                startB = startB.getNext();
            }
            
        }
        return result;
    }
}

class PolyNode {
    private int coef;
    private int exp;
    private PolyNode next;

    public PolyNode(int coef, int exp) {
        this.coef = coef;
        this.exp = exp;
        this.next = null;
    }

    public int getCoef() {
        return coef;
    }

    public int getExp() {
        return exp;
    }

    public PolyNode getNext() {
        return next;
    }

    public void setNext(PolyNode next) {
        this.next = next;
    }

}