package linkedList;

import util.ArrTools;

/**
 * @author kelvin
 * @create 2021-03-09 12:29
 */
public class PrintCommon {
    static public void printLinkedListCommon(Node head1, Node head2) {
        while (head1 != null && head2 != null) {
            if (head1.value < head2.value) {
                head1 = head1.next;
            } else if (head1.value > head2.value) {
                head2 = head2.next;
            } else {
                System.out.print(head1.value + " ");
                head1 = head1.next;
                head2 = head2.next;
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr1 = ArrTools.generateRandomArray(300, 5);
        int[] arr2 = ArrTools.generateRandomArray(300, 5);
        Node head1 = LLTools.createLinkedList(arr1, false);
        Node head2 = LLTools.createLinkedList(arr2, false);
        printLinkedListCommon(head1, head2);
    }
}
