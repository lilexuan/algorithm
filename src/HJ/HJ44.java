package HJ;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author kelvin
 * @create 2022-10-02 23:13
 */
public class HJ44 {
    private static int[][] sudoku = new int[9][9];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] raw = new int[9][9];
        LinkedList<Integer> zeroI = new LinkedList<>();
        LinkedList<Integer> zeroJ = new LinkedList<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                raw[i][j] = sc.nextInt();
                if (raw[i][j] == 0) {
                    zeroI.addLast(i);
                    zeroJ.addLast(j);
                }
            }
        }
        dfs(raw, zeroI, zeroJ);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (j != 0) {
                    System.out.print(" ");
                }
                System.out.print(sudoku[i][j]);
            }
            System.out.println();
        }
    }

    private static void dfs(int[][] raw, LinkedList<Integer> zeroI, LinkedList<Integer> zeroJ) {
        if (zeroI.size() == 0) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sudoku[i][j] = raw[i][j];
                }
            }
            return;
        }
        int ii = zeroI.removeLast();
        int jj = zeroJ.removeLast();
        for (int num = 1; num <= 9; num++) {
            if (isValidSudoku(ii, jj, num, raw)) {
                raw[ii][jj] = num;
                dfs(raw, zeroI, zeroJ);
                raw[ii][jj] = 0;
            }
        }
        zeroI.addLast(ii);
        zeroJ.addLast(jj);
    }

    private static boolean isValidSudoku(int ii, int jj, int num, int[][] raw) {
        for (int i = 0; i < 9; i++) {
            if (raw[i][jj] == num) {
                return false;
            }
        }
        for (int j = 0; j < 9; j++) {
            if (raw[ii][j] == num) {
                return false;
            }
        }
        int row = (ii / 3) * 3;
        int col = (jj / 3) * 3;
        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                if (raw[i][j] == num) {
                    return false;
                }
            }
        }
        return true;
    }
}
