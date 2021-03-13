package linkedList;

/**
 * @author kelvin
 * @create 2021-03-13 10:50
 */
public class Partition {
    static public Node partition(Node head, int target) {
        if (head == null) {
            return head;
        }
        Node sh = null, st = null, eh = null, et = null, bh = null, bt = null;
        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = null;
            if (head.value  < target) {
                if (sh == null) {
                    sh = head;
                    st = head;
                } else {
                    st.next = head;
                    st = head;
                }
            } else if (head.value == target) {
                if (eh == null) {
                    eh = head;
                    et = head;
                } else {
                    et.next = head;
                    et = head;
                }
            } else {
                if (bh == null) {
                    bh = head;
                    bt = head;
                } else {
                    bt.next = head;
                    bt = head;
                }
            }
            head = next;
        }
        if (st != null) {
            st.next = eh;
            et = et == null ? st : et;
        }
        if (et != null) {
            et.next = bh;
        }
        return sh != null ? sh : (eh != null ? eh : bh);
    }

    public static void main(String[] args) {
        Node head = LLTools.createLinkedList(new int[]{13, 12, 11, 10, 9, 9, 9, 8, 7, 6, 5}, false);
        Node result = partition(head, 9);
        LLTools.printLinkedList(result);
    }
}
