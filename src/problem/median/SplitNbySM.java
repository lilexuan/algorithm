package problem.median;

public class SplitNbySM {
    /**
     * 判断一个数是不是质数
     * @param n
     * @return
     */
    public static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        int max = (int) Math.sqrt(n);
        for (int i = 2; i <= max; i++) {
            if (n % i ==0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 分解一个数, 获取因子
     * @param n n不能是正数
     * @return res[0], 所有因子的和, 这个因子不包括1
     *         res[1], 所有因子的个数, 这个因子不包括1
     */
    public static int[] factor(int n) {
        int sum = 0;
        int cnt = 0;
        for (int i = 2; i <= n; i++) {
            if (n % i == 0) {
                sum += i;
                cnt++;
                System.out.print(i + " ");
                n /= i;
            }
        }
        System.out.println();
        return new int[] {sum, cnt};
    }

    public static int minOps(int n) {
        if (n < 2) {
            return 0;
        }
        if (isPrime(n)) {
            return n - 1;
        }
        int[] res = factor(n);
        return res[0] - res[1];
    }

    public static void main(String[] args) {
        int n = 36;
        System.out.println(minOps(36));
    }
}
