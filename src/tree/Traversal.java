package tree;

import sun.reflect.generics.tree.Tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author kelvin
 * @create 2021-03-14 12:36
 */
public class Traversal {
    public static void preOrderRecur(TreeNode head) {
        if (head == null) {
            return;
        }
        System.out.print(head.value + " ");
        preOrderRecur(head.left);
        preOrderRecur(head.right);
    }

    public static void preOrderUnRecur(TreeNode head) {
        if (head == null) {
            return;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(head);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            System.out.print(cur.value + " ");
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
        System.out.println();
    }

    public static void postOrderRecur(TreeNode head) {
        if (head == null) {
            return;
        }
        postOrderRecur(head.left);
        postOrderRecur(head.right);
        System.out.print(head.value + " ");
    }

    public static void postOrderUnRecur(TreeNode head) {
        if (head == null) {
            return;
        }
        Deque<TreeNode> stack1 = new LinkedList<>();
        Deque<TreeNode> stack2 = new LinkedList<>();
        stack1.push(head);
        while (!stack1.isEmpty()) {
            TreeNode cur = stack1.pop();
            stack2.push(cur);
            if (cur.left != null) {
                stack1.push(cur.left);
            }
            if (cur.right != null) {
                stack1.push(cur.right);
            }
        }
        while (!stack2.isEmpty()) {
            System.out.print(stack2.pop().value + " ");
        }
        System.out.println();
    }

    public static void inOrderRecur(TreeNode head) {
        if (head == null) {
            return;
        }
        inOrderRecur(head.left);
        System.out.print(head.value + " ");
        inOrderRecur(head.right);
    }

    public static void inOrderUnRecur(TreeNode head) {
        if (head == null) {
            return;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        while (!stack.isEmpty() || head != null) {
            if (head != null) {
                stack.push(head);
                head = head.left;
            } else {
                TreeNode cur = stack.pop();
                System.out.print(cur.value + " ");
                head = cur.right;
            }
        }
        System.out.println();
    }

    public static void levelOrder(TreeNode head) {
        if (head == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(head);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                System.out.print(cur.value + " ");
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        String str = "1,2,3,4,5,6,7,#,#,#,#,#,#,#,#";
        TreeNode head = TreeTools.reconByLevelString(str);
        TreeTools.printBinaryTree(head);
        System.out.println("-------------- pre order ---------------");
        preOrderRecur(head);
        System.out.println();
        preOrderUnRecur(head);
        System.out.println("-------------- post order --------------");
        postOrderRecur(head);
        System.out.println();
        postOrderUnRecur(head);
        System.out.println("-------------- in order ----------------");
        inOrderRecur(head);
        System.out.println();
        inOrderUnRecur(head);
        System.out.println("-------------- level order -------------");
        levelOrder(head);
    }
}
