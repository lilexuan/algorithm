package HJ;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author kelvin
 * @create 2022-10-03 9:23
 */
public class HJ48 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int headNum = sc.nextInt();
        ListNodeHj48 head = new ListNodeHj48(headNum);
        ListNodeHj48 headPre = new ListNodeHj48(-1);
        ListNodeHj48 tail = new ListNodeHj48(-2);  // 头尾都建立虚节点，防止空节点情况
        headPre.next = head;
        head.pre = headPre;
        head.next = tail;
        tail.pre = head;
        HashMap<Integer, ListNodeHj48> map = new HashMap<>();
        map.put(headNum, head);
        map.put(-2, headPre);
        map.put(-1, tail); // 其实不放也行
        for (int i = 0; i < n - 1; i++) {
            int inputNum = sc.nextInt();
            int preNum = sc.nextInt();
            ListNodeHj48 node = new ListNodeHj48(inputNum);
            map.put(inputNum, node);
            ListNodeHj48 pre = map.get(preNum);
            ListNodeHj48 next = pre.next;
            pre.next = node;
            node.pre = pre;
            node.next = next;
            next.pre = node;
        }
        int delNum = sc.nextInt();
        ListNodeHj48 delNode = map.get(delNum);
        ListNodeHj48 pre = delNode.pre, next = delNode.next;
        pre.next = next;
        next.pre = pre;
        ListNodeHj48 p = headPre;
        while (p != null) {
            if (p.val >= 0) {
                System.out.print(p.val + " ");
            }
            p = p.next;
        }
    }
}

class ListNodeHj48 {
    public int val;
    public ListNodeHj48 next;
    public ListNodeHj48 pre;
    public ListNodeHj48(int val) {
        this.val = val;
    }
}
