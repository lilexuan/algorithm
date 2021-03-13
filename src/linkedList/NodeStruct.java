package linkedList;

/**
 * @author kelvin
 * @create 2021-03-08 16:58
 */
class Node {
    public int value;
    public Node next;
    public Node(int value) {
        this.value = value;
        this.next = null;
    }
}

class DoubleNode {
    public DoubleNode pre;
    public DoubleNode next;
    public int value;

    public DoubleNode(int value) {
        this.value = value;
        this.pre = null;
        this.next = null;
    }
}

class RandomNode {
    public int value;
    public RandomNode next;
    public RandomNode rand;
    public RandomNode(int value) {
        this.value = value;
        this.next = null;
        this.rand = null;
    }
}
