package search;

/**
 * @author kelvin
 * @create 2021-03-02 17:41
 */
public class FindRightBound {
    public static int findRightBound(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int left = 0, right = arr.length - 1;
        int index = -1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (arr[middle] == target) {
                index = middle;
                left = middle + 1;
            } else if (arr[middle] < target) {
                left = middle + 1;
            } else if (arr[middle] > target) {
                right = middle - 1;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5, 6, 7, 7, 7, 9};
        System.out.println(findRightBound(arr1, 7));
        System.out.println(findRightBound(arr1, 1));
        System.out.println(findRightBound(arr1, 8));
    }
}
