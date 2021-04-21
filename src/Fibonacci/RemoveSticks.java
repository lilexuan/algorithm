package Fibonacci;

public class RemoveSticks {
    /**
     * 计算有多少个斐波那契数
     * @param n
     * @return
     */
    public static int removeSticks(int n) {
        if (n <= 3) {
            return 0;
        }
        int k2 = 2;
        int k1 = 3;
        int num = 3;
        while (k2 + k1 <= n) {
            num++;
            k1 += k2;
            k2 = k1 - k2;
        }
        return n - num;
    }

    public static void main(String[] args) {
        System.out.println(removeSticks(17));
    }

}
