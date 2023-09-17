import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class Leetcode232 {

}

class MyQueue {

    Stack<Integer> stackIn;
    Stack<Integer> stackOut;

    public MyQueue() {
        stackIn = new Stack<>();
        stackOut = new Stack<>();
    }

    public void push(int x) {
        stackIn.push(x);
    }

    public int pop() {
        while (!stackIn.empty()) {
            stackOut.push(stackIn.pop());
        }

        int result = stackOut.pop();

        while (!stackOut.empty()) {
            stackIn.push(stackOut.pop());
        }

        return result;
    }

    public int peek() {
        while (!stackIn.empty()) {
            stackOut.push(stackIn.pop());
        }

        int result = stackOut.peek();

        while (!stackOut.empty()) {
            stackIn.push(stackOut.pop());
        }

        return result;
    }

    public boolean empty() {
        return stackIn.isEmpty() && stackOut.isEmpty();
    }
}

class MyStack {

    Deque<Integer> queue;

    public MyStack() {
        queue = new ArrayDeque<>();
    }

    public void push(int x) {
        queue.addLast(x);
    }

    public int pop() {
        int size = queue.size() - 1;
        while (size-- > 0) {
            queue.addLast(queue.peekFirst());
            queue.pollFirst();
        }

        return queue.pollFirst();
    }

    public int top() {
        return queue.peekLast();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
