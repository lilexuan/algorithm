package tree;

public class AVL {
    /**
     * 获取节点的高度
     * @param head
     * @return
     */
    public int getHeight(TreeNode head) {
        if (head == null) {
            return 0;
        }
        return head.height;
    }

    /**
     * 更新节点的高度
     * @param head
     */
    private void updateHeight(TreeNode head) {
        head.height = Math.max(getHeight(head.left), getHeight(head.right)) + 1;
    }

    private int getBalanceFactor(TreeNode head) {
        // 左子树高度减去右子树高度
        return getHeight(head.left) - getHeight(head.right);
    }

    /**
     * 在AVL树中查找数据域为x的节点
     * @param head
     * @param x
     * @return
     */
    public TreeNode search(TreeNode head, int x) {
        if (head == null || head.value == x) {
            return head;
        } else if (head.value > x) {
            return search(head.left, x);
        } else {
            return search(head.right, x);
        }
    }

    /**
     * 左旋
     * @param head
     * @return
     */
    private TreeNode leftRotation(TreeNode head) {
        if (head == null) {
            return null;
        }
        TreeNode tmp = head.right;
        head.right = tmp.left;
        tmp.left = head;
        return tmp;
    }

    /**
     * 右旋
     * @param head
     * @return
     */
    private TreeNode rightRotation(TreeNode head) {
        if (head == null) {
            return null;
        }
        TreeNode tmp = head.left;
        head.left = tmp.right;
        tmp.right = head;
        return tmp;
    }

    /**
     * 插入权值为x的节点
     * @param head
     * @param x
     */


}
