package HJ;

import java.util.Scanner;

/**
 * @author kelvin
 * @create 2022-10-06 9:41
 */
public class HJ71 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String p = sc.nextLine().toLowerCase();
        String s = sc.nextLine().toLowerCase();
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;  // 两个都为空的时候, 可以匹配
        for (int j = 1; j <= p.length(); j++) {
            // 连续的*可以匹配空的s
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = true;
            } else {
                break;
            }
        }
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 1];  // 不使用*匹配
                    if (canMatch(s.charAt(i - 1))) {  // 使用*匹配
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                } else if (p.charAt(j - 1) == '?') {
                    if (canMatch(s.charAt(i - 1))) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                } else {
                    dp[i][j] = (s.charAt(i - 1) == p.charAt(j - 1)) && dp[i - 1][j - 1];
                }
            }
        }
        System.out.println(dp[s.length()][p.length()]);
    }

    private static boolean canMatch(char c) {
        return Character.isDigit(c) || Character.isLetter(c);
    }
}
