package com.example.algorithm.elementary_1.code_3;

import java.util.Arrays;

/*************************************************************************
 ******
 * - Copyright (c) 2022 shangzhao.com
 * - File Name: Code03_PartitionAndQuickSort
 * - @Author: WangJiLIn
 * - Description:
 * 接⼝描述
 * - Functions:
 *
 * - History:
 * Date        Author          Modification
 * 2022/9/24   WangJiLin     Create the current class
 *************************************************************************
 ******/
public class Code03_PartitionAndQuickSort {
    public static void main(String[] args) {
        int[] arr = {3, 2, 6, 1, 71, 5, 0};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr, int life, int right) {
        if (arr == null && arr.length < 2) {
            return;
        }
        process(arr, 0, arr.length - 1);
    }

    private static void process(int[] arr, int life, int right) {
        if (life > right) {
            return;
        }
        int n = partiton(arr, life, right);
        process(arr, life, n - 1);
        process(arr, n + 1, right);
    }

    private static int partiton(int[] arr, int life, int right) {
        if (life > right) {
            return -1;
        }
        if (life == right) {
            return life;
        }
        int lessEqual = life - 1;
        int index = life;
        while (index < right) {
            if (arr[index] <= arr[right]) {
                sawp(arr, index, ++lessEqual);
            }
            index++;
        }
        sawp(arr, ++lessEqual, right);
        return lessEqual;
    }

    private static void sawp(int[] arr, int l, int r) {
        int temp = 0;
        temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }
}
