package tree;

/**
 * @author kelvin
 * @create 2021-05-09 10:30
 */
public class LC124 {
    public static void main(String[] args) {
        String str = "5,4,8,11,#,13,4,7,2,#,#,#,1,#,#,#,#,#,#,";
        TreeNode treeNode = TreeTools.reconByLevelString(str);
        TreeTools.printBinaryTree(treeNode);
        Solution solution = new Solution();
        int i = solution.maxPathSum(treeNode);
        System.out.println(i);
    }
}

class Solution {
    public int maxPathSum(TreeNode root) {
        Info info = maxPathSumInfo(root);
        return info.maxSumAll;
    }

    private Info maxPathSumInfo(TreeNode root) {
        if (root == null) {
            return null;
        }
        Info leftInfo = maxPathSumInfo(root.left);
        Info rightInfo = maxPathSumInfo(root.right);
        int maxSumFromHead = root.value;
        int maxSumAll = root.value;
        if (leftInfo != null) {
            maxSumFromHead = Math.max(maxSumFromHead, leftInfo.maxSumFromHead + root.value);
            maxSumAll = Math.max(maxSumAll, Math.max(leftInfo.maxSumFromHead + root.value, leftInfo.maxSumAll));
        }
        if (rightInfo != null) {
            maxSumFromHead = Math.max(maxSumFromHead, rightInfo.maxSumFromHead + root.value);
            maxSumAll = Math.max(maxSumAll, Math.max(rightInfo.maxSumFromHead + root.value, rightInfo.maxSumAll));
        }
        if (leftInfo != null && rightInfo != null) {
            maxSumAll = Math.max(maxSumAll, root.value + leftInfo.maxSumFromHead + rightInfo.maxSumFromHead);
        }
        return new Info(maxSumAll, maxSumFromHead);
    }
}

class Info {
    public int maxSumAll;
    public int maxSumFromHead;
    public Info(int maxSumAll, int maxSumFromHead) {
        this.maxSumAll = maxSumAll;
        this.maxSumFromHead = maxSumFromHead;
    }
}
