package com.java.datastructure.CH07;

public class CH07_05 {
    public static int[] run = new int[9];
    public static GraphLink[] head = new GraphLink[9];
    public static int[] queue = new int[10];
    public static int front = -1;
    public static int rear = -1;

    public static void main(String[] args) {
        int[][] data = { { 1, 2 }, { 2, 1 }, { 1, 3 }, { 3, 1 }, { 2, 4 }, { 4, 2 }, { 2, 5 }, { 5, 2 }, { 3, 6 },
                { 6, 3 }, { 3, 7 }, { 7, 3 }, { 4, 5 }, { 5, 4 }, { 6, 7 }, { 7, 6 }, { 5, 8 }, { 8, 5 }, { 6, 8 },
                { 8, 6 } };
        int dataNum;
        System.out.println("Contents of the adjacency table of the graph");
        for (int i = 0; i < 9; i++) {
            run[i] = 0;
            head[i] = new GraphLink();
            System.out.print("Vertex" + i + "=>");
            for (int j = 0; j < 20; j++) {
                if (data[j][0] == i) {
                    dataNum = data[j][1];
                    head[i].insert(dataNum);
                }
            }
            head[i].print();
            System.out.println();
        }
        System.out.println("Depth first to traverse the vertices:");
        bfs(1);
        System.out.println();
    }
    
    public static void enqueue(int value) {
        if (rear >= 10) {
            return;
        }
        rear++;
        queue[rear] = value;
    }
    
    public static int dequeue() {
        if (front == rear) {
            return -1;
        }
        front++;
        return queue[front];
    }

    public static void bfs(int current) {
        Node tempNode;
        enqueue(current);
        run[current] = 1;
        System.out.print("[" + current + "]");
        while (front != rear) {
            current = dequeue();
            tempNode = head[current].first;
            while (tempNode != null) {
                if (run[tempNode.x] == 0) {
                    enqueue(tempNode.x);
                    run[tempNode.x] = 1;
                    System.out.print("[" + tempNode.x + "]");
                }
                tempNode = tempNode.next;
            }
        }
    }
}
