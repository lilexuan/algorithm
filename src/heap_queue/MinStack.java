package heap_queue;

import javafx.scene.control.Alert;

import java.util.Deque;
import java.util.LinkedList;

public class MinStack {
    private Deque<Integer> dataStack;
    private Deque<Integer> minStack;
    public MinStack() {
        dataStack = new LinkedList<>();
        minStack = new LinkedList<>();
    }

    public void push(int x) {
        dataStack.push(x);
        if (minStack.isEmpty()) {
            minStack.push(x);
        } else {
            if (x <= minStack.peek()) {
                minStack.push(x);
            }
        }
    }

    public int pop(){
        assert !dataStack.isEmpty();
        int x = dataStack.pop();
        if (x == minStack.peek()) {
            minStack.pop();
        }
        return x;
    }

    public int getMin() {
        assert !minStack.isEmpty();
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(5);
        minStack.push(4);
        minStack.push(3);
        minStack.push(3);
        minStack.push(1);
        minStack.push(2);
        minStack.push(1);
        System.out.println(minStack.getMin());
        minStack.pop();
        minStack.pop();
        minStack.pop();
        System.out.println(minStack.getMin());
    }
}
