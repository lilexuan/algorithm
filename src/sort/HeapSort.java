package sort;

import util.ArrTools;

/**
 * @author kelvin
 * @create 2021-03-06 22:54
 */
public class HeapSort {

    static public void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            ArrTools.swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    static public void heapify(int[] arr, int index, int size) {
        int left = 2 * index + 1;
        while (left < size) {
            // 如果右孩子存在且右孩子大于左孩子, 则最大值下标是右孩子, 否则就是左孩子
            int largest = left + 1 < size && arr[left + 1] > arr[left] ? left + 1 : left;
            // large 和 index哪个大?
            largest = arr[largest] > arr[index] ? largest : index;
            if (largest == index) {
                break;
            }
            ArrTools.swap(arr, largest, index);
            index = largest;
            left = 2 * index + 1;
        }
    }

    static public void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }
        int heapSize = arr.length;
        while (heapSize > 0) {
            ArrTools.swap(arr, 0, --heapSize);
            heapify(arr, 0, heapSize);
        }
    }

    public static void main(String[] args) {
        boolean succeed = ArrTools.isSortAlgoCorrect(HeapSort::heapSort, 50000, 100, 100);
        System.out.println(succeed ? "Nice!" : "Error!");
    }
}
