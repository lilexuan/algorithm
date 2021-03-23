package string;

import java.util.Arrays;

public class StringTools {
    public static String generateRandomString(int maxLength) {
        final String str = "qwertyuioplkjhgfdsazxcvbnm";
        int length = (int)Math.random() * maxLength;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int index = (int)Math.random() * str.length();
            sb.append(str.charAt(index));
        }
        return sb.toString();
    }

    public static String[] generateRandomStringArray(int arrayMaxLength, int stringMaxLength) {
        int length = (int)Math.random() * arrayMaxLength;
        String[] strArray = new String[length];
        for (int i = 0; i < length; i++) {
            strArray[i] = generateRandomString(stringMaxLength);
        }
        return strArray;
    }

    public static void main(String[] args) {
        String[] arr = {"abc", "bc", "dsf"};
        System.out.println(Arrays.toString(arr));
    }
}
