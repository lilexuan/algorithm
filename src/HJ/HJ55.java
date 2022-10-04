package HJ;

import java.util.Scanner;

/**
 * @author kelvin
 * @create 2022-10-03 22:41
 */
public class HJ55 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 7 == 0 || String.valueOf(i).contains("7")) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
