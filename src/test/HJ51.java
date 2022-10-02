package test;

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class HJ51 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ListNode head = new ListNode(-1, null);
        ListNode p = head;
        for (int i = 0; i < n; i++) {
            p.next = new ListNode(sc.nextInt(), null);
            p = p.next;
        }
        int k = sc.nextInt();
        p = head;
        while (k-- > 0) {
            p = p.next;
        }
        while (p != null) {
            head = head.next;
            p = p.next;
        }
        System.out.println(head.val);
    }
}

class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}