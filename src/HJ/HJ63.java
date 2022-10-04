package HJ;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author kelvin
 * @create 2022-10-04 10:51
 */
public class HJ63 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int n = sc.nextInt();
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('A', 0);
        map.put('C', 0);
        map.put('G', 0);
        map.put('T', 0);
        int left = 0, right = n - 1;
        for (int i = left; i <= right; i++) {
            map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
        }
        int resLeft = left, resRight = right;
        double max = getCGRate(map);
        map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
        left++;
        right++;
        while (right < s.length()) {
            map.put(s.charAt(right), map.get(s.charAt(right)) + 1);
            if (getCGRate(map) > max) {
                resLeft = left;
                resRight = right;
                max = getCGRate(map);
            }
            map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
            left++;
            right++;
        }
        System.out.println(s.substring(resLeft, resRight + 1));
    }

    private static double getCGRate(HashMap<Character, Integer> map) {
        return 1.0 * (map.get('C') + map.get('G')) / (map.get('A') + map.get('C') + map.get('G') + map.get('T'));
    }
}
