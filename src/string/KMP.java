package string;

public class KMP {
    public static int getIndexOf(String s, String m) {
        if (s == null || m == null || m.length() < 1 || s.length() < m.length()) {
            return -1;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = m.toCharArray();
        int x = 0, y = 0;
        int[] next = getNextArr(str2);
        while (x < str1.length && y < str2.length) {
            if (str1[x] == str2[y]) {  // 如果字符相等, 则一起往前走
                x++;
                y++;
            } else if (next[y] == -1) {  // y不能再往前走了, 只能让x往前走
                x++;
            } else {  // 剩下的情况就是, y往后跳
                y = next[y];
            }
        }
        // 如果y能走到最后, 说明每一个位置都和str1对上了, 那么返回str1中开始对上的位置
        // 否则说明没有对上, 返回-1
        return y == str2.length ? x - y : -1;
    }

    private static int[] getNextArr(char[] m) {
        if (m.length == 1) {
            return new int[]{-1};
        }
        int[] next = new int[m.length];
        next[0] = -1;
        next[1] = 0;
        int i = 2;
        int cn = 0;  // 也就是笔记中问号的位置
        while (i < next.length) {
            if (m[i - 1] == m[cn]) {  // i-1位置和?位置能对上, 则设置next值, i往前走
                next[i] = ++cn;
                i++;
            } else if (cn > 0) {  // i-1位置和?位置不能对上, 而且?位置不等于-1, 可以往后跳
                cn = next[cn];
            } else {  // 前后缀完全不相等, 只能让next值等于0, 然后i继续往前走
                next[i] = 0;
                i++;
            }
        }
        return next;
    }

    public static void main(String[] args) {
        String str = "abcabcababaccc";
        String match = "ababa";
        System.out.println(getIndexOf(str, match));
    }
}
