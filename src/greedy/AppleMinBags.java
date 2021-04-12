package greedy;

/**
 * @author kelvin
 * @create 2021-04-12 16:05
 */
public class AppleMinBags {
    public static int getMinBagsBF(int n) {
        int res = -1;
        for (int i = 0; 8 * i <= n; i++) {
            int rest = n - 8 * i;
            if (rest % 6 != 0) {
                continue;
            } else {
                res = res == -1 ? i + rest / 6 : Math.min(res, i + rest / 6);
            }
        }
        return res;
    }

    public static int getMinBagsPT(int n) {
        int[] table = {0, -1, -1, -1, -1, -1, 1, -1, 1, -1, -1, -1, 2, -1, 2, -1, 2, -1};
        if (n < 18) {
            return table[n];
        } else if (n % 2 == 1) {
            return -1;
        } else {
            return (n - 18) / 8 + 3;
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i <= 400; i++) {
            if (getMinBagsBF(i) != getMinBagsPT(i)) {
                System.out.println("fuck");
                return;
            }
        }
        System.out.println("nice");
    }
}
