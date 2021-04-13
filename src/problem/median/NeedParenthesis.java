package problem.median;

/**
 * @author kelvin
 * @create 2021-04-13 14:46
 */
public class NeedParenthesis {
    public static int getNeed(String s) {
        int cnt = 0;
        int res = 0;
        char[] chs = s.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            if (chs[i] == '(') {
                cnt++;
            } else {
                cnt--;
            }
            if (cnt < 0) {
                cnt = 0;
                res++;
            }
        }
        if (cnt > 0) {
            res += cnt;
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "())(";
        System.out.println(getNeed(s));
    }
}
