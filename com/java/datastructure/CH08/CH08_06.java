package com.java.datastructure.CH08;

public class CH08_06 {
    static int process = 1;
    public static void main(String[] args) {
      //  int[] data = { 6, 9, 2, 3, 4, 7, 5, 1 };
        int[] data = {26, 17, 5, 33, 87, 53, 27, 49, 28, 78};
        System.out.println("Original data:");
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
        quick(data, data.length, 0, data.length - 1);

    }

    private static void quick(int[] data, int size, int lf, int rg) {
        if (lf < rg) {
            int lfKey = lf + 1;
            int rgKey = rg;

            while (true) {
                System.out.print("Process " + process++ + " => ");
                for (int t = 0; t < size; t++) {
                    System.out.print("[" + data[t] + "] ");
                }
                System.out.println();
                for (int i = lf + 1; i <= rgKey; i++) {
                    if (data[i] > data[lf]) {
                        lfKey = i;
                        break;
                    }
                    lfKey++;
                }
                for (int j = rg; j >= lf + 1; j--) {
                    if (data[j] <= data[lf]) {
                        rgKey = j;
                        break;
                    }
                    rgKey--;
                }

                if (lfKey < rgKey) {
                    int temp = data[lfKey];
                    data[lfKey] = data[rgKey];
                    data[rgKey] = temp;
                } else {
                    break;
                }
            }
            if (lfKey >= rgKey) {
                int temp = data[lf];
                data[lf] = data[rgKey];
                data[rgKey] = temp;
                quick(data, size, lf, rgKey - 1);
                quick(data, size, rgKey + 1, rg);
            }
        }
    }

}
