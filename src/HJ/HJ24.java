package HJ;

import java.util.Scanner;
import java.lang.Math;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class HJ24 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] t = new int[n];
        for (int i = 0; i < n; i++) {
            t[i] = sc.nextInt();
        }
        int[] left = new int[n];
        int[] right = new int[n];
        for (int i = right.length - 2; i >= 0; i--) {
            int max = -1;
            for (int j = i + 1; j < right.length; j++) {
                if (t[j] < t[i]) {
                    max = Math.max(max, right[j]);
                }
            }
            right[i] = max + 1;
        }
        for (int i = 1; i < left.length; i++) {
            int max = -1;
            for (int j = i - 1; j >= 0; j--) {
                if (t[j] < t[i]) {
                    max = Math.max(max, left[j]);
                }
            }
            left[i] = max + 1;
        }
        int index = -1, max = -1;
        for (int i = 1; i <= t.length - 1; i++) {
            if (left[i] + right[i] > max) {
                max = left[i] + right[i];
                index = i;
            }
        }
        System.out.println(n - left[index] - right[index] - 1);
    }
}