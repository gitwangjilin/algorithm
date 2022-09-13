package com.example.algorithm.elementary_1.code_1;

import java.util.Arrays;

/**
 * 选择排序
 */
public class Code01_SelectionSort {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 2, 1, 0};
        awap(arr);
    }

    private static void awap(int[] arr) {
        int temp;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}
