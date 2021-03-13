package linkedList;

/**
 * @author kelvin
 * @create 2021-03-09 13:58
 */
public class IsPalindrome {
    static public boolean isPalindrome(Node head) {
        if (head == null) {
            return true;
        }
        Node part2 = MiddleNode.middleNode1(head).next;
        part2 = ReverseLinkedList.reverseLinkedList(part2);
        while (part2 != null) {
            if (part2.value != head.value) {
                return false;
            }
            part2 = part2.next;
            head = head.next;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5, 4, 3, 2, 1};
        int[] arr2=  {1, 2, 3, 4, 4, 3, 2, 1};
        int[] arr3=  {2, 3, 4, 4, 3, 2, 1};
        Node head1 = LLTools.createLinkedList(arr1, false);
        Node head2 = LLTools.createLinkedList(arr2, false);
        Node head3 = LLTools.createLinkedList(arr3, false);
        System.out.println(isPalindrome(head1));
        System.out.println(isPalindrome(head2));
        System.out.println(isPalindrome(head3));
    }
}
