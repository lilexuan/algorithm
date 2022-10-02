package tree;

/**
 * @author kelvin
 * @create 2022-09-25 21:37
 */
public class LC543 {
    public static void main(String[] args) {
        String str = "4,-7,-3,#,#,-9,-3,9,-7,-4,#,6,#,-6,-6,#,#,0,6,5,#,9,#,#,-1,-4,#,#,#,-2,#,#,#,#,#,#,#,";
        TreeNode treeNode = TreeTools.reconByLevelString(str);
        TreeTools.printBinaryTree(treeNode);
        LC543 lc543 = new LC543();
        int res = lc543.diameterOfBinaryTree(treeNode);
        System.out.println(res);
    }

    public int diameterOfBinaryTree(TreeNode root) {
        return getDiameter(root) - 1;
    }

    private int getDiameter(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int dRoot = height(root.left) + height(root.right) + 1;
        int dLeft = getDiameter(root.left);
        int dRight = getDiameter(root.right);
        return Math.max(dRoot, Math.max(dLeft, dRight));
    }

    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(height(root.left), height(root.right)) + 1;
    }
}
