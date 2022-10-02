package test;

import java.util.LinkedHashMap;

/**
 * @author kelvin
 * @create 2022-09-30 10:01
 */
public class LinkedMapTest {
    public static void main(String[] args) {
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        map.put(1, 2);
        map.put(3, 4);
        map.put(1, map.getOrDefault(1, 0) + 1);
        for (int key : map.keySet()) {
            System.out.println(key + ":" + map.get(key));
        }
    }
}
