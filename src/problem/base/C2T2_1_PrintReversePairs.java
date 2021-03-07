package problem.base;

import java.util.Arrays;

/**
 * @author kelvin
 * @create 2021-03-05 9:07
 */
public class C2T2_1_PrintReversePairs {
    static public void printReversePairs(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        mergeSort(arr, 0, arr.length - 1);
    }

    static private void mergeSort(int[] arr, int left, int right) {
        if (left == right) {
            return;
        }
        int middle = left + (right - left) / 2;
        mergeSort(arr, left, middle);
        mergeSort(arr, middle + 1, right);
        mergeAndPrint(arr, left, middle, right);
    }

    static private void mergeAndPrint(int[] arr, int left, int middle, int right) {
        int[] help = new int[right - left + 1];
        int pl = left, pr = middle + 1;
        int index = 0;
        while (pl <= middle && pr <= right) {
            if (arr[pl] > arr[pr]) {
                for (int i = pr; i <= right; i++) {
                    System.out.println("(" + arr[pl] + "," + arr[i] + ")");
                }
                help[index++] = arr[pl++];
            } else  {
                help[index++] = arr[pr++];
            }
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
        int[] arr = {7, 6, 5, 4, 3, 1, 2};
        printReversePairs(arr);
        System.out.println(Arrays.toString(arr));
    }
}
