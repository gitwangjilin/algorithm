package com.example.algorithm.elementary_1.code03;

import java.util.Arrays;

/*************************************************************************
 ******
 * - Copyright (c) 2022 shangzhao.com
 * - File Name: Code01_MergeSort
 * - @Author: WangJiLIn
 * - Description:
 * 接⼝描述
 * - Functions:
 *
 * - History:
 * Date        Author          Modification
 * 2022/11/3   WangJiLin     Create the current class
 *************************************************************************
 ******/
public class Code01_MergeSort {
    public static void main(String[] args) {
        int[] arr = {23, 123, 1, 432, 635, 234};
        process(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void process(int[] arr, int left, int right) {
        System.out.println(left + "===" + right);
        if (left == right) {
            return;
        }
        int mid = (left + right) >> 1;
        process(arr, left, mid);
        process(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        System.out.println(right - left + 1);
        int[] help = new int[right - left + 1];
        int i = 0;
        int p1 = left;
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= right) {
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }
        while (p2 <= right) {
            help[i++] = arr[p2++];
        }
        for (i = 0; i < help.length; i++) {
            arr[left + i] = help[i];
        }
    }
}
