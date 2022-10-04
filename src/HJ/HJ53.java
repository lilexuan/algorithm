package HJ;

import java.util.Scanner;

/**
 * @author kelvin
 * @create 2022-10-03 22:08
 */
public class HJ53 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] m = new int[2][2 * n];
        m[1][1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= 2 * n - 1; j++) {
                int sum = 0;
                if (j - 2 >= 1) sum += m[(i - 1) & 1][j - 2];
                if (j - 1 >= 1) sum += m[(i - 1) & 1][j - 1];
                sum += m[(i - 1) & 1][j];
                m[i & 1][j] = sum;
            }
        }
        int res = -1;
        for (int j = 1; j <= 2 * n - 1; j++) {
            if (m[n & 1][j] != 0 && m[n & 1][j] % 2 == 0) {
                res = j;
                break;
            }
        }
        System.out.println(res);
    }
}
