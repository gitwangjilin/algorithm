package com.example.algorithm.elementary_1.code06;

public class Code01_LinkedListMid {
    public static void main(String[] args) {
        Node node = null;
        node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(4);
        node.next.next.next.next = new Node(5);
        node.next.next.next.next.next = new Node(6);
        node.next.next.next.next.next.next = new Node(7);
        node.next.next.next.next.next.next.next = new Node(8);
//        node.next.next.next.next.next.next.next.next = new Node(9);
        //输入链表头节点，奇数返回中点，偶数返回上中点
        Node ans1 = midOrUpMidNode(node);
        System.out.println(ans1);
        //输入链表头节点，奇数返回中点，偶数返回中下点
        ans1 = midOrDownMidNode(node);
        System.out.println(ans1);
        //输入链表头节点，奇数返回中点上一个，偶数返回中点前一个
        ans1 = midOrUpMidPreNode(node);
        System.out.println(ans1);
        //输入链表头节点，奇数返回中点上一个，偶数返回中点下一个
        ans1 = midOrDownMidPreNode(node);
        System.out.println(ans1);
    }

    private static Node midOrDownMidPreNode(Node node) {
        if (node.next == null || node.next.next == null) {
            return null;
        }
        Node slowNode = node;
        Node fastNode = node.next.next;
        while (fastNode.next != null && fastNode.next.next != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }
        return slowNode;
    }

    private static Node midOrUpMidPreNode(Node node) {
        if (node.next == null || node.next.next == null) {
            return null;
        }
        Node slowNode = node;
        Node fastNode = node.next.next;
        while (fastNode.next != null && fastNode.next.next != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }
        return slowNode;
    }

    private static Node midOrDownMidNode(Node node) {
        if (node.next == null || node.next.next == null) {
            return null;
        }
        Node slowNode = node.next;
        Node fastNode = node.next;
        while (fastNode.next != null && fastNode.next.next != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }
        return slowNode;
    }

    private static Node midOrUpMidNode(Node node) {
        if (node.next == null || node.next.next == null) {
            return null;
        }
        Node slowNode = node.next;
        Node fastNode = node.next.next;
        while (fastNode.next != null && fastNode.next.next != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }
        return slowNode;
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
