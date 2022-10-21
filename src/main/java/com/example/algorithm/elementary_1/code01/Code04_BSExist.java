package com.example.algorithm.elementary_1.code01;

/*************************************************************************
 ******
 * - Copyright (c) 2022 shangzhao.com
 * - File Name: Code04_BSExist
 * - @Author: WangJiLIn
 * - Description:
 * 接⼝描述
 * - Functions:
 *
 * - History:
 * Date        Author          Modification
 * 2022/10/20   WangJiLin     Create the current class
 *************************************************************************
 ******/
public class Code04_BSExist {
    public static void main(String[] args) {
        int[] arrs = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        boolean flag = exist(arrs, 10);
        System.out.println(flag);
    }

    private static boolean exist(int[] arrs, int i) {
        int life = 0;
        int right = arrs.length - 1;

        while (life < right) {
            int mid = (life + right) >> 1;
            if (arrs[mid] == i) {
                return true;
            } else if (arrs[mid] > i) {
                right = mid - 1;
            } else {
                life = mid + 1;
            }

        }


        return false;
    }
}
