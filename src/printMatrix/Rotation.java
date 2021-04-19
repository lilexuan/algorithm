package printMatrix;

public class Rotation {
    public static void rotationPrint(int[][] m) {
        int[] p1 = new int[2];
        int[] p2 = new int[2];
        int row = m.length, col = m[0].length;
        p2[0] = row - 1;
        p2[1] = col - 1;
        // 当指针p2一直在P1下面或者p2和p1等高时就可以打印
        while (p2[1] >= p1[1]) {

        }
    }
}
