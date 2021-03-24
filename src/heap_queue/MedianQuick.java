package heap_queue;

import util.ArrTools;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MedianQuick {
    public static int getMedianBF(int[] arr) {
        int[] newArr = ArrTools.copyArray(arr);
        Arrays.sort(newArr);
        int mid = (newArr.length - 1) / 2;
        if (newArr.length % 2 == 0) {
            return (newArr[mid] + newArr[mid + 1]) / 2;
        } else {
            return newArr[mid];
        }
    }

    public static void main(String[] args) {
        int testTime = 20000;
        int maxSize = 1000;
        int maxValue = 1000;
        for (int i = 0; i < testTime; i++) {
            int[] arr = ArrTools.generateRandomArray(maxSize, maxValue);
            MedianHolder medianHolder = new MedianHolder();
            for (int num : arr) {
                medianHolder.addNumber(num);
            }
            Integer median = medianHolder.getMedian();
            if (median == null) {
                System.out.println("null");
                continue;
            }
            int medianBF = getMedianBF(arr);
            if (median.intValue() != medianBF) {
                System.out.println("Error!");
                System.out.println(Arrays.toString(arr));
                System.out.println(median);
                System.out.println(medianBF);
                return;
            }
        }
        System.out.println("Nice!");
//        int[] arr = {10, 9, 8, 5, 3, 2, 1, 6, 7, 4};
//        MedianHolder medianHolder = new MedianHolder();
//        for (int num : arr) {
//            medianHolder.addNumber(num);
//        }
//        System.out.println(medianHolder.getMedian());
    }
}

class MedianHolder {
    private PriorityQueue<Integer> maxHeap;
    private PriorityQueue<Integer> minHeap;
    public MedianHolder() {
        maxHeap = new PriorityQueue<>((i1, i2) -> {
            return i2 - i1;
        });
        minHeap = new PriorityQueue<>();
    }

    public void addNumber(int num) {
        if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
            maxHeap.offer(num);
        } else {
            minHeap.offer(num);
        }
        adjustHeap();
    }

    private void adjustHeap() {
        int maxHeapSize = maxHeap.size();
        int minHeapSize = minHeap.size();
        if (maxHeapSize - minHeapSize == 2) {
            minHeap.offer(maxHeap.poll());
        }
        if (minHeapSize - maxHeapSize == 2) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public Integer getMedian() {
        int maxHeapSize = maxHeap.size();
        int minHeapSize = minHeap.size();
        if (maxHeapSize + minHeapSize == 0) {
            return null;
        }
        if ((maxHeapSize + minHeapSize) % 2 == 0) {
            return ((maxHeap.peek() + minHeap.peek()) / 2);
        } else {
            return maxHeapSize > minHeapSize ? maxHeap.peek() : minHeap.peek();
        }
    }
}
