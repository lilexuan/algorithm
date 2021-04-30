package hash;

import java.util.ArrayList;
import java.util.List;

public class PrintNotInArray {
    public static List<Integer> printNotInArray(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            int index = i;
            int value = arr[i];
            while (value - 1 != index) {
                int tmp = arr[value - 1];
                arr[value - 1] = value;
                index = value - 1;
                value = tmp;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] - 1 != i) {
                res.add(i + 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 3, 5, 5};
        System.out.println(printNotInArray(arr).toString());
    }
}
