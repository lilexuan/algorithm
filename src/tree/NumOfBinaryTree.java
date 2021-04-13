package tree;

/**
 * @author kelvin
 * @create 2021-04-13 13:42
 */
public class NumOfBinaryTree {
    public static int getBinaryNumBF(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            int left = getBinaryNumBF(i);
            int right = getBinaryNumBF(n - 1 - i);
            res += left * right;
        }
        return res;
    }

    public static int getBinaryNumDP(int n) {
        if (n <= 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - 1 - j];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 19;
        long curTime, endTIme;

//        curTime = System.currentTimeMillis();
//        System.out.println(getBinaryNumBF(n));
//        endTIme = System.currentTimeMillis();
//        System.out.println("BF: " + (endTIme - curTime) + "ms");

        curTime = System.currentTimeMillis();
        System.out.println(getBinaryNumDP(n));
        endTIme = System.currentTimeMillis();
        System.out.println("DP: " + (endTIme - curTime) + "ms");

        for (int i = 0; i <= 21; i++) {
            System.out.println(i + " " + getBinaryNumDP(i));
        }
    }
}
