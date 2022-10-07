package HJ;

import java.util.Scanner;

/**
 * @author kelvin
 * @create 2022-10-04 15:53
 */
public class HJ65 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        if (s2.length() < s1.length()) {
            String tmp = s2;
            s2 = s1;
            s1 = tmp;
        }
        int max = 0;
        int index = 0; // 记录最大长度的末尾index
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    if (dp[i][j] > max) {
                        max = dp[i][j];
                        index = i;
                    }
                }
            }
        }
        System.out.println(s1.substring(index - max, index));
    }
}
