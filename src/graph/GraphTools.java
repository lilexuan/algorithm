package graph;

/**
 * @author kelvin
 * @create 2021-03-17 17:35
 */
public class GraphTools {
    public static Graph createGraph(Integer[][] matrix, boolean direct) {
        Graph graph = new Graph();
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

            // from点加上to点,如果是无向图, 则to点也要加上from点, 记得更新对应的出度和入度
            fromNode.nexts.add(toNode);
            fromNode.out++;
            toNode.in++;
            if (!direct) {
                toNode.nexts.add(fromNode);
                toNode.out++;
                fromNode.in++;
            }

            // 创建对应的边
            Edge edge = new Edge(weight, fromNode, toNode);

            // from点加上这条边, 如果是无向图, 则to点也要加上这条边.
            fromNode.edges.add(edge);
            if (!direct) {
                toNode.edges.add(edge);
            }

            // 图中加上这条边
            graph.edges.add(edge);
        }
        return graph;
    }
}
