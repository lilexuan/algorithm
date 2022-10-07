package HJ;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author kelvin
 * @create 2022-10-06 11:13
 */
public class HJ76 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = m * m * m;
        int a1 = (n - m * (m - 1)) / m;
        int a2 = n * 2 / m - a1;
        if (a1 > a2) {
            int tmp = a1;
            a1 = a2;
            a2 = tmp;
        }
        for (int i = a1; i <= a2; i += 2) {
            if (i != a1) {
                System.out.print("+");
            }
            System.out.print(i);
        }
    }
}
