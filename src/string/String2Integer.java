package string;

public class String2Integer {
    public static int string2Integer(String str) throws Exception {
        if (str == null || str.length() == 0) {
            throw new Exception("Cannot convert");
        }
        boolean negative = false;
        char[] chs = str.toCharArray();
        int sum = 0;

        if (chs[0] == '-') {
            // 如果-开头, 长度只有1, 不能转换
            if (chs.length == 1) {
                throw new Exception("Cannot convert");
            }

            // 如果-开头, 接着的数字是0, 不能转换
            if (chs[1] == '0') {
                throw new Exception("Cannot convert");
            }
            negative = true;
        }

        // 如果是0开头, 且长度大于1的, 不能转换
        if (chs[0] == '0' && chs.length > 1) {
            throw new Exception("Cannot convert");
        }

        int i = negative == true ? 1 : 0;
        for (; i < chs.length; i++) {
            // 如果不是数字, 那肯定不能转换
            if (chs[i] < '0' || chs[i] > '9') {
                throw new Exception("Cannot convert");
            }
            sum = sum * 10 + (chs[i] - '0');
        }
        if (negative) {
            sum = -sum;
        }
        return sum;
    }

    public static void main(String[] args){
        String s = "-";
        try {
            System.out.println(string2Integer(s));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
