package com.example.algorithm.elementary_1.code02;

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
 * 2023/3/23   WangJiLin     Create the current class
 *************************************************************************
 ******/
public class Code08_GetMax {
    public static int i = 0;

    public static void main(String[] args) {
        int[] arrs = new int[]{3, 5, 2, 0};
        process(arrs, 0, arrs.length - 1, "开始");
    }

    /**
     * 递归
     *
     * @param arrs
     * @param l
     * @param r
     * @param msg
     * @return
     */
    private static int process(int[] arrs, int l, int r, String msg) {
        i++;
        System.out.println("第" + i + "趟====" + "l: " + l + ";r: " + r + ";msg: " + msg);
        //数组划分为(0,0)、(1,1)、(2,2)、(3,3)
        if (l == r) {
            return arrs[l];
        }
        //将数据二分到不可分割
        int mid = l + ((r - l) >> 1);
        int left = process(arrs, l, mid, "左");
        System.out.println("递归返回值left：" + arrs[l]);
        int right = process(arrs, mid + 1, r, "右");
        System.out.println("递归返回值right：" + arrs[l]);
        System.out.println("递归返回最大值：" + Math.max(left, right));
        return Math.max(left, right);
    }
}
