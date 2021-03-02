package sort;

import util.ArrTools;

/**
 * @author kelvin
 * @create 2021-03-01 23:02
 */
public class SelectionSort {
    public static void selectionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            ArrTools.swap(arr, i, minIndex);
        }
    }

    public static void main(String[] args) {
        boolean succeed = ArrTools.isSortAlgoCorrect(SelectionSort::selectionSort, 50000, 100, 100);
        System.out.println(succeed ? "Nice!" : "Oh no");
    }
}
