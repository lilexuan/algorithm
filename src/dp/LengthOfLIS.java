package dp;

import util.ArrTools;

import java.util.Arrays;

/**
 * @author kelvin
 * @create 2021-05-01 16:33
 * @Desc 求最长递增子序列
 */
public class LengthOfLIS {
    public static int lengthOfLIS(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int[] dp = new int[arr.length];
        dp[0] = 1;
        int res = dp[0];
        for (int i = 1; i < arr.length; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = max + 1;
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] array = ArrTools.generateRandomArray(100, 60);
        System.out.println(Arrays.toString(array));
        System.out.println(lengthOfLIS(array));
    }
}
