package problem.median;

public class NearMultiple4Times {
    public static boolean isValid(int[] arr) {
        int countOdd = 0, countMod2 = 0, countMod4 = 0;
        for (int num : arr) {
            if (num % 2 == 1) {
                countOdd++;
            } else {
                if (num % 4 != 0) {
                    countMod2++;
                } else {
                    countMod4++;
                }
            }
        }
        if (countMod2 == 0) {
            return countMod4 >= countOdd - 1;
        } else {
            return countMod4 >= countOdd;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 10, 100};
        System.out.println(isValid(arr));
    }
}
