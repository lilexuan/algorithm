package heap_queue;

import java.util.HashMap;
import java.util.Map;

/**
 * @author kelvin
 * @create 2021-04-24 10:43
 */
public class TopKRecord {
    private NodeTKR[] heap;
    private Map<String, NodeTKR> strNodeMap;
    private Map<NodeTKR, Integer> nodeIndexMap;
    private int heapSize;

    public TopKRecord(int size) {
        heap = new NodeTKR[size];
        strNodeMap = new HashMap<>();
        nodeIndexMap = new HashMap<>();
        int index = 0;
    }

    /**
     * 从下往上调整
     *
     * @param index
     */
    private void heapInsert(int index) {
        while (index != 0) {
            int parent = (index - 1) / 2;
            // 我们构建小根堆, 小的在上面
            if (heap[index].cnt < heap[parent].cnt) {
                swap(index, parent);
                index = parent;
            } else {
                break;
            }
        }
    }

    /**
     * 从上往下调整
     *
     * @param index
     * @param heapSize
     */
    private void heapify(int index, int heapSize) {
        int left = index * 2 + 1, right = index * 2 + 2;
        int smallest = index;
        while (left < heapSize) {
            if (heap[left].cnt < heap[index].cnt) {
                smallest = left;
            }
            if (right < heapSize && heap[right].cnt < heap[smallest].cnt) {
                smallest = right;
            }
            if (index != smallest) {
                swap(index, smallest);
            } else {
                break;
            }
            index = smallest;
            left = index * 2 + 1;
            right = index * 2 + 2;
        }
    }


    private void swap(int i, int j) {
        NodeTKR tmp = heap[i];
        heap[i] = heap[j];
        heap[j] = tmp;
        nodeIndexMap.put(heap[i], i);
        nodeIndexMap.put(heap[j], j);
    }

    public void add(String str) {
        NodeTKR node = null;
        int preIndex = -1;  // 表示这个节点之前的index

        // 如果从来没有这个节点, 那么新建并加入, 否则就提取已经有的节点
        if (!strNodeMap.containsKey(str)) {
            node = new NodeTKR(str, 1);
            strNodeMap.put(str, node);
            nodeIndexMap.put(node, -1);  // -1表示从来没有进堆
        } else {
            node = strNodeMap.get(str);
            node.cnt++;
            preIndex = nodeIndexMap.get(node);
        }

        // 如果这个节点不在堆里面, 那么尝试将他加入堆
        // 否则说明这个节点是在堆里面, heapify
        if (preIndex == -1) {
            // 如果堆满了, 需要比较才能加入, 否则可以直接加入
            if (this.heapSize == heap.length) {
                if (node.cnt > heap[0].cnt) {
                    // 加入先需要弹出堆顶节点
                    nodeIndexMap.put(heap[0], -1);
                    nodeIndexMap.put(node, 0);
                    heap[0] = node;
                    heapify(0, heapSize);
                }
            } else {
                heap[heapSize] = node;
                nodeIndexMap.put(node, heapSize);
                heapInsert(heapSize);
                heapSize++;
            }
        } else {
            heapify(preIndex, heapSize);
        }
    }

    public void printTopK() {
        System.out.println("Top: ");
        for (int i = heapSize - 1; i >= 0; i--) {
            System.out.print("Str: " + heap[i].str);
            System.out.println(" Cnt: " + heap[i].cnt);
        }
    }

    public static void main(String[] args) {
        TopKRecord topKRecord = new TopKRecord(2);
        topKRecord.add("li");
        topKRecord.printTopK();
        topKRecord.add("le");
        topKRecord.add("le");
        topKRecord.printTopK();
        topKRecord.add("xuan");
        topKRecord.add("xuan");
        topKRecord.printTopK();
    }
}

class NodeTKR {
    String str;
    int cnt;

    public NodeTKR(String str, int cnt) {
        this.str = str;
        this.cnt = cnt;
    }
}