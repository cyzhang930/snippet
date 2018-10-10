package com.java.datastructure.CH07;

public class CH07_06 {
    public static int VERTS = 7;
    public static int vertices[] = new int[VERTS];
    public static KNode newList = new KNode();

    public static void main(String[] args) {
        int[][] data = { { 1, 2, 6 }, { 1, 6, 12 }, { 1, 5, 10 }, { 2, 3, 3 }, { 2, 4, 5 }, { 2, 6, 8 }, { 3, 4, 7 },
                { 4, 6, 11 }, { 4, 5, 9 }, { 5, 6, 16 } };
        int dataNum;
        int fromNum;
        int toNum;
        int findNum;
        int header = 0;
        int freeNode;
        int i, j;
        System.out.println("Create graph:");
        for (i = 0; i < 10; i++) {
            for(j = 1; j < VERTS; j++) {
                if (data[1][0] == j) {
                    fromNum = data[i][0];
                    toNum = data[i][1];
                    dataNum = data[i][2];
                    findNum = 0;
                    freeNode = newList.findFree();
                    newList.create(header, freeNode, dataNum, fromNum, toNum, findNum);
                }
            }
        }
        newList.printList(header);
        System.out.println("Build min cost spanning tree:");
        minTree();
    }

    public static int findMinCost() {
        int minVal = 100;
        int retPtr = 0;
        int a = 0;
        while (newList.next[a] != -1) {
            if (newList.val[a] < minVal && newList.find[a] == 0) {
                minVal = newList.val[a];
                retPtr = a;
            }
            a++;
        }
        newList.find[retPtr] = 1;
        return retPtr;
    }

    public static void minTree() {
        int i, result = 0;
        int mcePtr;
        int a = 0;
        for (i = 0; i < VERTS; i++) {
            vertices[i] = 0;
        }
        while (newList.next[a] != -1) {
            mcePtr = findMinCost();
            vertices[newList.from[mcePtr]]++;
            vertices[newList.to[mcePtr]]++;
            if (vertices[newList.from[mcePtr]] > 1 && vertices[newList.to[mcePtr]] > 1) {
                vertices[newList.from[mcePtr]]--;
                vertices[newList.to[mcePtr]]--;
                result = 1;
            } else {
                result = 0;
            }
            if (result == 0) {
                System.out.println(String.format("Start vertice[%d] End vertice[%d] Path length[%d]",
                        newList.from[mcePtr], newList.to[mcePtr], newList.val[mcePtr]));
            }
            a++;
        }

    }

}
