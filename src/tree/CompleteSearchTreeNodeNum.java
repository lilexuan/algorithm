package tree;

/**
 * @author kelvin
 * @create 2021-05-01 15:58
 */
public class CompleteSearchTreeNodeNum {
    public static int getCSTNum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        if (leftHeight == rightHeight) {
            return (1 << leftHeight) + getCSTNum(root.right);
        } else {
            return getCSTNum(root.left) + (1 << rightHeight);
        }
    }

    private static int height(TreeNode root) {
        int cnt = 0;
        while (root != null) {
            cnt++;
            root = root.left;
        }
        return cnt;
    }

    public static void main(String[] args) {
        String str = "1,2,3,4,5,6,7,8,9,#,#,#,#,#,#,#,#,#,#,#,";
        TreeNode treeNode = TreeTools.reconByLevelString(str);
        System.out.println(getCSTNum(treeNode));
    }
}
