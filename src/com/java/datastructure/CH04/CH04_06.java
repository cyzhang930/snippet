package com.java.datastructure.CH04;

public class CH04_06 {
    private static final int TRUE = 1;
    private static final int FALSE = 0;
    private static final int EIGHT = 8;

    static int[] queen = new int[EIGHT];
    static int number = 0;

    public static void main(String[] args) {
        decidePosition(0);
    }

    public static void pressEnter() {
        char tChar;
        System.out.println();
        System.out.println("... Press Enter and contnue...");
        try {
            tChar = (char) System.in.read();
        } catch (Exception e) {
            // do nothing
        }
    }

    public static void decidePosition(int value) {
        int col = 0;
        while (col < EIGHT) {
            if (myAttck(col, value) != TRUE) {
                queen[value] = col;
                if (value == 7) {
                    printTable();
                } else {
                    decidePosition(value + 1);
                }
            }
            col++;
        }
    }
    
    public static int attck(int row, int col) {
        int i = 0;
        int atk = FALSE;
        int offsetRow = 0;
        int offsetCol = 0;
        while (atk != TRUE && i < col) {
            offsetCol = Math.abs(i - col);
            offsetRow = Math.abs(queen[i] - row);
            if (queen[i] == row || offsetRow == offsetCol) {
                atk = TRUE;
            }
            i++;
        }
        
        return atk;
    }

    public static int myAttck(int col, int newQueen) {
        int oldQueen = 0;
        int atk = FALSE;
        int offsetRow = 0;
        int offsetCol = 0;
        while (atk != TRUE && oldQueen < newQueen) {
            offsetRow = Math.abs(oldQueen - newQueen);
            offsetCol = Math.abs(queen[oldQueen] - col);
            if (queen[oldQueen] == col || offsetRow == offsetCol) {
                atk = TRUE;
            }
            oldQueen++;
        }
        
        return atk;
    }

    public static void printTable() {
        number += 1;
        System.out.println();
        System.out.println("Solve the eight queen's problem, " + number + " resolution\t");
        for (int x = 0; x < EIGHT; x++) {
            for (int y = 0; y < EIGHT; y++) {
                if (x == queen[y]) {
                    System.out.print("<*>");
                } else {
                    System.out.print("<->");
                }
            }
            System.out.println();
        }
        pressEnter();
    }
}
