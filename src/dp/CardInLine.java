package dp;

public class CardInLine {
    private static int first(int[] arr, int i, int j) {
        if (i == j) {
            return arr[i];
        }
        return Math.max(arr[i] + second(arr, i + 1, j), arr[j] + second(arr, i, j - 1));
    }

    private static int second(int[] arr, int i, int j) {
        if (i == j) {
            return 0;
        }
        return Math.min(first(arr, i + 1, j), first(arr, i, j - 1));
    }

    public static int getWinScoreBF(int[] arr) {
        return Math.max(first(arr, 0, arr.length - 1), second(arr, 0, arr.length - 1));
    }

    public static int getWinScoreDP(int[] arr) {
        int n = arr.length;
        int[][] dpf = new int[n][n];
        int[][] dps = new int[n][n];
        for (int j = 0; j < n; j++) {
            for (int i = n - 1; i >= 0; i--) {
                if (i > j) {
                    continue;
                } else if (i == j) {
                    dpf[i][j] = arr[i];
                    dps[i][j] = 0;
                } else {
                    dpf[i][j] = Math.max(arr[i] + dps[i + 1][j], arr[j] + dps[i][j - 1]);
                    dps[i][j] = Math.min(dpf[i + 1][j], dpf[i][j - 1]);
                }
            }
        }
        return Math.max(dpf[0][n - 1], dps[0][n - 1]);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 100, 4};
        System.out.println(getWinScoreBF(arr));
        System.out.println(getWinScoreDP(arr));
    }
}
