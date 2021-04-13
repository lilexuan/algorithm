package preProcess;

import java.util.Arrays;

/**
 * @author kelvin
 * @create 2021-04-13 9:32
 */
public class MaxOneBorderSize {
    public static void preprocess(int[][] m, int[][] right, int[][] down) {
        int row = m.length, col = m[0].length;

        // set the last column of right and the last row of down
        for (int i = 0; i < row; i++) {
            right[i][col - 1] = m[i][col - 1];
        }
        for (int j = 0; j < col; j++) {
            down[row - 1][j] = m[row - 1][j];
        }

        // set the last row of right[][]
        for (int j = col - 2; j >= 0; j--) {
            if (m[row - 1][j] == 1) {
                right[row - 1][j] = right[row - 1][j + 1] + 1;
            } else {
                right[row - 1][j] = 0;
            }
        }

        // set the last column of down[][]
        for (int i = row - 2; i >= 0; i--) {
            if (m[i][col - 1] == 1) {
                down[i][col - 1] = down[i + 1][col - 1] + 1;
            } else {
                down[i][col - 1] = 0;
            }
        }

        // set the other position of right[][]  and down[][]
        for (int i = row - 2; i >= 0; i--) {
            for (int j = col - 2; j >= 0; j--) {
                if (m[i][j] == 1) {
                    right[i][j] = right[i][j + 1] + 1;
                    down[i][j] = down[i + 1][j] + 1;
                } else {
                    right[i][j] = 0;
                    down[i][j] = 0;
                }
            }
        }
    }

    public static int getMaxBorderSize(int[][] m) {
        int[][] right = new int[m.length][m[0].length];
        int[][] down = new int[m.length][m[0].length];
        preprocess(m, right, down);
        int n = Math.min(m.length, m[0].length);
        for (int size = n; size >= 0; size--) {
            if (hasSizeOfBorder(size, right, down)) {
                return size;
            }
        }
        return 0;
    }

    private static boolean hasSizeOfBorder(int size, int[][] right, int[][] down) {
        for (int i = 0; i < right.length - size + 1; i++) {
            for (int j = 0; j < right[0].length - size + 1; j++) {
                if (right[i][j] >= size && down[i][j] >= size && right[i + size - 1][j] >= size && down[i][j + size - 1] >= size) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {0, 1, 1, 1, 1},
                {0, 1, 0, 0, 1},
                {0, 1, 0, 0, 1},
                {0, 1, 1, 1, 1},
                {0, 1, 0, 1, 1}
        };
        int[][] right = new int[matrix.length][matrix[0].length];
        int[][] down = new int[matrix.length][matrix[0].length];
        preprocess(matrix, right, down);
        for (int[] row : right) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println();
        for (int [] row : down) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println(getMaxBorderSize(matrix));
    }
}
