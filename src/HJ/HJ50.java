package HJ;

import java.util.*;

/**
 * @author kelvin
 * @create 2022-10-03 10:13
 */
public class HJ50 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        s = preprocessString(s);
        System.out.println(s);
        ArrayList<Character> expers = mid2post(s);  // 转换为后缀表达式
        int res = post2num(expers);
        System.out.println(res);
    }

    private static String preprocessString(String s) {
        s = s.replace('{', '(');
        s = s.replace('[', '(');
        s = s.replace('}', ')');
        s = s.replace(']', ')');
        char[] chs = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        boolean needP = false;
        for (int i = 0; i < chs.length; i++) {
            if (chs[i] != '-') {
                sb.append(chs[i]);
            } else {
                if (chs[i - 1] > '9' || chs[i - 1] < '0') {
                    sb.append("(0-" + chs[i + 1] + ")");
                    i++;
                } else {
                    sb.append(chs[i]);
                }
            }
        }
        return sb.toString();
    }

    private static int post2num(ArrayList<Character> expers) {
        Deque<Integer> stack = new LinkedList<>();
        for (char c : expers) {
            if ('0' <= c && c <= '9') {
                stack.push(c - '0');
            } else {
                int num1 = stack.pop();
                int num2 = stack.pop();
                if (c == '+') stack.push(num1 + num2);
                if (c == '-') stack.push(num1 - num2);
                if (c == '*') stack.push(num1 * num2);
                if (c == '/') stack.push(num1 / num2);
            }
        }
        return stack.peek();
    }

    private static ArrayList<Character> mid2post(String s) {
        ArrayList<Character> stackA = new ArrayList<>();
        Deque<Character> stackB = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ('0' <= c && c <= '9') {
                stackA.add(c);
            } else if (c == '(') {
                stackB.push(c);
            } else if (c == ')') {
                while (stackB.peek() != '(') {
                    stackA.add(stackB.pop());
                }
                stackB.pop();
            } else if (c == '+' || c == '-' || c == '*' || c == '/') {
                while (!stackB.isEmpty() && stackB.peek() != '(' && stackB.peek() != ')' && compareOp(stackB.peek(), c) >= 0) {
                    stackA.add(stackB.pop());
                }
                stackB.push(c);
            }
        }
        while (!stackB.isEmpty()) {
            stackA.add(stackB.pop());
        }
        return stackA;
    }

    private static int compareOp(char c1, char c2) {
        if (c1 == '+' || c1 == '-') {
            if (c2 == '+' || c2 == '-') {
                return 0;
            } else if (c2 == '*' || c2 == '/') {
                return -1;
            }
        } else if (c1 == '*' || c1 == '/') {
            if (c2 == '+' || c2 == '-') {
                return 1;
            } else if (c2 == '*' || c2 == '/') {
                return 0;
            }
        }
        return 0;
    }
}
