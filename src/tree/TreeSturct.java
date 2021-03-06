package tree;

/**
 * @author kelvin
 * @create 2021-03-14 9:53
 */
class TreeNode {
    int value;
    int height;
    TreeNode left;
    TreeNode right;
    TreeNode(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
        this.height = 1;
    }
}

class TrieNode {
    public int path;
    public int end;
    public TrieNode[] nexts;
    public TrieNode() {
        this.path = 0;
        this.end = 0;
        this.nexts = new TrieNode[26];
    }
}
