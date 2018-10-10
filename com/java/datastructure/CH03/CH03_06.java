package com.java.datastructure.CH03;

public class CH03_06 {

    public static void main(String[] args) {
        final int rows = 8;
        final int cols = 9;
        final int non_zero_num = 8;
        int sparse[][] = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < rows; j++) {
                sparse[i][j] = 0;
            }
        }
        int tempRow = 0;
        int tempCol = 0;
        int randomLen = non_zero_num + 1;
        for (int i = 0; i < randomLen; i++) {
            tempRow = (int) (Math.random() * 100);
            tempRow = tempRow % rows;
            tempCol = (int) (Math.random() * 100);
            tempCol = tempCol % cols;
            if (sparse[tempRow][tempCol] != 0) {
                randomLen++;
            }
            sparse[tempRow][tempCol] = i;
        }
        System.out.println("Elements in the sparse:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(sparse[i][j] + "\t");
            }
            System.out.println();
        }

        toCrossLinkedList(sparse);
    }

    private static void toCrossLinkedList(int[][] sparse) {
        int rowNodeArrLen = sparse.length;
        int colNodeArrLen = sparse[0].length;

        CrossNode[] rowNodeFirstArr = new CrossNode[rowNodeArrLen];
        CrossNode[] colNodeFirstArr = new CrossNode[colNodeArrLen];

        for (int i = 0; i < rowNodeArrLen; i++) {
            rowNodeFirstArr[i] = new CrossNode(0, 0, 0);
            for (int j = 0; j < colNodeArrLen; j++) {
                if (colNodeFirstArr[j] == null) {
                    colNodeFirstArr[j] = new CrossNode(0, 0, 0);
                }
                if (sparse[i][j] != 0) {
                    CrossNode newNode = new CrossNode(i + 1, j + 1, sparse[i][j]);
                    CrossNode rowNext = rowNodeFirstArr[i].getRight();
                    if (rowNext == null) {
                        rowNodeFirstArr[i].setRight(newNode);
                    } else {
                        while (rowNext.getRight() != null) {
                            rowNext = rowNext.getRight();
                        }
                        rowNext.setRight(newNode);
                    }
                    
                    CrossNode nextNode = colNodeFirstArr[j].getDown();
                    if (nextNode == null) {
                        colNodeFirstArr[j].setDown(newNode);
                    } else {
                        while (nextNode.getDown() != null) {
                            nextNode = nextNode.getDown();
                        }
                        nextNode.setDown(newNode);
                    }
                }
            }
        }

        for (int i = 0; i < rowNodeArrLen; i++) {
            if (i < rowNodeArrLen - 1) {
                rowNodeFirstArr[i].setDown(rowNodeFirstArr[i + 1]);
            } else {
                // rowNodeFirstArr[i].setDown(rowNodeFirstArr[0]);
            }
        }

        for (int j = 0; j < colNodeArrLen; j++) {
            if (j < colNodeArrLen - 1) {
                colNodeFirstArr[j].setRight(colNodeFirstArr[j + 1]);
            } else {
                // colNodeFirstArr[j].setDown(colNodeFirstArr[0]);
            }
        }

        CrossNode start = rowNodeFirstArr[0];
        while (start != null) {
            //System.out.println(start.toString());
            CrossNode right = start.getRight();
            while (right != null) {
                System.out.println("[" + right.getRow() + " " + right.getCol() + " " + right.getValue() + "]");
                right = right.getRight();
            }
            start = start.getDown();
        }
        System.out.println();
        
        CrossNode start1 = colNodeFirstArr[0];
        while (start1 != null) {
            //System.out.println(start.toString());
            CrossNode down = start1.getDown();
            while (down != null) {
                System.out.println("[" + down.getRow() + " " + down.getCol() + " " + down.getValue() + "]");
                down = down.getDown();
            }
            start1 = start1.getRight();
        }
    }

}


class CrossNode {
    private int row;
    private int col;
    private CrossNode down;
    private CrossNode right;
    private int value;

    public CrossNode(int row, int col, int value) {
        this.row = row;
        this.col = col;
        this.value = value;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public CrossNode getDown() {
        return down;
    }

    public void setDown(CrossNode down) {
        this.down = down;
    }

    public CrossNode getRight() {
        return right;
    }

    public void setRight(CrossNode right) {
        this.right = right;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "CrossNode [row=" + row + ", col=" + col + ", right=" + right + ", value=" + value
                + "]";
    }

}
