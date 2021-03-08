package sort;

import util.ArrTools;

import java.util.Arrays;

/**
 * @author kelvin
 * @create 2021-03-08 11:30
 */
public class RadixSort {
    static public void radixSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        radixSort(arr, 0, arr.length - 1, maxbits(arr));
    }

    static private void radixSort(int[] arr, int left, int right, int digit) {
        final int index = 10;
        int[] bucket = new int[right - left + 1];  // 创建待排序数组长度的桶

        for (int d = 1; d <= digit; d++) {  // 在每一位上进行入桶出桶操作
            int[] count = new int[index];  // 建立当前位上的计数数组

            // 建立count数组: 记录d位上每一个数字出现的次数
            for (int i = left; i <= right; i++) {
                int j = getDigit(arr[i], d);
                count[j]++;
            }

            // 将count数组转化位前缀和数组
            for (int i = 1; i < count.length; i++) {
                count[i] = count[i - 1] + count[i];
            }

            // 从右往左遍历, 将数放到对应的桶里面
            for (int i = right; i >= left; i--) {
                int j = getDigit(arr[i], d);
                bucket[count[j] - 1] = arr[i];
                count[j]--;
            }

            // 将辅助空间(桶)的数复制回到原来的数组中
            for (int i = 0, j = left; i < bucket.length; i++, j++) {
                arr[j] = bucket[i];
            }
        }
    }

    private static int getDigit(int x, int d) {
        return (x / (int)(Math.pow(10, d - 1))) % 10;
    }

    static private int maxbits(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int num : arr) {
            max = Math.max(max, num);
        }
        int cnt = 0;
        while (max != 0) {
            cnt++;
            max /= 10;
        }
        return cnt;
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
            radixSort(arr);
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
