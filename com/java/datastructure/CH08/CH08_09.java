package com.java.datastructure.CH08;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class CH08_09 {

    public static void main(String[] args) throws Exception {
        String output = "/Users/chunyingzhang/tools/eclipse/java_workspace/JavaTest/src/com/cyzhang/data/data.txt";
        String file1 = "/Users/chunyingzhang/tools/eclipse/java_workspace/JavaTest/src/com/cyzhang/data/data1.txt";
        String file2 = "/Users/chunyingzhang/tools/eclipse/java_workspace/JavaTest/src/com/cyzhang/data/data2.txt";
        
        File fp = new File(output);
        File fp1 = new File(file1);
        File fp2 = new File(file2);
        
        if (!fp.exists() || ! fp1.exists() || !fp2.exists()) {
            System.err.println("fail to find file");
        } else {
            merge(fp, fp1, fp2);
        }
    }
    
    private static void merge (File fp, File fp1, File fp2) throws Exception {
        try (BufferedWriter pFile = new BufferedWriter(new FileWriter(fp));BufferedReader pFile1 = new BufferedReader(new FileReader(fp1));
                BufferedReader pFile2 = new BufferedReader(new FileReader(fp2));) {
            char char1, char2;
            int n1, n2;
            n1 = pFile1.read();
            n2 = pFile2.read();
            while (n1 != -1 && n2 != -1) {
                if (n1 < n2) {
                    char1 = (char) n1;
                    pFile.write(char1);
                    n1 = pFile1.read();
                } else {
                    char2 = (char) n2;
                    pFile.write(char2);
                    n2 = pFile2.read();
                }
            }
            if (n2 != -1) {
                while (true) {
                    if (n2 == -1) {
                        break;
                    }
                    char2 = (char) n2;
                    pFile.write(char2);
                    n2 = pFile2.read();
                }
            }
            if (n1 != -1) {
                while (true) {
                    if (n1 == -1) {
                        break;
                    }
                    char1 = (char) n1;
                    pFile.write(char1);
                    n1 = pFile1.read();
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        
        
    }

}
