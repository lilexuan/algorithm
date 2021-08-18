package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @author kelvin
 * @create 2021-06-10 19:46
 */
public class LoopWord {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        String[] strings = new String[n];
        int[] mark = new int[n];
        for (int i = 0; i < n; i++) {
            strings[i] = bf.readLine();
        }
        int cnt = 0;
        for (int i = 0; i < n; i++ ) {
            for (int j = i + 1; j < n; j++) {
                if (isLoopWord(strings[i], strings[j])) {
                    if (mark[i] == 0) {
                        mark[i] = ++cnt;
                    }
                    mark[j] = mark[i];
                }
            }
        }
        System.out.println(cnt);
    }

    private static boolean isLoopWord(String a, String b) {
        return  a.length() == b.length() && (a + a).contains(b);
    }
}
