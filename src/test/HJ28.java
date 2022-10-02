package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author kelvin
 * @create 2022-10-01 10:19
 */
public class HJ28 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        // 将数分为偶数和奇数
        List<Integer> evens = new ArrayList<>();
        List<Integer> odds = new ArrayList<>();
        for (int num : nums) {
            if (num % 2 == 0) {
                evens.add(num);
            } else {
                odds.add(num);
            }
        }

        int cnt = 0;
        int[] evenMatch = new int[evens.size()];
        // 遍历每一个奇数
        for (int odd : odds) {
            int[] used = new int[evens.size()]; // 用于标记偶数是否被查找过（对于某个奇数的匹配而言）
            if (findMatch(odd, evens, used, evenMatch)) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    private static boolean findMatch(int odd, List<Integer> evens, int[] used, int[] evenMatch) {
        // 遍历偶数：去检查当前传入的奇数能和哪些偶数进行匹配
        for (int i = 0; i < evens.size(); i++) {
            int even = evens.get(i);
            // 如果当前偶数和奇数匹配， 且当前偶数还没有匹配过奇数
            if (isPrimeHJ24(odd + even) && used[i] == 0) {
                // 设置当前偶数位匹配位true
                used[i] = 1;

                // 如果第i个偶数没有伴侣
                // 或者第i个偶数原来有伴侣, 该伴侣(奇数)可以重新找到他的偶数时
                // 此处的奇数可以设置为第i个偶数的标绿
                // 这就是匈牙利算法, 能让则让
                if (evenMatch[i] == 0 || findMatch(evenMatch[i], evens, used, evenMatch)) {
                    evenMatch[i] = odd;
                    return true;
                }
            }
        }
        // 遍历完偶数发现没有可以传入奇数做伴侣的, 返回false
        return false;
    }

    private static boolean isPrimeHJ24(int num) {
        if (num <= 1) {
            return false;
        }
        int k = (int)Math.sqrt(num);
        for (int i = 2; i <= k; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
