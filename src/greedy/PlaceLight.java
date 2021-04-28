package greedy;
import java.util.Scanner;

public class PlaceLight {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int n;
        char[] str = null;
        String s = null;
        while (t-- != 0) {
            n = sc.nextInt();
            s = sc.next();
            str = s.toCharArray();
            int res = getLight(str);
            System.out.println(res);
        }
    }

    public static int getLight(char[] str) {
        int cnt = 0;
        int i = 0;
        while (i <str.length) {
            if (str[i] == 'X') {
                i++;
                continue;
            } else {
                if (i == str.length - 1) {
                    cnt++;
                    i++;
                } else {
                    cnt++;
                    i += 3;
                }
            }
        }
        return cnt;
    }

}

/* test data
2
3
.X.
11
...XX....XX
 */
