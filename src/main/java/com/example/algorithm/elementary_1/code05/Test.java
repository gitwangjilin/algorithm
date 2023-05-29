package com.example.algorithm.elementary_1.code05;

import java.util.Arrays;

/*************************************************************************
 ******
 * - Copyright (c) 2023 shangzhao.com
 * - File Name: Test
 * - @Author: WangJiLIn
 * - Description:
 * 接⼝描述
 * - Functions:
 *
 * - History:
 * Date        Author          Modification
 * 2023/3/31   WangJiLin     Create the current class
 *************************************************************************
 ******/
public class Test {
    public static void main(String[] args) {
        int[] arrs = new int[]{1, 12, 301, 23, 0, 0};
        radixSort(arrs);
        System.out.println(Arrays.toString(arrs));
    }

    /**
     * 桶排序组织数据
     *
     * @param arrs
     */
    private static void radixSort(int[] arrs) {
        if (arrs == null && arrs.length < 2) {
            return;
        }
        radixSort(arrs, 0, arrs.length - 1, maxbits(arrs));
    }

    /**
     * 桶排序
     *
     * @param arrs
     * @param L
     * @param R
     * @param digit
     */
    private static void radixSort(int[] arrs, int L, int R, int digit) {
        //定义计数数组大小
        int radix = 10;
        int i, j;
        //创建临时变量
        int[] help = new int[R - L + 1];
        //按最大位数遍历
        for (int d = 1; d <= digit; d++) {
            //定义0-9数组来计数出现的次数
            int[] count = new int[radix];
            //将出现的次数维护到count数组中
            for (i = L; i <= R; i++) {
                j = getDigit(arrs[i], d);
                count[j]++;
            }
            //前缀树叠加得到数组最大值的区间下标
            for (i = 1; i < radix; i++) {
                count[i] = count[i] + count[i - 1];
            }
            //逆序下标在临时数组中添加
            for (i = R; i >= L; i--) {
                j = getDigit(arrs[i], d);
                help[count[j] - 1] = arrs[i];
                count[j]--;
            }
            //将临时数组刷回原数组中
            for (i = 0, j = L; j <= R; i++, j++) {
                arrs[i] = help[j];
            }
        }
    }

    /**
     * 按位进行除得到个位值
     *
     * @param x
     * @param d
     * @return
     */
    public static int getDigit(int x, int d) {
        return ((x / ((int) Math.pow(10, d - 1))) % 10);
    }

    /**
     * 得到数组中最大数的位数
     *
     * @param arrs
     * @return
     */
    private static int maxbits(int[] arrs) {
        //定义最小值
        int max = Integer.MIN_VALUE;
        //遍历数组得到最大值
        for (int i = 0; i < arrs.length; i++) {
            max = Math.max(max, arrs[i]);
        }
        int res = 0;
        //最大数除10得到最大位数
        while (max > 0) {
            res++;
            max /= 10;
        }
        return res;
    }
}