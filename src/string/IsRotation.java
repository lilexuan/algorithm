package string;

public class IsRotation {
    public static boolean isRotation(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }
        String s = a + a;
        return s.contains(b);
    }

    public static void main(String[] args) {
        String a = "cdab", b = "abcd";
        System.out.println(isRotation(a, b));
    }
}
