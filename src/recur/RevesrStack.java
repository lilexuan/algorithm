package recur;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class RevesrStack {
    private static int getAndRemoveLast(Deque<Integer> stack) {
        int result = stack.pop();
        if (stack.isEmpty()) {
            return result;
        } else {
            int last = getAndRemoveLast(stack);
            stack.push(result);
            return last;
        }
    }

    public static void reverseStack(Deque<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int last = getAndRemoveLast(stack);
        reverseStack(stack);
        stack.push(last);
    }

    public static void main(String[] args) {
        Deque<Integer> stack = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        reverseStack(stack);
        System.out.println(stack);
    }
}
