package HJ;

import java.util.Scanner;

/**
 * @author kelvin
 * @create 2022-10-06 17:35
 */
public class HJ86 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        String numStr = Integer.toBinaryString(num);
        int max = 0, cnt = 0;
        for (int i = 0; i < numStr.length(); i++) {
            char c = numStr.charAt(i);
            if (c == '1') {
                cnt++;
            } else {
                cnt = 0;
            }
            max = Math.max(cnt, max);
        }
        System.out.println(max);
    }
}
