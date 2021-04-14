package recur;

public class TranslateNum {
    public static int count(char[] chs, int i) {
        if (i == chs.length) {
            return 1;
        }
        if (chs[i] == '0') {
            return 0;
        }
        if (chs[i] == '1') {
            int res = count(chs, i + 1);
            if (i + 1 < chs.length) {
                res += count(chs, i + 2);
            }
            return res;
        }
        if (chs[i] == '2') {
            int res = count(chs, i + 1);
            if (i + 1 <chs.length && (chs[i + 1] >= '0' && chs[i + 1] <= '6')) {
                res += count(chs, i + 2);
            }
            return res;
        }
        return count(chs, i + 1);
    }

    public static void main(String[] args) {
        String str1 = "1250156147";
        String str2 = "2361267258";
        System.out.println(count(str1.toCharArray(), 0));
        System.out.println(count(str2.toCharArray(), 0));
    }
}
