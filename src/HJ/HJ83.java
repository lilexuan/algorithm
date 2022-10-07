package HJ;

import java.util.Scanner;

/**
 * @author kelvin
 * @create 2022-10-06 16:40
 */
public class HJ83 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int m = sc.nextInt(), n = sc.nextInt();
            int initCode = m <= 9 && n <= 9 ? 0 : -1;
            System.out.println(initCode);
            int x1 = sc.nextInt(), y1 = sc.nextInt(), x2 = sc.nextInt(), y2 = sc.nextInt();
            if (initCode == 0) {
                int swapCode = (0 <= x1 && x1 < m && 0 <= x2 && x2 < m && 0 <= y1 && y1 <= n && 0 <= y2 && y2 <= n) ? 0 : -1;
                System.out.println(swapCode);
            } else {
                System.out.println(-1);
            }
            int x = sc.nextInt();
            if (initCode == 0) {
                int addxCode = m < 9 && 0 <= x && x < m ? 0 : -1;
                System.out.println(addxCode);
            } else {
                System.out.println(-1);
            }
            int y = sc.nextInt();
            if (initCode == 0) {
                int addyCode = n < 9 && 0 <= y && y < n ? 0 : -1;
                System.out.println(addyCode);
            } else {
                System.out.println(-1);
            }
            x = sc.nextInt();
            y = sc.nextInt();
            if (initCode == 0) {
                int queryCode = (0 <= x && x < m && 0 <= y && y < n) ? 0 : -1;
                System.out.println(queryCode);
            } else {
                System.out.println(-1);
            }
        }
    }

}
