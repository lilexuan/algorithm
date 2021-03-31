package slidingWindow;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class MaxSlidingWindow {
    public static int[] maxSlidingWindow(int[] arr, int w) {
        if (arr == null || w < 1 || arr.length < w) {
            return null;
        }
        Deque<Integer> monoStack = new LinkedList<>();
        int[] res = new int[arr.length - w + 1];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            // 扩充窗口
            while (!monoStack.isEmpty() && arr[monoStack.peekLast()] <= arr[i]) {
                monoStack.pollLast();
            }
            monoStack.addLast(i);

            // 缩小窗口
            if (i - w == monoStack.peekFirst()) {
                monoStack.pollFirst();
            }

            // 更新答案
            if (i >= w - 1) {
                res[index++] = arr[monoStack.peekFirst()];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = { 4, 3, 5, 4, 3, 3, 6, 7 };
        int w = 3;
        System.out.println(Arrays.toString(maxSlidingWindow(arr, w)));
    }
}
