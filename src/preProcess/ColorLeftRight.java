package preProcess;

/**
 * @author kelvin
 * @create 2021-04-12 19:08
 */
public class ColorLeftRight {
    public static int getColorWaysBF(String s) {
        char[] chs = s.toCharArray();
        int n = chs.length;
        // R的范围为0~r
        int res = Integer.MAX_VALUE;
        for (int r = -1; r < n; r++) {
            int toR = 0, toG = 0;
            for (int i = 0; i <= r; i++) {
                if (chs[i] == 'G') {
                    toR++;
                }
            }
            for (int i = r + 1; i < n; i++) {
                if (chs[i] == 'R') {
                    toG++;
                }
            }
            res = Math.min(res, toR + toG);
        }
        return res;
    }

    public static int getColorWayPreprocess(String s) {
        char[] chs = s.toCharArray();
        int n = chs.length;
        int[] leftG = new int[n];
        int[] rightR = new int[n];
        for (int i = 0; i < n; i++) {
            if (chs[i] == 'G') {
                leftG[i] = i == 0 ? 1 : leftG[i - 1] + 1;
            } else {
                leftG[i] = i == 0 ? 0 : leftG[i - 1];
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            if (chs[i] == 'R') {
                rightR[i] = i == n - 1 ? 1 : rightR[i + 1] + 1;
            } else {
                rightR[i] = i == n - 1 ? 0 : rightR[i + 1];
            }
        }
        int res = Integer.MAX_VALUE;
        for (int r = -1; r < n; r++) {
            int tmp;
            if (r == -1) {
                tmp = rightR[0];
            } else if (r == n - 1) {
                tmp = leftG[n - 1];
            } else {
                tmp = leftG[r] + rightR[r + 1];
            }
            res = Math.min(res, tmp);
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "RGRGR";
        System.out.println(getColorWaysBF(s));
        System.out.println(getColorWayPreprocess(s));
    }
}
