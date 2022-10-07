package HJ;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author kelvin
 * @create 2022-10-07 14:15
 */
public class HJ93 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.println(dfsHJ93(0, nums, new LinkedList<>(), new LinkedList<>()));
    }

    public static boolean dfsHJ93(int index, int[] nums, LinkedList<Integer> group5, LinkedList<Integer> group3) {
        if (index == nums.length) {
            int sum1 = 0, sum2 = 0;
            for (int num : group5) {
                sum1 += num;
            }
            for (int num : group3) {
                sum2 += num;
            }
            return sum1 == sum2;
        }
        boolean res = false;
        if (nums[index] % 5 == 0) {
            group5.addLast(nums[index]);
            res = res || dfsHJ93(index + 1, nums, group5, group3);
            group5.removeLast();
        } else if (nums[index] % 3 == 0) {
            group3.addLast(nums[index]);
            res = res || dfsHJ93(index + 1, nums, group5, group3);
            group3.removeLast();
        } else {
            group5.addLast(nums[index]);
            res = res || dfsHJ93(index + 1, nums, group5, group3);
            group5.removeLast();

            group3.addLast(nums[index]);
            res = res || dfsHJ93(index + 1, nums, group5, group3);
            group3.removeLast();
        }
        return res;
    }
}
