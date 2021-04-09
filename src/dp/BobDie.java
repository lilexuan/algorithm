package dp;

import math.MathTools;

public class BobDie {
    private static int waysBobAlive(int n, int m, int i, int j, int k) {
        int[][][] dp = new int[n][m][k + 1];
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                dp[row][col][0] = 1;
            }
        }
        int[] drow = {0, 1, 0, -1};
        int[] dcol = {-1, 0, 1, 0};
        for (int step = 1; step <= k; step++) {
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < m; col++) {
                    for (int t = 0; t < drow.length; t++) {
                        int newRow = row + drow[t];
                        int newCol = col + dcol[t];
                        if (isValid(newRow, newCol, n, m)) {
                            dp[row][col][step] += dp[newRow][newCol][step - 1];
                        }
                    }
                }
            }
        }
        return dp[i][j][k];
    }

    private static boolean isValid(int newRow, int newCol, int n, int m) {
        return newRow >= 0 && newRow < n && newCol >= 0 && newCol < m;
    }

    public static String probBobAlive(int n, int m, int i, int j, int k) {
        int aliveNums = waysBobAlive(n, m, i, j, k);
        int totalNums = (int)Math.pow(4, k);
        int g = MathTools.gcd(aliveNums, totalNums);
        return aliveNums/g + "/" + totalNums/g;
    }

    public static void main(String[] args) {
        int N = 10;
        int M = 10;
        int i = 3;
        int j = 2;
        int K = 5;
        System.out.println(probBobAlive(N, M, i, j, K));
    }
}
