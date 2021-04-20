package heap_queue;

import java.util.LinkedList;
import java.util.Queue;

public class StackBy2Queue {
    private Queue<Integer> queue;
    private Queue<Integer> help;
    public StackBy2Queue() {
        queue = new LinkedList<>();
        help = new LinkedList<>();
    }

    public void push(int x) {
        queue.offer(x);
    }

    public int pop() {
        assert !queue.isEmpty();
        while (queue.size() > 1) {
            help.offer(queue.poll());
        }
        int x = queue.poll();
        swap();
        return x;
    }

    public int peek() {
        assert !queue.isEmpty();
        while (queue.size() > 1) {
            help.offer(queue.poll());
        }
        int x = queue.poll();
        help.offer(x);
        swap();
        return x;
    }

    private void swap() {
        Queue<Integer> tmp = queue;
        queue = help;
        help = tmp;
    }

    public static void main(String[] args) {
        StackBy2Queue stack = new StackBy2Queue();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
