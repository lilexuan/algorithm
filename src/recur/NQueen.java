package recur;

public class NQueen {
    public static int countNQueen(int n, int row, int[] record) {
        if (row == n) {
            return 1;
        }
        int res = 0;
        for (int col = 0; col < n; col++) {
            if (isValid(record, row, col)) {
                record[row] = col;
                res += countNQueen(n, row + 1, record);
            }
        }
        return res;
    }

    private static boolean isValid(int[] record, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (record[i] == col || (Math.abs(i - row) == Math.abs(record[i] - col))) {
                return false;
            }
        }
        return true;
    }

    public static int countNQueen(int n) {
        int[] record = new int[n];
        return countNQueen(n, 0, record);
    }

    public static int countNQueeenPlus(int n) {
        // 不能超过32皇后, 因为int也就32位
        if (n < 1 || n > 32) {
            return -1;
        }
        // limit: n皇后问题, 则limit是前面
        int limit = n == 32 ? -1 : (1 << n) - 1;
        return countNQueeenPlus(limit, 0, 0, 0);
    }

    private static int countNQueeenPlus(int upperLim, int colLim, int leftDiaLim, int rightDiaLim) {
        if (colLim == upperLim) {
            return 1;
        }
        int pos = 0;
        int mostRightOne = 0;
        pos = upperLim & (~(colLim | leftDiaLim | rightDiaLim));
        int res = 0;
        while (pos != 0) {
            mostRightOne = pos & (~pos + 1);
            pos = pos - mostRightOne; // 不断提取最右面的1, 也就是pos的位信息包含多少个1, 就循环多少次
            res += countNQueeenPlus(upperLim,
                    colLim | mostRightOne,
                    (leftDiaLim | mostRightOne) << 1,
                    (rightDiaLim | mostRightOne) >>> 1);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(countNQueen(1));
        System.out.println(countNQueen(8));
        System.out.println(countNQueeenPlus(1));
        System.out.println(countNQueeenPlus(8));
    }
}
