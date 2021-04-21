package greedy;

public class LeftMaxRightMaxDiff {
    public static int getDiff(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        for (int num : arr) {
            max = Math.max(num, max);
        }
        return Math.max(Math.abs(arr[0] - max), Math.abs(arr[arr.length - 1] - max));
    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 1, 4, 2};
        System.out.println(getDiff(arr));
    }
}
