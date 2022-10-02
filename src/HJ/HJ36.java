package HJ;

import java.util.LinkedHashSet;
import java.util.Scanner;

/**
 * @author kelvin
 * @create 2022-10-01 16:48
 */
public class HJ36 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String key = sc.nextLine();
        String s = sc.nextLine();
        String oriTable = "abcdefghijklmnopqrstuvwxyz";
        String newTalbe = createNewTalbe(oriTable, key);
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            res.append(newTalbe.charAt(c - 'a'));
        }
        System.out.println(res);
    }

    private static String createNewTalbe(String oriTable, String key) {
        char[] keyChs = key.toCharArray();
        char[] oriChs = oriTable.toCharArray();
        LinkedHashSet<Character> set = new LinkedHashSet<>();
        for (char c : keyChs) {
            set.add(c);
        }
        for (char c : oriChs) {
            set.add(c);
        }
        StringBuilder s = new StringBuilder();
        for (char c : set) {
            s.append(c);
        }
        return s.toString();
    }
}
