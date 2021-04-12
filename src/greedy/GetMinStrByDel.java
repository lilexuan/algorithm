package greedy;

import java.util.*;

/**
 * @author kelvin
 * @create 2021-04-10 15:45
 */
public class GetMinStrByDel {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String str = sc.nextLine();
        String str = "acbc";
        String res = getMinStrFalse(str);
        System.out.println(res);
    }

    private static String getMinStrFalse(String str) {
        char[] chs = str.toCharArray();
        Deque<Character> deque = new LinkedList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < chs.length; i++) {
            char c = chs[i];
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < chs.length; i++) {
            char c = chs[i];
            Deque<Character> stack = new LinkedList<>();
            while (!deque.isEmpty()) {
                char popC = deque.pollLast();
                if (map.get(popC) == 0 || popC < c) {
                    stack.push(popC);
                } else {
                    set.remove(popC);
                }
            }
            while (!stack.isEmpty()) {
                deque.addLast(stack.pop());
            }
            if (!set.contains(c)) {
                deque.addLast(c);
                set.add(c);
                map.put(c, map.get(c) - 1);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : deque) {
            sb.append(c);
        }
        return sb.toString();
    }
}
