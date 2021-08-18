package test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author kelvin
 * @create 2021-05-20 10:22
 */
public class LC581 {
    static class Solution {
        public int findUnsortedSubarray(int[] nums) {
            Deque<Integer> monoStack = new LinkedList<>();
            int right = -1;
            for (int i = 0; i < nums.length; i++) {
                while (!monoStack.isEmpty() && nums[monoStack.peek()] > nums[i]) {
                    monoStack.pop();
                    if (right == -1) {
                        right = i;
                    }
                }
                monoStack.push(i);
            }

            monoStack.clear();
            int left = nums.length;
            for (int i = nums.length - 1; i >= 0; i--) {
                while (!monoStack.isEmpty() && nums[monoStack.peek()] < nums[i]) {
                    monoStack.pop();
                    left = i;
                }
                monoStack.push(i);
            }
            System.out.println(left + " " + right);
            if (right == -1) {
                return 0;
            } else {
                return right - left + 1;
            }
        }
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2, 3, 3, 2, 4};
        int unsortedSubarray = solution.findUnsortedSubarray(nums);
        System.out.println(unsortedSubarray);
    }
}
