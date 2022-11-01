package com.example.algorithm.elementary_1.code02;

import java.util.Stack;

/*************************************************************************
 ******
 * - Copyright (c) 2022 shangzhao.com
 * - File Name: Code06_TwoStacksImplementQueue
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
public class Code06_TwoStacksImplementQueue {

    public static class TwoStacksQueue {
        public Stack<Integer> stackPush;
        public Stack<Integer> stackPop;

        public TwoStacksQueue() {
            stackPush = new Stack<Integer>();
            stackPop = new Stack<Integer>();
        }

        public void add(Integer value) {
            stackPush.push(value);
            pushToPop();
        }

        public int poll() {
            if (stackPush.isEmpty() && stackPop.isEmpty()) {
                throw new RuntimeException("队列为空");
            }
            pushToPop();
            return stackPop.pop();
        }

        /**
         * 添加数据需要将备用栈数据重新添加
         */
        private void pushToPop() {
            if (stackPop.isEmpty()) {
                while (!stackPush.isEmpty()) {
                    stackPop.push(stackPush.pop());
                }
            }
        }

        public int peek() {
            if (stackPop.empty() && stackPush.empty()) {
                throw new RuntimeException("Queue is empty!");
            }
            pushToPop();
            return stackPop.peek();
        }
    }

    public static void main(String[] args) {
        TwoStacksQueue test = new TwoStacksQueue();
    }
}
