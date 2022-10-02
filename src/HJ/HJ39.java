package HJ;

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class HJ39 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String mask = sc.nextLine();
            String ip1 = sc.nextLine();
            String ip2 = sc.nextLine();
            String[] maskArr = mask.split("\\.");
            String[] ip1Arr = ip1.split("\\.");
            String[] ip2Arr = ip2.split("\\.");
            if (!isValid(maskArr, ip1Arr, ip2Arr)) {
                System.out.println(1);
                continue;
            }
            boolean isSameNet = true;
            for (int i = 0; i < 4; i++) {
                long res1 = (Long.parseLong(maskArr[i]) & Long.parseLong(ip1Arr[i]));
                long res2 = (Long.parseLong(maskArr[i]) & Long.parseLong(ip2Arr[i]));
                if (res1 != res2) {
                    isSameNet = false;
                    break;
                }
            }
            if (isSameNet) {
                System.out.println(0);
            } else {
                System.out.println(2);
            }
        }
    }

    private static boolean isValid(String[] maskArr, String[] ip1Arr, String[] ip2Arr) {
        for (int i = 0; i < 4; i++) {
            if (Integer.parseInt(ip1Arr[i]) < 0 || Integer.parseInt(ip1Arr[i]) > 255 || Integer.parseInt(ip2Arr[i]) < 0 || Integer.parseInt(ip2Arr[i]) > 255) {
                return false;
            }
            if (Integer.parseInt(maskArr[i]) < 0 || Integer.parseInt(maskArr[i]) > 255) {
                return false;
            }
        }
        String mask = "";
        for (String m : maskArr) {
            m = Integer.toBinaryString(Integer.parseInt(m));
            int size = m.length();
            for (int i = 0; i < 8 - size; i++) {
                m = "0" + m;
            }
            mask += m;
        }
        return mask.matches("[1]{1,}[0]{1,}");
    }
}