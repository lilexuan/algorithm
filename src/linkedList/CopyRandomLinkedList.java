package linkedList;

import java.util.HashMap;
import java.util.Random;
import java.util.TreeMap;

import static linkedList.LLTools.createRandomLinkedList;
import static linkedList.LLTools.printRandomLinkedList;

/**
 * @author kelvin
 * @create 2021-03-13 15:08
 */
public class CopyRandomLinkedList {
    public static RandomNode copyRandomLinkedlist1(RandomNode head) {
        if (head == null) {
            return null;
        }
        RandomNode cur = head;
        HashMap<RandomNode, RandomNode> map = new HashMap<>();
        while (cur != null) {
            map.put(cur, new RandomNode(cur.value));
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).rand = map.get(cur.rand);
            cur = cur.next;
        }
        return map.get(head);
    }

    public static RandomNode copyRandomLinkedList2(RandomNode head) {
        if (head == null) {
            return null;
        }
        RandomNode cur = head;
        while (cur != null) {
            RandomNode tmp = new RandomNode(cur.value);
            tmp.next = cur.next;
            cur.next = tmp;
            cur = tmp.next;
        }
        cur = head;
        RandomNode res = cur.next;
        while (cur != null) {
            RandomNode next = cur.next.next;
            RandomNode curCopy = cur.next;
            curCopy.rand = cur.rand != null ? cur.rand.next : null;
            cur = next;
        }
        cur = head;
        while (cur != null) {
            RandomNode next = cur.next.next;
            RandomNode curCopy = cur.next;
            cur.next = next;
            curCopy.next = next != null ? next.next : null;
            cur = next;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        TreeMap<Integer, Integer> randIndex = new TreeMap<>();
        randIndex.put(1, 3);
        randIndex.put(2, 4);
        randIndex.put(5, 7);
        RandomNode head = createRandomLinkedList(arr, false, randIndex);
        printRandomLinkedList(head);
        RandomNode head2 = copyRandomLinkedlist1(head);
        printRandomLinkedList(head2);
        RandomNode head3 = copyRandomLinkedList2(head);
        printRandomLinkedList(head3);
    }
}
