package graph;

import java.util.*;

/**
 * @author kelvin
 * @create 2021-03-18 20:50
 */
public class Prim {
    public static Set<Edge> prim(Graph graph) {
        Set<Edge> res = new HashSet<>();
        Set<Node> set = new HashSet<>();
        PriorityQueue<Edge> minHeap = new PriorityQueue<>((o1, o2) -> {
            return o1.weight - o2.weight;
        });
        for (Node node : graph.nodes.values()) {
            if (!set.contains(node)) {
                set.add(node);
                for (Edge edge : node.edges) {
                    minHeap.offer(edge);
                }
                while (!minHeap.isEmpty()) {
                    Edge edge = minHeap.poll();
                    if (!set.contains(edge.to)) {
                        set.add(edge.to);
                        res.add(edge);
                        for (Edge nextEdge : edge.to.edges) {
                            minHeap.offer(nextEdge);
                        }
                    } else if (!set.contains(edge.from)) {
                        // 我觉得左神这里漏写了, 因为这条边被加进来肯定是其中一个节点被看过了, 但这个节点
                        // 不一定是toNode, 也有可能是fromNode, 所以一条边的两个节点都得检查
                        set.add(edge.from);
                        res.add(edge);
                        for (Edge nextEdge : edge.from.edges) {
                            minHeap.offer(nextEdge);
                        }
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Integer[][] matrix = {
                {6, 1, 2},
                {5, 1, 3},
                {1, 1, 4},
                {5, 2, 4},
                {5, 3, 4},
                {3, 2, 5},
                {6, 4, 5},
                {4, 4, 6},
                {2, 3, 6},
                {5, 5, 6}
        };
        Graph graph = GraphTools.createGraph(matrix, false);
        Set<Edge> edges = prim(graph);
        for (Edge edge : edges) {
            System.out.println(edge.from.value + "-" + edge.to.value);
        }
    }
}
