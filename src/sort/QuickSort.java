package sort;

import util.ArrTools;

/**
 * @author kelvin
 * @create 2021-03-07 21:23
 */
public class QuickSort {
    static public void quickSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    static private void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            ArrTools.swap(arr, left + (int)(Math.random() * (right - left + 1)), right);
            int[] equalEdge = partition(arr, left, right);
            quickSort(arr, left, equalEdge[0] - 1);
            quickSort(arr, equalEdge[1] + 1, right);
        }
    }

    static private int[] partition(int[] arr, int left, int right) {
        int less = left - 1, more = right;  // 最后一个数默认在边界里面
        while (left < more) {
            if (arr[left] < arr[right]) {
                ArrTools.swap(arr, ++less, left++);
            } else if (arr[left] > arr[right]) {
                ArrTools.swap(arr, --more, left);
            } else {
                left++;
            }
        }
        ArrTools.swap(arr, more, right);  // 把最后一个数剔除出大区域
        return new int[]{less + 1, more};  // more+1才是大区域的边界
    }

    public static void main(String[] args) {
        boolean succeed = ArrTools.isSortAlgoCorrect(QuickSort::quickSort, 50000, 100, 100);
        System.out.println(succeed ? "Nice!" : "Oh no");
    }
}
