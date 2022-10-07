package HJ;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author kelvin
 * @create 2022-10-05 23:21
 */
public class HJ72 {
    private static ArrayList<ArrayList<Integer>> res = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] price = {5, 3, 1};
        dfsHJ72(0, price, 100, 100, new LinkedList<>());
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

    public static void dfsHJ72(int index, int[] price, int chickNum, int balance, LinkedList<Integer> path) {
        if (index == price.length) {
            if (chickNum == 0 && balance == 0) {
                res.add(new ArrayList<>(path));
            }
            return;
        }
        if (index != 2) {
            for (int i = 0; i <= chickNum && balance - price[index] * i >= 0; i++) {
                path.addLast(i);
                dfsHJ72(index + 1, price, chickNum - i, balance - price[index] * i, path);
                path.removeLast();
            }
        } else {
            for (int i = 0; i <= chickNum && balance - price[index] * i / 3 >= 0; i += 3) {
                path.addLast(i);
                dfsHJ72(index + 1, price, chickNum - i, balance - price[index] * i / 3, path);
                path.removeLast();
            }
        }
    }
}
