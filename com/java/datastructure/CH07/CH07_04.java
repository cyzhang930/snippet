package com.java.datastructure.CH07;

public class CH07_04 {
    public static int[] run = new int[9];
    public static GraphLink[] head = new GraphLink[9];

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
        dfs(1);
        System.out.println();
    }

    public static void dfs(int current) {
        run[current] = 1;
        System.out.print("[" + current + "]");
        while (head[current].first != null) {
            if (run[head[current].first.x] == 0) {
                dfs(head[current].first.x);
            } else {
                System.out.print("(" + head[current].first.x + ")");
            }
            head[current].first = head[current].first.next;
        }
    }
}
