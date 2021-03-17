package tree;

/**
 * @author kelvin
 * @create 2021-03-17 11:37
 */
public class IsBalanceTree {
    /**
     * check a tree is a balance binary tree or not
     * @param head
     * @return
     */
    public static boolean isBalanceTree(TreeNode head) {
        return process(head).isBalance;
    }

    private static class ReturnType {
        boolean isBalance;
        int height;
        public ReturnType(boolean isBalance, int height) {
            this.isBalance = isBalance;
            this.height = height;
        }
    }

    private static ReturnType process(TreeNode head) {
        if (head == null) {
            return new ReturnType(true, 0);
        }
        ReturnType leftData = process(head.left);
        ReturnType rightData = process(head.right);
        boolean isBalance = leftData.isBalance
                && rightData.isBalance
                && Math.abs(leftData.height - rightData.height) <= 1;
        int height = Math.max(leftData.height, rightData.height) + 1;
        return new ReturnType(isBalance, height);
    }

    public static void main(String[] args) {
        // see leetcode110
        // https://leetcode-cn.com/problems/balanced-binary-tree/
    }
}
