package problem.base;

import util.ArrTools;

import java.util.Arrays;

/**
 * @author kelvin
 * @create 2021-03-07 20:43
 * @Description 荷兰国旗问题, 比target小的放左边, 比target大的放右边, 相等的放中间
 */
public class C2T6_NetherlandsFlag {
    public static void partition(int[] arr, int left, int right, int target) {
        int less = left - 1, more = right + 1;
        while (left < more) {
            if (arr[left] < target) {
                ArrTools.swap(arr, ++less, left++);
            } else if (arr[left] > target) {
                ArrTools.swap(arr, --more, left);
            } else {
                left++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = ArrTools.generateRandomArray(20, 10);
        System.out.println(Arrays.toString(nums));
        partition(nums, 0, nums.length - 1, 5);
        System.out.println(Arrays.toString(nums));
    }
}
