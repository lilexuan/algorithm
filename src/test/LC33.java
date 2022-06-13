package test;

public class LC33 {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int index = -1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] == target) {
                index = middle;
                break;
            } else if (nums[middle] < target) {
                // 左侧有序且在左侧的范围内
                if (nums[0] <= nums[middle] && target >= nums[0]) {
                    right = middle - 1;
                } else {
                    left = middle + 1;
                }
            } else if (nums[middle] > target) {
                // 右侧有序且在右侧的范围内
                if (nums[middle] <= nums[nums.length - 1] && target < nums[nums.length - 1]) {
                    left = middle + 1;
                } else {
                    right = middle - 1;
                }
            }
        }
        return index;
    }

    public static void main(String[] args) {
        LC33 lc33 = new LC33();
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int search = lc33.search(nums, 0);
        System.out.println(search);
    }
}
