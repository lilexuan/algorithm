package test;
import java.util.HashMap;
import java.util.Scanner;
public class Main2 {
    public static void main(String[] args) {
        // 读入数据
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();
        in.nextLine(); // 必须有
        char[][] matrix = new char[n][m];
        for (int i = 0; i < n; i++) {
            String s = in.nextLine();
            matrix[i] = s.toCharArray();
        }

        int len = 1;
        while (Math.pow(len, 2) < k) {
            len++;
        }

        whole: while (len <= Math.min(m, n)) {
            HashMap<Character, Integer> map = new HashMap<>();
            for (int i = 0; i <= n - len; i++) {
                for (int j = 0; j <= m - len; j++) {
                    if (j == 0) {
                        map.clear();
                        addMap(matrix, i, j, i + len - 1, j + len - 1, map);
                    } else {
                        addMap(matrix, i, j + len - 1, i + len - 1, j + len - 1, map);
                        removeMap(matrix, i, j, i + len - 1, j, map);
                    }
                    if (map.keySet().size() >= k) {
                        break whole;
                    }
                }
            }
            len++;
        }
        System.out.println(len);
    }

    private static void removeMap(char[][] matrix, int a, int b, int c, int d, HashMap<Character, Integer> map) {
        for (int i = a; i <= c; i++) {
            for (int j = b; j <= d; j++) {
                map.put(matrix[i][j], map.get(matrix[i][j]) - 1);
                if (map.get(matrix[i][j]) == 0) {
                    map.remove(matrix[i][j]);
                }
            }
        }
    }

    private static void addMap(char[][] matrix, int a, int b, int c, int d, HashMap<Character, Integer> map) {
        for (int i = a; i <= c; i++) {
            for (int j = b; j <= d; j++) {
                map.put(matrix[i][j], map.getOrDefault(matrix[i][j], 0) + 1);
            }
        }
    }
}