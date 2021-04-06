package stackAndQueue;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author kelvin
 * @create 2021-04-02 10:04
 * @Description 计算每一个数的左边和右边最近的最大值
 */
public class GetNearMax {
    public static int[][] getNearMaxNoRepeat(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        Deque<Integer> monoStack = new LinkedList<>();
        int[][] res = new int[arr.length][2];
        for (int i = 0; i < arr.length; i++) {
            while (!monoStack.isEmpty() && arr[monoStack.peek()] < arr[i]) {
                int curIndex = monoStack.poll();
                int leftIndex = monoStack.isEmpty() ? -1 : monoStack.peek();
                int rightIndex = i;
                res[curIndex][0] = leftIndex;
                res[curIndex][1] = rightIndex;
            }
            monoStack.push(i);
        }

        while (!monoStack.isEmpty()) {
            int curIndex = monoStack.poll();
            int leftIndex = monoStack.isEmpty() ? -1 : monoStack.peek();
            int rightIndex = -1;
            res[curIndex][0] = leftIndex;
            res[curIndex][1] = rightIndex;
        }
        return res;
    }

    public static int[][] getNearMaxRepeat(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        Deque<LinkedList<Integer>> monoStack = new LinkedList<>();
        int[][] res = new int[arr.length][2];
        for (int i = 0; i < arr.length; i++) {
            while (!monoStack.isEmpty() && arr[monoStack.peek().getLast()] < arr[i]) {
                LinkedList<Integer>  popIndex = monoStack.pop();
                int leftIndex = monoStack.isEmpty() ? -1 : monoStack.peek().getLast();
                int rightIndex = i;
                for (int curIndex : popIndex) {
                    res[curIndex][0] = leftIndex;
                    res[curIndex][1] = rightIndex;
                }
            }
            if (!monoStack.isEmpty() && arr[monoStack.peek().getFirst()] == arr[i]) {
                monoStack.peek().add(i);
            } else {
                LinkedList<Integer> list = new LinkedList<>();
                list.add(i);
                monoStack.push(list);
            }
        }
        while (!monoStack.isEmpty()) {
            LinkedList<Integer> popIndex = monoStack.pop();
            int leftIndex = monoStack.isEmpty()? -1 : monoStack.peek().getLast();
            int rightIndex = -1;
            for (int index : popIndex) {
                res[index][0] = leftIndex;
                res[index][1] = rightIndex;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 23, 34, 7, 9, 0, 4, 35, 45, 2, 234};
        int[][] res = getNearMaxNoRepeat(arr1);
        for (int[] nums : res) {
            System.out.println(Arrays.toString(nums));
        }

        int[] arr2 = {1, 2, 3, 34, 34, 7, 9, 8, 4, 23, 12,435 ,234, 123, 23};
        int[][] res2 = getNearMaxRepeat(arr2);
        for (int[] nums : res2) {
            System.out.println(Arrays.toString(nums));
        }
    }
}
