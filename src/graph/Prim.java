package graph;

import java.util.*;

/**
 * @author kelvin
 * @create 2021-03-18 20:50
 */
public class Prim {
    public static Set<Edge> prim(UndirectedGraph graph) {
        Set<Edge> res = new HashSet<>();
        Set<Node> set = new HashSet<>();
        PriorityQueue<Edge> minHeap = new PriorityQueue<>((o1, o2) -> {
            return o1.weight - o2.weight;
        });
        for (Node node : graph.nodes.values()) {
            if (!set.contains(node)) {
                set.add(node);
                for (Adj adj : node.adjs) {
                    Edge edge = adj.edge;
                    minHeap.offer(edge);
                }
                while (!minHeap.isEmpty()) {
                    Edge edge = minHeap.poll();
                    if (!set.contains(edge.to)) {
                        set.add(edge.to);
                        res.add(edge);
                        for (Adj adj : edge.to.adjs) {
                            Edge nextEdge = adj.edge;
                            minHeap.offer(nextEdge);
                        }
                    } else if (!set.contains(edge.from)) {
                        // 我觉得左神这里漏写了, 因为这条边被加进来肯定是其中一个节点被看过了, 但这个节点
                        // 不一定是toNode, 也有可能是fromNode, 所以一条边的两个节点都得检查
                        set.add(edge.from);
                        res.add(edge);
                        for (Adj adj : edge.from.adjs) {
                            Edge nextEdge = adj.edge;
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
                {6, 5, 6}
        };
        UndirectedGraph graph = GraphTools.createUndirectedGraph(matrix);
        Set<Edge> edges = prim(graph);
        for (Edge edge : edges) {
            System.out.println(edge.from.value + "-" + edge.to.value);
        }
    }
}
