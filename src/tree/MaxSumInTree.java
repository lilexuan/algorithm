package tree;

public class MaxSumInTree {
    public static int getMaxSumInTree(TreeNode head) {
        return process(head, 0);
    }

    private static int process(TreeNode head, int pre) {
        if (head == null) {
            return Integer.MIN_VALUE;
        }
        if (head.left == null && head.right == null) {
            return pre + head.value;
        }
        int leftMax = process(head.left, pre + head.value);
        int rightMax = process(head.right, pre + head.value);
        return Math.max(leftMax, rightMax);
    }

    public static void main(String[] args) {
        String str = "1,2,3,4,5,6,7,#,#,#,#,#,#,#,#";
        TreeNode head = TreeTools.reconByLevelString(str);
        TreeTools.printBinaryTree(head);
        int maxSumInTree = getMaxSumInTree(head);
        System.out.println(maxSumInTree);
    }
}
