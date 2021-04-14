package stackAndQueue;

import java.util.Deque;
import java.util.LinkedList;

public class StackSort {
    public static void stackSort(Deque<Integer> stack) {
        Deque<Integer> stack2 = new LinkedList<>();
        while (!stack.isEmpty()) {
            int elem = stack.pop();
            if (stack2.isEmpty() || stack2.peek() >= elem) {
                stack2.push(elem);
            } else {
                while (!stack2.isEmpty() && stack2.peek() > elem) {
                    stack.push(stack2.pop());
                }
                stack2.push(elem);
            }
        }
        while (!stack2.isEmpty()) {
            stack.push(stack2.pop());
        }
    }

    public static void printStack(Deque<Integer> stack) {
        for (int num : stack) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Deque<Integer> stack = new LinkedList<>();
        stack.push(3);
        stack.push(2);
        stack.push(9);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);
        stack.push(3);
        stack.push(0);
        stack.push(1);
        printStack(stack);
        stackSort(stack);
        printStack(stack);
    }
}
