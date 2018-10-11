package com.java.datastructure.CH05;

import java.io.*;

public class CH05_03 {
    public static int front = -1, rear = -1, val;
    public static int[] queue = new int[5];

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (rear < 5 && val != -1) {
            System.out.print("Please input the value to be stored in the queue, if you want to get value please input 0.(End input -1):\t");
            val = Integer.parseInt(reader.readLine());
            if (val == 0) {
                if (front == rear) {
                    System.out.println("The queue is empty");
                    break;
                } else {
                    front++;
                    if (front == 5) {
                        front = 0;
                    }
                    System.out.println("Got data:" + queue[front]);
                    queue[front] = 0;
                }
            } else if (rear < 5 && val != -1) {
                if (rear + 1 == front || rear ==4 && front <= 0) {
                    System.out.println("The queue is full");
                    break;
                } else {
                    rear++;
                    if (rear == 5) {
                        rear = 0;
                    }
                    queue[rear] = val;
                }
            }
            
        }
        System.out.println("Left in the queue:");
        if (front == rear) {
            System.out.println("The queue is empty");
        } else {
            while (front != rear) {
                front++;
                if (front == 5) {
                    front = 0;
                }
                System.out.println(queue[front]);
                queue[front] = 0;
            }
        }
        
    }

}
