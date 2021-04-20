package heap_queue;

import string.StringTools;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKTimes {
    private static class Node {
        String str;
        int cnt;
        public Node(String str, int cnt) {
            this.str = str;
            this.cnt = cnt;
        }
    }

    public static void getTopK(String[] strs, int k) {
        if (strs == null || strs.length == 0) {
            return;
        }
        Map<String, Integer> map = new HashMap<>();
        for (String str : strs) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        PriorityQueue<Node> minHeap = new PriorityQueue<>((n1, n2) -> {
            return n1.cnt - n2.cnt;
        });
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            Node node = new Node(entry.getKey(), entry.getValue());
            if (minHeap.size() < k) {
                minHeap.offer(node);
            } else {
                if (node.cnt <= minHeap.peek().cnt) {
                    continue;
                } else {
                    minHeap.poll();
                    minHeap.offer(node);
                }
            }
        }
        for (Node node : minHeap) {
            System.out.println(node.str + " " + node.cnt);
        }
    }

    public static void main(String[] args) {
        String[] strings = StringTools.generateRandomStringArray(100000, 100);
//        String[] strings = new String[]{"abc", "abc", "abc", "edf", "edf", "lalala", "lalala", "alalalsdf", "asdfasfwe", "awrfwf"};
        getTopK(strings, 10);
    }
}
