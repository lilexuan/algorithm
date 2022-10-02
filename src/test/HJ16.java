package test;

import java.util.Scanner;

/**
 * @author kelvin
 * @create 2022-09-29 18:15
 */
public class HJ16 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int m = sc.nextInt();

        Goods[] goods = new Goods[m];
        for (int i = 0; i < m; i++) {
            goods[i] = new Goods();
        }
        for (int i = 0; i < m; i++) {
            int v = sc.nextInt();
            int p = sc.nextInt();
            int q = sc.nextInt();
            goods[i].v = v;
            goods[i].p = p * v;
            if (q == 0) {
                goods[i].main = true;
            }
            else if (goods[q - 1].a1 == -1) {
                goods[q - 1].a1 = i;
            }
            else {
                goods[q - 1].a2 = i;
            }
        }

        int[][] dp = new int[m + 1][N + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 0; j <= N; j++) {
                dp[i][j] = dp[i - 1][j]; // 默认不选择
                if (!goods[i - 1].main) { // 这里如果不是主件, 直接继续. 因为已经将上一行的给复制下来了, 所以不影响后面的dp[i-1]操作
                    continue;
                }
                // 仅考虑主件
                if (j >= goods[i-1].v) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - goods[i - 1].v] + goods[i - 1].p);
                }
                int a1 = goods[i - 1].a1;
                int a2 = goods[i - 1].a2;
                // 考虑附件1
                if (a1 != -1 && j >= goods[i - 1].v + goods[a1].v) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - goods[i - 1].v - goods[a1].v] + goods[i - 1].p + goods[a1].p);
                }
                // 考虑附件2
                if (a2 != -1 && j >= goods[i - 1].v + goods[a2].v) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - goods[i - 1].v - goods[a2].v] + goods[i - 1].p + goods[a2].p);
                }
                // 考虑附件1和2
                if (a1 != -1 && a2 != -1 && j >= goods[i - 1].v + goods[a1].v + goods[a2].v) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - goods[i - 1].v - goods[a1].v - goods[a2].v] + goods[i - 1].p + goods[a1].p + goods[a2].p);
                }
            }

        }
        System.out.println(dp[m][N]);

    }

    static class Goods {
        int v;
        int p;
        boolean main = false;
        int a1 = -1;
        int a2 = -1;
    }
}
