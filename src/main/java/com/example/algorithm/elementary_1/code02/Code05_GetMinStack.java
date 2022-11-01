package com.example.algorithm.elementary_1.code02;

import java.util.Stack;

/*************************************************************************
 ******
 * - Copyright (c) 2022 shangzhao.com
 * - File Name: Code05_GetMinStack
 * - @Author: WangJiLIn
 * - Description:
 * 接⼝描述
 * - Functions:
 *
 * - History:
 * Date        Author          Modification
 * 2022/11/1   WangJiLin     Create the current class
 *************************************************************************
 ******/
public class Code05_GetMinStack {

    public static class MyStack1 {
        private Stack<Integer> stackData;
        private Stack<Integer> stackMin;

        /**
         * 省空间，记录栈只保留栈中最值
         */
        public void push(Integer value) {
            if (this.stackMin.isEmpty()) {
                stackMin.push(value);
            } else if (stackMin.pop() <= this.getMin()) {
                stackMin.push(value);
            }
            stackData.push(value);
        }

        /**
         * 弹栈需要注意，记录栈要判定数据栈相同则在弹栈，需要多加一步判断
         *
         * @return
         */
        public int pop() {
            if (this.stackData.isEmpty()) {
                throw new RuntimeException("栈以为空");
            }
            int value = this.stackData.pop();
            if (value == this.getMin()) {
                this.stackMin.pop();
            }
            return this.stackMin.pop();
        }

        /**
         * 获取栈顶值
         *
         * @return
         */
        public int getMin() {
            if (this.stackMin.isEmpty()) {
                throw new RuntimeException("栈以为空");
            }
            return this.stackMin.peek();
        }
    }

    public static class MyStack2 {
        private Stack<Integer> stackData;
        private Stack<Integer> stackMin;

        public MyStack2() {
            this.stackData = new Stack<Integer>();
            this.stackMin = new Stack<Integer>();
        }

        /**
         * 不省内存空间两个相同大小栈
         *
         * @param newNum
         */
        public void push(int newNum) {
            if (this.stackMin.isEmpty()) {
                this.stackMin.push(newNum);
            } else if (newNum < this.getmin()) {
                this.stackMin.push(newNum);
            } else {
                int newMin = this.stackMin.peek();
                this.stackMin.push(newMin);
            }
            this.stackData.push(newNum);
        }

        public int pop() {
            if (this.stackData.isEmpty()) {
                throw new RuntimeException("Your stack is empty.");
            }
            this.stackMin.pop();
            return this.stackData.pop();
        }

        public int getmin() {
            if (this.stackMin.isEmpty()) {
                throw new RuntimeException("Your stack is empty.");
            }
            return this.stackMin.peek();
        }
    }

    public static void main(String[] args) {
        //省内存空，每次值保留最值，如果在添加大于以加入的抛弃，在弹栈的时候，需要判定是否是当前值，备用栈在弹栈
        MyStack1 myStack1 = new MyStack1();
        myStack1.push(1);
        myStack1.push(2);
        myStack1.push(3);
        myStack1.push(4);
        //不省空间两个相同栈
        MyStack2 myStack2 = new MyStack2();
        myStack2.push(1);
        myStack2.push(2);
        myStack2.push(3);
        myStack2.push(4);
    }
}
