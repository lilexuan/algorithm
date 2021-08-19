package heap_queue;

import java.util.Random;

/**
 * @author kelvin
 * @create 2021-08-19 11:20
 */
public class MinHeap {
    private int[] nums;
    private int heapSize;

    public MinHeap(int cap) {
        nums = new int[cap];
        heapSize = 0;
    }

    private void heapInsert(int index) {
        while (nums[index] < nums[(index - 1) / 2]) {
            swap(index, (index -1) / 2);
            index = (index - 1) / 2;
        }
    }

    private void heapify(int index) {
        int left = index * 2 + 1;
        while (left < heapSize) {
            int smallest = left + 1 < heapSize && nums[left + 1] < nums[left] ? left + 1 : left;
            smallest = nums[smallest] < nums[index] ? smallest : index;
            if (smallest == index) {
                break;
            }
            swap(smallest, index);
            index = smallest;
            left = 2 * index + 1;
        }
    }

    private void swap(int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public void offer(int num) {
        if (heapSize == nums.length) {
            return;
        }
        nums[heapSize] = num;
        heapInsert(heapSize++);
    }

    public int poll() {
        if (heapSize == 0) {
            return -1;
        }
        int value = nums[0];
        swap(0, --heapSize);
        heapify(0);
        return value;
    }

    public int size() {
        return heapSize;
    }

    public int peek() {
        return nums[0];
    }

    public static void main(String[] args) {
        int[] nums = {10, 9, 8};
        MinHeap minHeap = new MinHeap(nums.length);
        for (int num : nums) {
            minHeap.offer(num);
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.println(minHeap.poll());
        }
    }
}
