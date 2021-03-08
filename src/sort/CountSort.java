package sort;

import util.ArrTools;

import java.util.Arrays;

/**
 * @author kelvin
 * @create 2021-03-07 22:39
 */
public class CountSort {
    static public void countSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        int max = Integer.MIN_VALUE;
        for (int num : arr) {
            max = Math.max(num, max);
        }
        int[] bucket = new int[max + 1];
        for (int num : arr) {
            bucket[num]++;
        }
        int index = 0;
        for (int i = 0; i < bucket.length; i++) {
            while (bucket[i]-- > 0) {
                arr[index++] = i;
            }
        }
    }

    public static void main(String[] args) {
       int testTime = 50000;
       int maxValue = 100;
       int maxSize = 100;
       for (int i = 0; i < testTime; i++) {
           int[] arr = new int[(int)((maxSize + 1) * Math.random())];
           for (int j = 0; j < arr.length; j++) {
               arr[j] = (int)((maxValue + 1) * Math.random());
           }
           int[] arr2 = ArrTools.copyArray(arr);
           countSort(arr);
           ArrTools.comparator(arr2);
           if (!ArrTools.isEqual(arr, arr2)) {
               System.out.println("error");
               System.out.println(Arrays.toString(arr));
               System.out.println(Arrays.toString(arr2));
               return;
           }
       }
        System.out.println("Nice!");
    }
}
