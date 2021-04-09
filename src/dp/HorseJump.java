package dp;

public class HorseJump {
    public static int horseJump(int x, int y, int k) {
        int[][][] dp = new int[9][10][k + 1];
        dp[0][0][k] = 1;
        int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
        int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};
        for (int s = k - 1; s >= 0; s--) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 10; j++) {
                    for (int t = 0; t < dx.length; t++) {
                        int newX = i + dx[t];
                        int newY = j + dy[t];
                        if (isValid(newX, newY)) {
                            dp[i][j][s] += dp[newX][newY][s + 1];
                        }
                    }
                }
            }
        }
        return dp[x][y][0];
    }

    private static boolean isValid(int newX, int newY) {
        return newX >= 0 && newX < 9 && newY >= 0 && newY < 10;
    }

    public static void main(String[] args) {
        int x = 7, y = 7, k = 10;
        System.out.println(horseJump(x, y, k));
    }
}
