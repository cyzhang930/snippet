package com.java.datastructure.CH02;

import java.util.Arrays;

/*
 * Use two-dimensional array to implement a lottery number generator
 */

public class CH02_01 {
    private final int FIRST_DEMENSION_LEN = 2;
    private final int SECOND_DEMENSION_LEN = 42;
    private final int MAX_NUMBER_COUNT = 6;
    private int[][] intArray = new int[FIRST_DEMENSION_LEN][SECOND_DEMENSION_LEN];
    
    public void createArray(int intCreate) {
        int intRand;
        while (intCreate-- > 0) {
            intRand = (int) (Math.random() * SECOND_DEMENSION_LEN);
            intArray[0][intRand]++;
            intArray[1][intRand]++;
        }
        Arrays.sort(intArray[0]);

        int boundaryMax = SECOND_DEMENSION_LEN - 1;
        int boundaryMin = boundaryMax - MAX_NUMBER_COUNT;

        for (int i = boundaryMax; i > boundaryMin; i--) {
            for (int j = boundaryMax; j >= 0; j--) {
                if (intArray[0][i] == intArray[1][j]) {
                    System.out.println("Random number " + (j + 1) + " appears " + intArray[0][i] + " times.");
                    intArray[1][j] = 0;
                    break;
                }
            }
        }
    }

}
