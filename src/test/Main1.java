package test;
import java.util.Scanner;
public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long a = in.nextLong();
        long b = in.nextLong();
        long c = in.nextLong();
        long preSum = 2 * a + 3 * b + 4 * c;
        long cnt = a + b + c;
        long d = 0L;
        while (Math.round((preSum + d * 5) * 1.0 / cnt) < 4) {
            cnt++;
            d++;
        }
        System.out.println(d);
    }
}