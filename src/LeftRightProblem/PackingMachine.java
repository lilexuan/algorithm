package LeftRightProblem;

public class PackingMachine {
    public static int minOps(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        if (sum % arr.length != 0) {
            return -1;
        }
        int avg = sum / arr.length;  // 笔记中的target
        int leftSum = 0;
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            int L = avg * i - leftSum;
            int rightSum = sum - leftSum - arr[i];
            int R = (arr.length - i - 1) * avg - rightSum;
            if (L > 0 && R >0) {
                ans = Math.max(ans, Math.abs(L) + Math.abs(R));
            } else {
                ans = Math.max(ans, Math.max(Math.abs(R), Math.abs(L)));
            }
            leftSum += arr[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1, 0, 5};
        System.out.println(minOps(arr));
    }
}
