package tree;

public class MaxDistanceInTree {
    private static class Info {
        public int height;
        public int maxDistance;
        public Info(int height, int maxDistance) {
            this.height = height;
            this.maxDistance = maxDistance;
        }
    }

    public static int getMaxDistanceInTree(TreeNode head) {
        return process(head).maxDistance;
    }

    private static Info process(TreeNode head) {
        if (head == null) {
            return new Info(0, 0);
        }
        Info leftInfo = process(head.left), rightInfo = process(head.right);
        Info maxInfo = leftInfo.maxDistance > rightInfo.maxDistance ? leftInfo : rightInfo;
        int headIncludeDistance = leftInfo.height + rightInfo.height + 1;
        if (maxInfo.maxDistance > headIncludeDistance) {
            return maxInfo;
        } else {
            return new Info(maxInfo.height + 1, headIncludeDistance);
        }
    }

    public static void main(String[] args) {
        String str = "1,2,3,4,5,#,#,#,#,#,#,";
        TreeNode head = TreeTools.reconByLevelString(str);
        TreeTools.printBinaryTree(head);
        System.out.println(getMaxDistanceInTree(head));
    }

}


