package math;

public class Mod3 {
    public static int getMod3Num(int l, int r) {
        int sum = 0;
        for (int i = l; i <= r; i++) {
            long tmp = (long) (i + 1) * (long)i / 2L;
            if (tmp % 3 == 0) {
                sum++;
            }
        }
        return sum;
    }
}
