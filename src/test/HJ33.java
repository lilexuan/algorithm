package test;

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class HJ33 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String ip = sc.nextLine();
        String num = sc.nextLine();
        System.out.println(ip2num(ip));
        System.out.println(num2ip(num));
    }

    private static long ip2num(String ip) {
        String[] ipArr = ip.split("\\.");
        String binary = "";
        for (int i = 0; i < ipArr.length; i++) {
            binary += toBinary(ipArr[i]);
        }
        return Long.parseLong(binary, 2);
    }

    private static String toBinary(String num) {
        String s = Long.toBinaryString(Long.parseLong(num));
        int size = s.length();
        for (int i = 0; i < 8 - size; i++) {
            s = "0" + s;
        }
        return s;
    }

    private static String num2ip(String num) {
        String binary = Long.toBinaryString(Long.parseLong(num));
        int size = binary.length();
        for (int i = 0; i < 32 - size; i++) {
            binary = "0" + binary;
        }
        String res = "";
        for (int i = 1; i <= 4; i++) {
            res += Integer.parseInt(binary.substring(8 * (i - 1), 8 * i), 2);
            if (i < 4) {
                res += ".";
            }
        }
        return res;
    }
}