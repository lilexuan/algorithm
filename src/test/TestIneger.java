package test;

public class TestIneger {
    public static void main(String[] args) {
        Integer a = 1;
        int b = 1;
        process2(a);
        process2(b);
        System.out.println(a);
        System.out.println(b);
    }

    public static void process1(int x) {
        x = x - 1;
    }

    public static void process2(Integer x) {
        x = x - 1;
    }
}
