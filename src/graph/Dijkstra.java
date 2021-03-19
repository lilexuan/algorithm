package graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author kelvin
 * @create 2021-03-19 9:36
 */
public class Dijkstra {
    public static HashMap<Node, Integer> dijkstra(Node head) {
        HashMap<Node, Integer> distanceMap = new HashMap<>();
        HashSet<Node> selectedNodes = new HashSet<>();
        distanceMap.put(head, 0);
        Node minNode = getMinDistanceAndUnselectedNode(distanceMap, selectedNodes);
        while (minNode != null) {
            int distance = distanceMap.get(minNode);
            for (Adj adj : minNode.adjs) {
                if (!distanceMap.containsKey(adj.node)) {
                    distanceMap.put(adj.node, distance + adj.edge.weight);
                }else {
                    distanceMap.put(adj.node, Math.min(distance + adj.edge.weight, distanceMap.get(adj.node)));
                }
            }
            selectedNodes.add(minNode);
            minNode = getMinDistanceAndUnselectedNode(distanceMap, selectedNodes);
        }
        return distanceMap;
    }

    private static Node getMinDistanceAndUnselectedNode(HashMap<Node, Integer> distanceMap, HashSet<Node> selectedNodes) {
        int min = Integer.MAX_VALUE;
        Node res = null;
        for (Map.Entry<Node, Integer> entry : distanceMap.entrySet()) {
            Node node = entry.getKey();
            int distance = entry.getValue();
            if (!selectedNodes.contains(node) && distance < min) {
                min = distance;
                res = node;
            }
        }
        return res;
    }

    private static class NodeRecord {
        public Node node;
        public int distance;
        public NodeRecord(Node node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }

    private static class NodeHeap {
        private Node[] nodes;  // 用数组存储节点, 堆的底层就是数组
        private HashMap<Node, Integer> heapIndexMap;  // 用于找到节点在数组中的索引
        private HashMap<Node, Integer> distanceMap;  // 记录从起始节点出发到node的最短距离
        private int size;  // 当前堆有多少个节点
        public NodeHeap(int size) {
            this.nodes = new Node[size];
            heapIndexMap = new HashMap<>();
            distanceMap = new HashMap<>();
            this.size = 0;
        }

        /**
         * 如果node在堆上面, 则比较原来的distance和新传进来的distance, 那个小就更新哪一个
         * 如果node没有进过堆, 那么就新建记录
         * 如果node进过堆, 但是现在不在堆上了, 说明node已经是确定了最短路径的节点了, ignore
         * @param node
         * @param distance
         */
        public void addOrUpdateOrIgnore(Node node, int distance) {
            if (isInHeap(node)) {
                distanceMap.put(node, Math.min(distanceMap.get(node), distance));
                insertHeapify(node, heapIndexMap.get(node));
            }
            if (!isEntered(node)) {
                nodes[size] = node;
                distanceMap.put(node, distance);
                heapIndexMap.put(node, size);
                insertHeapify(node, size);
                size++;
            }

        }

        public boolean isEmpty() {
            return size == 0;
        }

        public NodeRecord pop() {
            NodeRecord nodeRecord = new NodeRecord(nodes[0], distanceMap.get(nodes[0]));
            swap(0, size - 1);
            heapIndexMap.put(nodes[size - 1], -1);
            distanceMap.remove(nodes[size - 1]);
            nodes[size - 1] = null;
            size--;
            heapify(0, size);
            return nodeRecord;
        }

        /**
         * 判断一个node是否曾经进入过堆, 如果已经不在这个堆里面, heapIndexMap.get(node)返回-1
         * @param node
         * @return
         */
        private boolean isEntered(Node node) {
            return heapIndexMap.containsKey(node);
        }

        /**
         * 判断一个node是否在堆上面, 如果曾经进入过堆, 且heapIndexMap的value不是-1, 则说明node在堆上面
         * @param node
         * @return
         */
        private boolean isInHeap(Node node) {
            return isEntered(node) && heapIndexMap.get(node) != -1;
        }

        /**
         * 交换两个node在nodes上的位置, 同时需要更新heapIndexMap
         * @param index1
         * @param index2
         */
        private void swap(int index1, int index2) {
            heapIndexMap.put(nodes[index1], index2);
            heapIndexMap.put(nodes[index2], index1);
            Node tmp = nodes[index1];
            nodes[index1] = nodes[index2];
            nodes[index2] = tmp;
        }

        private void insertHeapify(Node node, int index) {
            while (distanceMap.get(nodes[index]) < distanceMap.get(nodes[(index - 1) / 2])) {
                swap(index, (index - 1) / 2);
                index = (index - 1) / 2;
            }
        }

        private void heapify(int index, int size) {
            int left = index * 2 + 1;
            while (left < index) {
                int smallest = left + 1 < size && distanceMap.get(nodes[left + 1]) < distanceMap.get(nodes[left]) ?
                        left + 1 : left;
                smallest = distanceMap.get(nodes[smallest]) < distanceMap.get(nodes[index]) ? smallest : index;
                if (smallest == index) {
                    break;
                }
                swap(smallest, index);
                index = smallest;
                left = 2 * index + 1;
            }
        }
    }

    public static HashMap<Node, Integer> dijkstraPlus(Node head, int size) {
        NodeHeap nodeHeap = new NodeHeap(size);
        HashMap<Node, Integer> result = new HashMap<>();
        nodeHeap.addOrUpdateOrIgnore(head, 0);
        while (!nodeHeap.isEmpty()) {
            NodeRecord nodeRecord = nodeHeap.pop();
            Node cur = nodeRecord.node;
            int distance = nodeRecord.distance;
            for (Adj adj : cur.adjs) {
                nodeHeap.addOrUpdateOrIgnore(adj.node, adj.edge.weight + distance);
            }
            result.put(cur, distance);
        }
        return result;
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
        DirectedGraph directedGraph = GraphTools.createDirectedGraph(matrix);
        UndirectedGraph undirectedGraph = GraphTools.createUndirectedGraph(matrix);
        HashMap<Node, Integer> resDir = dijkstra(directedGraph.nodes.get(1));
        HashMap<Node, Integer> reseUndir = dijkstra(undirectedGraph.nodes.get(1));
        System.out.println("=========dir==============");
        for (Map.Entry<Node, Integer> entry : resDir.entrySet()) {
            System.out.println("Node" + entry.getKey().value + "->" + entry.getValue());
        }
        System.out.println("=========undir==============");
        for (Map.Entry<Node, Integer> entry : reseUndir.entrySet()) {
            System.out.println("Node" + entry.getKey().value + "->" + entry.getValue());
        }

        System.out.println("=======================plus=========================");
        HashMap<Node, Integer> resDirP = dijkstraPlus(directedGraph.nodes.get(1), 6);
        HashMap<Node, Integer> reseUndirP = dijkstraPlus(undirectedGraph.nodes.get(1), 6);
        System.out.println("=========dir==============");
        for (Map.Entry<Node, Integer> entry : resDirP.entrySet()) {
            System.out.println("Node" + entry.getKey().value + "->" + entry.getValue());
        }
        System.out.println("=========undir==============");
        for (Map.Entry<Node, Integer> entry : reseUndirP.entrySet()) {
            System.out.println("Node" + entry.getKey().value + "->" + entry.getValue());
        }

    }
}
