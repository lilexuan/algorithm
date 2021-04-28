package greedy;

import java.util.Scanner;

public class MaxSubMatrixSum {
    private static int maxSubArraySum(int[] arr) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int num : arr) {
            sum += num;
            max = Math.max(max, sum);
            if (sum < 0) {
                sum = 0;
            }
        }
        return max;
    }

    private static int maxSubMatrixSum(int[][] matrix) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            int[] array = matrix[i];
            max = Math.max(max, maxSubArraySum(array));
            for (int k = 1; i + k < matrix.length; k++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    array[j] += matrix[i + k][j];
                }
                max = Math.max(max, maxSubArraySum(array));
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        int res = maxSubMatrixSum(matrix);
        System.out.println(res);
    }
}

/* test data
3 3
-1 -1 -1
-1 2 2
-1 -1 -1
output: 4

3 3
-90 48 78
64 -40 64
-81 -7 66
output: 209
 */
