package HJ;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author kelvin
 * @create 2022-10-05 8:56
 */
public class HJ67 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nums = new int[4];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = sc.nextInt();
        }
        LinkedList<Integer> path = new LinkedList<>();
        boolean[] visited = new boolean[nums.length];
        System.out.println(dfsHJ67(nums, 0.0, path, visited));
    }

    private static boolean dfsHJ67(int[] nums, double res, LinkedList<Integer> path, boolean[] visited) {
        if (path.size() == nums.length) {
            return Math.abs(res - 24) < 1e-5;
        }
        boolean ans = false;
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                path.addLast(nums[i]);
                ans = ans || dfsHJ67(nums, res + nums[i], path, visited);
                ans = ans || dfsHJ67(nums, res - nums[i], path, visited);
                ans = ans || dfsHJ67(nums, res * nums[i], path, visited);
                if (nums[i] != 0)
                    ans = ans || dfsHJ67(nums, res / nums[i], path, visited);
                visited[i] = false;
                path.removeLast();
            }
        }
        return ans;
    }
}