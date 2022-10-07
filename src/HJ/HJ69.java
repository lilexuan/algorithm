package HJ;

import java.util.Scanner;

/**
 * @author kelvin
 * @create 2022-10-05 10:08
 */
public class HJ69 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int z = sc.nextInt();
        int[][] A = new int[x][y];
        int[][] B = new int[y][z];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                A[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < z; j++) {
                B[i][j] = sc.nextInt();
            }
        }
        int[][] C = new int[x][z];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < z; j++) {
                int sum = 0;
                for (int k = 0; k < y; k++) {
                    sum += A[i][k] * B[k][j];
                }
                C[i][j] = sum;
            }
        }
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < z; j++) {
                if (j != 0) {
                    System.out.print(" ");
                }
                System.out.print(C[i][j]);
            }
            System.out.println();
        }
    }
}
