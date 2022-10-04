package HJ;

import java.util.Scanner;

/**
 * @author kelvin
 * @create 2022-10-04 10:18
 */
public class HJ61 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(), n = sc.nextInt();
        int[][] dp = new int[m + 1][n + 1];

        // 初始化
        // 1个盘子的情况下, 只有一种方案
        for (int i = 0; i <= m; i++) {
            dp[i][1] = 1;
        }
        // 0个苹果和1个苹果的情况下, 只有一种方案
        for (int j = 0; j <= n; j++) {
            dp[0][j] = 1;
            dp[1][j] = 1;
        }

        for (int i = 2; i <= m; i++) {
            for (int j = 2; j <= n; j++) {
                if (i < j) {
                    dp[i][j] = dp[i][i];
                } else {
                    dp[i][j] = dp[i][j - 1] + dp[i - j][j];
                }
            }
        }
        System.out.println(dp[m][n]);
    }
}
