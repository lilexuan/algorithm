package recur;

public class PrintAllSubsequences {
    public static void printSub(String str, int index, String res) {
        if (index == str.length()) {
            System.out.println(res);
            return;
        }
        printSub(str, index + 1, res);
        printSub(str, index + 1, res + str.charAt(index));
    }

    public static void main(String[] args) {
        String str = "abc";
        printSub(str, 0, "");
    }
}
