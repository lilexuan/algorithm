package dp;

/**
 * the dp way of recur/TranslateNum.java
 */
public class TranslateNumDP {
    public static int count(String s) {
        char[] chs = s.toCharArray();
        int[] dp = new int[chs.length + 1];
        dp[chs.length] = 1;
        for (int i = chs.length - 1; i >= 0; i--) {
            if (chs[i] == '0') {
                dp[i] = 0;
            } else if (chs[i] == '1') {
                dp[i] = dp[i + 1];
                if (i + 1 < chs.length) {
                    dp[i] += dp[i + 2];
                }
            } else if (chs[i] == '2') {
                dp[i] = dp[i + 1];
                if (i + 1 < chs.length && (chs[i + 1] >= '0' && chs[i + 1] <= '6')) {
                    dp[i] +=  dp[i + 2];
                }
            } else {
                dp[i] = dp[i + 1];
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        String str1 = "2361267258";
        String str2 = "111111";
        System.out.println(count(str1));
        System.out.println(count(str2));
    }
}
