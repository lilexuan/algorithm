package heap_queue;

/**
 * @author kelvin
 * @create 2021-08-19 13:18
 */
public class MaxHeap {
    private int[] nums;
    private int heapSize;

    public MaxHeap(int cap) {
        this.nums = new int[cap];
        this.heapSize = 0;
    }

    private void heapInsert(int index) {
        while (nums[index] > nums[(index - 1) / 2]) {
            swap(index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    private void heapify(int index) {
        int left = 2 * index + 1;
        while (left < heapSize) {
            int biggest = left + 1 < heapSize && nums[left + 1] > nums[left] ? left + 1 : left;
            biggest = nums[biggest] > nums[index] ? biggest : index;
            if (biggest == index) {
                break;
            }
            swap(biggest, index);
            index = biggest;
            left = 2 * index + 1;
        }
    }

    public int size() {
        return heapSize;
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

    public int peek() {
        return nums[0];
    }

    private void swap(int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {23, 423, 432,43254, 6,7};
        MaxHeap maxHeap = new MaxHeap(nums.length);
        for (int num : nums) {
            maxHeap.offer(num);
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.println(maxHeap.poll());
        }
    }
}
