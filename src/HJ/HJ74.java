package HJ;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author kelvin
 * @create 2022-10-06 10:38
 */
public class HJ74 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        boolean needQuo = false;
        ArrayList<String> res = new ArrayList<>();
        int begin = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ' && !needQuo) {
                String substr = s.substring(begin, i);
                if (substr.length() > 0) {
                    res.add(substr);
                }
                begin = i + 1;
            } else if (c == '"') {
                if (!needQuo) {
                    needQuo = true;
                    begin = i + 1;
                } else {
                    String substr = s.substring(begin, i);
                    if (substr.length() > 0) {
                        res.add(substr);
                    }
                    begin = i + 1;
                    needQuo = false;
                }
            }
        }
        if (begin < s.length()) {
            res.add(s.substring(begin));
        }
        System.out.println(res.size());
        for (String r : res) {
            System.out.println(r);
        }
    }
}
