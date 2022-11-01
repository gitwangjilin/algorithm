package com.example.algorithm.elementary_1.code02;

import java.util.Queue;

/*************************************************************************
 ******
 * - Copyright (c) 2022 shangzhao.com
 * - File Name: Code07_TwoQueueImplementStack
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
public class Code07_TwoQueueImplementStack {
    public static class TwoQueueStack<T> {
        public Queue<T> queue;
        public Queue<T> help;

        public boolean isEmpty() {
            return queue.isEmpty();
        }

        public void push(T value) {
            queue.offer(value);
        }

        public T peek() {
            while (queue.size() > 1) {
                help.offer(queue.poll());
            }
            T ans = queue.poll();
            help.offer(ans);
            Queue<T> tmp = queue;
            queue = help;
            help = tmp;
            return ans;
        }

        public T poll() {
            while (queue.size() > 1) {
                help.offer(queue.poll());
            }
            T ans = queue.poll();
            Queue<T> tmp = queue;
            queue = help;
            help = tmp;
            return ans;
        }
    }

    public static void main(String[] args) {
        TwoQueueStack<Integer> myStack = new TwoQueueStack<>();
    }
}
