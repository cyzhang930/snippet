package com.java.datastructure.CH07;

public class KNode {
    private static final int MAX_LENGTH = 20;
    int[] from = new int[MAX_LENGTH];
    int[] to = new int[MAX_LENGTH];
    int[] find = new int[MAX_LENGTH];
    int[] val = new int[MAX_LENGTH];
    int[] next = new int[MAX_LENGTH];

    public KNode() {
        for (int i = 0; i < MAX_LENGTH; i++) {
            next[i] = -2;
        }
    }

    public int findFree() {
        int i = 0;
        while (i < MAX_LENGTH) {
            if (next[i] == -2) {
                System.out.println(String.format("Find next free:%d", i));
                break;
            }
            i++;
        }
        return i;
    }

    public void create(int header, int freeNode, int dataNum, int fromNum, int toNum, int findNum) {
        int pointer;
        if (header == freeNode) {
            val[header] = dataNum;
            from[header] = fromNum;
            find[header] = findNum;
            to[header] = toNum;
            next[header] = -1;
        } else {
            pointer = header;
            val[freeNode] = dataNum;
            from[freeNode] = fromNum;
            find[freeNode] = findNum;
            to[freeNode] = toNum;

            next[freeNode] = -1;
            while (next[pointer] != -1) {
                pointer = next[pointer];
            }
            next[pointer] = freeNode;
        }
    }

    public void printList(int header) {
        int pointer = header;
        while (pointer != -1) {
            System.out.print(String.format("Start pointer[%d] End pointer[%d] Path length[%d]", from[pointer],
                    to[pointer], val[pointer]));
            System.out.println();
            pointer = next[pointer];
        }
    }
}
