package search;

import util.ArrTools;

import javax.sound.midi.MidiChannel;
import java.util.Arrays;

/**
 * @author kelvin
 * @create 2021-03-02 21:52
 */
public class LocalMin {
    public static int localMin(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        if (arr.length == 1 || arr[0] < arr[1]) {
            return 0;
        }
        if (arr[arr.length - 2] > arr[arr.length - 1]) {
            return arr.length - 1;
        }
        int left = 1, right = arr.length - 2;
        while (left < right) {
            int middle = left + (right - left) / 2;
            if (arr[middle] > arr[middle - 1]) {
                right = middle - 1;
            } else if (arr[middle] > arr[middle + 1]) {
                left = middle + 1;
            } else {  // 又不大于左边, 又不大于右边, 那就是小于两边, middle就是低谷
                return middle;
            }
        }
        return left;  // [1, 0, 1]情况下, left<right不成立, 但是需要返回, 也就是left的初始值
    }

    public static void main(String[] args) {
        int[] arr = ArrTools.generateRandomArray(20, 20);
        System.out.println(Arrays.toString(arr));
        System.out.println(localMin(arr));
    }
}
