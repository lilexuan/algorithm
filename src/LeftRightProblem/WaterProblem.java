package LeftRightProblem;

public class WaterProblem {
    public static int getWater(int[] arr) {
        if (arr == null || arr.length <= 2) {
            return 0;
        }
        int leftMax = arr[0], rightMax = arr[arr.length - 1];
        int l = 1, r = arr.length - 2;
        int res = 0;
        while (l <= r) {
            if (leftMax < rightMax) {
                res += Math.max(0, leftMax - arr[l]);
                leftMax = Math.max(arr[l], leftMax);
                l++;
            } else {
                res += Math.max(0, rightMax - arr[r]);
                rightMax = Math.max(arr[r], rightMax);
                r--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(getWater(arr));
    }
}
