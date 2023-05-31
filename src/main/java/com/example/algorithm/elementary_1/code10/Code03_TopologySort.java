package com.example.algorithm.elementary_1.code10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import static com.example.algorithm.elementary_1.code10.GraphGenerator.createGraph;

public class Code03_TopologySort {
    public static void main(String[] args) {
        Integer[][] graphArrs = {{5, 1, 4}, {6, 2, 4}, {3, 1, 2}, {2, 4, 7}};
        Graph graph = createGraph(graphArrs);
        List<Node> nodeList = sortedTopology(graph);
        for (Node node : nodeList) {
            System.out.println(node.value);
        }
    }

    private static List<Node> sortedTopology(Graph graph) {
        HashMap<Node, Integer> inMap = new HashMap<>();
        LinkedList<Node> zeroInQueue = new LinkedList<>();
        //将所以点放入Map中做为一个查询
        //将入度为0的先找到放在集合中
        for (Node node : graph.nodes.values()) {
            inMap.put(node, node.in);
            if (node.in == 0) {
                zeroInQueue.add(node);
            }
        }
        ArrayList<Node> result = new ArrayList<>();
        //遍历入度为0的所有下个节点
        while (!zeroInQueue.isEmpty()) {
            Node cur = zeroInQueue.poll();
            //返回节点
            result.add(cur);
            //遍历下个节点
            for (Node next : cur.nexts) {
                //更新集合中节点入度值
                inMap.put(next, inMap.get(next) - 1);
                //如果为0添加返回
                if (inMap.get(next) == 0) {
                    zeroInQueue.add(next);
                }
            }
        }
        return result;
    }
}
