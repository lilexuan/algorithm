package hash;

import java.util.TreeMap;

public class Kdiff {
    public static int findPairs(int[] arr, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int res = 0;
        for (int num : map.keySet()) {
            if (k == 0) {
                if (map.get(num) >= 2) {
                    res++;
                     System.out.println("(" + num + "," + (num + k) + ")");
                }
            } else {
                if (map.containsKey(num + k)) {
                    res++;
                    System.out.println("(" + num + "," + (num + k) + ")");
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1};
        int k = 0;
        System.out.println(findPairs(nums, k));
    }
}
