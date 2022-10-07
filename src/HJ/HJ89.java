package HJ;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author kelvin
 * @create 2022-10-07 10:45
 */
public class HJ89 {
    private static ArrayList<String> res = new ArrayList<>();
    private static final String[] pokesLevel = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < pokesLevel.length; i++) {
            map.put(pokesLevel[i], i + 1);
        }
        String[] split = s.split(" ");
        int[] nums = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            if (!map.containsKey(split[i])) {
                System.out.println("ERROR");
                return;
            }
            nums[i] = map.get(split[i]);
        }
        boolean[] visited = new boolean[nums.length];
        LinkedList<String> path = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            visited[i] = true;
            path.addLast(pokesLevel[nums[i] - 1]);
            dfsHJ89(nums, visited, path, nums[i]);
            path.removeLast();
            visited[i] = false;
        }
        if (!res.isEmpty()) {
            for (String r : res) {
                System.out.print(r);
            }
        } else {
            System.out.println("NONE");
        }

    }

    private static void dfsHJ89(int[] nums, boolean[] visited, LinkedList<String> path, int sum) {
        if (path.size() == nums.length) {
            if (sum == 24) {
                res = new ArrayList<>(path);
            }
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                path.addLast("+" + pokesLevel[nums[i] - 1]);
                dfsHJ89(nums, visited, path, sum + nums[i]);
                path.removeLast();

                path.addLast("-" + pokesLevel[nums[i] - 1]);
                dfsHJ89(nums, visited, path, sum - nums[i]);
                path.removeLast();

                path.addLast("*" + pokesLevel[nums[i] - 1]);
                dfsHJ89(nums, visited, path, sum * nums[i]);
                path.removeLast();

                path.addLast("/" + pokesLevel[nums[i] - 1]);
                dfsHJ89(nums, visited, path, sum / nums[i]);
                path.removeLast();

                visited[i] = false;

            }
        }
    }
}
