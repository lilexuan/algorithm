package test;

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class HJ35 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] res = new int[n][n];
        int num = 1;
        for (int k = 0; k < n; k++) {
            for (int i = k; i >= 0; i--) {
                res[i][k - i] = num++;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i <= j) {
                    System.out.print(res[i][j]);
                    if (i != j) {
                        System.out.print(" ");
                    }
                }
            }
            System.out.println();
        }
    }
}