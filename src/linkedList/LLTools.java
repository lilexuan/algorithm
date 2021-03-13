package linkedList;

import jdk.nashorn.internal.ir.LoopNode;

import java.util.*;

/**
 * @author kelvin
 * @create 2021-03-08 22:05
 */
public class LLTools {
    /**
     *
     * @param arr
     * @param headFlag need empty head node or not
     * @return
     */
    static public Node createLinkedList(int[] arr, boolean headFlag) {
        Node head = new Node(0), cur = head;
        for (int num : arr) {
            cur.next = new Node(num);
            cur = cur.next;
        }
        if (!headFlag) {
            head = head.next;
        }
        return head;
    }

    static public DoubleNode createDoubleLinkedList(int[] arr, boolean headFlag) {
        DoubleNode head = new DoubleNode(0), cur = head;
        for (int num : arr) {
            DoubleNode tmp = new DoubleNode(num);
            tmp.pre = cur;
            cur.next = tmp;
            cur = cur.next;
        }
        if (!headFlag) {
            head = head.next;
        }
        return head;
    }

    static public RandomNode createRandomLinkedList(int[] arr, boolean headFlag, TreeMap<Integer, Integer> randIndex) {
        RandomNode head = new RandomNode(0), cur = head;
        for (int num : arr) {
            cur.next = new RandomNode(num);
            cur = cur.next;
        }
        for (Map.Entry<Integer, Integer> entry : randIndex.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            RandomNode kp = head, vp = head;
            for (int i = 0; i < key; i++) {
                kp = kp.next;
            }
            for (int i = 0; i < value; i++) {
                vp = vp.next;
            }
            if (kp != null && vp != null) {
                kp.rand = vp;
            }
        }
        if (!headFlag) {
            head = head.next;
        }
        return head;
    }

    static public Node createLoopLinkedList(int[] arr, boolean headFlag, int loopIndex) {
        Node head = new Node(0), loopNode = null, cur = head;
        for (int i = 0; i < arr.length; i++) {
            cur.next = new Node(arr[i]);
            cur = cur.next;
            if (i + 1 == loopIndex) {
                loopNode = cur;
            }
        }
        cur.next = loopNode;
        if (!headFlag) {
            head = head.next;
        }
        return head;
    }

    static public void printLinkedList(Node head) {
        if (getLoopNode(head) == null) {
            while (head != null) {
                System.out.print(head.value + "->");
                head = head.next;
            }
            System.out.println("null");
        } else {
            ;
        }
    }

    static public void printDoubleLinkedList(DoubleNode head) {
        DoubleNode tail = null;
        while (head != null) {
            System.out.print(head.value + "->");
            if (head.next == null) {
                tail = head;
            }
            head = head.next;
        }
        System.out.println("null");

        Deque<DoubleNode> stack = new LinkedList<>();
        while (tail != null) {
            stack.push(tail);
            tail = tail.pre;
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop().value + "<-");
        }
        System.out.println("null");
    }

    static public void printRandomLinkedList(RandomNode head) {
        HashMap<RandomNode, RandomNode> randLink = new HashMap<>();
        while (head != null) {
            if (head.rand != null) {
                randLink.put(head, head.rand);
            }
            System.out.print(head.toString() + "(" + head.value + ")" + "->");
            head = head.next;
        }
        System.out.println("null");
        for (Map.Entry<RandomNode, RandomNode> entry : randLink.entrySet()) {
            System.out.println(entry.getKey() + "->" + entry.getValue());
        }
    }

    static public void printLoopLinkedList(Node head) {
        HashSet<Node> set = new HashSet<>();
        Node cur = head;
        while (cur != null && !set.contains(cur)) {
            set.add(cur);
            cur = cur.next;
        }
        Node loopNode = cur;
        int cnt = 0;
        while (cnt <= 1) {
            if (head == loopNode) {
                cnt++;
            }
            System.out.print(head.toString() + "(" + head.value + ")" + "->");
            head = head.next;
        }
        System.out.println();
        System.out.println("loop Node is " + loopNode + "(" + loopNode.value + ")");
    }

    static public Node getLoopNode(Node head) {
        Node slow = head, fast = head;
        boolean hasCycle = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                hasCycle = true;
                break;
            }
        }
        if (!hasCycle) {
            return null;
        }
        slow =  head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    /**
     * head1 insert into at the index of head2, count from 1
     * @param head1
     * @param head2
     * @param index
     * @return
     */
    static public void makeIntersect(Node head1, Node head2, int index) {
        if (head1 == null || head2 == null) {
            return;
        }
        Node cur1 = head1, cur2 = head2;
        while (cur1.next != null) {
            cur1 = cur1.next;
        }
        int cnt = 0;
        while (cnt < index - 1) {
            cur2 = cur2.next;
            cnt++;
        }
        cur1.next = cur2;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        Node head = createLoopLinkedList(arr, false, 4);
        printLoopLinkedList(head);
        System.out.println(getLoopNode(head));
    }
}
