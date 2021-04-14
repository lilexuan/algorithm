package problem.median;

public class ParenthesesDeep {
    public static int getDeep(String s) {
        char[] chs = s.toCharArray();
        int res = Integer.MIN_VALUE;
        int cnt = 0;
        for (int i = 0; i < chs.length; i++) {
            if (chs[i] == '(') {
                cnt++;
            } else {
                cnt--;
            }
            if (cnt < 0) {
                cnt = 0;
            }
            res = Math.max(res, cnt);
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "(())";
        System.out.println(getDeep(s));
    }
}
