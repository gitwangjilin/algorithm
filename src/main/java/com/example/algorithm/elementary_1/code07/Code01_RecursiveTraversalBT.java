package com.example.algorithm.elementary_1.code07;

/**
 * 先序中序后序递归遍历
 */
public class Code01_RecursiveTraversalBT {
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

    }

    //后序遍历
    private static void pos(Node node) {
        if (node == null) {
            return;
        }
        in(node.left);
        in(node.right);
        System.out.print(node.value);
    }

    //中序遍历
    private static void in(Node node) {
        if (node == null) {
            return;
        }
        in(node.left);
        System.out.print(node.value);
        in(node.right);
    }

    //前序遍历
    private static void pro(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.value);
        pro(node.left);
        pro(node.right);
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
