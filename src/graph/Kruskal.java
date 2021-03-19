package graph;

import unionFind.UnionFind;

import java.util.*;

/**
 * @author kelvin
 * @create 2021-03-18 16:09
 */
public class Kruskal {
    public static Set<Edge> kruskal(UndirectedGraph graph) {
        Set<Edge> res = new HashSet<>();
        UnionFind<Node> uf = new UnionFind<>();
        uf.init(new ArrayList<>(graph.nodes.values()));
        PriorityQueue<Edge> minHeap = new PriorityQueue<>((o1, o2) -> {
            return o1.weight - o2.weight;
        });
        for (Edge edge : graph.edges) {
            minHeap.offer(edge);
        }
        while (!minHeap.isEmpty()) {
            Edge curEdge = minHeap.poll();
            if (!uf.isUnion(curEdge.to, curEdge.from)) {
                res.add(curEdge);
                uf.union(curEdge.to, curEdge.from);
//                System.out.println("edge:" + curEdge.from.value + "-" + curEdge.to.value);
//                System.out.println("uf:");
//                printUF(uf);
            }

        }
        return res;
    }

    private static void printUF(UnionFind<Node> uf) {
        System.out.println("--------- uf start  --------------");
        for (Node node : uf.parent.keySet()) {
            System.out.println(node.value + "->" + uf.findParent(node).value);
        }
        System.out.println("---------- uf end -----------------");
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
        Set<Edge> edges = kruskal(graph);
        for (Edge edge : edges) {
            System.out.println(edge.from.value + "-" + edge.to.value);
        }
    }
}
