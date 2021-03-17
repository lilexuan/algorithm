package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author kelvin
 * @create 2021-03-17 11:05
 */
public class IsFBT {
    /**
     * check a tree is a full binary search tree or not
     * @param head
     * @return
     */
    public static boolean isFBT(TreeNode head) {
        if (head == null) {
            return true;
        }
        int level = 0;
        int cnt = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(head);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            cnt += size;
            level++;
        }
        return (int)Math.pow(2, level) - 1 == cnt;
    }

    public static void main(String[] args) {
        System.out.println("============================== test1 ==================================");
        String treeStr1 = "1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,#,#,#,#,#,#,#,#,#,#,#,#,#,#,#,#,";
        TreeNode head1 = TreeTools.reconByLevelString(treeStr1);
        TreeTools.printBinaryTree(head1);
        System.out.println(isFBT(head1));

        System.out.println("============================== test2 ==================================");
        String treeStr2 = "1,2,3,4,5,6,7,8,9,10,11,12,13,14,#,#,#,#,#,#,#,#,#,#,#,#,#,#,#,";
        TreeNode head2 = TreeTools.reconByLevelString(treeStr2);
        TreeTools.printBinaryTree(head2);
        System.out.println(isFBT(head2));
    }
}
