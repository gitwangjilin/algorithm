package com.example.algorithm.elementary_1.code02;

/*************************************************************************
 ******
 * - Copyright (c) 2022 shangzhao.com
 * - File Name: Code01_ReverseList
 * - @Author: WangJiLIn
 * - Description:
 * 接⼝描述
 * - Functions:
 *
 * - History:
 * Date        Author          Modification
 * 2022/10/25   WangJiLin     Create the current class
 *************************************************************************
 ******/
public class Code01_ReverseList {
    public static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    '}';
        }
    }

    public static class DoubleNode {
        public int value;
        public DoubleNode last;
        public DoubleNode next;

        public DoubleNode(int data) {
            value = data;
        }
    }

    /**
     * 反转单链表
     *
     * @param head
     * @return
     */
    public static Node reverseLinkedList(Node head) {
        //如果链表为空或者只一个值就不用反转
        if (head == null || head.next == null) {
            return head;
        }
        //新链表
        Node pro = null;
        //临时缓存链表中的下一个值
        Node next;
        while (head != null) {
            //缓存链表
            next = head.next;
            //将新链表的值给原始链表
            head.next = pro;
            //将反转的链表给新链表
            pro = head;
            //缓存的链表给原始链表
            head = next;
        }
        return pro;
    }

    /**
     * 双向链表反转
     *
     * @param head
     * @return
     */
    public static DoubleNode reverseDoubleList(DoubleNode head) {
        //如果链表为空或者只一个值就不用反转
        if (head == null || head.next == null) {
            return head;
        }
        DoubleNode pro = null;
        DoubleNode next;
        while (head != null) {
            next = head.next;
            head.next = pro;
            head.last = next;
            pro = head;
            head = next;
        }
        return pro;
    }


    /**
     * 打印链表
     *
     * @param head
     */
    public static void println(Node head) {
        if (head == null) {
            System.out.println("head中没有值");
        }
        while (head.next != null) {
            System.out.println(head.value);
            head = head.next;
        }
    }

    public static void main(String[] args) {
        //单链表
        Node node = new Node(0);
        node.next = new Node(1);
        node.next.next = new Node(2);
        node.next.next.next = new Node(3);
        //打印反转后的值
        println(reverseLinkedList(node));
        //双向链表
        DoubleNode doubleNode = new DoubleNode(1);
        doubleNode.next = new DoubleNode(2);
        doubleNode.last = doubleNode;
        doubleNode.next.next = new DoubleNode(3);
        doubleNode.last.last = doubleNode.next;
    }

}
