package unionFind;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Islands {
    public static int countIslands1(int[][] m) {
        if (m == null || m.length == 0) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                if (m[i][j] == 1) {
                    res++;
                    infect(m, i, j);
                }
            }
        }
        return res;
    }

    private static void infect(int[][] m, int i, int j) {
        if (i < 0 || i >= m.length || j < 0 || j >= m[0].length || m[i][j] != 1) {
            return;
        }
        m[i][j] = 2;
        infect(m, i - 1, j);
        infect(m, i, j + 1);
        infect(m, i, j - 1);
        infect(m, i + 1, j);
    }

    public static int countIslands2(int[][] m) {
        if (m == null || m.length == 0) {
            return 0;
        }
        UnionFind<Pair<Integer, Integer>> uf = new UnionFind<>();
        int[] di = new int[]{0, 0, -1, 1};
        int[] dj = new int[]{-1, 1, 0, 0};

        // init
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                if (m[i][j] == 1) {
                    uf.insert(new Pair<>(i, j));
                }
            }
        }

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++){
                if (m[i][j] == 1) {
                    for (int k = 0; k < 4; k++) {
                        int newI = i + di[k], newJ = j + dj[k];
                        if (isValid(newI, newJ, m.length, m[0].length) && m[newI][newJ] == 1) {
                            Pair<Integer, Integer> cur = new Pair<>(i, j), next = new Pair<>(newI, newJ);
                            if (!uf.isUnion(cur, next)) {
                                uf.union(cur, next);
                            }
                        }
                    }
                }
            }
        }

        return uf.count;
    }

    private static boolean isValid(int i, int j, int row, int col) {
        return i >= 0 && i < row && j >= 0 && j < col;
    }

    public static void main(String[] args) {
        int[][] m1 = {  { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 1, 1, 1, 0, 1, 1, 1, 0 },
                { 0, 1, 1, 1, 0, 0, 0, 1, 0 },
                { 0, 1, 1, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 1, 1, 0, 0 },
                { 0, 0, 0, 0, 1, 1, 1, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, };
        int[][] m11 = {  { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 1, 1, 1, 0, 1, 1, 1, 0 },
                { 0, 1, 1, 1, 0, 0, 0, 1, 0 },
                { 0, 1, 1, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 1, 1, 0, 0 },
                { 0, 0, 0, 0, 1, 1, 1, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, };
        System.out.println(countIslands1(m1));
        System.out.println(countIslands2(m11));


        int[][] m2 = {  { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 1, 1, 1, 1, 1, 1, 1, 0 },
                { 0, 1, 1, 1, 0, 0, 0, 1, 0 },
                { 0, 1, 1, 0, 0, 0, 1, 1, 0 },
                { 0, 0, 0, 0, 0, 1, 1, 0, 0 },
                { 0, 0, 0, 0, 1, 1, 1, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, };
        int[][] m22 = {  { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 1, 1, 1, 1, 1, 1, 1, 0 },
                { 0, 1, 1, 1, 0, 0, 0, 1, 0 },
                { 0, 1, 1, 0, 0, 0, 1, 1, 0 },
                { 0, 0, 0, 0, 0, 1, 1, 0, 0 },
                { 0, 0, 0, 0, 1, 1, 1, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, };
        System.out.println(countIslands1(m2));
        System.out.println(countIslands2(m22));

    }
}
