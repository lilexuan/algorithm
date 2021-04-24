package dp;

public class ZeroOneBagWays {
    /**
     *
     * @param arr
     * @param i 表示0~i范围上已经做出了选择(对于其中一个可以选择使用或者不使用)
     * @param weight
     * @return
     */
    public static int getWaysBF(int[] arr, int i, int weight) {
        if (weight == 0) {
            return 1;
        }
        if (weight < 0) {
            return 0;
        }
        if (i == 0) {
            // 如果只剩下第0个没选, 而背包空位是大于选择的体积的, 那么我有两种选择: 选或者不选
            // 否则就只有一种选择, 不选
            return weight >= arr[0] ? 2 : 1;
        }
        // 当前位置i选择不放入背包的数量+当前位置i选择放入背包的数量
        return getWaysBF(arr, i - 1, weight) + getWaysBF(arr, i - 1, weight - arr[i]);
    }

    public static int getWaysDP(int[] arr, int weight) {
        int[][] dp = new int[arr.length][weight + 1];
        for (int i = 0; i < arr.length; i++) {
            dp[i][0] = 1;
        }
        for (int j = 1; j <= weight; j++) {
            dp[0][j] = j >= arr[0] ? 2 : 1;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j <= weight; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j - arr[i] >= 0) {
                    dp[i][j] += dp[i - 1][j - arr[i]];
                }
            }
        }
        return dp[arr.length - 1][weight];
    }

    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 9};
        int w = 8;
        System.out.println(getWaysBF(arr, arr.length - 1, w));
        System.out.println(getWaysDP(arr, w));
    }
}
