package com.example.algorithm.elementary_1.code07;

import com.example.algorithm.elementary_1.code08.Code01_IsBalanced;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/*************************************************************************
 ******
 * - Copyright (c) 2023 shangzhao.com
 * - File Name: Test
 * - @Author: WangJiLIn
 * - Description:
 * 接⼝描述
 * - Functions:
 *
 * - History:
 * Date        Author          Modification
 * 2023/4/6   WangJiLin     Create the current class
 *************************************************************************
 ******/
public class Test {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.left.left = new Node(4);
        node.left.right = new Node(5);
        node.right.left = new Node(6);
        node.right.right = new Node(7);
        node.right.right.left = new Node(8);
        boolean[] ans = new boolean[1];
        ans[0] = true;
        System.out.println( process1(node,ans));
    }

    public static int process1(Node head, boolean[] ans) {
        if (!ans[0] || head == null) {
            return -1;
        }
        System.out.println("left:" + head.value);
        int leftHeight = process1(head.left, ans);
        System.out.println("right:" + head.value);
        int rightHeight = process1(head.right, ans);
        if (Math.abs(leftHeight - rightHeight) > 1) {
            ans[0] = false;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
