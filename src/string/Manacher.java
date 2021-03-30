package string;

import java.util.Arrays;

public class Manacher {
    public static char[] manacherString(String str) {
        char[] chs = str.toCharArray();
        char[] res = new char[chs.length * 2 + 1];
        int index = 0;
        for (int i = 0; i < res.length; i++) {
            res[i] = i % 2 == 0 ? '#' : chs[index++];
        }
        return res;
    }

    public static String maxLcpsLength(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        char[] chs = manacherString(str);
        int[] pArr = new int[chs.length];
        int C = -1, R = -1;  // 最右的有效区是R-1位置
        int max = Integer.MIN_VALUE;
        int center = 0;
        for (int i = 0; i < chs.length; i++) {  // 每一个位置都求回文半径
            // i在R外, pArr[i]=1, 回文半径为1
            // i在R内, 2*C-i是i'的位置, 那么回文半径就是求pArr[i']和R-i的最小值
            // 这一句就是求出了最起码的回文半径, 后面还会继续更新
            pArr[i] = R > i ? Math.min(pArr[2 * C - i], R - i) : 1;

            // 从最起码的回文半径开始, 尝试扩大回文半径
            while (i + pArr[i] < chs.length && i - pArr[i] > -1) {
                if (chs[i + pArr[i]] == chs[i - pArr[i]]) {
                    pArr[i]++;
                } else {
                    break;
                }
            }
            if (i + pArr[i] > R) {
                R = i + pArr[i];
                C = i;
            }
            if (pArr[i] > max) {
                max = pArr[i];
                center = i;
            }
        }
        int len = max - 1;
        int beginIndex = (center - len) / 2;
        return str.substring(beginIndex, beginIndex + len);
    }

    public static void main(String[] args) {
        String str1 = "abc1234321ab";
        System.out.println(maxLcpsLength(str1));
        System.out.println(maxLcpsLength(str1).length());
    }
}
