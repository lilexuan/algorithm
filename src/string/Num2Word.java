package string;

public class Num2Word {
    public static String num2Chinese(int num) {
        if (num == 0) {
            return "零";
        }
        String neg = num < 0 ? "负" : "";
        num = Math.abs(num);
        String res = null;
        if (num <= 9999) {
            res = num1to9999(num, false);
        } else if  (10000 <= num && num <= 99999999) {
            res = num10000to99999999(num, false);
        } else if (100000000 <= num && num <= Integer.MAX_VALUE) {
            res = num100000000toMax(num);
        }
        return neg + res;
    }

    private static String num100000000toMax(int num) {
        assert 100000000 <= num && num <= Integer.MAX_VALUE;
        int pre = num / 100000000;
        int post = num - pre * 100000000;
        String res = null;
        if (post == 0) {
            res = num1to9999(pre, false) + "亿";
        } else if (0 < post && post <= 9999) {
            res = num1to9999(pre, false) + "亿零" + num1to9999(post, true);
        } else if (10000 <= post && post < 10000000) {
            res = num1to9999(pre, false) + "亿零" + num10000to99999999(post, true);
        } else if (10000000 <= post && post <= 99999999) {
            res = num1to9999(pre, false) + "亿" + num10000to99999999(post, true);
        }
        return res;
    }

    private static String num10000to99999999(int num, boolean hasWordYi) {
        assert 10000 <= num && num <= 99999999;
        int pre = num / 10000;
        int post = num - pre * 10000;
        String res = null;
        if (post == 0) {
            res = num1to9999(pre, hasWordYi) + "万";
        } else if (0 < post && post < 1000) {
            res = num1to9999(pre, hasWordYi) + "万零" + num1to9999(post, true);
        } else if (1000 <= post && post <= 9999) {
            res = num1to9999(pre, hasWordYi) + "万" + num1to9999(post, true);
        }
        return res;
    }

    private static String num1to9999(int num, boolean hasWordYi) {
        assert 1 <= num && num <= 9999;
        if (1 <= num && num <= 9) {
            return num1to9(num);
        } else if (10 <= num && num <= 99) {
            return num10to99(num, hasWordYi);
        } else if (100 <= num && num <= 999) {
            return num100to999(num);
        } else if (1000 <= num && num <= 9999) {
            return num1000to9999(num);
        }
        return null;
    }

    private static String num1000to9999(int num) {
        assert 1000 <= num && num <= 9999;
        int thousandDigit = num / 1000;
        int rest = num - thousandDigit * 1000;
        String res = null;
        if (rest == 0) {
          res = num1to9(thousandDigit) + "千";
        } else if (100 <= rest && rest <= 999) {
            res = num1to9(thousandDigit) + "千" + num100to999(rest);
        } else if (10 <= rest && rest <= 99) {
            res = num1to9(thousandDigit) + "千零" + num10to99(rest, true);  // 一千零一十, 一千零一十四, 而不是一千零十四
        } else if (1 <= rest && rest <= 9) {
            res = num1to9(thousandDigit) + "千零" + num1to9(rest);
        }
        return res;
    }

    private static String num100to999(int num) {
        assert 100 <= num && num <= 999;
        int hundredDigit = num / 100;
        int rest = num - hundredDigit * 100;
        String res = null;
        if (rest == 0) {
            res = num1to9(hundredDigit) + "百";
        } else if (10 <= rest && rest <= 99){
            res = num1to9(hundredDigit) + "百" + num10to99(rest, true);
        } else if (1 <= rest && rest <= 9) {
            res = num1to9(hundredDigit) + "百零" + num1to9(rest);
        }
        return res;
    }

    /**
     *
     * @param num
     * @param hasWordYi 读这个两位数的时候需要把一十一的第一个一给读出来吗, 如果要, 那么就是一百一十一, 而不是一百十一
     * @return
     */
    private static String num10to99(int num, boolean hasWordYi) {
        assert 10 <= num && num <= 99;
        int tenDigit = num / 10;
        String res = null;
        if (tenDigit == 1 && !hasWordYi) {
            res = "十" + num1to9(num % 10);
        } else {
            res = num1to9(tenDigit) + "十" + num1to9(num % 10);
        }
        return res;
    }

    private static String num1to9(int num) {
        assert 1 <= num && num <= 9;
        // 0返回空字符串
        String[] names = {"", "一", "二", "三", "四", "五", "六", "七", "八", "九"};
        return names[num];
    }

    public static String num2English(int num) {
        if (num == 0) {
            return "Zero";
        }
        String res = num < 0 ? "Negative, " : "";
        if (num < 0) {
            res = "Negative, ";
        }
        if (num == Integer.MIN_VALUE) {
            res += "Two Billion, ";
            num %= -2000000000;
        }
        num = Math.abs(num);
        int high = 1000000000;
        int highIndex = 0;
        String[] names = { "Billion", "Million", "Thousand", "" };
        while (num != 0) {
            int cur = num / high;
            num %= high;
            if (cur != 0) {
                res += num1to999(cur);
                res += names[highIndex] + (num == 0 ? " " : ", ");
            }
            high /= 1000;
            highIndex++;
        }
        return res;
    }

    private static String num1to999(int num) {
        if (num < 1 || num > 999) {
            return "";
        }
        if (num < 100) {
            return num1to99(num);
        }
        int high = num / 100;
        return num1to19(high) + "Hundred " + num1to99(num % 100);
    }

    private static String num1to99(int num) {
        if (num < 1 || num > 99) {
            return "";
        }
        if (num < 20) {
            return num1to19(num);
        }
        int high = num / 10;
        String[] tyNames = { "Twenty ", "Thirty ", "Forty ", "Fifty ",
                "Sixty ", "Seventy ", "Eighty ", "Ninety " };
        return tyNames[high - 2] + num1to19(num % 10);
    }

    private static String num1to19(int num) {
        if (num < 1 || num > 19) {
            return "";
        }
        String[] names = {"One ", "Two ", "Three ", "Four ", "Five ", "Six ", "Seven ", "Eight ", "Nine ",
        "Ten ", "Eleven ", "Twelve ", "Thirteen ", "Fourteen ", "Fifteen ", "Sixteen ", "Seventeen ", "Eighteen", "Nineteen "};
        return names[num - 1];
    }

    public static void main(String[] args) {
        int num = 302867967;
        System.out.println(num2Chinese(num));
        System.out.println(num2English(num));
    }
}
