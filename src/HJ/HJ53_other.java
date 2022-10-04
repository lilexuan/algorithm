package HJ;

import java.util.Scanner;

/**
 * @author kelvin
 * @create 2022-10-03 22:33
 */
public class HJ53_other {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        if (num == 1 || num == 2) {
            System.out.println(-1);
        } else if (num % 4 == 1 || num % 4 == 3) {
            System.out.println(2);
        } else if (num % 4 == 0) {
            System.out.println(3);
        } else if (num % 4 == 2) {
            System.out.println(4);
        }
    }
}
