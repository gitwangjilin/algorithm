package com.example.algorithm.elementary_1.code03;

import java.util.Arrays;

/*************************************************************************
 ******
 * - Copyright (c) 2022 shangzhao.com
 * - File Name: Code03_MergeSort
 * - @Author: WangJiLIn
 * - Description:
 * 接⼝描述
 * - Functions:
 *
 * - History:
 * Date        Author          Modification
 * 2022/9/22   WangJiLin     Create the current class
 *************************************************************************
 ******/
public class Code03_MergeSort {
    public static void main(String[] args) {
        int[] arr = {6, 3, 65, 34, 23, 1, 34, 5};
        //process(arr, 0, arr.length - 1);
        mergewhile(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void mergewhile(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int arrSize = arr.length;
        int increment = 1;
        while (increment < arrSize) {
            int arr_lift = 0;
            while (arr_lift < arrSize) {
                int mid = arr_lift + increment - 1;
                if (mid >= arrSize) {
                    break;
                }
                int arr_right = Math.min(mid + increment, arrSize - 1);
                merge(arr, arr_lift, mid, arr_right);
                arr_lift = arr_right + 1;
            }
            increment <<= 1;
        }
    }

    private static void process(int[] arr, int life, int right) {
        //结束递归
        if (life == right) {
            return;
        }
        int mid = life + ((right - life) >> 1);
        process(arr, life, mid);
        process(arr, mid + 1, right);
        merge(arr, life, mid, right);
    }

    private static void merge(int[] arr, int life, int mid, int right) {
        //定义新数组因数组下标是以0开始所以长度为right-life+1;
        int[] temp = new int[right - life + 1];
        //结束while循环条件
        int i = 0;
        //新数组的开始位置
        int new_arr_left = life;
        //新数组中点
        int new_arr_mid = mid + 1;
        while (new_arr_left <= mid && new_arr_mid <= right) {
            //循环比较左右拿个小，将小的放进数组中
            temp[i++] = arr[new_arr_left] <= arr[new_arr_mid] ? arr[new_arr_left++] : arr[new_arr_mid++];
        }
        //都全是右边大
        while (new_arr_left <= mid) {
            temp[i++] = arr[new_arr_left++];
        }
        //全部左边大
        while (new_arr_mid <= right) {
            temp[i++] = arr[new_arr_mid++];
        }
        for (int j = 0; j < temp.length; j++) {
            arr[life + j] = temp[j];
        }
        System.out.println(Arrays.toString(arr));

    }
}
