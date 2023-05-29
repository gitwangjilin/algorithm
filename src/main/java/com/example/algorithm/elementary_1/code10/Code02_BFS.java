package com.example.algorithm.elementary_1.code10;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

import static com.example.algorithm.elementary_1.code10.GraphGenerator.createGraph;

//宽度优先遍历
public class Code02_BFS {
    public static void main(String[] args) {
        Integer[][] graphArrs = {{5, 1, 4}, {6, 2, 4}, {3, 1, 2}, {2, 4, 7}};
        Graph graph = createGraph(graphArrs);
        bfs(graph.nodes.get(1));
    }

    private static void bfs(Node node) {
        if (node == null) {
            return;
        }
        //队列：先进先出
        Queue<Node> queue = new LinkedList<>();
        //set集合：判断已经打印机过不在打印
        HashSet<Node> set = new HashSet<>();
        queue.add(node);
        set.add(node);
        while (!queue.isEmpty()) {
            //出队列
            Node cur = queue.poll();
            System.out.println(cur.value);
            //获取点下面关联的点
            for (Node next : cur.nexts) {
                //打印过不在入队列
                if (!set.contains(next)) {
                    set.add(next);
                    queue.add(next);
                }
            }
        }
    }
}
