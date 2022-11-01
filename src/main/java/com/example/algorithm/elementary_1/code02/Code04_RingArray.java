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
            arr = new int[limit];
            push = 0;
            polli = 0;
            size = 0;
            this.limit = limit;
        }

        /**
         * 弹栈
         *
         * @return
         */
        public int pop() {
            if (size == 0) {
                throw new RuntimeException("栈空了，不能再拿了");
            }
            size--;
            int ans = arr[polli];
            polli = nextIndex(polli);
            return ans;
        }

        /**
         * 判定不为空
         *
         * @return
         */
        public boolean isEmpty() {
            return size == 0;
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