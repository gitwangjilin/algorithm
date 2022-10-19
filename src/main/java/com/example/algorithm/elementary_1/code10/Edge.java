package com.example.algorithm.elementary_1.code10;

/*************************************************************************
 ******
 * - Copyright (c) 2022 shangzhao.com
 * - File Name: Edge
 * - @Author: WangJiLIn
 * - Description: 线
 * 接⼝描述
 * - Functions:
 *
 * - History:
 * Date        Author          Modification
 * 2022/10/18   WangJiLin     Create the current class
 *************************************************************************
 ******/
public class Edge {
    /**
     * 线的宽度
     */
    public int weight;
    /**
     * 开始
     */
    public Node from;
    /**
     * 结束
     */
    public Node to;

    public Edge(int weight, Node from, Node to) {
        this.weight = weight;
        this.from = from;
        this.to = to;
    }
}
