package HJ;

import java.util.*;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class HJ30 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String ss = sc.nextLine();
        String[] split = ss.split(" ");
        String s = split[0] + split[1];
        List<Character> evens = new ArrayList<>();
        List<Character> odds = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (i % 2 == 0) {
                evens.add(c);
            } else {
                odds.add(c);
            }
        }
        evens.sort((c1, c2) -> c1.compareTo(c2));
        odds.sort((c1, c2) -> c1.compareTo(c2));
        char[] chs = new char[s.length()];
        int ie = 0, io = 0;
        for (int i = 0; i < chs.length; i++) {
            if (i % 2 == 0) {
                chs[i] = transfer(evens.get(ie++));
            } else {
                chs[i] = transfer(odds.get(io++));
            }
        }
        System.out.println(chs);
    }

    private static char transfer(char c) {
        if (!isNum(c)) {
            return c;
        }
        String s = toBinary(c);
        s = flip(s);
        int num = Integer.parseInt(s, 2);
        char[] list = {'0', '1', '2', '3', '4', '5', '6', '7' , '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        return list[num];
    }

    private static String toBinary(char c) {
        int num;
        if ('0' <= c && c <= '9') {
            num = c - '0';
        } else {
            c = Character.toLowerCase(c);
            num = (c - 'a') + 10;
        }
        String s = Integer.toBinaryString(num);
        int size = s.length();
        for (int i = 0; i < 4 - size; i++) {
            s = "0" + s;
        }
        return s;
    }

    private static String flip(String s) {
        char[] chs = s.toCharArray();
        int left = 0, right = chs.length - 1;
        while (left <= right) {
            char tmp = chs[left];
            chs[left] = chs[right];
            chs[right] = tmp;
            left++;
            right--;
        }
        return String.valueOf(chs);
    }

    private static boolean isNum(char c) {
        return ('0' <= c && c <= '9') || ('a' <= c && c <= 'f') || ('A' <= c && c <= 'F');
    }
}