package com.example.algorithm.elementary_1.code06;

import java.util.Stack;

public class Code02_IsPalindromeList {
    public static void main(String[] args) {
        Node node = null;
        node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(4);
        node.next.next.next.next = new Node(3);
        node.next.next.next.next.next = new Node(2);
        node.next.next.next.next.next.next = new Node(1);
        isPalindrome1(node);
    }

    private static boolean isPalindrome1(Node node) {
        if (node == null || node.next == null || node.next.next == null) {
            return false;
        }
        Stack<Node> nodes = new Stack<>();
        Node cur = node;
        int count = 1;
        while (cur != null) {
            count++;
            nodes.push(cur);
            cur = cur.next;
        }
        int a = (count >> 1);
        System.out.println(a);
        int count1 = 0;
        boolean flag = true;
        while (node.next != null) {
            count1++;
            if (count1 > a) {
                break;
            }
            if (nodes.pop().id != node.id) {
                flag = false;
            }
            node = node.next;
        }
        System.out.println(flag);
        return true;
    }

    public static class Node {
        public int id;
        public Node next;

        public Node(int id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "id=" + id +
                    '}';
        }
    }
}
