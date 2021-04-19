package printMatrix;

import java.util.Arrays;

/**
 * @author kelvin
 * @create 2021-04-19 16:52
 */
public class ClockWise {
    /**
     *
     * @param m m是正方形矩阵
     */
    public static void clockRatation(int[][] m) {
        int top = 0, down = m.length - 1, left = 0, right = m[0].length - 1;
        while (left < right && top < down) {
            rotation(top, down, left, right, m);
            left++;
            top++;
            down--;
            right--;
        }
    }

    private static void rotation(int top, int down, int left, int right, int[][] m) {
        for (int i = 0; i < right - left; i++) {
            int tmp = m[top][left + i];
            m[top][left + i] = m[down - i][left];
            m[down - i][left] = m[down][right - i];
            m[down][right - i] = m[top + i][right];
            m[top + i][right] = tmp;
        }
    }

    public static void main(String[] args) {
        int[][] m = {
                {0, 1, 2, 3},
                {4, 5, 6, 7},
                {8, 9, 10, 11},
                {12, 13, 14, 15}
        };
        clockRatation(m);
        for (int[] row : m) {
            System.out.println(Arrays.toString(row));
        }
    }
}
