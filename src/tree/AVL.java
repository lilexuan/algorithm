package tree;

public class AVL {
    /**
     * 获取节点的高度
     * @param head
     * @return
     */
    public  static int getHeight(TreeNode head) {
        if (head == null) {
            return 0;
        }
        return head.height;
    }

    /**
     * 更新节点的高度
     * @param head
     */
    private static void updateHeight(TreeNode head) {
        head.height = Math.max(getHeight(head.left), getHeight(head.right)) + 1;
    }

    private static int getBalanceFactor(TreeNode head) {
        // 左子树高度减去右子树高度
        return getHeight(head.left) - getHeight(head.right);
    }

    /**
     * 在AVL树中查找数据域为x的节点
     * @param head
     * @param x
     * @return
     */
    public static TreeNode search(TreeNode head, int x) {
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
    private static TreeNode leftRotation(TreeNode head) {
        if (head == null) {
            return null;
        }
        TreeNode tmp = head.right;
        head.right = tmp.left;
        tmp.left = head;
        updateHeight(head);
        updateHeight(tmp);
        return tmp;
    }

    /**
     * 右旋
     * @param head
     * @return
     */
    private static TreeNode rightRotation(TreeNode head) {
        if (head == null) {
            return null;
        }
        TreeNode tmp = head.left;
        head.left = tmp.right;
        tmp.right = head;
        updateHeight(head);
        updateHeight(tmp);
        return tmp;
    }

    /**
     * 插入权值为x的节点
     * @param head
     * @param x
     */
    public static TreeNode insert(TreeNode head, int x) {
        if (head == null) {
            return new TreeNode(x);
        }
        if (x < head.value) {
            head.left = insert(head.left, x);
            // 插入后需要更新树的高度
            updateHeight(head);
            // 因为是往左子树上插入, 所以只用检查是LL类型还是LR类课
            if (getBalanceFactor(head) == 2) {
                if (getBalanceFactor(head.left) == 1) {  // LL类型
                    head = rightRotation(head);
                } else if (getBalanceFactor(head.left) == -1) {  // LR类型
                    head.left = leftRotation(head.left);
                    head = rightRotation(head);
                }
            }
        } else {
            head.right = insert(head.right, x);
            // 插入后需要更新树的高度
            updateHeight(head);
            // 因为是往右子树上插入, 所以只用检查是RR类型还是RL类型
            if (getBalanceFactor(head) == -2) {
                if (getBalanceFactor(head.right) == -1) {  // RR类型
                    head = leftRotation(head);
                } else if (getBalanceFactor(head.right) == 1) {  // RL类型
                    head.right = rightRotation(head.right);
                    head = leftRotation(head);
                }
            }
        }
        return head;
    }

    public static TreeNode create(int[] nums) {
        TreeNode head = null;
        for (int num : nums) {
            head = insert(head, num);
        }
        return head;
    }

    public static void main(String[] args) {
//        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] arr = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        TreeNode treeNode = create(arr);
        TreeTools.printBinaryTree(treeNode);
    }
}
