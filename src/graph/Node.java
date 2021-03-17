package graph;


import java.util.ArrayList;

/**
 * @author kelvin
 * @create 2021-03-17 17:10
 */
public class Node {
    public int value;  // 值
    public int in;  // 入度
    public int out;  // 出度
    public ArrayList<Node> nexts;  // 与当前节点相连的节点们
    public ArrayList<Edge> edges;  // 与当前节点相连的边
    public Node(int value) {
        this.value = value;
        in = 0;
        out = 0;
        nexts = new ArrayList<>();
        edges = new ArrayList<>();
    }
}
