package com.java.datastructure.CH04;

public class CH04_05 {
    public static int EXIT_X = 8;
    public static int EXIT_Y = 10;

    public static int[][] MAZE = { { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1 },
            { 1, 1, 1, 0, 1, 1, 0, 0, 0, 0, 1, 1 }, { 1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1 },
            { 1, 1, 1, 0, 0, 0, 0, 1, 1, 0, 1, 1 }, { 1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1 },
            { 1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1 }, { 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1 },
            { 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1 }, { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 } };

    public static void main(String[] args) throws Exception {
        TraceRecord path = new TraceRecord();
        System.out.println("Path of the maze(0 part)");
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 12; j++) {
                System.out.print(MAZE[i][j]);
            }
            System.out.println();
        }
        int x = 1;
        int y = 1;
        while (x <= EXIT_X && y <= EXIT_Y) {
            MAZE[x][y] = 2;
            if (MAZE[x - 1][y] == 0) {
                x -= 1;
                path.insert(x, y);
            } else if (MAZE[x + 1][y] == 0) {
                x += 1;
                path.insert(x, y);
            } else if (MAZE[x][y - 1] == 0) {
                y -= 1;
                path.insert(x, y);
            } else if (MAZE[x][y + 1] == 0) {
                y += 1;
                path.insert(x, y);
            } else if (chkExit(x, y, EXIT_X, EXIT_Y) == 1) {
                break;
            } else {
                MAZE[x][y] = 2;
                path.delete();
                x = path.last.getX();
                y = path.last.getY();
            }
        }
        System.out.println("Path of maze(2 part)");
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 12; j++) {
                System.out.print(MAZE[i][j]);
            }
            System.out.println();
        }
    }

    public static int chkExit(int x, int y, int ex, int ey) {
        if (x == ex && y == ey) {
            if (MAZE[x - 1][y] == 1 || MAZE[x + 1][y] == 1 || MAZE[x][y - 1] == 1 || MAZE[x][y + 1] == 2) {
                return 1;
            }
            if (MAZE[x - 1][y] == 1 || MAZE[x + 1][y] == 1 || MAZE[x][y - 1] == 2 || MAZE[x][y + 1] == 1) {
                return 1;
            }
            if (MAZE[x - 1][y] == 1 || MAZE[x + 1][y] == 2 || MAZE[x][y - 1] == 1 || MAZE[x][y + 1] == 1) {
                return 1;
            }
            if (MAZE[x - 1][y] == 2 || MAZE[x + 1][y] == 1 || MAZE[x][y - 1] == 1 || MAZE[x][y + 1] == 1) {
                return 1;
            }
        }
        return 0;
    }
}
