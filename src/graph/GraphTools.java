package graph;

/**
 * @author kelvin
 * @create 2021-03-17 17:35
 */
public class GraphTools {
    public static DirectedGraph createDirectedGraph(Integer[][] matrix) {
        DirectedGraph graph = new DirectedGraph();
        for (Integer[] info : matrix) {
            // 获取权重, from节点, to节点
            Integer weight = info[0], from = info[1], to = info[2];

            // 如果图的点集里面没有from点, 则加入from点
            if (!graph.nodes.containsKey(from)) {
                graph.nodes.put(from, new Node(from));
            }

            // 如果图的点集里面没有to点, 则加入to点
            if (!graph.nodes.containsKey(to)) {
                graph.nodes.put(to, new Node(to));
            }

            // 获取Node类型的from点和to点
            Node fromNode = graph.nodes.get(from);
            Node toNode = graph.nodes.get(to);

            // 创建对应的边并加入图中
            Edge edge = new Edge(weight, fromNode, toNode);
            graph.edges.add(edge);

            // 创建from点的邻接类型, 并添加给from点
            fromNode.adjs.add(new Adj(toNode, edge));

            // 更新入度和出度
            fromNode.out++;
            toNode.in++;
        }
        return graph;
    }

    public static UndirectedGraph createUndirectedGraph(Integer[][] matrix) {
        UndirectedGraph graph = new UndirectedGraph();
        for (Integer[] info : matrix) {
            // 获取权重, from节点, to节点
            Integer weight = info[0], from = info[1], to = info[2];

            // 如果图的点集里面没有from点, 则加入from点
            if (!graph.nodes.containsKey(from)) {
                graph.nodes.put(from, new Node(from));
            }

            // 如果图的点集里面没有to点, 则加入to点
            if (!graph.nodes.containsKey(to)) {
                graph.nodes.put(to, new Node(to));
            }

            // 获取Node类型的from点和to点
            Node fromNode = graph.nodes.get(from);
            Node toNode = graph.nodes.get(to);

            // 创建对应的边并加入图中
            Edge edge = new Edge(weight, fromNode, toNode);
            graph.edges.add(edge);

            // 创建from点的邻接类型, 并添加给from点
            fromNode.adjs.add(new Adj(toNode, edge));

            // 无向图特有
            // 创建to点的邻接类型, 并添加给to点
            toNode.adjs.add(new Adj(fromNode, edge));

            // 更新入度和出度
            fromNode.out++;
            fromNode.in++;
            toNode.out++;
            toNode.in++;
        }
        return graph;
    }
}
