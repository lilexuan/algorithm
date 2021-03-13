package linkedList;

/**
 * @author kelvin
 * @create 2021-03-13 20:42
 */
public class Intersect {
    static public Node intersection(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        Node loop1 = LLTools.getLoopNode(head1);
        Node loop2 = LLTools.getLoopNode(head2);
        if (loop1 == null && loop2 == null) {  // 两个都不是循环链表
            return noLoop(head1, head2);
        } else if (loop1 != null && loop2 != null) {  // 两个都是循环链表
            return bothLoop(head1, loop1, head2, loop2);
        }
        return null; // 只有其中一个是循环链表
    }

    static public Node noLoop(Node head1, Node head2) {
        Node cur1 = head1, cur2 = head2;
        int cnt1 = 1, cnt2 = 1;
        while (cur1.next != null) {
            cur1 = cur1.next;
            cnt1++;
        }
        while (cur2.next != null) {
            cur2 = cur2.next;
            cnt2++;
        }
        if (cur1 != cur2) {  // 如果两条链表的尾节点不相等, 说明没有相交
            return null;
        }
        if (cnt1 < cnt2) {
            int tmpVal = cnt1;
            cnt1 = cnt2;
            cnt2 = tmpVal;
            Node tmpNode = head1;
            head1 = head2;
            head2 = tmpNode;
        }
        cur1 = head1;
        cur2 = head2;
        for (int i = 0; i < cnt1 - cnt2; i++) {
            cur1 = cur1.next;
        }
        while (cur1 != cur2) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }

    static public Node bothLoop(Node head1, Node loop1, Node head2, Node loop2) {
        Node cur1 = head1, cur2 = head2;
        if (loop1 == loop2) {  // 两条链表的循环点一样
            cur1 = head1;
            cur2 = head2;
            int n = 0;
            while (cur1 != loop1) {
                n++;
                cur1 = cur1.next;
            }
            while (cur2 != loop2) {
                n--;
                cur2 = cur2.next;
            }
            cur1 = n > 0? head1 : head2;
            cur2 = cur1 == head1 ? head2 : head1;
            n = Math.abs(n);
            while (n != 0) {
                n--;
                cur1 = cur1.next;
            }
            while (cur1 != cur2) {
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return cur1;
        } else {  // 两个链表循环点不一样
            cur1 = loop1.next;
            while (cur1 != loop1) {
                if (cur1 == loop2) {
                    return loop1;
                }
                cur1 = cur1.next;
            }
            return null;
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5, 6};
        int[] arr2 = {7, 8, 9};
        Node head1 = LLTools.createLinkedList(arr1, false);
        Node head2 = LLTools.createLinkedList(arr2, false);
        LLTools.makeIntersect(head1, head2, 2);
        Node intersection = intersection(head1, head2);
        System.out.println(intersection.value);

        Node head3 = LLTools.createLoopLinkedList(arr1, false, 4);
        Node head4 = LLTools.createLinkedList(arr2, false);
        LLTools.makeIntersect(head4, head3, 3);
        Node intersection1 = intersection(head3, head4);
        System.out.println(intersection1.value);

        Node head5 = LLTools.createLoopLinkedList(arr1, false, 4);
        Node head6 = LLTools.createLinkedList(arr2, false);
        LLTools.makeIntersect(head6, head5, 5);
        Node intersection2 = intersection(head5, head6);
        System.out.println(intersection2.value);
        System.out.println("ha");
    }

}
