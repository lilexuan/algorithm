package linkedList;

/**
 * @author kelvin
 * @create 2021-03-09 13:38
 */
public class MiddleNode {
    /**
     *
     * @param head
     * @return if even, the middle node is the second one
     */
    static public Node middleNode2(Node head) {
        if (head == null) {
            return null;
        }
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /**
     *
     * @param head
     * @return if even, the middle node is the first one
     */
    static public Node middleNode1(Node head) {
        if (head == null) {
            return null;
        }
        Node slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] arr2 = {1, 2, 3, 4, 5, 6, 7};
        Node head1 = LLTools.createLinkedList(arr1, false);
        Node head2 = LLTools.createLinkedList(arr2, false);
        System.out.println(middleNode1(head1).value);
        System.out.println(middleNode2(head1).value);
        System.out.println(middleNode1(head2).value);
        System.out.println(middleNode2(head2).value);
    }
}
