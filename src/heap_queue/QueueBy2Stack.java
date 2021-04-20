package heap_queue;

import java.util.Deque;
import java.util.LinkedList;

public class QueueBy2Stack {
    private Deque<Integer> stack;
    private Deque<Integer> help;
    public QueueBy2Stack() {
        stack = new LinkedList<>();
        help = new LinkedList<>();
    }

    public void offer(int x) {
        stack.push(x);
    }

    public int poll() {
        assert !stack.isEmpty() || !help.isEmpty();
        if (help.isEmpty()) {
            while (!stack.isEmpty()) {
                help.push(stack.pop());
            }
        }
        return help.pop();
    }

    public int peek() {
        assert !stack.isEmpty() || !help.isEmpty();
        if (help.isEmpty()) {
            while (!stack.isEmpty()) {
                help.push(stack.pop());
            }
        }
        return help.peek();
    }

    public static void main(String[] args) {
        QueueBy2Stack queue = new QueueBy2Stack();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        queue.offer(5);
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }
}
