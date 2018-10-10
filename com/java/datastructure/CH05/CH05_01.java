package com.java.datastructure.CH05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CH05_01 {
    public static int FRONT = -1;
    public static int REAR = -1;
    public static int MAX = 20;

    public static void main(String[] args) throws NumberFormatException, IOException {
        int max = 20;
        int[] queue = new int[max];
        BufferedReader keyIn = new BufferedReader(new InputStreamReader(System.in));
        int rear = -1;
        int input = 0;
        
        while (rear < max - 1 && input != 3) {
            System.out.println("[1] add [2] get [3] end");
            input = Integer.parseInt(keyIn.readLine());
            switch (input) {
            case 1:
                System.out.println("[Please input number]: ");
                queue[++rear] = Integer.parseInt(keyIn.readLine());
                break;
            case 2:
                if (rear > FRONT) {
                    FRONT++;
                    System.out.println("[Get number]:" + queue[FRONT]);
                    queue[FRONT] = 0;
                } else {
                    System.out.println("The queue is empty");
                }
                break;
            default:
                System.out.println();
                break;
            }
        }
        if (rear == max -1) {
            System.out.println("[The queue is full]");
        }
        System.out.println("[Current number in the queue]:");
        if (FRONT >= rear) {
            System.out.println("NOTHING");
            System.out.println("[The queue is empty]");
        } else {
            while (rear > FRONT) {
                System.out.print(queue[++FRONT] + "\t");
            }
            System.out.println();
        }

    }

}
