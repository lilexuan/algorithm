package util;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

public class Test {
    public static void main(String[] args) {
        char[][] grid = new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        Solution solution = new Solution();
        int i = solution.numIslands(grid);
        System.out.println(i);
    }
}


class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        UnionFind uf = new UnionFind();
        int row = grid.length, col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    int index = getIndex(i, j, col);
                    uf.insert(index);
                }
            }
        }
        int[] di = new int[]{0, 0, -1, 1};
        int[] dj = new int[]{-1, 1, 0, 0};
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    for (int k = 0; k < 4; k++) {
                        int newI = i + di[k], newJ = j + dj[k];
                        if (isValid(newI, newJ, row, col) && grid[newI][newJ] == '1') {
                            int curIndex = getIndex(i, j, col), nextIndex = getIndex(newI, newJ, col);
                            if (!uf.isUnion(curIndex, nextIndex)) {
                                uf.union(curIndex, nextIndex);
                            }
                        }
                    }
                }
            }
        }
        return uf.count();
    }

    private int getIndex(int i, int j, int col) {
        return i * col + j;
    }

    private boolean isValid(int i, int j, int row, int col) {
        return i >= 0 && i < row && j >= 0 && j < col;
    }

}

class UnionFind {
    private HashMap<Integer, Integer> parent;
    private HashMap<Integer, Integer> size;
    private int count;

    public UnionFind() {
        parent = new HashMap<>();
        size = new HashMap<>();
        count = 0;
    }

    public void insert(int index) {
        parent.put(index, index);
        size.put(index, 1);
        count++;
    }

    public int findParent(int index) {
        Deque<Integer> stack = new LinkedList<>();
        while (index != parent.get(index)) {
            stack.push(index);
            index = parent.get(index);
        }
        while (!stack.isEmpty()) {
            parent.put(stack.poll(), index);
        }
        return index;
    }

    public boolean isUnion(int p, int q) {
        return findParent(p) == findParent(q);
    }

    public void union(int p, int q) {
        int rootP = findParent(p);
        int rootQ = findParent(q);
        if (rootP == rootQ) {
            return;
        }
        if (size.get(rootP) > size.get(rootQ)) {
            parent.put(rootQ, rootP);
            size.put(rootP, size.get(rootP) + size.get(rootQ));
        } else {
            parent.put(rootP, rootQ);
            size.put(rootQ, size.get(rootP) + size.get(rootQ));
        }
        count--;
    }

    public int count() {
        return count;
    }
}
