package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

class Node {
    public int value;  // 值
    public int in;  // 入度
    public int out;  // 出度
    public ArrayList<Adj> adjs;  // 与当前节点相连的边和节点
    public Node(int value) {
        this.value = value;
        in = 0;
        out = 0;
        adjs = new ArrayList<>();
    }
}

class Edge {
    public int weight;  // 权重
    public Node from;  // 边的来源
    public Node to;  // 边的指向
    public Edge(int weight, Node from, Node to) {
        this.weight = weight;
        this.from = from;
        this.to = to;
    }
}

class Adj {
    public Node node;
    public Edge edge;
    public Adj(Node node, Edge edge) {
        this.node = node;
        this.edge = edge;
    }
}

class DirectedGraph {
    public HashMap<Integer, Node> nodes;
    public HashSet<Edge> edges;
    public DirectedGraph() {
        nodes = new HashMap<>();
        edges = new HashSet<>();
    }
}

class UndirectedGraph {
    public HashMap<Integer, Node> nodes;
    public HashSet<Edge> edges;
    public UndirectedGraph() {
        nodes = new HashMap<>();
        edges = new HashSet<>();
    }
}