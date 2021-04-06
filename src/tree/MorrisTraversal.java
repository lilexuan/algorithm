package tree;

import linkedList.ReverseLinkedList;

/**
 * @author kelvin
 * @create 2021-04-03 16:52
 */
public class MorrisTraversal {
    public static void morrisPre(TreeNode head) {
        if (head == null) {
            return;
        }
        TreeNode cur = head;
        TreeNode mostRight = null;
        while (cur != null) {
            mostRight = cur.left;

            // 当cur1的左子树不为空时
            if (mostRight != null) {
                // 找到cur1左子树上最右的节点mostRight
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }

                //如果mostRight的右指针指向空, 让其指向cur, 然后cur向左移动
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    System.out.print(cur.value + " ");
                    cur = cur.left;
                    continue;
                } else {
                    // 如果mostRight的右指针指向cur, 让其指向null
                    mostRight.right = null;
                }
            } else {
                System.out.print(cur.value + " ");
            }
            // cur向右移动
            cur = cur.right;
        }
        System.out.println();
    }

    public static void morrisIn(TreeNode head) {
        if (head == null) {
            return;
        }
        TreeNode cur = head;
        TreeNode mostRight = null;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else {
                    mostRight.right = null;
                }
            }
            System.out.print(cur.value + " ");
            cur = cur.right;
        }
        System.out.println();
    }

    public static void morrisPost(TreeNode head) {
        if (head == null) {
            return;
        }
        TreeNode cur = head;
        TreeNode mostRight = null;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else {
                    mostRight.right = null;
                    printEdge(cur.left);
                }
            }
            cur = cur.right;
        }
        printEdge(head);
        System.out.println();
    }

    private static void printEdge(TreeNode head) {
        TreeNode tail = reverseEdge(head);
        TreeNode cur = tail;
        while (cur != null) {
            System.out.print(cur.value + " ");
            cur = cur.right;
        }
        reverseEdge(tail);
    }

    private static TreeNode reverseEdge(TreeNode head) {
        TreeNode cur = null;
        TreeNode next = null;
        while (head != null) {
            next = head.right;
            head.right = cur;
            cur = head;
            head = next;
        }
        return cur;
    }

    public static void main(String[] args) {
        String treeStr1 = "1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,#,#,#,#,#,#,#,#,#,#,#,#,#,#,#,#,";
        TreeNode head1 = TreeTools.reconByLevelString(treeStr1);
        System.out.println("====preOrder====");
        morrisPre(head1);
        Traversal.preOrderRecur(head1);
        System.out.println();
        System.out.println("====inOrder====");
        morrisIn(head1);
        Traversal.inOrderRecur(head1);
        System.out.println();
        System.out.println("====postOrder====");
        morrisPost(head1);
        Traversal.postOrderRecur(head1);

    }
}
