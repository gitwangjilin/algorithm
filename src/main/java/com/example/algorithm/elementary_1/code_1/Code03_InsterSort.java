package com.example.algorithm.elementary_1.code_1;

import java.util.Arrays;

public class Code03_InsterSort {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 123, 4, 1, 54, 1232};
        swap(arr);
    }

    private static void swap(int[] arr) {
        int temp;
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }
        System.out.println(6|3);
        System.out.println(Arrays.toString(arr));
    }
}
