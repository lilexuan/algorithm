package test;

import java.util.LinkedList;

/**
 * @author kelvin
 * @create 2021-04-02 14:50
 */
public class Test {
    public static void main(String[] args) {
        LinkedList<Integer> res = new LinkedList<>();
        res.add(1);
        res.add(2);
        res.add(3);
        System.out.println(res.getLast());
    }
}
