package HJ;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author kelvin
 * @create 2022-10-07 14:38
 */
public class HJ94 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String[] names = sc.nextLine().split(" ");
        int m = Integer.parseInt(sc.nextLine());
        String[] votes = sc.nextLine().split(" ");
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        for (String name : names) {
            map.put(name, 0);
        }
        map.put("Invalid", 0);
        for (String vote : votes) {
            if (map.containsKey(vote)) {
                map.put(vote, map.get(vote) + 1);
            } else {
                map.put("Invalid", map.get("Invalid") + 1);
            }
        }
        for (String name : map.keySet()) {
            System.out.println(name + " : " + map.get(name));
        }
    }
}
