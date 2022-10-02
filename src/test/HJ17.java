package test;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * @author kelvin
 * @create 2022-09-29 21:13
 */
public class HJ17 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] coords = s.split(";");
        int x = 0, y = 0;
        for (String coord : coords) {
            if (isValid(coord)) {
                char c = coord.charAt(0);
                int num = Integer.parseInt(coord.substring(1));
                if (c == 'A') {
                    x -= num;
                }
                if (c == 'S') {
                    y -= num;
                }
                if (c == 'W') {
                    y += num;
                }
                if (c == 'D') {
                    x += num;
                }
            }
        }
        System.out.println(x + "," + y);
    }

    private static boolean isValid(String coord) {
        String pattern = "^[ASWD][0-9]{1,2}$";
        return Pattern.matches(pattern, coord);
    }
}
