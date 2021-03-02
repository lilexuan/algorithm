package sort;

import util.ArrTools;

/**
 * @author kelvin
 * @create 2021-03-02 10:04
 */
public class InsertSort {
    public static void insertSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    ArrTools.swap(arr, j, j - 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        boolean succeed = ArrTools.isCorrect(InsertSort::insertSort, 50000, 100, 100);
        System.out.println(succeed ? "Nice!" : "Oh no");
    }
}
