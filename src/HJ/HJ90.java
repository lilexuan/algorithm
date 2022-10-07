package HJ;

import java.util.Scanner;

/**
 * @author kelvin
 * @create 2022-10-07 12:25
 */
public class HJ90 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String ip = sc.nextLine();
        String[] ipArr = ip.split("\\.");
        if (ipArr.length != 4) {
            System.out.println("NO");
            return;
        }
        String flag = "YES";
        for (String part : ipArr) {
            if (part.length() == 0 || (part.startsWith("0") && part.length() != 1) || part.startsWith("+")) {
                flag = "NO";
                break;
            }
            int num = Integer.parseInt(part);
            if (num < 0 || num > 255) {
                flag = "NO";
                break;
            }
        }
        System.out.println(flag);
    }
}
