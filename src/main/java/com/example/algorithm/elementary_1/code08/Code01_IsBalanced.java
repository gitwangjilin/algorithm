package com.example.algorithm.elementary_1.code08;

public class Code01_IsBalanced {
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
        System.out.println( isBalanced2(head));
    }

    private static boolean isBalanced2(Node head) {
        return process2(head).isBalaced;

    }

    private static Info process2(Node head) {
        if (head == null) {
            return new Info(true, 0);
        }
        Info leftInfo = process2(head.left);
        Info rightInfo = process2(head.right);
        int height = Math.max(leftInfo.height, leftInfo.height) + 1;
        boolean isBalaced = true;
        if (!leftInfo.isBalaced || !rightInfo.isBalaced || Math.abs(leftInfo.height - rightInfo.height) > 1) {
            isBalaced = false;
        }

        return new Info(isBalaced, height);
    }

    // 左、右要求一样，Info 信息返回的结构体
    public static class Info {
        public boolean isBalaced;
        public int height;

        public Info(boolean b, int h) {
            isBalaced = b;
            height = h;
        }
    }

    private static Node generateRandomBST(int maxLevel, int maxValue) {
        return generate(1, maxLevel, maxValue);
    }

    // for test
    public static Node generate(int level, int maxLevel, int maxValue) {
        if (level > maxLevel || Math.random() < 0.5) {
            return null;
        }
        Node head = new Node((int) (Math.random() * maxValue));
        head.left = generate(level + 1, maxLevel, maxValue);
        head.right = generate(level + 1, maxLevel, maxValue);
        return head;
    }
}
