package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author kelvin
 * @create 2021-03-17 10:38
 */
public class IsCBT {
    /**
     * check a tree is a complete binary search tree or not
     * @param head
     * @return
     */
    public static boolean isCBT(TreeNode head) {
        if (head == null) {
            return true;
        }
        boolean flag = false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(head);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur.left == null && cur.right != null) {
                return false;
            }
            if (flag) {
                if (cur.left != null || cur.right != null) {
                    return false;
                }
            } else {
                if (cur.right == null) {
                    flag = true;
                }
            }
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // see Leetcode958
        // https://leetcode-cn.com/problems/check-completeness-of-a-binary-tree/
    }
}
