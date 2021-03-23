package greedy;

import java.util.*;

/**
 * 暴力解法真不会.....
 */
public class LessMoneySplit {
    public static int lessMoneySplit(int[] arr) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : arr) {
            minHeap.offer(num);
        }
        int sum = 0;
        while (minHeap.size() >= 2) {
            int cur = minHeap.poll() + minHeap.poll();
            sum += cur;
            minHeap.offer(cur);
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 30};
        System.out.println(lessMoneySplit(arr));
    }
}
