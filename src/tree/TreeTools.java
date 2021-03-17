package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author kelvin
 * @create 2021-03-14 9:56
 */
public class TreeTools {
    public static void printBinaryTree(TreeNode head) {
        System.out.println("Binary Tree:");
        printInorder(head, 0, "H", 17);
        System.out.println();
    }

    private static void printInorder(TreeNode head, int height, String to, int len) {
        if (head == null) {
            return;
        }
        printInorder(head.right, height + 1, "v", len);
        String val = to + head.value + to;
        int lenM = val.length();
        int lenL = (len - lenM) / 2;
        int lenR = len - lenM - lenL;
        val = getSpace(lenL) + val + getSpace(lenR);
        System.out.println(getSpace(height * len) + val);
        printInorder(head.left, height + 1, "^", len);
    }

    private static String getSpace(int num) {
        String space = " ";
        StringBuffer buf = new StringBuffer("");
        for (int i = 0; i < num; i++) {
            buf.append(space);
        }
        return buf.toString();
    }

    public static String serialByPre(TreeNode head) {
        if (head == null) {
            return "#,";
        }
        String res = head.value + ",";
        res += serialByPre(head.left);
        res += serialByPre(head.right);
        return res;
    }

    public static TreeNode reconByPreString(String preStr) {
        String[] values = preStr.split(",");
        Queue<String> queue = new LinkedList<>();
        for (String value : values) {
            queue.offer(value);
        }
        return reconByPreOrder(queue);
    }

    private static TreeNode reconByPreOrder(Queue<String> queue) {
        String value = queue.poll();
        if (value.equals("#")) {
            return null;
        }
        TreeNode head = new TreeNode(Integer.valueOf(value));
        head.left = reconByPreOrder(queue);
        head.right = reconByPreOrder(queue);
        return head;
    }

    public static String serialByLevel(TreeNode head) {
        if (head == null) {
            return "#,";
        }
        String res = head.value + ",";
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(head);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur.left != null) {
                res += cur.left.value + ",";
                queue.offer(cur.left);
            } else {
                res += "#,";
            }
            if (cur.right != null) {
                res += cur.right.value + ",";
                queue.offer(cur.right);
            } else {
                res += "#,";
            }
        }
        return res;
    }

    public static TreeNode reconByLevelString(String levelStr) {
        String[] values = levelStr.split(",");
        int index = 0;
        TreeNode head = generateTreeNodeByString(values[index++]);
        Queue<TreeNode> queue = new LinkedList<>();
        if (head != null) {
            queue.offer(head);
        }
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            cur.left = generateTreeNodeByString(values[index++]);
            cur.right = generateTreeNodeByString(values[index++]);
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }
        return head;
    }

    private static TreeNode generateTreeNodeByString(String str) {
        if (str.equals("#")) {
            return null;
        }
        return new TreeNode(Integer.valueOf(str));
    }

    public static void main(String[] args) {
//        String str = "1,2,4,#,#,5,#,#,3,#,6,#,#,";
//        TreeNode head = reconByPreString(str);
//        printBinaryTree(head);
//        String str2 = serialByPre(head);
//        System.out.println(str2);

        String str = "1,2,3,4,5,#,6,#,#,#,#,#,#";
        TreeNode head = reconByLevelString(str);
        printBinaryTree(head);
        String str2 = serialByLevel(head);
        System.out.println(str2);
    }
}
