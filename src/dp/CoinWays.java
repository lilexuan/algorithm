package dp;

/**
 * @author kelvin
 * @create 2021-04-08 15:47
 */
public class CoinWays {
    public static int coinWaysDP(int[] arr, int aim) {
        int n = arr.length;
        int[][] dp = new int[n + 1][aim + 1];
        dp[n][0] = 1;
        for (int index = n - 1; index >= 0; index--) {
            for (int rest = 0; rest <= aim; rest++) {
                if (rest - arr[index] >= 0) {
                    dp[index][rest] += dp[index][rest - arr[index]];
                }
                dp[index][rest] += dp[index + 1][rest];
            }
        }
        return dp[0][aim];
    }

    public static int coinWaysBF(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        return process(arr, 0, aim);
    }

    private static int process(int[] arr, int index, int rest) {
        int res = 0;
        if (index == arr.length) {
            return rest == 0 ? 1 : 0;
        }
        for (int k = 0; k * arr[index] <= rest; k++) {
            res += process(arr, index + 1, rest - k * arr[index]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 5};
        int aim = 5;
        System.out.println(coinWaysBF(nums, aim));
        System.out.println(coinWaysDP(nums, aim));
    }
}
