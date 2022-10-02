package test;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * @author kelvin
 * @create 2022-09-29 21:39
 */
public class HJ18 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int aNum = 0;
        int bNum = 0;
        int cNum = 0;
        int dNum = 0;
        int eNum = 0;
        int errNum = 0;
        int pNum = 0;
        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            String[] strArr = str.split("~");
            int ipFirst = getIpSeg(strArr[0], 0);
            if (ipFirst == 0 || ipFirst == 127) {
                continue;
            }
            if (maskIsInvalid(strArr[1])) {
                errNum++;
                continue;
            }
            if (ipIsInvalid(strArr[0])) {
                errNum++;
                continue;
            }
            if (ipFirst >= 1 && ipFirst <= 126) {
                aNum++;
            }
            if (ipFirst >= 128 && ipFirst <= 191) {
                bNum++;
            }
            if (ipFirst >= 192 && ipFirst <= 223) {
                cNum++;
            }
            if (ipFirst >= 224 && ipFirst <= 239) {
                dNum++;
            }
            if (ipFirst >= 240 && ipFirst <= 255) {
                eNum++;
            }
            int ipSecond = getIpSeg(strArr[0], 1);
            if (ipFirst == 10 || (ipFirst == 172 && ipSecond >= 16 && ipSecond <=31) || (ipFirst == 192 && ipSecond == 168)) {
                pNum++;
            }
        }
        System.out.println(aNum + " " + bNum + " " + cNum + " " + dNum + " " + eNum + " " + errNum + " " + pNum);
    }

    private static boolean ipIsInvalid(String ip) {
        String[] ipArr = ip.split("\\.");
        if (ipArr.length != 4) {
            return true;
        }
        return Integer.parseInt(ipArr[0]) > 255 || Integer.parseInt(ipArr[1]) > 255 || Integer.parseInt(ipArr[2]) > 255 || Integer.parseInt(ipArr[3]) > 255;
    }

    private static boolean maskIsInvalid(String mask) {
        String[] maskArr = mask.split("\\.");
        if (maskArr.length != 4) {
            return true;
        }
        String maskBinary = toBin(maskArr[0]) + toBin(maskArr[1]) + toBin(maskArr[2]) + toBin(maskArr[3]);
        return !maskBinary.matches("[1]{1,}[0]{1,}");
    }

    private static String toBin(String s) {
        String numBinary = Integer.toBinaryString(Integer.parseInt(s));
        // 记得补齐8位!
        while (numBinary.length() < 8) {
            numBinary = "0" + numBinary;
        }
        return numBinary;
    }

    private static int getIpSeg(String ip, int index) {
        String[] ipArr = ip.split("\\.");
        return Integer.parseInt(ipArr[index]);
    }
}
