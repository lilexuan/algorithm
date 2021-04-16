package recur;

public class Brose {
    public static String winnerBF(int n) {
        if (n < 5) {
            return (n == 0 || n == 2) ? "last" : "first";
        }
        int base = 1;
        while (base <= n) {
            if (winnerBF(n - base).equals("last")) {
                return "first";
            }
            // 防止溢出
            if (base > n / 4) {
                break;
            }
            base *= 4;
        }
        return "last";
    }

    public static String getWinnerBF(int n) {
        String s = winnerBF(n);
        return s.equals("first") ? "niu" : "yang";
    }

    public static String getWinnerPT(int n) {
        if (n % 5 == 0 || n % 5 == 2) {
            return "yang";
        } else {
            return "niu";
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 80; i++) {
            if (!getWinnerBF(i).equals(getWinnerPT(i))) {
                System.out.println(i);
                System.out.println("fuck!");
                return;
            }
        }
        System.out.println("nice");
    }
}
