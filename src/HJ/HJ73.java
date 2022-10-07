package HJ;

import java.util.Scanner;

/**
 * @author kelvin
 * @create 2022-10-06 10:23
 */
public class HJ73 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt(), month = sc.nextInt(), day = sc.nextInt();
        int[] months = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (isLeap(year)) {
            months[2]++;
        }
        int res = 0;
        for (int i = 1; i < month; i++) {
            res += months[i];
        }
        System.out.println(res + day);
    }

    private static boolean isLeap(int year) {
        if (year % 100 == 0) {
            return year % 400 == 0;
        } else {
            return year % 4 == 0;
        }
    }
}
