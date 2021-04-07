package dp;

public class RobotWalk {
    public static int robotWalk(int N, int M, int K, int P) {
        if (N < 2 || M < 1 || M > N || P < 1 || P > N || K < 1) {
            return 0;
        }
        int[][] dp = new int[K + 1][N + 1];
        dp[0][M] = 1;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (j - 1 > 0) {
                    dp[i][j] += dp[i - 1][j - 1];
                }
                if (j + 1 <= N) {
                    dp[i][j] += dp[i - 1][j + 1];
                }
            }
        }
        return dp[K][P];
    }

    public static void main(String[] args) {
        int N = 3, M = 1, K = 3, P = 3;
        System.out.println(robotWalk(N, M, K, P));
    }
}
