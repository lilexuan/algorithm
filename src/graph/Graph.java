package graph;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author kelvin
 * @create 2021-03-17 17:33
 */
public class Graph {
    public HashMap<Integer, Node> nodes;
    public HashSet<Edge> edges;

    public Graph() {
        nodes = new HashMap<>();
        edges = new HashSet<>();
    }
}
