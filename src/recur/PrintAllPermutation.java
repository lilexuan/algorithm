package recur;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class PrintAllPermutation {
    public static void printPermutation(String str) {
        StringBuilder sb = new StringBuilder();
        Set<Character> set = new HashSet<>();
        printPermutation(str, sb, set);
    }

    private static void printPermutation(String str, StringBuilder sb, Set<Character> set) {
        if (sb.length() == str.length()) {
            System.out.println(sb);
            return;
        }

        char[] chs = str.toCharArray();
        for (char c :chs) {
//            if (sb.toString().contains(String.valueOf(c))) {
//                continue;
//            }
            // 如果不想用上面那个时间复杂度为O(n)的contains的话, 就必须新增一个hashset, 并且传到递归函数里面
            if (set.contains(c)) {
                continue;
            }
            set.add(c);
            sb.append(c);
            printPermutation(str, sb, set);
            sb.deleteCharAt(sb.length() - 1);
            set.remove(c);
        }
    }

    public static void main(String[] args) {
        printPermutation("abc");
    }
}
