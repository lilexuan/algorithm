package HJ;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author kelvin
 * @create 2022-10-02 11:53
 */
public class Hj43 {
    private static LinkedList<PairHJ43> res;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        int[][] maze = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                maze[i][j] = sc.nextInt();
            }
        }
        LinkedList<PairHJ43> path = new LinkedList<>();
        boolean[][] vis = new boolean[row][col];
        res = new LinkedList<>();
        path.addLast(new PairHJ43(0, 0));
        dfs(0, 0, maze, path, vis);
        for (PairHJ43 p : res) {
            System.out.println(p);
        }
    }

    public static void dfs(int i, int j, int[][] maze, LinkedList<PairHJ43> path, boolean[][] vis) {
        if (i == maze.length - 1 && j == maze[0].length - 1) {
            res = new LinkedList<>(path);
            return;
        }
        int[] di = {-1, 0, 1, 0};
        int[] dj = {0, 1, 0, -1};
        for (int k = 0; k < 4; k++) {
            int ii = i + di[k];
            int jj = j + dj[k];
            if (0 <= ii && ii < maze.length && 0 <= jj && jj < maze[0].length && maze[ii][jj] == 0 && !vis[ii][jj]) {
                vis[ii][jj] = true;
                path.addLast(new PairHJ43(ii, jj));
                dfs(ii, jj, maze, path, vis);
                path.removeLast();
                vis[ii][jj] = false;
            }
        }
    }
}

class PairHJ43 {
    public int i;
    public int j;
    public PairHJ43(int i, int j) {
        this.i = i;
        this.j = j;
    }

    @Override
    public String toString() {
        return "(" + i + "," + j + ")";
    }
}
