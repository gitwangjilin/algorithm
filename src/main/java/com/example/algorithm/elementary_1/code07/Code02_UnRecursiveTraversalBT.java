package com.example.algorithm.elementary_1.code07;

import java.util.Stack;

/**
 * 先序中序后序非递归遍历
 */
public class Code02_UnRecursiveTraversalBT {
    public static void main(String[] args) {
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.left.left = new Node(4);
        node.left.right = new Node(5);
        node.right.left = new Node(6);
        node.right.right = new Node(7);
        //先序遍历
        pro(node);
        System.out.println();
        //中序
        in(node);
        System.out.println();
        //后序
        pos(node);
        System.out.println();
        //后序
        pos1(node);
        System.out.println();
    }

    //后序遍历
    private static void pos1(Node head) {
        if (head != null) {
            Stack<Node> stack = new Stack<>();
            Node node = null;
            stack.push(head);
            while (!stack.isEmpty()) {
                node = stack.peek();
                if (node.left != null && head != node.left && head != node.right) {
                    stack.push(node.left);
                } else if (node.right != null && head != node.right) {
                    stack.push(node.right);
                } else {
                    System.out.println(stack.pop().value);
                    head = node;
                }

            }
        }
    }

    //后序遍历
    private static void pos(Node head) {
        if (head != null) {
            Stack<Node> stack1 = new Stack<>();
            Stack<Node> stack2 = new Stack<>();
            stack1.push(head);
            while (!stack1.isEmpty()) {
                head = stack1.pop();
                stack2.push(head);
                if (head.left != null) {
                    stack1.push(head.left);
                }
                if (head.right != null) {
                    stack1.push(head.right);
                }
            }
            while (!stack2.isEmpty()) {
                System.out.println(stack2.pop().value);
            }
        }
    }

    //中序
    private static void in(Node head) {
        Stack<Node> stack = new Stack<>();
        while (!stack.isEmpty() || head != null) {
            if (head != null) {
                stack.push(head);
                head = head.left;
            } else {
                Node pop = stack.pop();
                System.out.println(pop.value);
                head = pop.right;
            }
        }
    }

    //先序
    private static void pro(Node node) {
        if (node != null) {
            Stack<Node> nodes = new Stack<>();
            nodes.push(node);
            while (!nodes.isEmpty()) {
                Node pop = nodes.pop();
                System.out.println(pop.value);
                if (pop.right != null) {
                    nodes.push(pop.right);
                }
                if (pop.left != null) {
                    nodes.push(pop.left);
                }
            }
        }

    }

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int v) {
            value = v;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    '}';
        }
    }
}
