package dp;

/**
 * @author kelvin
 * @create 2021-04-08 13:17
 * @Desc 计算凑成余额所需要的**最小硬币数**
 */
public class MinCoinNums {
    private static int[] arr;
    private static int process(int index, int rest) {
        if (index == arr.length) {
            return rest == 0 ? 0 : -1;
        }
        int res = -1;  // 最少张数, 初始值为-1, 因为还没有找到有效解
        for (int k = 0; k * arr[index] <= rest; k++) {
            int next = process(index + 1, rest - k * arr[index]);
            if (next != -1) {
                res = res == - 1? next + k : Math.min(res, next + k);
            }
        }
        return res;
    }

    public static int minCoinNumBF(int[] nums, int aim) {
        if (nums == null || nums.length == 0 || aim < 0) {
            return -1;
        }
        arr = nums;
        return process(0, aim);
    }

    public static int minCoinNumDP(int[] nums, int aim) {
        if (nums == null || nums.length == 0 || aim < 0) {
            return -1;
        }
        arr = nums;
        int N = arr.length;
        int[][] dp = new int[N + 1][aim + 1];
        // 设置最后一排的值, 除了dp[N][0]为0之外, 其他都是-1
        for (int col = 1; col <= aim; col++) {
            dp[N][col] = -1;
        }
        for (int i = N - 1; i >= 0; i--) {
            for (int rest = 0; rest <= aim; rest++) {
                dp[i][rest] = -1;  // 设置dp[i][rest]初始值
                // 如果下面的值有效, 那么先讲dp[i][rest]暂时设置为下面的值
                if (dp[i + 1][rest] != -1) {
                    dp[i][rest] = dp[i + 1][rest];
                }
                //左边的位置不越界并且有效
                if (rest - arr[i] >= 0 && dp[i][rest - arr[i]] != -1) {
                    // 如果之前下面的值无效
                    if (dp[i + 1][rest] == -1) {
                        dp[i][rest] = dp[i][rest - arr[i]] + 1;
                    } else {
                        dp[i][rest] = Math.min(dp[i][rest - arr[i]] + 1, dp[i][rest]);
                    }
                }
            }
        }
        return dp[0][aim];
    }

    public static void main(String[] args) {
        int[] nums = {5, 2, 3};
        int aim = 20;
        System.out.println(minCoinNumBF(nums, aim));
        System.out.println(minCoinNumDP(nums, aim));
    }

}
