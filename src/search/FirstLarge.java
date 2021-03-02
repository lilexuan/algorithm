package search;

/**
 * @author kelvin
 * @create 2021-03-02 21:42
 */
public class FirstLarge {
    public static int firstLarge(int[] sortedArr, int target) {
        if (sortedArr == null || sortedArr.length == 0) {
            return -1;
        }
        int left = 0, right = sortedArr.length - 1;
        int index = -1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (sortedArr[middle] == target) {
                left = middle + 1;
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
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 7, 8, 10};
        System.out.println(firstLarge(arr,-1));
        System.out.println(firstLarge(arr,1));
        System.out.println(firstLarge(arr,7));
        System.out.println(firstLarge(arr,9));
        System.out.println(firstLarge(arr,10));
        System.out.println(firstLarge(arr,11));
    }
}
