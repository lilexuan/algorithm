package bit;

public class Power2or4 {
    public static boolean is2Power(int x) {
        return (x & (x - 1)) == 0;
    }

    public static boolean is4Power(int x) {
        return (x & (x -1)) == 0 && (x & 0x55555555) != 0;
    }

    public static void main(String[] args) {
        System.out.println(is2Power(2));
        System.out.println(is2Power(4));
        System.out.println(is2Power(6));
        System.out.println(is2Power(8));
        System.out.println(is2Power(10));
        System.out.println(is2Power(12));
        System.out.println(is2Power(14));
        System.out.println(is2Power(16));

        System.out.println(is4Power(2));
        System.out.println(is4Power(4));
        System.out.println(is4Power(6));
        System.out.println(is4Power(8));
        System.out.println(is4Power(10));
        System.out.println(is4Power(12));
        System.out.println(is4Power(14));
        System.out.println(is4Power(16));
    }
}
