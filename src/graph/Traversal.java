package graph;

import javax.lang.model.element.VariableElement;
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
            for (Node next : cur.nexts) {
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
        for (Node next : node.nexts) {
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
            for (Node next : cur.nexts) {
                if (!set.contains(next)) {
                    stack.push(next);
                    set.add(next);
                }
            }
        }
    }

    public static void main(String[] args) {
        Integer[][] matrix = {
                {1, 1, 2},
                {1, 1, 6},
                {1, 2, 3},
                {1, 6, 4},
                {1, 3, 4},
                {1, 6, 5},
                {1, 4, 5}
        };
        Graph graph = GraphTools.createGraph(matrix);
        Node node = graph.nodes.get(1);
        System.out.println("----------------------- bfs -------------------------");
        bfs(node);
        System.out.println();
        System.out.println("----------------------- dfsRecur -------------------------");
        dfsRecur(node);
        System.out.println();
        System.out.println("----------------------- dfsUnRecur -------------------------");
        dfsUnRecur(node);
        System.out.println();
    }
}
