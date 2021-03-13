package linkedList;

/**
 * @author kelvin
 * @create 2021-03-08 17:00
 */

public class ReverseLinkedList {
    /**
     *
     * @param head linkedlist without empty head
     * @return
     */
    public static Node reverseLinkedList(Node head) {
        Node next = null, pre = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    /**
     *
     * @param head double linked list without empty head
     * @return
     */
    public static DoubleNode reverseDoubleLinkedList(DoubleNode head) {
        DoubleNode pre = null, next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            head.pre = next;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        Node head = LLTools.createLinkedList(arr, false);
        head = reverseLinkedList(head);
        LLTools.printLinkedList(head);

        DoubleNode dh = LLTools.createDoubleLinkedList(arr, false);
        dh = reverseDoubleLinkedList(dh);
        LLTools.printDoubleLinkedList(dh);
    }
}
