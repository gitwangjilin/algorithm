package com.example.algorithm.elementary_1.code02;

/*************************************************************************
 ******
 * - Copyright (c) 2022 shangzhao.com
 * - File Name: Code02_DeleteGivenValue
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
public class Code02_DeleteGivenValue {
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

    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        println(node);
        println(removeValue(node, 2));


    }

    /**
     * 遍历链表
     *
     * @param node
     */
    private static void println(Node node) {
        while (node != null) {
            System.out.println(node.value);
            node = node.next;
        }
    }

    /**
     * 删除指定链表
     *
     * @param head
     * @param num
     * @return
     */
    private static Node removeValue(Node head, int num) {
        //判断链表中是否有值
        while (head != null) {
            if (head.value != num) {
                break;
            }
            head = head.next;
        }
        //将链表定义两个变量来跳动使用
        //保留当前链表
        Node pro = head;
        //跳动下个链表
        Node cur = head;
        while (cur != null) {
            if (cur.value == num) {
                //将当前的
                pro.next = cur.next;
                break;
            } else {
                pro = cur;
            }
            cur = cur.next;
        }
        return head;
    }
}
