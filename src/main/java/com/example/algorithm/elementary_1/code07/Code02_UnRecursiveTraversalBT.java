package com.example.algorithm.elementary_1.code07;

import java.util.Stack;

/*************************************************************************
 ******
 * - Copyright (c) 2022 shangzhao.com
 * - File Name: Code02_UnRecursiveTraversalBT
 * - @Author: WangJiLIn
 * - Description:
 * 接⼝描述
 * - Functions:
 *
 * - History:
 * Date        Author          Modification
 * 2022/11/26   WangJiLin     Create the current class
 *************************************************************************
 ******/
public class Code02_UnRecursiveTraversalBT {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int v) {
            value = v;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);
        //非递归打印二叉树
        pre(head);
        System.out.println("========");
        in(head);
        System.out.println("========");
        pos1(head);
        System.out.println("========");
        pos2(head);
        System.out.println("========");
    }

    private static void pos2(Node head) {
        if (head != null) {
            Stack<Node> stack = new Stack<>();
            stack.push(head);
            Node c = null;
            while (!stack.isEmpty()) {
                c = stack.peek();
                if (c.left != null && head != c.left && head != c.right) {
                    stack.push(c.left);
                } else if (c.right != null && head != c.right) {
                    stack.push(c.right);
                } else {
                    System.out.print(stack.pop().value);
                    head = c;
                }
            }
        }
    }

    private static void pos1(Node head) {
        if (head != null) {
            Stack<Node> s1 = new Stack<>();
            Stack<Node> s2 = new Stack<>();
            s1.push(head);
            while (!s1.isEmpty()) {
                head = s1.pop();
                s2.push(head);
                if (head.left != null) {
                    s1.push(head.left);
                }
                if (head.right != null) {
                    s1.push(head.right);
                }
            }
            while (!s2.isEmpty()) {
                Node pop = s2.pop();
                System.out.print(pop.value + " ");
            }
        }
    }

    private static void in(Node head) {
        if (head == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        while (!stack.isEmpty() || head != null) {
            if (head != null) {
                stack.push(head);
                head = head.left;
            } else {
                Node pop = stack.pop();
                System.out.print(pop.value + " ");
                head = pop.right;
            }
        }
        System.out.println();
    }

    private static void pre(Node head) {
        if (head == null) {
            return;
        }
        Stack<Node> nodes = new Stack<>();
        nodes.push(head);
        while (!nodes.isEmpty()) {
            Node pop = nodes.pop();
            System.out.print(pop.value + "");
            if (pop.right != null) {
                nodes.push(pop.right);
            }
            if (pop.left != null) {
                nodes.push(pop.left);
            }
        }
    }
}
