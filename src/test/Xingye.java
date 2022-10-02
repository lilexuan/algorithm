package test;

import java.util.Arrays;

/**
 * @author kelvin
 * @create 2021-10-24 16:18
 */
public class Xingye {
    public static int[] test(String str1) {
        int[] res = new int[4];
        for (int i = 0; i < str1.length(); i++) {
            char c = str1.charAt(i);
            if (('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z')) {
                res[1]++;
            } else if ('0' <= c && c <= '9') {
                res[2]++;
            } else if (c == ' ') {
                res[3]++;
            } else if (c >= 0x4E00 && c <= 0x9FA5) {
                res[0]++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] test = test("222df&& 人");
        System.out.println(Arrays.toString(test));
    }
}
