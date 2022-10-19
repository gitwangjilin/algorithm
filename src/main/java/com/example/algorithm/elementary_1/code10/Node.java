package com.example.algorithm.elementary_1.code10;


import java.util.ArrayList;

/*************************************************************************
 ******
 * - Copyright (c) 2022 shangzhao.com
 * - File Name: Node
 * - @Author: WangJiLIn
 * - Description:
 * 接⼝描述
 * - Functions:
 *
 * - History:
 * Date        Author          Modification
 * 2022/10/18   WangJiLin     Create the current class
 *************************************************************************
 ******/
public class Node {
    /**
     * 点
     */
    public int value;
    /**
     * 连接点
     */
    public int in;
    /**
     * 连出点
     */
    public int out;
    /**
     * 下一个点
     */
    public ArrayList<Node> nexts;
    /**
     * 线
     */
    public ArrayList<Edge> edges;

    public Node(int value) {
        this.value = value;
        this.in = 0;
        this.out = 0;
        this.nexts = new ArrayList<>();
        this.edges = new ArrayList<>();
    }
}
