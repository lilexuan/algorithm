package greedy;

import string.StringTools;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 *  求字符串数组的最小字典序
 */

public class LowestLexicography {
    public static String lowestString1(String[] strs) {
        Arrays.sort(strs);
        return array2String(strs);
    }

    public static String lowestString2(String[] strs) {
        Arrays.sort(strs, (str1, str2) -> {
            return (str1 + str2).compareTo(str2 + str1);
        });
        return array2String(strs);
    }

    /**
     * brute force
     * @param strs
     * @return
     */
    public static String lowestStringBF(String[] strs) {
        LinkedList<String> arrange = new LinkedList<>();  // 存储字符串们的排列
        LinkedList<LinkedList<String>> res = new LinkedList<>();  // 存储所有的排列
        backtrace(strs, arrange, res);
        String minStr = null;
        for (LinkedList<String> strings : res) {
            String str = array2String(strings);
            if (minStr == null) {
                minStr = str;
            } else {
                minStr = str.compareTo(minStr) < 0 ? str : minStr;
            }
        }
        return minStr;
    }

    private static void backtrace(String[] strs, LinkedList<String> arrange, LinkedList<LinkedList<String>> res) {
        if (arrange.size() == strs.length) {
            res.add(new LinkedList<>(arrange));
            return;
        }
        for (String str : strs) {
            if (arrange.contains(str)) {
                continue;
            }
            arrange.addLast(str);
            backtrace(strs, arrange, res);
            arrange.removeLast();
        }
    }

    private static String array2String(String[] strs) {
        StringBuffer sb = new StringBuffer();
        for (String str : strs) {
            sb.append(str);
        }
        return sb.toString();
    }

    private static String array2String(List<String> strs) {
        StringBuffer sb = new StringBuffer();
        for (String str : strs) {
            sb.append(str);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int testTime = 100000, stringMaxLength = 10, arrayMaxLength = 20;
        for (int i = 0; i < testTime; i++) {
            String[] strs = StringTools.generateRandomStringArray(arrayMaxLength, stringMaxLength);
            String res1 = lowestString1(strs);
            String res2 = lowestString2(strs);
            String resBF = lowestStringBF(strs);
            if (!res1.equals(resBF) || !res2.equals(resBF)) {
                System.out.println("Error!");
                System.out.println(Arrays.toString(strs));
                System.out.println(" res1: " + res1);
                System.out.println(" res2: " + res2);
                System.out.println("resBF: " + resBF);
            }
        }
        System.out.println("Nice!");
    }
}
