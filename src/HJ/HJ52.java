package HJ;

import java.util.Scanner;

/**
 * @author kelvin
 * @create 2022-10-03 18:49
 */
public class HJ52 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        // 当另一个字符串长度为0时, 编辑距离就等于另一个字符串
        for (int i = 0; i <= s1.length(); i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= s2.length(); j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) != s2.charAt(j - 1)) {
                    dp[i][j] = 1 + Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]);
                } else {
                    dp[i][j] = 1 + Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1] - 1);
                }
            }
        }
        System.out.println(dp[s1.length()][s2.length()]);
    }
}
