package util;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author kelvin
 * @create 2021-03-01 23:09
 */
public class ArrTools {
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void comparator(int[] arr) {
        Arrays.sort(arr);
    }

    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int len = arr.length;
        int[] copyArr = new int[len];
        for (int i = 0; i < len; i++) {
            copyArr[i] = arr[i];
        }
        return copyArr;
    }

    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int)((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    public static boolean isCorrect(FunctionCaller<int[]> caller, int testTime, int maxValue, int maxSize) {
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            caller.call(arr1);
            comparator(arr2);
            if (!isEqual(arr1, arr2)) {
                System.out.println(Arrays.toString(arr1));
                System.out.println(Arrays.toString(arr2));
                return false;
            }
        }
        return true;
    }

}
