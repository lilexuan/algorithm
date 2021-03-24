package recur;

public class Hanoi {
    public static void honoi(int n) {
        if (n > 0) {
            honoi(n, "left", "mid", "right");
        }
    }

    public static void honoi(int i, String from, String help, String to) {
        if (i == 1) {
            System.out.println("move " + i + " from " + from + " to " + to);
        } else {
            honoi(i - 1, from, to, help);
            honoi(1, from, help, to);
            honoi(i - 1, help, from, to);
        }
    }

    public static void main(String[] args) {
        int n = 3;
        honoi(3);
    }
}
