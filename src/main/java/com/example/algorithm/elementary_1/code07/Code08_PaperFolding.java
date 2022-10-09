package com.example.algorithm.elementary_1.code07;

/**
 * 折凹凸
 */
public class Code08_PaperFolding {
    public static void main(String[] args) {
        int N = 3;
        printAllFolds(N);
    }

    private static void printAllFolds(int n) {
        printProcess(1, n, true);
    }

    private static void printProcess(int i, int n, boolean down) {
        if (i > n) {
            return;
        }
        printProcess(i + 1, n, true);
        System.out.println(down ? "凹 " : "凸 ");
        printProcess(i + 1, n, false);

    }
}
