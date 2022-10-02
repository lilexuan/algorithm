 package HJ;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

/**
 * @author kelvin
 * @create 2022-10-02 8:33
 */
public class HJ41_dp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] weight = new int[n];
        int[] mount = new int[n];
        for (int i = 0; i < n; i++) {
            weight[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            mount[i] = sc.nextInt();
        }

        int sum = 0;  // 可以达到的最大重量, 也就是全部加起来
        for (int i = 0; i < n; i++) {
            sum += weight[i] * mount[i];
        }

        List<Integer> Weight = new ArrayList<>(); // 放入所有砝码, 包括重复的
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < mount[i]; j++) {
                Weight.add(weight[i]);
            }
        }
        int len= Weight.size();
        HashSet<Integer> ok = new HashSet<>();

        boolean[][] dp = new boolean[len + 1][sum + 1]; // 第i号砝码能否凑出重量j, 这里的i包括了所以可以重复的砝码
        for (int i = 0; i < len + 1; i++) {
            dp[i][0] = true;  // 重量0肯定可以
        }

        for (int i = 1; i < len + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if (Weight.get(i - 1) > j) {
                    // 当上一个砝码的重量比重量j要大时, 是否能凑齐就看i-1个之前的砝码能否凑齐
                    // 因为第i个肯定超标了
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // 使用当前砝码或者不使用当前砝码
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - Weight.get(i - 1)];
                }
                if (dp[i][j]) {
                    ok.add(j);
                }
            }
        }
        System.out.println(ok.size() + 1);
    }
}
