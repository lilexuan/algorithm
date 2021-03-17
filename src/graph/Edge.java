package graph;

/**
 * @author kelvin
 * @create 2021-03-17 17:25
 */
public class Edge {
    public int weight;  // 权重
    public Node from;  // 边的来源
    public Node to;  // 边的指向
    public Edge(int weight, Node from, Node to) {
        this.weight = weight;
        this.from = from;
        this.to = to;
    }
    public Edge(int weight) {
        this.weight = weight;
        this.from = null;
        this.to = null;
    }
}
