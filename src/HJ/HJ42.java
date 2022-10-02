package HJ;

import java.util.Scanner;

/**
 * @author kelvin
 * @create 2022-10-02 10:05
 */
public class HJ42 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String numStr = sc.nextLine();
        int len = numStr.length();
        if (len <= 3) {
            String part1 = numStr;
            String res = parsePart(part1);
            System.out.println(res.substring(1));
        } else if (3 < len && len <= 6) {
            String part1 = numStr.substring(numStr.length() - 3);
            String part2 = numStr.substring(0, numStr.length() - 3);
            String res = parsePart(part2) + " thousand" + parsePart(part1);
            System.out.println(res.substring(1));
        } else {
            String part1 = numStr.substring(numStr.length() - 3);
            String part2 = numStr.substring(numStr.length() - 6, numStr.length() - 3);
            String part3 = numStr.substring(0, numStr.length() - 6);
            String res = parsePart(part3) + " million" + parsePart(part2) + " thousand" + parsePart(part1);
            System.out.println(res.substring(1));
        }

    }

    private static String parsePart(String numStr) {
        int num = Integer.parseInt(numStr);
        int bai = 0, shi = 0, ge = 0;
        bai = num / 100;
        shi = (num - bai * 100) / 10;
        ge = num - bai * 100 - shi * 10;
        String[] ges = {"", " one", " two", " three", " four", " five", " six", " seven", " eight", " nine"};
        String[] shis1 = {" ten", " eleven", " twelve", " thirteen", " fourteen", " fifteen", " sixteen", " seventeen", " eighteen", " nineteen"};
        String[] shis2 = {"", "", " twenty", " thirty", " forty", " fifty", " sixty", " seventy", " eighty", " ninety"};
        String res = "";
        if (bai != 0) {
            res = ges[bai] + " hundred";
        }
        if (shi != 0) {
            if (bai != 0) {
                res += " and";
            }
            if (shi == 1) {
                res += shis1[ge];
            } else {
                res += shis2[shi];
            }
        }
        if (ge != 0) {
            if (bai != 0 && shi == 0) {
                res += " and";
            }
            if (shi != 1) {
                res += ges[ge];
            }
        }
        return res;
    }
}
