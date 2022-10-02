package HJ;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @author kelvin
 * @create 2022-10-02 8:33
 */
public class HJ41 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] m = new int[n];
        int[] x = new int[n];
        for (int i = 0; i < n; i++) {
            m[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
        }
        HashSet<Integer> set = new HashSet<>();
        processHJ41(0, m, x, set, 0);
        System.out.println(set.size());
    }

    private static void processHJ41(int index, int[] m, int[] x, HashSet<Integer> set, int weight) {
        if (index == m.length) {
            return;
        }
        for (int i = 0; i <= x[index]; i++) {
            int newWeight = weight + i * m[index];
            set.add(newWeight);
            processHJ41(index + 1, m, x, set, newWeight);
        }
    }
}
