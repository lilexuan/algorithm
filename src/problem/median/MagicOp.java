package problem.median;

import java.util.Arrays;

public class MagicOp {
    public static int magicOp(int[] arr1, int[] arr2) {
        int sum1 = 0, sum2 = 0;
        for (int num : arr1) {
            sum1 += num;
        }
        for (int num : arr2) {
            sum2 += num;
        }
        double avg1 = mean(sum1, arr1.length);
        double avg2 = mean(sum2, arr2.length);
        int bigSum = 0, smallSum = 0;
        int[] bigArr = null, smallArr = null;
        if (avg1 == avg2) {
            return 0;
        } else if (avg1 > avg2) {
            bigSum = sum1;
            bigArr = arr1;
            smallSum = sum2;
            smallArr = arr2;
        } else {
            bigSum = sum2;
            bigArr = arr2;
            smallSum = sum1;
            smallArr = arr1;
        }
        int cnt = 0;
        Arrays.sort(bigArr);
        int lenBig = bigArr.length, lenSmall = smallArr.length;
        for (int i = 0; i < lenBig; i++) {
            double cur = bigArr[i];
            if (cur < mean(bigSum, lenBig) && cur > mean(smallSum, lenSmall)) {
                bigSum -= cur;
                lenBig--;
                smallSum += cur;
                lenSmall++;
                cnt++;
            }
        }

        return cnt;
    }

    private static double mean(int sum, int length) {
        return (double) sum / (double) length;
    }

    public static void main(String[] args) {
        int[] arr1 = { 1, 2, 5 };
        int[] arr2 = { 2, 3, 4, 5, 6 };
        System.out.println(magicOp(arr1, arr2));
    }
}
