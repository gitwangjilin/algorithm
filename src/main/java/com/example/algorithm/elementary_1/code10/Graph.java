package com.example.algorithm.elementary_1.code10;

import java.util.HashMap;
import java.util.HashSet;

/*************************************************************************
 ******
 * - Copyright (c) 2022 shangzhao.com
 * - File Name: Graph
 * - @Author: WangJiLIn
 * - Description:  图
 * 接⼝描述
 * - Functions:
 *
 * - History:
 * Date        Author          Modification
 * 2022/10/20   WangJiLin     Create the current class
 *************************************************************************
 ******/
public class Graph {
    //编号为1点的描述 编号为2点的描述
    public HashMap<Integer, Node> nodes;
    //边集
    public HashSet<Edge> edges;

    public Graph() {
        nodes = new HashMap<>();
        edges = new HashSet<>();
    }
}
