package graph;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author kelvin
 * @create 2021-03-17 18:49
 */
public class Traversal {
    public static void bfs(Node node) {
        if (node == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        HashSet<Node> set = new HashSet<>();
        queue.offer(node);
        set.add(node);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            System.out.print(cur.value + " ");
            for (Adj adj : cur.adjs) {
                Node next = adj.node;
                if (!set.contains(next)) {
                    queue.offer(next);
                    set.add(next);
                }
            }
        }
    }

    public static void dfsRecur(Node node) {
        HashSet<Node> set = new HashSet<>();
        dfs(node, set);
    }

    private static void dfs(Node node, HashSet<Node> set) {
        if (node == null) {
            return;
        }
        System.out.print(node.value + " ");
        set.add(node);
        for (Adj adj : node.adjs) {
            Node next = adj.node;
            if (!set.contains(next)) {
                dfs(next, set);
            }
        }
    }

    public static void dfsUnRecur(Node node) {
        if (node == null) {
            return;
        }
        Deque<Node> stack = new LinkedList<>();
        HashSet<Node> set = new HashSet<>();
        stack.push(node);
        set.add(node);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            System.out.print(cur.value + " ");
            for (Adj adj : cur.adjs) {
                Node next = adj.node;
                if (!set.contains(next)) {
                    stack.push(next);
                    set.add(next);
                }
            }
        }
    }

    public static void main(String[] args) {
        Integer[][] matrix = {
                {1, 2, 1},
                {1, 6, 1},
                {1, 2, 3},
                {1, 6, 4},
                {1, 3, 4},
                {1, 6, 5},
                {1, 4, 5}
        };
        System.out.println("============================ direct ====================================");
        DirectedGraph graphDir = GraphTools.createDirectedGraph(matrix);
        Node nodeDir = graphDir.nodes.get(1);
        System.out.println("----------------------- bfs -------------------------");
        bfs(nodeDir);
        System.out.println();
        System.out.println("----------------------- dfsRecur -------------------------");
        dfsRecur(nodeDir);
        System.out.println();
        System.out.println("----------------------- dfsUnRecur -------------------------");
        dfsUnRecur(nodeDir);
        System.out.println();

        System.out.println("======================== undirect ============================");
        UndirectedGraph graphUnDir = GraphTools.createUndirectedGraph(matrix);
        Node nodeUnDir = graphUnDir.nodes.get(1);
        System.out.println("----------------------- bfs -------------------------");
        bfs(nodeUnDir);
        System.out.println();
        System.out.println("----------------------- dfsRecur -------------------------");
        dfsRecur(nodeUnDir);
        System.out.println();
        System.out.println("----------------------- dfsUnRecur -------------------------");
        dfsUnRecur(nodeUnDir);
        System.out.println();

    }
}
