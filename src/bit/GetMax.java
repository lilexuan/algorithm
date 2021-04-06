package bit;

import java.util.Random;

public class GetMax {
    /**
     * 判断n是非负数还是负数
     * @param n
     * @return n是非负数返回1, n是负数, 返回0
     */
    public static int sign(int n) {
        return flip((n >> 31) & 1);
    }

    /**
     * 对0或者1进行翻转
     * @param n 必须保证n是0或者1
     * @return
     */
    public static int flip(int n) {
        return n ^ 1;
    }

    public static int getMax1(int a, int b) {
        int c = a - b;
        int scA = sign(c);
        int scB = flip(scA);
        return scA * a + scB * b;
    }

    public static int getMax2(int a, int b) {
        int c = a - b;
        int sa = sign(a);
        int sb = sign(b);
        int sc = sign(c);
        int diffSAB = sa ^ sb;
        int sameSAB = flip(diffSAB);
        int returnA = diffSAB * sa + sameSAB * sc;
        int returnB = flip(returnA);
        return returnA * a + returnB * b;
    }

    public static void main(String[] args) {
        int a = 10, b = 20;
        System.out.println(getMax1(a, b));
        System.out.println(getMax2(a, b));
    }
}
