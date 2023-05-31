package com.example.algorithm.elementary_1.code10;

import java.util.HashSet;
import java.util.Stack;

import static com.example.algorithm.elementary_1.code10.GraphGenerator.createGraph;

public class Code02_DFS {

    public static void main(String[] args) {
        Integer[][] graphArrs = {{5, 1, 4}, {6, 2, 4}, {3, 1, 2}, {2, 4, 7}};
        Graph graph = createGraph(graphArrs);
        dfs(graph.nodes.get(1));
    }

    private static void dfs(Node node) {
        if (node == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        HashSet<Node> set = new HashSet<>();
        stack.add(node);
        set.add(node);
        System.out.println(node.value);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            for (Node next : cur.nexts) {
                if (!set.contains(next)) {
                    stack.push(cur);
                    stack.push(next);
                    set.add(next);
                    System.out.println(next.value);
                    break;
                }
            }
        }
    }
}
