package HJ;

import java.util.*;

/**
 * @author kelvin
 * @create 2022-10-05 10:28
 */
public class HJ70 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<MatrixHJ70> matrixArray = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int row = sc.nextInt();
            int column = sc.nextInt();
            matrixArray.add(new MatrixHJ70(row, column));
        }
        sc.nextLine();
        String pattern = sc.nextLine();
        Deque<MatrixHJ70> stack = new LinkedList<>();
        int res = 0;
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            if ('A' <= c && c <= 'Z') {  // 如果是字符直接入栈
                int t = c - 'A';
                stack.push(matrixArray.get(t));
            } else if (c == ')') {  // 右括号则 弹出两个元素, 并累加乘法次数
                MatrixHJ70 y = stack.pop();
                MatrixHJ70 x = stack.pop();
                if (x.column == y.row) {
                    res += x.column * x.row * y.column;
                    stack.push(new MatrixHJ70(x.row, y.column));
                } else if (x.row == y.column) {
                    res += x.row * x.column * y.row;
                    stack.push(new MatrixHJ70(x.column, y.row));
                }
            }
        }
        System.out.println(res);
    }


}

class MatrixHJ70 {
    public int row;
    public int column;
    public MatrixHJ70(int row, int column) {
        this.row = row;
        this.column = column;
    }
}
