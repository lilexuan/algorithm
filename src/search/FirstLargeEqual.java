package search;

/**
 * @author kelvin
 * @create 2021-03-02 18:20
 */
public class FirstLargeEqual {
    public static int firstLargeEqual(int[] sortedArr, int target) {
        if (sortedArr == null || sortedArr.length == 0) {
            return -1;
        }
        int left = 0, right = sortedArr.length - 1;
        int index = -1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (sortedArr[middle] == target) {
                index = middle;
                right = middle - 1;
            } else if (sortedArr[middle] < target) {
                left = middle + 1;
            } else if (sortedArr[middle] > target) {
                index = middle;
                right = middle - 1;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5, 6, 7, 7, 7, 10, 11};
        System.out.println(firstLargeEqual(arr1, 7));
        System.out.println(firstLargeEqual(arr1, 1));
        System.out.println(firstLargeEqual(arr1, 8));
    }
}
