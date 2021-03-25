package recur;

public class Knapsack {
    public static int count(int i, int[] weights, int[] values, int bag, int currentWeight) {
        if (i == weights.length) {
            return 0;
        }
        if (currentWeight > bag) {
            return 0;
        }
        return Math.max(
                values[i] + count(i + 1, weights, values, bag, currentWeight + weights[i]),
                count(i + 1, weights, values, bag, currentWeight)
        );
    }

    public static void main(String[] args) {
        int[] weights = { 3, 2, 4, 7 };
        int[] values = { 5, 6, 3, 19 };
        int bag = 11;
        System.out.println(count(0, weights, values, bag, 0));

    }
}
