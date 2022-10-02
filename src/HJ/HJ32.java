package HJ;

import java.util.*;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class HJ32 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char[] chs = s.toCharArray();
        boolean[][] dp = new boolean[chs.length][chs.length];
        for (int i = 0; i < chs.length; i++) {
            dp[i][i] = true;
            if (i + 1 < chs.length) {
                dp[i][i + 1] = chs[i] == chs[i + 1];
            }
        }
        int max = 0;
        for (int i = chs.length - 1; i >= 0; i--) {
            for (int j = 0; j < chs.length; j++) {
                if (i + 1 <= j - 1) {
                    dp[i][j] = (chs[i] == chs[j]) && dp[i + 1][j - 1];
                }
                if (dp[i][j]) {
                    max = Math.max(max, j - i + 1);
                }

            }
        }
        System.out.println(max);
        for (int i = 0; i < dp.length; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
    }
}