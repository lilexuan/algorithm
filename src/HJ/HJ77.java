package HJ;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author kelvin
 * @create 2022-10-06 12:02
 */
public class HJ77 {
    private static ArrayList<ArrayList<Integer>> res = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        LinkedList<Integer> trains = new LinkedList<>();
        LinkedList<Integer> stack = new LinkedList<>();
        LinkedList<Integer> path = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            trains.addLast(sc.nextInt());
        }
        dfsHJ77(n, trains, stack, path);
        res.sort((o1, o2) -> {
            for (int i = 0; i < o1.size(); i++) {
                if (!o1.get(i).equals(o2.get(i))) {
                    return o1.get(i) - o2.get(i);
                }
            }
            return 0;
        });
        for (ArrayList<Integer> arr : res) {
            for (int i = 0; i < arr.size(); i++) {
                if (i != 0) {
                    System.out.print(" ");
                }
                System.out.print(arr.get(i));
            }
            System.out.println();
        }

    }

    private static void dfsHJ77(int n, LinkedList<Integer> trains, LinkedList<Integer> stack, LinkedList<Integer> path) {
        if (path.size() ==n) {
            res.add(new ArrayList<>(path));
            return;
        }
        // 火车从trains队列进站(stack)
        if (!trains.isEmpty()) {
            stack.push(trains.removeFirst());
            dfsHJ77(n, trains, stack, path);
            trains.addFirst(stack.pop());
        }


        // 出站(stack)
        if (!stack.isEmpty()) {
            path.addLast(stack.pop());
            dfsHJ77(n,trains, stack, path);
            stack.push(path.removeLast());
        }
    }
}
