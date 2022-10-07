package HJ;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author kelvin
 * @create 2022-10-07 12:53
 */
public class HJ92 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            int max = 0;
            ArrayList<String> res = new ArrayList<>();
            String s = sc.nextLine();
            char[] chs = s.toCharArray();
            int left = 0, right = 0;
            while (right < chs.length) {
                while (left < chs.length && Character.isLetter(chs[left])) {
                    left++;
                    right++;
                }
                while (right < chs.length && Character.isDigit(chs[right])) {
                    right++;
                }
                if (right - left == max) {
                    res.add(s.substring(left, right));
                } else if (right - left > max) {
                    max = right - left;
                    res.clear();
                    res.add(s.substring(left, right));
                }
                left = right;
            }
            for (String ss : res) {
                System.out.print(ss);
            }
            System.out.println("," + res.get(0).length());
        }
    }
}
