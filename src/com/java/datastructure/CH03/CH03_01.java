package com.java.datastructure.CH03;

import java.io.*;
import java.util.Scanner;

/*
 * A simple about how to create a LinkedList in Java
 */
public class CH03_01 {

    Scanner in = new Scanner(System.in);

    public void setIn(ByteArrayInputStream baIn) {
        this.in = new Scanner(baIn);
    }

    public String getInputLine() {
        return in.nextLine();
    }

    public LinkedList createListWithInput(int length) throws Exception {
        if (length < 1) {
            throw new Exception("Invalid parameter");
        }
        LinkedList list = new LinkedList();
        for (int i = 0; i < length; i++) {
            int num = Integer.parseInt(getInputLine());
            String name = getInputLine();
            int score = Integer.parseInt(getInputLine());
            list.insert(num, name, score);
        }
        return list;
    }

}
