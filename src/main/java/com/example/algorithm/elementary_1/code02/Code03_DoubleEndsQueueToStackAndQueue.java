package com.example.algorithm.elementary_1.code02;

/*************************************************************************
 ******
 * - Copyright (c) 2022 shangzhao.com
 * - File Name: Code03_DoubleEndsQueueToStackAndQueue
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
public class Code03_DoubleEndsQueueToStackAndQueue {
    public static class Node<T> {
        /**
         * 参数
         */
        public T value;
        /**
         * 前节点
         */
        public Node<T> last;
        /**
         * 后节点
         */
        public Node<T> next;

        public Node(T value) {
            this.value = value;
        }
    }

    public static class DoubleEndsQueue<T> {
        //头节点
        public Node<T> head;
        //尾结点
        public Node<T> tail;

        /**
         * 添加头节点
         *
         * @param value
         */
        public void addFromHead(T value) {
            Node<T> cur = new Node<>(value);
            //如果为空头尾节点都指向node
            if (head == null) {
                head = cur;
                tail = cur;
            } else {
                //cur的下个节点为head,head的上个节点为cur,在将最新的cur给head
                cur.next = head;
                head.last = cur;
                head = cur;
            }
        }

        /**
         * 从尾结点开始添加
         *
         * @param value
         */
        public void addFromBottom(T value) {
            Node<T> cur = new Node<>(value);
            if (head == null) {
                head = cur;
                tail = cur;
            } else {
                cur.last = tail;
                tail.next = cur;
                tail = cur;
            }
        }

        /**
         * 弹出头节点
         *
         * @return
         */
        public T popFromHead() {
            if (head == null) {
                return null;
            }
            Node<T> cur = head;
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                head = head.next;
                cur.next = null;
                head.last = null;
            }
            return cur.value;
        }

        public boolean isEmpty() {
            return head == null;
        }

        /**
         * 出队列
         *
         * @return
         */
        public T popFromBottom() {
            if (head == null) {
                return null;
            }
            Node<T> cur = tail;
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                tail = tail.last;
                tail.next = null;
                cur.last = null;
            }
            return cur.value;
        }
    }

    /**
     * 队列
     *
     * @param <T>
     */
    public static class MyStack<T> {
        private DoubleEndsQueue<T> queue;

        public MyStack() {
            queue = new DoubleEndsQueue<T>();
        }

        public void push(T value) {
            queue.addFromHead(value);
        }

        public T pop() {
            return queue.popFromHead();
        }

        public boolean isEmpty() {
            return queue.isEmpty();
        }

    }

    /**
     * 栈
     *
     * @param <T>
     */
    public static class MyQueue<T> {
        private DoubleEndsQueue<T> queue;

        public MyQueue() {
            queue = new DoubleEndsQueue<T>();
        }

        public void push(T value) {
            queue.addFromHead(value);
        }

        public T poll() {
            return queue.popFromBottom();
        }

        public boolean isEmpty() {
            return queue.isEmpty();
        }

    }

    /**
     * 双向链表实现栈和队列
     *
     * @param args
     */
    public static void main(String[] args) {
        MyStack<Integer> myStack = new MyStack<>();
        MyQueue<Integer> myQueue = new MyQueue<>();
        for (int i = 0; i < 5; i++) {
            //栈中加数据
            myStack.push(i);
            //队列中加数据
            myQueue.push(i);
        }
        myStack.pop();
        myQueue.poll();
    }
}
