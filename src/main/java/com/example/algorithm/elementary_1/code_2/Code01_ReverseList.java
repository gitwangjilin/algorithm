package com.example.algorithm.elementary_1.code_2;

/*************************************************************************
 ******
 * - Copyright (c) 2022 shangzhao.com
 * - File Name: Code01_Reatv
 * - @Author: WangJiLIn
 * - Description:
 * 接⼝描述
 * - Functions:
 *
 * - History:
 * Date        Author          Modification
 * 2022/9/26   WangJiLin     Create the current class
 *************************************************************************
 ******/
public class Code01_ReverseList {
    public static void main(String[] args) {
        NodeTest nodeTest = new NodeTest();
        nodeTest.add(new Node(1, "小王"));
        nodeTest.add(new Node(2, "小罗"));
        nodeTest.add(new Node(3, "小王1"));
    }
}

class NodeTest {
    private static Node tempNode = new Node(-1, "");

    public void add(Node node) {
        if (node == null) {
            return;
        }
        Node helpNode = tempNode;
        while (helpNode.getNode() != null) {
            helpNode = helpNode.getNode();
        }
        helpNode.setNode(node);
    }

    public void look() {
        Node helpNode = tempNode;
        while (helpNode.getNode() != null) {
            System.out.println(helpNode.getNode());
            helpNode = helpNode.getNode();
        }
    }

    public void reversed() {
        if (tempNode.getNode() == null) {
            return;
        }
        Node helpNode = tempNode.getNode().getNode();
        Node temp = new Node(-1, "");
        while (tempNode.getNode() != null) {
            temp.setNode(tempNode.getNode());
            helpNode = tempNode.getNode();
            helpNode = tempNode.getNode();
            tempNode = helpNode;
        }
    }
}

class Node {
    private int id;
    private String name;
    private Node node;

    public Node(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Node getNode() {
        return node;
    }

    public void setNode(Node node) {
        this.node = node;
    }

    @Override
    public String toString() {
        return "Node{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}