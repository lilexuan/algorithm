package problem.base;

import util.ArrTools;

import java.util.Arrays;

/**
 * @author kelvin
 * @create 2021-03-03 15:48
 * @Description 基础班第二节课第二题, 求小数和
 */
public class C2T2_LittleSum {
    public static int litleSum(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return 0;
        }
        return mergeSort(arr, 0, arr.length - 1);
    }

    private static int mergeSort(int[] arr, int left, int right) {
        if (left == right) {
            return 0;
        }
        int middle = left + (right - left) / 2;
        int leftLittleSum = mergeSort(arr, left, middle);
        int rightLittleSum = mergeSort(arr, middle + 1, right);
        return merge(arr, left, middle, right) + leftLittleSum + rightLittleSum;
    }

    private static int merge(int[] arr, int left, int middle, int right) {
        int pl = left, pr = middle + 1;
        int index = 0;
        int[] help = new int[right - left + 1];
        int res = 0;
        while (pl <= middle && pr <= right) {
            if (arr[pl] < arr[pr]) {
                res += arr[pl] * (right - pr + 1);  // 左右都有序的, 所以pr之后的数都是大于arr[pl]的
                help[index++] = arr[pl++];
            } else {
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
        return res;
    }

    private static int comparator(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return 0;
        }
        int res = 0;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    res += arr[j];
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int testTime = 50000;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = ArrTools.generateRandomArray(20, 20);
            int[] arr2 = ArrTools.copyArray(arr1);
            int res1 = litleSum(arr1);
            int res2 = comparator(arr2);
            if (res1 != res2) {
                System.out.println("error!");
                System.out.println("res1: " + res1);
                System.out.println("res2: " + res2);
                System.out.println(Arrays.toString(arr1));
                return;
            }
        }
        System.out.println("Nice!");
    }
}
