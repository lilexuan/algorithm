package printMatrix;

public class Zigzag {
    public static void zigzagPrint(int[][] m) {
        int[] p1 = new int[2];
        int[] p2 = new int[2];
        int cnt = 0;
        int row = m.length, col = m[0].length;
        int moveTime = row + col - 2;
        boolean upFlag = true;
        while (cnt <= moveTime) {
            printDiag(p1, p2, m, upFlag);
            upFlag = !upFlag;

            // move p1
            if (p1[0] <= row - 2) {
                p1[0]++;
            } else {
                p1[1]++;
            }

            // move p2
            if (p2[1] <= col - 2) {
                p2[1]++;
            } else {
                p2[0]++;
            }

            cnt++;
        }
    }

    private static void printDiag(int[] p1, int[] p2, int[][] m, boolean upFlag) {
        if (upFlag) {
            int i = p1[0], j = p1[1];
            while (i >= p2[0]) {
                System.out.print(m[i][j] + " ");
                i--;
                j++;
            }
        } else {
            int i = p2[0], j = p2[1];
            while (i <= p1[0]) {
                System.out.print(m[i][j] + " ");
                i++;
                j--;
            }
        }
    }

    public static void main(String[] args) {
        int[][] m = new int[][]{
                {0, 1, 2, 3},
                {4, 5, 6, 7},
                {8, 9, 10, 11},
                {12, 13, 14, 15},
                {16, 17, 18, 19}
        };
        zigzagPrint(m);
    }
}
