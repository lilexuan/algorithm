package HJ;

import java.util.Scanner;

/**
 * @author kelvin
 * @create 2022-10-04 8:58
 */
public class Hj60 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int minDis = Integer.MAX_VALUE;
        int p1 = -1, p2 = -1;
        for (int i = 2; i <= n - 2; i++) {
            if (isPrimeHJ60(i) && isPrimeHJ60(n - i) && Math.abs(n -i - i)< minDis) {
                p1 = i;
                p2 = n - i;
                minDis = Math.abs(n - i - i);
            }
        }
        if (p2 > p1) {
            System.out.println(p1);
            System.out.println(p2);
        } else {
            System.out.println(p2);
            System.out.println(p1);
        }
    }

    public static boolean isPrimeHJ60(int num) {
        if (num == 1) {
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
