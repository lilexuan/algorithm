package HJ;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * @author kelvin
 * @create 2022-10-03 9:07
 */
public class HJ45 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        while (n-- > 0) {
            String s = sc.nextLine();
            HashMap<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
            List<Integer> list = new ArrayList<>(map.values());
            list.sort((i1, i2) -> i2 - i1);
            int pretty = 26;
            int res = 0;
            for (int num : list) {
                res += pretty * num;
                pretty--;
            }
            System.out.println(res);
        }
    }
}
