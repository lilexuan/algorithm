package HJ;

import java.util.Scanner;

/**
 * @author kelvin
 * @create 2022-10-06 15:11
 */
public class HJ82_others {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String[] sa = scanner.nextLine().split("/");
            int f1 = Integer.parseInt(sa[0]);
            int f2 = Integer.parseInt(sa[1]);
            for (int i = 0; i < f1; i++) {
                if (i + 1 < f1) {
                    System.out.print("1/" + f2 + "+");
                } else {
                    System.out.println("1/" + f2);
                }
            }
        }
    }
}
