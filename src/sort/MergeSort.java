package sort;

import util.ArrTools;

import java.util.Arrays;

/**
 * @author kelvin
 * @create 2021-03-03 14:28
 */
public class MergeSort {
    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        mergeSort(arr, 0, arr.length - 1);
    }

    private static void mergeSort(int[] arr, int left, int right) {
        if (left == right) {
            return;
        }
        int middle = left + (right - left) / 2;
        mergeSort(arr, left, middle);
        mergeSort(arr, middle + 1, right);
        merge(arr, left, middle, right);
    }

    private static void merge(int[] arr, int left, int middle, int right) {
        int[] help = new int[right - left + 1];
        int pl = left, pr = middle + 1;
        int index = 0;
        while (pl <= middle && pr <= right) {
            help[index++] = arr[pl] <= arr[pr] ? arr[pl++] : arr[pr++];
//            if (arr[pl] <= arr[pr]) {
//                help[index++] = arr[pl++];
//            } else {
//                help[index++] = arr[pr++];
//            }
        }
        while (pl <= middle) {
            help[index++] = arr[pl++];
        }
        while (pr <= right) {
            help[index++] = arr[pr++];
        }
        for (int i = 0; i < help.length; i++) {
            arr[left + i] = help[i];
        }
    }

    public static void main(String[] args) {
//        boolean succeed = ArrTools.isSortAlgoCorrect(MergeSort::mergeSort, 50000, 100, 100);
//        System.out.println(succeed ? "Nice!" : "Oh no");
        int[] arr = {3, 1, 16, -16, 3, -14, -4, -2, -4, 5, -1, 3};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
