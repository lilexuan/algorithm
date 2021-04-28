package tree;

import java.util.TreeMap;

/**
 * @author kelvin
 * @create 2021-04-24 14:48
 */
public class GetAndPriintFolderTree {
    public static void getAndPriintFolderTree(String[] dirs) {
        FolderTree tree = new FolderTree();
        for (String dir : dirs) {
            String[] paths = dir.split("\\\\");  // 恶心的转义字符
            tree.insert(paths);
        }
        tree.print();
    }

    public static void main(String[] args) {
        String[] arr = { "b\\cst", "d\\", "a\\d\\e", "a\\b\\c" };
        getAndPriintFolderTree(arr);
    }
}

class FTreeNode {
    String name;
    TreeMap<String, FTreeNode> map;
    public FTreeNode(String name) {
        this.name = name;
        map = new TreeMap<>();
    }
}

class FolderTree {
    FTreeNode root = null;
    public FolderTree() {
        root = new FTreeNode("");
    }

    public void insert(String[] names) {
        if (names == null || names.length == 0) {
            return;
        }
        FTreeNode node = root;
        for (String name : names) {
            if (!node.map.containsKey(name)) {
                node.map.put(name, new FTreeNode(name));
            }
            node = node.map.get(name);
        }
    }

    public void print() {
        print(root, -1);
    }

    private void print(FTreeNode node, int level) {
        System.out.println(getNChar(level, '-') + node.name);
        for (FTreeNode child : node.map.values()) {
            print(child, level + 1);
        }
    }

    private String getNChar(int level, char c) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < level * 2; i++) {
            sb.append(c);
        }
        return sb.toString();
    }
}