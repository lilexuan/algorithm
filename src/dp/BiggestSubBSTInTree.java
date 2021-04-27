package dp;

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class BiggestSubBSTInTree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int rootValue = sc.nextInt();
        NodeBST root = new NodeBST(rootValue);
        Map<Integer, NodeBST> map = new HashMap<>();
        map.put(rootValue, root);
        map.put(0, null);
        for (int i = 0; i < n ;i++) {
            int faValue = sc.nextInt();
            int lchValue = sc.nextInt();
            int rchValue = sc.nextInt();
            NodeBST fa = map.getOrDefault(faValue, new NodeBST(faValue));
            NodeBST lch = map.getOrDefault(lchValue, new NodeBST(lchValue));
            NodeBST rch = map.getOrDefault(rchValue, new NodeBST(rchValue));
            fa.left = lch;
            fa.right = rch;
            if (!map.containsKey(faValue)) {
                map.put(faValue, fa);
            }
            if (!map.containsKey(lchValue)) {
                map.put(lchValue, lch);
            }
            if (!map.containsKey(rchValue)) {
                map.put(rchValue, rch);
            }
        }
        InfoBST infoBST = process(root);
        System.out.println(infoBST.cnt);
    }

    private static InfoBST process(NodeBST head) {
        if (head == null) {
            return new InfoBST(null, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        InfoBST leftInfoBST = process(head.left);
        InfoBST rightInfoBST = process(head.right);
        int min = Math.min(head.value, Math.min(leftInfoBST.min, rightInfoBST.min));
        int max = Math.max(head.value, Math.max(leftInfoBST.max, rightInfoBST.max));
        int cnt = Math.max(leftInfoBST.cnt, rightInfoBST.cnt);
        NodeBST maxBSTHead = leftInfoBST.cnt >= rightInfoBST.cnt ? leftInfoBST.maxBSTHead : rightInfoBST.maxBSTHead;
        if (leftInfoBST.maxBSTHead == head.left && rightInfoBST.maxBSTHead == head.right && leftInfoBST.max < head.value && head.value < rightInfoBST.min) {
            maxBSTHead = head;
            cnt = leftInfoBST.cnt + rightInfoBST.cnt + 1;
        }
        return new InfoBST(maxBSTHead, cnt, min, max);
    }
}

class NodeBST {
    int value;
    NodeBST left;
    NodeBST right;
    public NodeBST(int value) {
        this.value = value;
        left = null;
        right = null;
    }
}

class InfoBST {
    NodeBST maxBSTHead;
    int cnt;
    int min;
    int max;
    public InfoBST(NodeBST maxBSTHead, int cnt, int min, int max) {
        this.maxBSTHead = maxBSTHead;
        this.cnt = cnt;
        this.min = min;
        this.max = max;
    }
}

/* test data
3 2
2 1 3
1 0 0
3 0 0
 */