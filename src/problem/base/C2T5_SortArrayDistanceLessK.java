package problem.base;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author kelvin
 * @create 2021-03-07 18:43
 * @Description 一个数组几乎有序, 对其进行排序, 每个数最多移动不超过k步
 */
public class C2T5_SortArrayDistanceLessK {
    public static void sortArrayLessK(int[] arr, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int j = 0;
        for (; j < Math.min(k, arr.length); j++) {
            minHeap.add(arr[j]);
        }
        int i = 0;
        for (; j < arr.length; i++, j++) {
            minHeap.add(arr[j]);
            arr[i] = minHeap.poll();
        }
        while (!minHeap.isEmpty()) {
            arr[i++] = minHeap.poll();
        }
    }

    public static void main(String[] args) {
        int[] arr = {6, 5, 4, 3, 2, 1, 0, 13, 12, 11, 10, 9, 8, 7};
        sortArrayLessK(arr, 6);
        System.out.println(Arrays.toString(arr));
    }
}
