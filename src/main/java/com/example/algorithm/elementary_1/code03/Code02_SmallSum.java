package com.example.algorithm.elementary_1.code03;

import java.util.Arrays;

/*************************************************************************
 ******
 * - Copyright (c) 2022 shangzhao.com
 * - File Name: Code02_SmallSum
 * - @Author: WangJiLIn
 * - Description:
 * 接⼝描述
 * - Functions:
 *
 * - History:
 * Date        Author          Modification
 * 2022/11/8   WangJiLin     Create the current class
 *************************************************************************
 ******/
public class Code02_SmallSum {
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 2, 5};
        int i = smallSum(arr);
        System.out.println(i);
        System.out.println(Arrays.toString(arr));
    }

    private static int smallSum(int[] arr) {
        if (arr == null && arr.length < 2) {
            return 0;
        }
        return process(arr, 0, arr.length - 1);
    }

    private static int process(int[] arr, int left, int right) {
        if (left == right) {
            return 0;
        }
        int mid = (left + right) >> 1;

        return process(arr, left, mid) + process(arr, mid + 1, right) + merge(arr, left, mid, right);

    }

    private static int merge(int[] arr, int left, int mid, int right) {
        int[] help = new int[right - left + 1];
        int p1 = left;
        int p2 = mid + 1;
        int i = 0;
        int res = 0;
        while (p1 <= mid && p2 <= right) {
            res += arr[p1] < arr[p2] ? (right - p2 + 1) * arr[p1] : 0;
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
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
        System.out.println(res);
        return res;
    }

}
