package com.example.algorithm.elementary_1.code01;

import java.util.Arrays;

public class Code02_BubbleSort {
    public static void main(String[] args) {
        int[] arr = new int[]{23, 1, 432, 4, 2};
        swap(arr);
    }

    private static void swap(int[] arr) {
        int temp;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
