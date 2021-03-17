package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kelvin
 * @create 2021-03-17 9:38
 */

public class IsBST {
    /**
     * check a tree is a binary search tree or not
     * @param head
     * @return
     */
    public static boolean isBST(TreeNode head) {
        List<Integer> inOrderList = new ArrayList<>();
        inorder(head, inOrderList);
        int pre = inOrderList.get(0);
        for (int i = 1; i < inOrderList.size(); i++) {
            int num = inOrderList.get(i);
            if (num <= pre) {
                return false;
            }
            pre = num;
        }
        return true;
    }

    private static void inorder(TreeNode head, List<Integer> list) {
        if (head == null) {
            return;
        }
        inorder(head.left, list);
        list.add(head.value);
        inorder(head.right, list);
    }

    public static void main(String[] args) {
        // see leetcode98
        // https://leetcode-cn.com/problems/validate-binary-search-tree/
    }
}
