package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author kelvin
 * @create 2021-05-09 8:50
 */
public class LC139 {
    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        Solution22 solution22 = new Solution22();
        boolean b = solution22.wordBreak(s, wordDict);
        System.out.println(b);
    }
}

class Solution22 {
    public boolean wordBreak(String s, List<String> wordDict) {
        Trie trie = new Trie();
        for (String word : wordDict) {
            trie.insert(word);
        }
        return dfs(s, 0, trie.getRoot());
    }

    private boolean dfs(String s, int index, Node root) {
        if (index == s.length()) {
            return true;
        }
        Node cur = root;
        for (int i = index; i < s.length(); i++) {
            if (!cur.next.containsKey(s.charAt(i))) {
                return false;
            }
            // 分支1 如果当前已经匹配好了一个字符串, 那么从i+1起, 从root开始重新搜索
            if (cur.next.get(s.charAt(i)).end && dfs(s, i + 1, root)) {
                return true;
            }
            // 分支2 如果当前字符串匹配好但是重新搜索不行, 或者根本没有匹配好, 那么就继续往下走
            cur = cur.next.get(s.charAt(i));
        }
        // 检查是否到达了树中的某一个结束节点
        return cur.end;
    }
}

class Node {
    public boolean end;
    public Map<Character, Node> next;
    public Node() {
        this.end = false;
        this.next = new HashMap<>();
    }
}

class Trie {
    private Node root;
    public Trie() {
        root = new Node();
    }

    public void insert(String str) {
        char[] chs = str.toCharArray();
        Node cur = root;
        for (int i = 0; i < chs.length; i++) {
            if (!cur.next.containsKey(chs[i])) {
                cur.next.put(chs[i], new Node());
            }
            cur = cur.next.get(chs[i]);
        }
        cur.end = true;;
    }

    public Node getRoot() {
        return root;
    }
}


