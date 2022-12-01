package com.example.algorithm.elementary_1.code08;

public class Code02_IsFull {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
//        head.left.left.left = new Node(4);
//        head.left.left.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);
        //是否是平衡二叉树
        System.out.println(isFull2(head));
    }
    public static class Info {
        public int height;
        public int nodes;

        public Info(int h, int n) {
            height = h;
            nodes = n;
        }
    }
    private static boolean isFull2(Node head) {
        if (head == null) {
            return true;
        }
        Info all = process(head);
        return (1 << all.height) - 1 == all.nodes;
    }

    private static Info process(Node head) {
        if (head == null) {
            return new Info(0, 0);
        }
        Info leftInfo = process(head.left);
        Info rightInfo = process(head.right);
        int height = Math.max(leftInfo.height, rightInfo.height) + 1;
        int nodes = leftInfo.nodes + rightInfo.nodes + 1;
        return new Info(height, nodes);    }
}
