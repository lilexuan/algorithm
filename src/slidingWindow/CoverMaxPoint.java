package slidingWindow;

/**
 * @author kelvin
 * @create 2021-04-12 15:43
 * @Desc 给定一个有序数组arr，代表数轴上从左到右有n个点arr[0]、arr[1]...arr[n－1]，给定一个正数L，代表一根长度为L的绳子，求绳子最多能覆盖其中的几个点。
 */
public class CoverMaxPoint {
    /**
     *
     * @param arr 必须是有序的数组
     * @param L
     * @return
     */
    public static int getCoverMaxPoint(int[] arr, int L) {
        int left = 0, right = 0, res = 0, n = arr.length;
        while (left < n) {
            while (right + 1 < n && arr[right + 1] <= arr[left] + L) {
                right++;
            }
            res = Math.max(res, right - left + 1);
            left++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = { 0, 13, 24, 35, 46, 57, 60, 72, 87 };
        int L = 6;
        System.out.println(getCoverMaxPoint(arr, L));
    }
}
