package dp;

public class MinPathSum {
    public static int minPathSum(int[][] m) {
        int row = m.length, col = m[0].length;
        int[][] dp = new int[row][col];
        dp[0][0] = m[0][0];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                if (i == 0) {
                    dp[i][j] = m[i][j] + dp[i][j - 1];
                } else if (j == 0) {
                    dp[i][j] = m[i][j] + dp[i - 1][j];
                } else {
                    dp[i][j] = m[i][j] + Math.min(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[row - 1][col - 1];
    }

    public static void main(String[] args) {
        int[][] m = { { 1, 3, 5, 9 }, { 8, 1, 3, 4 }, { 5, 0, 6, 1 },
                { 8, 8, 4, 0 } };
        System.out.println(minPathSum(m));
    }
}
