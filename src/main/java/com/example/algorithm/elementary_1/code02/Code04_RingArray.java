package com.example.algorithm.elementary_1.code02;

/*************************************************************************
 ******
 * - Copyright (c) 2022 shangzhao.com
 * - File Name: Code04_RingArray
 * - @Author: WangJiLIn
 * - Description:
 * 接⼝描述
 * - Functions:
 *
 * - History:
 * Date        Author          Modification
 * 2022/10/26   WangJiLin     Create the current class
 *************************************************************************
 ******/
public class Code04_RingArray {
    public static class MyQueue {
        private int[] arr;
        private int push;
        private int polli;
        private int size;
        private final int limit;

        public MyQueue(int limit) {
            this.limit = limit;
        }

        /**
         * 添加元素
         *
         * @param value
         */
        public void push(int value) {
            if (size == limit) {
                throw new RuntimeException("数组已满");
            }
            size++;
            arr[polli] = value;
            polli = nextIndex(polli);


        }

        private int nextIndex(int i) {
            return i < limit - 1 ? i + 1 : 0;
        }
    }
}