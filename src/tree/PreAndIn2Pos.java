package tree;

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class PreAndIn2Pos {
    private static int posIndex;
    private static Map<Integer, Integer> map = null;
    private static int[] pos = null;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        map = new HashMap<>();
        int n = sc.nextInt();
        int[] pre = new int[n];
        int[] in = new int[n];
        for (int i = 0; i < n; i++) {
            pre[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            in[i] = sc.nextInt();
            map.put(in[i], i);
        }
        pos = new int[n];
        posIndex = n - 1;
        process(pre, 0, n - 1, in, 0, n - 1);
        for (int i = 0; i < n; i++) {
            if (i != 0) {
                System.out.print(" ");
            }
            System.out.print(pos[i]);
        }
    }

    public static void process(int[] pre, int preL, int preR, int[] in, int inL, int inR) {
        if (preL > preR || inL > inR) {
            return;
        }
        int root = pre[preL];
        pos[posIndex--] = root;
        int k = map.get(root);
        int leftSize = k - inL, rightSize = inR - k;
        process(pre, preL + leftSize + 1, preR, in, k + 1, inR);
        process(pre, preL + 1, preL + leftSize, in, inL, k - 1);
    }
}

/* test data
7
1 2 4 5 3 6 7
4 2 5 1 6 3 7
 */
