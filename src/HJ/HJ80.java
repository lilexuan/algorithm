package HJ;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * @author kelvin
 * @create 2022-10-06 14:19
 */
public class HJ80 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = "1";
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            set.add(sc.nextInt());
        }
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            set.add(sc.nextInt());
        }
        for (int num : set) {
            System.out.print(num);
        }
    }
}
