package stackAndQueue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author kelvin
 * @create 2021-04-02 16:45
 */
public class MaxSumTimsMin {
    public static int countMax(int[] arr) {
        int size = arr.length;
        int[] sum = new int[size];
        sum[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            sum[i] = arr[i] + sum[i - 1];
        }
        int max = Integer.MIN_VALUE;
        Deque<Integer> monoStack = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            while (!monoStack.isEmpty() && arr[monoStack.peek()] >= arr[i]) {
                int j = monoStack.pop();
                max = Math.max(max, monoStack.isEmpty()? sum[i - 1] : (sum[i - 1] - sum[monoStack.peek()]) * arr[j]);
            }
            monoStack.push(i);
        }
        while (!monoStack.isEmpty()) {
            int j = monoStack.pop();
            max = Math.max(max, arr[j] * (monoStack.isEmpty() ? sum[size - 1] : sum[size - 1] - sum[j]));
        }
        return max;
    }

    public static int countMaxBF(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int minNum = Integer.MAX_VALUE;
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += arr[k];
                    minNum = Math.min(minNum, arr[k]);
                }
                max = Math.max(max, minNum * sum);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 2, 1, 6, 7, 8, 4};
        System.out.println(countMaxBF(arr));
        System.out.println(countMax(arr));
    }
}
