package printMatrix;

public class Rotation {
    public static void rotationPrint(int[][] m) {
        int[] p1 = new int[2];
        int[] p2 = new int[2];
        int row = m.length, col = m[0].length;
        p2[0] = row - 1;
        p2[1] = col - 1;
        // 当指针p2一直在P1下面或者p2和p1等高时就可以打印
        while (p2[0] >= p1[0] && p2[1] >= p1[1]) {
            printFrame(p1, p2, m);
            p1[0]++;
            p1[1]++;
            p2[0]--;
            p2[1]--;
        }
    }

    private static void printFrame(int[] p1, int[] p2, int[][] m) {
        int up = p1[0], down = p2[0], right = p2[1], left = p1[1];
        for (int j = left; j <= right; j++) {
            System.out.print(m[up][j] + " ");
        }
        for (int i = up + 1; i <= down; i++) {
            System.out.print(m[i][right] + " ");
        }
        if (left < right && up < down) {
            for (int j = right - 1; j >= left; j--) {
                System.out.print(m[down][j] + " ");
            }
            for (int i = down - 1; i > up; i--) {
                System.out.print(m[i][left] + " ");
            }
        }
    }

    public static void main(String[] args) {
        int[][] m = new int[][]{
                {1},
                {2},
                {3},
                {4},
                {5},
                {6}
        };
        rotationPrint(m);
    }
}
