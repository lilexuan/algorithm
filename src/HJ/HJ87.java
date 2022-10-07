package HJ;

import java.util.Scanner;

/**
 * @author kelvin
 * @create 2022-10-07 8:49
 */
public class HJ87 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int score = 0;

        // 长度
        if (s.length() <= 4) {
            score += 5;
        } else if (s.length() <= 7) {
            score += 10;
        } else {
            score += 25;
        }

        int cntLetter = 0, cntNum = 0, cntAscii = 0, cntUpper = 0, cntLower = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLetter(c)) {
                cntLetter++;
                if (Character.isUpperCase(c)) {
                    cntUpper++;
                }
                if (Character.isLowerCase(c)) {
                    cntLower++;
                }
            } else if (Character.isDigit(c)) {
                cntNum++;
            } else {
                cntAscii++;
            }
        }

        // 字母
        if ((cntUpper != 0 && cntLower == 0) || (cntUpper == 0 && cntLower != 0)) {
            score += 10;
        } else if (cntUpper != 0 && cntLower != 0) {
            score += 20;
        }

        // 数字
        if (cntNum == 1) {
            score += 10;
        } else if (cntNum > 1) {
            score += 20;
        }

        // 符号
        if (cntAscii == 1) {
            score += 10;
        } else if (cntAscii > 1) {
            score += 25;
        }

        // 奖励
        if (cntUpper > 0 && cntLower > 0 && cntNum > 0 && cntAscii > 0) {
            score += 5;
        } else if (cntLetter > 0 && cntNum > 0 && cntAscii > 0) {
            score += 3;
        } else if (cntLetter > 0 && cntNum > 0) {
            score += 2;
        }

        // 评分
        if (score >= 90) {
            System.out.println("VERY_SECURE");
        } else if (score >= 80) {
            System.out.println("SECURE");
        } else if (score >= 70) {
            System.out.println("VERY_STRONG");
        } else if (score >= 60) {
            System.out.println("STRONG");
        } else if (score >= 50) {
            System.out.println("AVERAGE");
        } else if (score >= 25) {
            System.out.println("WEAK");
        } else {
            System.out.println("VERY_WEAK");
        }
    }
}
