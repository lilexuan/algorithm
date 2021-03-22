package tree;

public class Trie {
    private TrieNode root;
    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        if (word == null) {
            return;
        }
        char[] chs = word.toCharArray();
        TrieNode node = root;
        for (int i = 0; i < chs.length; i++) {
            int index = chs[i] - 'a';
            if (node.nexts[index] == null) {
                node.nexts[index] = new TrieNode();
            }
            node = node.nexts[index];
            node.path++;
        }
        node.end++;
    }

    public boolean search(String word) {
        if (word == null) {
            return false;
        }
        char[] chs = word.toCharArray();
        TrieNode node = root;
        for (int i = 0; i < chs.length; i++) {
            int index = chs[i] - 'a';
            if (node.nexts[index] == null) {
                return false;
            }
            node = node.nexts[index];
        }
        return node.end != 0;
    }

    public void delete(String word) {
        if (word == null || !search(word)) {
            return;
        }
        TrieNode node = root;
        char[] chs = word.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            int index = chs[i] - 'a';
            node.nexts[index].path--;
            if (node.nexts[index].path == 0) {
                node.nexts[index] = null;
                return;
            }
            node = node.nexts[index];
        }
        node.end--;
    }

    public boolean startWith(String word) {
        if (word == null) {
            return false;
        }
        char[] chs = word.toCharArray();
        TrieNode node = root;
        for (int i = 0; i < chs.length; i++) {
            int index = chs[i] - 'a';
            if (node.nexts[index] == null) {
                return false;
            }
            node = node.nexts[index];
        }
        return node.path != 0;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        System.out.println(trie.search("zuo") + "1");
        trie.insert("zuo");
        System.out.println(trie.search("zuo") + "2");
        trie.delete("zuo");
        System.out.println(trie.search("zuo") + "3");
        trie.insert("zuo");
        trie.insert("zuo");
        trie.delete("zuo");
        System.out.println(trie.search("zuo") + "4");
        trie.delete("zuo");
        System.out.println(trie.search("zuo") + "5");
        trie.insert("zuoa");
        trie.insert("zuoac");
        trie.insert("zuoab");
        trie.insert("zuoad");
        trie.delete("zuoa");
        System.out.println(trie.search("zuoa") + "6");
        System.out.println(trie.startWith("zuo") + "7");
        System.out.println(trie.startWith("zuoa") + "8");
    }

}
