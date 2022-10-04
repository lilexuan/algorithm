package HJ;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Scanner;

/**
 * @author kelvin
 * @create 2022-10-04 8:49
 */
public class HJ59 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        String res = "-1";
        for (char c : map.keySet()) {
            if (map.get(c) == 1) {
                res = String.valueOf(c);
                break;
            }
        }
        System.out.println(res);
    }
}
