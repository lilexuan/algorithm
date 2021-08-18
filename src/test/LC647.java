package test;

import java.util.Arrays;

/**
 * @author kelvin
 * @create 2021-05-19 11:22
 */
public class LC647 {
    static class Solution {
        public int countSubstrings(String s) {
            int len = s.length();
            char[] chs = s.toCharArray();

            boolean[][] isPalindrome = new boolean[len][len];
            for (int i = 0; i < len; i++) {
                isPalindrome[i][i] = true;
            }

            for (int i = len - 1; i >= 0; i--) {
                for (int j = len - 1; j > i; j--) {
                    isPalindrome[i][j] = chs[i] == chs[j];
                    if (i + 1 <= j - 1) {
                        isPalindrome[i][j] = isPalindrome[i][j] && isPalindrome[i + 1][j - 1];
                    }
                }
            }

            for (boolean[] row : isPalindrome) {
                System.out.println(Arrays.toString(row));
            }

            int[] dp = new int[len];
            dp[0] = 1;
            for (int i = 1; i < len; i++) {
                dp[i] = dp[i - 1];
                for (int j = 0; j <= i; j++) {
                    if (isPalindrome[j][i]) {
                        dp[i]++;
                    }
                }
            }
            System.out.println(Arrays.toString(dp));
            return dp[len - 1];
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String str = "aaaaa";
        int i = solution.countSubstrings(str);
        System.out.println(i);
    }
}
