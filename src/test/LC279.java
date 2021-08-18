package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author kelvin
 * @create 2021-05-13 14:53
 */
public class LC279 {
    static class Solution {
        public int numSquares(int n) {
            List<Integer> squareNums = genSquares(n);
            return process(n, squareNums, 0);
        }

        private int process(int remain, List<Integer> squareNums, int cnt) {
            if (remain == 0) {
                return cnt;
            }
            int minCnt = Integer.MAX_VALUE;
            for (int i = 0; i < squareNums.size(); i++) {
                int squareNum = squareNums.get(i);
                if (remain - squareNum >= 0) {
                    int tmp = process(remain - squareNum, squareNums, cnt + 1);
                    minCnt = Math.min(tmp, minCnt);
                }
            }
            return minCnt;
        }


        private List<Integer> genSquares(int n) {
            List<Integer> squareNums = new ArrayList<>();
            for (int i = 1; i * i <= n; i++) {
                squareNums.add(i * i);
            }
            return squareNums;
        }

        public int numSquaresDP(int n) {
            int[] dp = new int[n + 1];
            for (int i = 1; i * i <= n; i++) {
                dp[i * i] = 1;
            }
            List<Integer> squareNums = genSquares(n);
            for (int i  = 1; i <= n; i++) {
                if (dp[i] == 1) {
                    continue;
                }
                int min = Integer.MAX_VALUE;
                for (int squareNum : squareNums) {
                    if (i - squareNum > 0) {
                        min = Math.min(min, dp[i - squareNum]);
                    }
                }
                dp[i] = min + 1;
            }
            return dp[n];
        }

    }

    public static void main(String[] args) {
        int n = 12;
        Solution solution = new Solution();
        int i = solution.numSquaresDP(n);
        System.out.println(i);
    }
}
