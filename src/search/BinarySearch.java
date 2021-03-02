package search;

/**
 * @author kelvin
 * @create 2021-03-02 14:49
 */
public class BinarySearch {
    public static int isExist(int[] sortedArr, int target) {
        if (sortedArr == null || sortedArr.length == 0) {
            return -1;
        }
        int left = 0, right = sortedArr.length - 1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (sortedArr[middle] == target) {
                return middle;
            } else if (sortedArr[middle] < target) {
                left = middle + 1;
            } else if (sortedArr[middle] > target) {
                right = middle  - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] sortedArr = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(isExist(sortedArr, 1));
        System.out.println(isExist(sortedArr, 2));
        System.out.println(isExist(sortedArr, 3));
        System.out.println(isExist(sortedArr, 4));
        System.out.println(isExist(sortedArr, 5));
        System.out.println(isExist(sortedArr, 6));
        System.out.println(isExist(sortedArr, 7));
        System.out.println(isExist(sortedArr, 8));
        System.out.println(isExist(sortedArr, 9));
    }
}
