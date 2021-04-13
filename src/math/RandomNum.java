package math;

/**
 * @author kelvin
 * @create 2021-04-13 11:39
 */
public class RandomNum {
    public static int rand1to5() {
        return (int) (Math.random() * 5) + 1;
    }

    public static int rand1to7() {
        int num = 0;
        do {
            num = (rand1to5() - 1) * 5 + rand1to5() + 1;
        } while (num > 20);
        return num % 7 + 1;
    }

    public static int rand01p(double p) {
        return Math.random() < p ? 0 : 1;
    }

    public static int rand01() {
        int num;
        double p = 0.83;
        do {
            num = rand01p(p);
        } while (num == rand01p(p));
        return num;
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        int cnt0 = 0, cnt1 = 0;
        for (int i = 0; i < 1000000; i++) {
            System.out.println(i);
            int res = rand01();
            if (res == 0) {
                cnt0++;
            } else {
                cnt1++;
            }
        }
        System.out.println("0: " + cnt0);
        System.out.println("1: " + cnt1);
        long endTime = System.currentTimeMillis();
        System.out.println("运行时间: " + (endTime - startTime) / 1000 + "s");
    }
}
