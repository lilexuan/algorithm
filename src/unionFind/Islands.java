package unionFind;

public class Islands {
    public static int countIslands1(int[][] m) {
        if (m == null || m.length == 0) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                if (m[i][j] == 1) {
                    res++;
                    infect(m, i, j);
                }
            }
        }
        return res;
    }

    private static void infect(int[][] m, int i, int j) {
        if (i < 0 || i >= m.length || j < 0 || j >= m[0].length || m[i][j] != 1) {
            return;
        }
        m[i][j] = 2;
        infect(m, i - 1, j);
        infect(m, i, j + 1);
        infect(m, i, j - 1);
        infect(m, i + 1, j);
    }

    public static int countIslands2(int[][] m) {

    }

    public static void main(String[] args) {
        int[][] m1 = {  { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 1, 1, 1, 0, 1, 1, 1, 0 },
                { 0, 1, 1, 1, 0, 0, 0, 1, 0 },
                { 0, 1, 1, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 1, 1, 0, 0 },
                { 0, 0, 0, 0, 1, 1, 1, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, };
        System.out.println(countIslands1(m1));

        int[][] m2 = {  { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 1, 1, 1, 1, 1, 1, 1, 0 },
                { 0, 1, 1, 1, 0, 0, 0, 1, 0 },
                { 0, 1, 1, 0, 0, 0, 1, 1, 0 },
                { 0, 0, 0, 0, 0, 1, 1, 0, 0 },
                { 0, 0, 0, 0, 1, 1, 1, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, };
        System.out.println(countIslands1(m2));

    }
}
