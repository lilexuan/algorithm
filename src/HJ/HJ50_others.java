package HJ;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author kelvin
 * @create 2022-10-03 14:51
 */
public class HJ50_others {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        s = s.replace('{', '(');
        s = s.replace('[', '(');
        s = s.replace('}', ')');
        s = s.replace(']', ')');

        // 为了统一计算逻辑，在最外面的表达式也放括号
        if (s.charAt(0) != '(') {
            s = '(' + s + ')';
        }

        System.out.println(solveHJ50(s));
    }

    private static int solveHJ50(String s) {
        char[] chs = s.toCharArray();

        // 用于存放数字
        Deque<Integer> stack = new LinkedList<>();

        // 记录数字
        int number = 0;

        // 记录上个操作符
        char op = '+';

        for (int i = 0; i < chs.length; i++) {
            char c = chs[i];
            // 一直入栈
            // 遇到右括号就出栈, 直到左括号出现位置
            // 括号内包裹的表达式进行计算
            // 如果当前字符是小括号
            if (c == '(') {
                // 移到小括号后一位字符
                int j = i + 1;
                // 统计括号的数量
                int count = 1;
                while (count > 0) {
                    // 遇到右括号, 括号数量-1
                    if (chs[j] == ')') {
                        count--;
                    }
                    // 遇到左括号, 括号数+1
                    if (chs[j] == '(') {
                        count++;
                    }
                    j++;
                }
                // 递归, 解小括号中的表达式
                number = solveHJ50(s.substring(i + 1, j - 1));
                i = j - 1;
            } else if (Character.isDigit(c)) {
                // 多位数字的处理
                number = number * 10 + c - '0';
            }

            if (!Character.isDigit(c) || i == chs.length - 1) {
                // 遇到符号, 将数字处理后放入栈
                if (op == '+') {
                    stack.push(number);
                } else if (op == '-') {
                    stack.push(-1 * number);
                } else if (op == '*') {
                    stack.push(stack.pop() * number);
                } else if (op == '/') {
                    stack.push(stack.pop() / number);
                }
                // 更新符号
                op = c;
                // 刷新数字
                number = 0;
            }
        }

        // 栈中数字求和得到结果
        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        return sum;
    }
}
