package graph;

import java.util.*;

/**
 * @author kelvin
 * @create 2021-03-18 9:59
 */
public class TopologySort {
    public static List<Node> topologySort(Graph graph) {
        HashMap<Node, Integer> inMap = new HashMap<>();
        Queue<Node> zeroQueue = new LinkedList<>();
        for (Node node : graph.nodes.values()) {
            inMap.put(node, node.in);
            if (node.in == 0) {
                zeroQueue.offer(node);
            }
        }
        List<Node> res = new ArrayList<>();
        while (!zeroQueue.isEmpty()) {
            Node cur = zeroQueue.poll();
            res.add(cur);
            for (Node next : cur.nexts) {
                inMap.put(next, inMap.get(next) - 1);
                if (inMap.get(next) == 0) {
                    zeroQueue.offer(next);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Integer[][] matrix = {
                {1, 1, 4},
                {1, 1, 2},
                {1, 2, 4},
                {1, 2, 3},
                {1, 4, 3},
                {1, 3, 5},
                {1, 4, 5}
        };
        Graph graph = GraphTools.createGraph(matrix, true);
        List<Node> nodes = topologySort(graph);
        for (Node node : nodes) {
            System.out.println(node.value);
        }
    }
}
