package test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author kelvin
 * @create 2022-10-01 15:20
 */
public class HJ34 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char[] chs = s.toCharArray();
        Arrays.sort(chs);
        System.out.println(chs);
    }
}
