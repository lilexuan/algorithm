package HJ;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @author kelvin
 * @create 2022-10-04 8:24
 */
public class HJ56 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cnt = 0;
        for (int i = 1; i < n; i++) {
            if (isPerfect(i)) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    private static boolean isPerfect(int n) {
        if (n == 1) {
            return false;
        }
        int k = (int)Math.sqrt(n);
        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        for (int i = 2; i <= k; i++) {
            if (n % i == 0) {
                set.add(i);
                set.add(n / i);
            }
        }
        int sum = 0;
        for (int num : set) {
            sum += num;
        }
        return sum == n;
    }
}
