package com.example.algorithm.com.example.jvm.codo01;

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
 * 2023/3/10   WangJiLin     Create the current class
 *************************************************************************
 ******/
public class Test {

    public static void main(String[] args) {
        System.out.println(ways(2, 3, 3));
    }

    private static int ways(int x, int y, int k) {
        if (k == 0) {
            return x == 0 && y == 0 ? 1 : 0;
        }
        if (x < 0 || x > 9 || y < 0 || y > 8) {
            return 0;
        }
        return    ways(x + 1, y + 2, k - 1)
                + ways(x + 1, y - 2, k - 1)
                + ways(x + 2, y + 1, k - 1)
                + ways(x + 2, y - 1, k - 1)
                + ways(x - 1, y - 2, k - 1)
                + ways(x - 1, y + 1, k - 1)
                + ways(x - 2, y + 1, k - 1)
                + ways(x - 2, y - 1, k - 1)
                ;
    }
}
