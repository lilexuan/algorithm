package recur;

public class CardInLine {
    public static int f(int[] arr, int left, int right) {
        if (left == right) {
            return arr[left];
        }
        return Math.max(
                arr[left] + s(arr, left + 1, right),
                arr[right] + s(arr, left, right - 1)
        );
    }

    public static int s(int[] arr, int left, int right) {
        if (left == right) {
            return 0;
        }
        return Math.min(
                f(arr, left + 1, right),
                f(arr, left, right - 1)
        );
    }

    public static int win(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        return Math.max(f(arr, 0, arr.length - 1), s(arr, 0,arr.length - 1));
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 100, 4};
        System.out.println(win(arr));
    }
}
