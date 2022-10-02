package test;

import java.util.Scanner;

/**
 * @author kelvin
 * @create 2022-09-30 10:35
 */
public class HJ20 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            boolean res = isPwdValid(s);
            if (res) {
                System.out.println("OK");
            } else {
                System.out.println("NG");
            }
        }
    }

    private static boolean isPwdValid(String pwd) {
        if (pwd.length() <= 8) {
            return false;
        }
        int cntUp = 0, cntLow = 0, cntNum = 0, cntOther = 0;
        for (int i = 0; i < pwd.length(); i++) {
            char c = pwd.charAt(i);
            if (c == ' ' || c == '\n') {
                continue;
            } else if ('a' <= c && c <= 'z') {
                cntLow++;
            } else if ('A' <= c && c <= 'Z') {
                cntUp++;
            } else if ('0' <= c && c <= '9') {
                cntNum++;
            } else {
                cntOther++;
            }
        }
        int res = 0;
        if (cntUp > 0) res++;
        if (cntLow > 0) res++;
        if (cntNum > 0) res++;
        if (cntOther > 0) res++;
        if (res < 3) {
            return false;
        }
        for (int i = 0; i <= pwd.length() - 3; i++) {
            String subStr = pwd.substring(i, i + 3);
            if (pwd.indexOf(subStr) != pwd.lastIndexOf(subStr)) {
                return false;
            }
        }
        return true;
    }
}
