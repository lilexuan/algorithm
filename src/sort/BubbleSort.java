package sort;

import util.ArrTools;

/**
 * @author kelvin
 * @create 2021-03-01 23:55
 */
public class BubbleSort {
    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int k = arr.length - 1; k > 0; k--) {
            for (int i = 0; i < k; i++) {
                if (arr[i] > arr[i + 1]) {
                    ArrTools.swap(arr, i, i + 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        boolean succeed = ArrTools.isSortAlgoCorrect(BubbleSort::bubbleSort, 50000, 100, 100);
        System.out.println(succeed ? "Nice!" : "Oh no");
    }
}
