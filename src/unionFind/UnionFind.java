package unionFind;

import java.util.*;

/**
 * @author kelvin
 * @create 2021-03-18 15:31
 */
public class UnionFind<T> {
    public HashMap<T, T> parent;
    public HashMap<T, Integer> size;
    public int count;

    public UnionFind(){
        this.parent = new HashMap<>();
        this.size = new HashMap<>();
        this.count = 0;
    }

    public void init(List<T> list) {
        for (T elem : list) {
            parent.put(elem, elem);
            size.put(elem, 1);
        }
        count += list.size();
    }

    public void insert(T elem) {
        parent.put(elem, elem);
        size.put(elem, 1);
        count++;
    }

    public T findParent(T elem) {
        Deque<T> stack = new LinkedList<>();
        while (elem != parent.get(elem)) {
            stack.push(elem);
            elem = parent.get(elem);
        }
        while (!stack.isEmpty()) {
            parent.put(stack.pop(), elem);
        }
        return elem;
    }

    public void union(T elem1, T elem2) {
        T f1 = findParent(elem1);
        T f2 = findParent(elem2);
        if (f1 == f2) {
            return;
        }
        if (size.get(f1) > size.get(f2)) {
            parent.put(f2, f1);
            size.put(f1, size.get(f1) + size.get(f2));
            size.remove(f2);
        } else {
            parent.put(f1, f2);
            size.put(f2, size.get(f1) + size.get(f2));
            size.remove(f1);
        }
        count--;
    }

    public boolean isUnion(T elem1, T elem2) {
        return findParent(elem1) == findParent(elem2);
        // error: return parent.get(elem1) == parent.get(elem2);
    }

    public static void main(String[] args) {
        UnionFind<Integer> unionFind = new UnionFind<>();
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        unionFind.init(list);
        unionFind.union(1, 2);
        unionFind.union(3, 4);
        unionFind.union(4, 7);
        System.out.println(unionFind.isUnion(1, 2));
        System.out.println(unionFind.isUnion(1, 3));
        System.out.println(unionFind.isUnion(1, 7));
        System.out.println(unionFind.isUnion(3, 4));
        System.out.println(unionFind.isUnion(3, 7));
    }
}
