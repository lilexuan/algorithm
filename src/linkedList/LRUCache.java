package linkedList;

import java.util.HashMap;
import java.util.Map;

/**
 * @author kelvin
 * @create 2021-08-18 22:04
 */
public class LRUCache {
    private int capacity;
    private Map<Integer, LRUNode> map;
    private DoubleList doubleList;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.doubleList = new DoubleList();
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        LRUNode node = map.get(key);
        makeRecently(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (!map.containsKey(key)) {
            LRUNode node = new LRUNode(key, value);
            map.put(key, node);
            if (doubleList.size() == capacity) {
                LRUNode first = doubleList.removeFirst();
                map.remove(first.key);
            }
            doubleList.addLast(node);
        } else {
            LRUNode node = map.get(key);
            node.value = value;
            map.put(key, node);
            makeRecently(node);
        }
    }

    private void makeRecently(LRUNode x) {
        doubleList.remove(x);
        doubleList.addLast(x);
    }
}

class LRUNode {
    public int key, value;
    public LRUNode pre, next;

    public LRUNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

/**
 * 链表头部是最久未使用的节点, 链表尾部是最近使用的节点
 */
class DoubleList {
    private LRUNode head, tail;
    private int size;

    public DoubleList() {
        this.head = new LRUNode(0, 0);
        this.tail = new LRUNode(0, 0);
        head.next = tail;
        tail.pre = head;
        this.size = 0;
    }

    /**
     * 在链表末尾添加节点
     * @param x
     */
    public void addLast(LRUNode x) {
        x.pre = tail.pre;
        x.next = tail;
        tail.pre = x;
        x.pre.next = x;
        size++;
    }

    /**
     * 删除并返回链表头部节点
     */
    public LRUNode removeFirst() {
        if (head.next == tail) {
            return null;
        }
        LRUNode first = head.next;
        remove(first);
        return first;
    }

    /**
     * 删除链表中特定的节点, 这个节点必须在链表里面
     * @param x
     */
    public void remove(LRUNode x) {
        x.next.pre = x.pre;
        x.pre.next = x.next;
        size--;
    }

    public int size() {
        return size;
    }
}