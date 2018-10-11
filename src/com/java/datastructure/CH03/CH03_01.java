package com.java.datastructure.CH03;

import java.io.*;

public class CH03_01 {
    public static void main(String[] args) throws Exception {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        int num;
        String name;
        int score;
        
        System.out.println("Please input data of 5 students: ");
        LinkedList list = new LinkedList();
        for (int i = 0; i < 6; i++) {
            System.out.println("Please input student number: ");
            num = Integer.parseInt(buf.readLine());
            System.out.println("Please input studen name: ");
            name = buf.readLine();
            System.out.println("Please input the score: ");
            score = Integer.parseInt(buf.readLine());
            list.insert(num, name, score);
            System.out.println("-------------------------");
        }
        System.out.println("Student score");
        System.out.println("Student name and score ====");
        list.print();
    }
}
