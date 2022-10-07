package HJ;

import java.util.Scanner;

/**
 * @author kelvin
 * @create 2022-10-07 12:40
 */
public class HJ91 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                    continue;
                }
                if (i - 1 >= 0) {
                    dp[i][j] += dp[i - 1][j];
                }
                if (j - 1 >= 0) {
                    dp[i][j] += dp[i][j - 1];
                }
            }
        }
        System.out.println(dp[n][m]);
    }
}
